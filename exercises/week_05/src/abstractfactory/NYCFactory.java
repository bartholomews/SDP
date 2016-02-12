package abstractfactory;

/**
 *
 */
public class NYCFactory implements AbstractParserFactory {

    @Override
    public XMLParser getParserInstance(String parserType) {
        switch(parserType.toUpperCase()) {
            case "NYCORDER": return new NYCParser("order");
            default: throw new IllegalArgumentException("NYC do not have a " + parserType + " parserType");
        }
    }

}
