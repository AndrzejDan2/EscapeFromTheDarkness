import javax.swing.*;
import java.awt.*;

public class GameWindow extends JWindow{
    final int windowWidth = 1024;
    final int windowHeight = 768;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public GameWindow() {
        super();
        setSize(windowWidth, windowHeight);
        setLocation((screenSize.width- windowWidth)/2, (screenSize.height- windowHeight)/2);
        JPanel jpanel = new JPanel();
        jpanel.setBackground(Color.BLACK);
        add(jpanel);
        setVisible(true);
    }
}
