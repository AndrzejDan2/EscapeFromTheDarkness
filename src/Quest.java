import javax.swing.*;
import java.awt.*;

public class Quest extends JPanel {
    private QuestButtonHandler questButtonHandler;

    public QuestConfigurator questConfigurator;
    //public boolean isSolved;
    public Button b1;
    public Button b2;
    public Quest(QuestConfigurator questConfigurator) {
        super();
        this.questConfigurator = questConfigurator;
        //isSolved = false;
        setBackground(Color.CYAN);
        setBounds(10,68, 1000, 680);
        questButtonHandler = new QuestButtonHandler(this.questConfigurator);
        initButtons();
    }

    private void initButtons() {
        b1 = new Button("B1", 40, 60, 50, 50,  new ImageIcon("res/Play.png"));
        b2 = new Button("B2", 110, 60, 50, 50, new ImageIcon("res/Pause.png"));
        b1.addActionListener(questButtonHandler);
        b2.addActionListener(questButtonHandler);
        this.add(b1);
        this.add(b2);
    }

}
