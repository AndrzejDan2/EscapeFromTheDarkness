import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class GameArea extends JPanel {
    int x = 10;
    int y = 10;
    final int tileSize = 40; //40x40
    final int row = 17;
    final int col = 25;

    MapConfigurator mapConfigurator = new MapConfigurator(this);
    public GameArea() {
        super();
        setBackground(Color.darkGray);
        setBounds(10,68, 1000, 680);
        addKeyListener(new KeyHandler(this));
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        mapConfigurator.draw(g2);
        g2.setColor(Color.GREEN);
        g2.fillRect(x, y, 40, 40);
    }
}
