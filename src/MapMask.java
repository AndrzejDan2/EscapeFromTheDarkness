import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class MapMask {
    Player player;
    int radius = 50;

    public MapMask(Player player) {
        this.player = player;
    }

    public void render(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        Area outter = new Area(new Rectangle(0,0,Game.tileSize * Game.col,Game.tileSize * Game.row));
        Ellipse2D.Double innerCircle = new Ellipse2D.Double(player.x + (Game.tileSize/2) - radius, player.y + (Game.tileSize/2) - radius, 2 * radius, 2 * radius);
        outter.subtract(new Area(innerCircle));

        //Rectangle xd = new Rectangle(50,50,70,600);
        //outter.subtract(new Area(xd));                //TODO checkpoints

        g2.setColor(Color.BLACK);
        g2.fill(outter);
    }

}
