import javax.swing.*;
import java.awt.*;

public class GameArea extends JPanel {
    int x = 10;
    int y = 10;
    public GameArea() {
        super();
        setBackground(Color.darkGray);
        setBounds(10,68, 1004, 692);
        addKeyListener(new KeyHandler(this));
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.GREEN);
        g2.fillRect(x, y, 40, 40);

    }
}
