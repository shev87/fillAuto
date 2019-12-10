import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Model {
    private File file;
    private Properties properties;

    public Model(File file) {
        this.file = file;
        properties = new Properties();
        try {
            properties.load(new FileReader(file));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Файл \"properties.properties\" не найден!",
                    "Ошибка!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getValue (String key){
        String value = properties.getProperty(key);
        return value;
    }

    public void copyClipboard(String text){
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public void setValue(String key, String value){
        properties.setProperty(key, value);
    }
}
