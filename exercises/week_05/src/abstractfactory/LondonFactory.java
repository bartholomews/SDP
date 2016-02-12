package abstractfactory;

/**
 *
 */
public class LondonFactory implements AbstractParserFactory {

    @Override
    public XMLParser getParserInstance(String parserType) {
        switch(parserType) {
            case "LondonFEEDBACK": return new LondonParser("feedback");
            default: throw new IllegalArgumentException("London do not have a " + parserType + " parserType");
        }
    }

}
