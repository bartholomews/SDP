package abstractfactory;

/**
 *
 */
public class NYCParser implements XMLParser {
    private String parserType;

    public NYCParser(String parserType) {
        this.parserType = parserType;
    }

    @Override
    public String parse() {
        System.out.println("NYC Parsing " + parserType + " XML...");
        return "NYC " + parserType.substring(0,1).toUpperCase() + parserType.substring(1) + " XML Message";
    }
}
