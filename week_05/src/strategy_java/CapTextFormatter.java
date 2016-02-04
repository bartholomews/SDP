package strategy_java;

/**
 *
 */
public class CapTextFormatter implements TextFormatter {

    @Override
    public void format(String text) {
        System.out.println(text.toUpperCase());
    }
}
