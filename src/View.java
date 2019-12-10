import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private JPanel jPanel = new JPanel();
    private JLabel jLabelIn = new JLabel();
    private JLabel jLabelName = new JLabel();
    private  Model model;
    private JButton buttonSurname;
    private JButton buttonSetSurname;
    private JButton buttonName;
    private JButton buttonSetName;

    public View(Model model){
        this.model = model;
    }

    public void init() {
        createWindow();
        createButtonSurname();
        createLabelButtonSurname("");
        createButtonSetSurname();
        createButtonName();
        createLabelButtonName("");
        createButtonSetName();
        revalidate();
    }

    private void createWindow() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - 250, dimension.height / 2 - 250, 600, 200);
        setTitle("FillAuto");
        this.add(jPanel);
    }

    private void createButtonSurname() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0.1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 0, 0, 0);

        buttonSurname = new JButton("Фамилия заявителя");
        jPanel.add(buttonSurname, constraints);
        buttonSurname.addActionListener(this);
        revalidate();
    }

    protected void createLabelButtonSurname(String text){
        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.weightx = 0;
//        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 0,0,0);

        constraints.anchor = GridBagConstraints.WEST;
        jLabelIn.setText("фамилия заявителя: " + text);
        jPanel.add(jLabelIn, constraints);
        revalidate();
    }

    private void createButtonSetSurname(){
        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.weightx = 0;
        constraints.weighty = 0.1;
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 0,0,0);

        buttonSetSurname = new JButton("Установить фамилию заявителя");
        buttonSetSurname.addActionListener(this);
        jPanel.add(buttonSetSurname, constraints);
        revalidate();

    }

    private void createButtonName() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 0;
        constraints.weighty = 0.1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 0, 0, 0);

        buttonName = new JButton("Имя заявителя");
        jPanel.add(buttonName, constraints);
        buttonName.addActionListener(this);
        revalidate();
    }

    protected void createLabelButtonName(String text){
        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.weightx = 0;
//        constraints.weighty = 0;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 0,0,0);

        constraints.anchor = GridBagConstraints.WEST;
        jLabelName.setText("имя заявителя: " + text);
        jPanel.add(jLabelName, constraints);
        revalidate();
    }

    private void createButtonSetName(){
        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.weightx = 0;
        constraints.weighty = 0.1;
        constraints.gridx = 100;
        constraints.gridy = 100;
        constraints.gridheight = 100;
        constraints.gridwidth = 100;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 0,0,0);
        buttonSetName = new JButton("Установить имя заявителя");
        buttonSetName.addActionListener(this);
        jPanel.add(buttonSetName, constraints);
        revalidate();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = e.getActionCommand();
        if (text.equals(buttonSurname.getText())){
            String value = model.getValue("фамилияЗаявителя");
            model.copyClipboard(value);
            createLabelButtonSurname(value);
        } else if (text.equals(buttonSetSurname.getText())){
            try {
                String s = JOptionPane.showInputDialog(jPanel, "Введите фамилию заявителя!");
                model.setValue("фамилияЗаявителя", s);
                createLabelButtonSurname(s);
            } catch (NullPointerException ex) {

            }
        } else if (text.equals(buttonName.getText())){
            String value = model.getValue("имяЗаявителя");
            model.copyClipboard(value);
            createLabelButtonName(value);
        } else if (text.equals(buttonSetName.getText())){
            try {
                String s = JOptionPane.showInputDialog(jPanel, "Введите имя заявителя!");
                model.setValue("имяЗаявителя", s);
                createLabelButtonName(s);
            } catch (NullPointerException ex) {

            }
        }
    }
}
