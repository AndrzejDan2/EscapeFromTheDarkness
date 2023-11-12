import javax.swing.*;
import java.awt.*;

public class GameArea extends JPanel {
    public GameArea() {
        super();
        setBackground(Color.darkGray);
        setBounds(10,68, 1004, 692);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.fillRect(10, 10, 10, 10);
        g2.setColor(Color.PINK);
    }
}
