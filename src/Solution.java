import java.io.File;

public class Solution {
    public static void main(String[] args) {
        Model model = new Model(new File("properties.properties"));
        View view = new View(model);
        view.init();

    }
}
