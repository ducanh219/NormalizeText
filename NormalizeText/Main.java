
import Controller.TextNormalizer;
import Model.Text;

public class Main {
    public static void main(String[] args) {
        Text text = new Text();
        new TextNormalizer(text).run();
    }
}
