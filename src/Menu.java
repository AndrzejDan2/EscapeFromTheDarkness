import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    private ButtonHandler buttonHandler;
    public Menu() {
        super();
        setBackground(Color.WHITE);
        setBounds(0,0, 1024, 68);
        setLayout(null);
        buttonHandler = new ButtonHandler();
        initButtons();
    }
    public void initButtons(){
        Button bPlay = new Button("Play", 40, 10, 50, 50,  new ImageIcon("res/Play.png"));
        Button bPause = new Button("Pause", 110, 10, 50, 50, new ImageIcon("res/Pause.png"));
        Button bRestart = new Button("Restart", 180, 10, 50, 50, new ImageIcon("res/Restart.png"));
        Button bExit = new Button("Exit", 250, 10, 50, 50, new ImageIcon("res/Exit.png"));
        bPlay.addActionListener(buttonHandler);
        bPause.addActionListener(buttonHandler);
        bRestart.addActionListener(buttonHandler);
        bExit.addActionListener(buttonHandler);
        this.add(bPlay);
        this.add(bPause);
        this.add(bRestart);
        this.add(bExit);
    }

}
