import javax.swing.*;
import java.awt.*;

public class Quest extends JPanel {
    private QuestButtonHandler questButtonHandler;
    boolean[] answers = new boolean[3];
    public QuestConfigurator questConfigurator;
    //public boolean isSolved;
    public JButton b1, b2, b3, b4;
    public JLabel image;
    public Quest(QuestConfigurator questConfigurator) {
        super();
        this.questConfigurator = questConfigurator;
        //isSolved = false;
        setLayout(null);
        setBackground(Color.CYAN);
        setBounds(10,68, 1000, 680);
        questButtonHandler = new QuestButtonHandler(this.questConfigurator);
        initButtons();
        image = new JLabel();
        image.setBounds(370, 50, 370, 510);
        add(image);
    }

    private void initButtons() {
        //b1 = new Button("B1", 374, 560, 50, 50,  new ImageIcon("res/Play.png"));
        b1 = new JButton("A");
        b1.setFont(new Font("Arial", Font.BOLD, 10));
        b1.setBounds(374,560,50,50);
        b1.setActionCommand("B1");

        b2 = new JButton("B");
        b2.setFont(new Font("Arial", Font.BOLD, 10));
        b2.setBounds(484, 560, 50, 50);
        b2.setActionCommand("B2");

        b3 = new JButton("C");
        b3.setFont(new Font("Arial", Font.BOLD, 10));
        b3.setBounds(581, 560, 50, 50);
        b3.setActionCommand("B3");

        b4 = new JButton("Check");
        b4.setFont(new Font("Arial", Font.BOLD, 10));
        b4.setBounds(700, 560, 100, 50);
        b4.setActionCommand("B4");

        b1.addActionListener(questButtonHandler);
        b2.addActionListener(questButtonHandler);
        b3.addActionListener(questButtonHandler);
        b4.addActionListener(questButtonHandler);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
    }

}
