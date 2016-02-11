package strategy_java;

/**
 *
 */
public class TextEditor implements TextEditorInterface {
    private TextFormatter formatter;

    public TextEditor(TextFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void publishText(String text) {
        formatter.format(text);
    }
}
