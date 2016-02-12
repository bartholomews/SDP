package abstractfactory;

/**
 *
 */
public class LondonParser implements XMLParser {
   private String parserType;

    public LondonParser(String parserType) {
        this.parserType = parserType;
    }

    @Override
    public String parse() {
        System.out.println("London Parsing " + parserType + " XML...");
        return "London " + parserType.substring(0,1).toUpperCase() + parserType.substring(1).toLowerCase() + " XML Message";
    }
}
