package abstractfactory;

/**
 *
 */
public class ParserFactoryProducer {

    public static AbstractParserFactory getFactory(String factory) {
        switch(factory.toUpperCase()) {
            case "NYCFACTORY": return new NYCFactory();
            case "LONDONFACTORY": return new LondonFactory();
            default: throw new IllegalArgumentException(factory + " is not a valid factory");
        }
    }

}
