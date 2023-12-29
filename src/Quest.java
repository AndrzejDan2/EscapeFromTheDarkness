import javax.swing.*;
import java.awt.*;

public class Quest extends JPanel {
    private QuestButtonHandler questButtonHandler;
    boolean[] answers = new boolean[3];
    public QuestConfigurator questConfigurator;
    //public boolean isSolved;
    public Button b1, b2, b3, b4;
    public Quest(QuestConfigurator questConfigurator) {
        super();
        this.questConfigurator = questConfigurator;
        //isSolved = false;
        setLayout(null);
        setBackground(Color.CYAN);
        setBounds(10,68, 1000, 680);
        questButtonHandler = new QuestButtonHandler(this.questConfigurator);
        initButtons();
    }

    private void initButtons() {
        b1 = new Button("B1", 40, 60, 50, 50,  new ImageIcon("res/Play.png"));
        b2 = new Button("B2", 110, 60, 50, 50, new ImageIcon("res/Pause.png"));
        b3 = new Button("B3", 180, 60, 50, 50, new ImageIcon("res/Restart.png"));
        b4 = new Button("B4", 250, 60, 50, 50, new ImageIcon("res/Restart.png"));
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
