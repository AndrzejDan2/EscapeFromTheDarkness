import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    public Menu() {
        super();
        setBackground(Color.lightGray);
        setBounds(0,0, 1024, 68);
        setLayout(null);
        initButtons();
    }
    public void initButtons(){
        Button bPlay = new Button("Play", 40, 10, 50, 50);
        Button bPause = new Button("Pause", 110, 10, 50, 50);
        Button bRestart = new Button("Restart", 180, 10, 50, 50);
        Button bExit = new Button("Exit", 250, 10, 50, 50);
        this.add(bPlay);
        this.add(bPause);
        this.add(bRestart);
        this.add(bExit);
    }

}
