import javax.swing.*;
import java.awt.*;

public class Quest extends JPanel {
    private ButtonHandler buttonHandler;
    public Quest() {
        super();
        setBackground(Color.CYAN);
        setBounds(10,68, 1000, 680);
        buttonHandler = new ButtonHandler();
        initButtons();
    }

    private void initButtons() {
        Button b1 = new Button("B1", 40, 60, 50, 50,  new ImageIcon("res/Play.png"));
        Button b2 = new Button("B2", 110, 60, 50, 50, new ImageIcon("res/Pause.png"));
        b1.addActionListener(buttonHandler);
        b2.addActionListener(buttonHandler);
        this.add(b1);
        this.add(b2);
    }

}
