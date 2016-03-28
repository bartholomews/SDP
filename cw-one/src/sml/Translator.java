package sml;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
public class Translator {

    private static final String SRC = "src";
    // word + line is the part of the current line that's not yet processed
    // word has no whitespace
    // If word and line are not empty, line begins with whitespace
    private String line = "";
    private Labels labels; // The labels of the program being translated
    private ArrayList<Instruction> program; // The program to be created
    private String fileName; // source file of SML code
    private static final String INSTRUCTION = "Instruction";
    private static final String SML = "sml.";

    public Translator(String fileName) {
        this.fileName = SRC + "/" + fileName;
    }

    // translate the small program in the file into lab (the labels) and
    // prog (the program)
    // return "no errors were detected"
    public boolean readAndTranslate(Labels lab, ArrayList<Instruction> prog) {

        try (Scanner sc = new Scanner(new File(fileName))) {
            // Scanner attached to the file chosen by the user
            labels = lab;
            labels.reset();
            program = prog;
            program.clear();

            try {
                line = sc.nextLine();
            } catch (NoSuchElementException ioE) {
                return false;
            }

            // Each iteration processes line and reads the next line into line
            while (line != null) {
                // Store the label in label
                String label = scan();

                if (label.length() > 0) {
                    Instruction ins = getInstruction(label);
                    if (ins != null) {
                        labels.addLabel(label);
                        program.add(ins);
                    }
                }

                try {
                    line = sc.nextLine();
                } catch (NoSuchElementException ioE) {
                    return false;
                }
            }
        } catch (IOException ioE) {
            System.out.println("File: IO error " + ioE.getMessage());
            return false;
        }
        return true;
    }

    // line should consist of an SML instruction, with its label already
    // removed. Translate line into an instruction with label label
    // and return the instruction
    public Instruction getInstruction(String label) {
        int s1; // Possible operands of the instruction
        int s2;
        int r;
        String l;

        if (line.equals(""))
            return null;

        String ins = scan();
        // Subclasses of Instruction need to have name in the form "[Ins]Instruction" (e.g. AddInstruction)
        String name = Character.toUpperCase(ins.charAt(0)) + ins.substring(1) + INSTRUCTION;

        try {
            // get the Instruction subclass in sml package
            Class impl = Class.forName(SML + name);
            // get all its constructors
            Constructor[] constructors = impl.getConstructors();
            for (Constructor constructor : constructors) {

                Class[] param = constructor.getParameterTypes();
                // skip the constructor inherited from Instruction (with params String, String)
                Class[] secondary = {String.class, String.class};
                if (!(Arrays.equals(param, secondary))) {

                   // int size = constructor.getParameterCount();

                    // get the parameters of the next constructor
                    Class[] params = constructor.getParameterTypes();

                    // New implementations of Instruction which have a constructor different
                    // from the below formats need to be added together with a new return statement.
                    Class[] binaryType = {String.class, int.class, int.class, int.class};
                    Class[] linType = {String.class, int.class, int.class};
                    Class[] outType = {String.class, int.class};
                    Class[] bnzType = {String.class, int.class, String.class};
                    Class[] intStringStringType = {String.class, int.class, String.class, String.class};
                    Class[] otherType = {}; // ADD HERE

                    if (Arrays.equals(params, binaryType)) {
                        return (Instruction) constructor.newInstance(label, scanInt(), scanInt(), scanInt());
                    } else if (Arrays.equals(params, linType)) {
                        return (Instruction) constructor.newInstance(label, scanInt(), scanInt());
                    } else if (Arrays.equals(params, bnzType)) {
                        return (Instruction) constructor.newInstance(label, scanInt(), scan());
                    } else if (Arrays.equals(params, outType)) {
                        return (Instruction) constructor.newInstance(label, scanInt());
                    } else if (Arrays.equals(params, intStringStringType)) {
                        return (Instruction) constructor.newInstance(label, scanInt(), scan(), scan());
                    } else {
                        return null;
                    }
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(name + ": class not found");
        } catch (InstantiationException ex) {
            System.out.println(name + " could not be instantiated");
        } catch (IllegalAccessException ex) {
            System.out.println("Cannot get access to " + name);
        } catch (InvocationTargetException ex) {
            ex.getTargetException();
        }
        return null;
    }

    /*
    public Instruction stuff(Class[] cl, Constructor con, Object... args) throws Exception {
        for(Class c : cl) {
            if(c == String.class)
        }   // see http://stackoverflow.com/questions/13477462/adding-an-unknown-number-of-parameters-to-a-method-call-in-java
        return (Instruction) c.newInstance(args);
    }
    */

        /* THIS DOESNT WORK, YOU CANNOT WRAP THE PARAMETER LIST.... :(
    private List<Object> getArgs(String label, Class[] param) {
        List<Object> objects = new ArrayList<>();
        objects.add(label);
        for (Class c : param) {
            if (c.equals(String.class)) {
                objects.add(scan());
            } else if (c.equals(int.class)) {
                objects.add(scanInt());
            }
        }
        return objects;
    }
    */

/*
        switch (ins) {
            case "add":
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                return new AddInstruction(label, r, s1, s2);
            case "sub":
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                return new SubInstruction(label, r, s1, s2);
            case "div":
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                return new DivInstruction(label, r, s1, s2);
            case "mul":
                r = scanInt();
                s1 = scanInt();
                s2 = scanInt();
                return new MulInstruction(label, r, s1, s2);
            case "lin":
                r = scanInt();
                s1 = scanInt();
                return new LinInstruction(label, r, s1);
            case "out":
                r = scanInt();
                return new OutInstruction(label, r);
            case "bnz":
                r = scanInt();
                l = scan();
                return new BnzInstruction(label, r, l);
        }

        return null;
    }
*/


    // You will have to write code here for the other instructions.

    /*
     * Return the first word of line and remove it from line. If there is no
     * word, return ""
     */
    private String scan() {
        line = line.trim();
        if (line.length() == 0)
            return "";

        int i = 0;
        while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '\t') {
            i = i + 1;
        }
        String word = line.substring(0, i);
        line = line.substring(i);
        return word;
    }

    // Return the first word of line as an integer. If there is
    // any error, return the maximum int
    private int scanInt() {
        String word = scan();
        if (word.length() == 0) {
            return Integer.MAX_VALUE;
        }

        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE;
        }
    }
}