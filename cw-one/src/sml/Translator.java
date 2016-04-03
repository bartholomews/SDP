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
                Class[] constructorToSkip = {String.class, String.class};
                if (!(Arrays.equals(param, constructorToSkip))) {
                    // get the parameters of the next constructor
                    Class[] params = constructor.getParameterTypes();
                    Object[] args = new Object[params.length];
                    // String at index 0 is already scanned and assigned to "label"
                    args[0] = label;
                    for(int i=1; i<params.length; i++) {
                        Class<?> c = params[i];
                        if (c.isAssignableFrom(String.class)) {
                            args[i] = scan();
                        } else if (c.isAssignableFrom(int.class)) {
                            args[i] = scanInt();
                        } else {
                            throw new IllegalArgumentException(c.getName() + " is not supported");
                        }
                    }
                    return (Instruction) constructor.newInstance(args);
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