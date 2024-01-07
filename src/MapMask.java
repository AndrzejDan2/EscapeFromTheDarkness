import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class MapMask {
    Player player;
    int radius = 50;
    private MapMask cpyMapMask;
    public Area outter;
    public MapMask(MapMask mapMask){
        this.cpyMapMask = mapMask;
    }
    public MapMask(Player player) {
        this.player = player;
        this.outter = new Area(new Rectangle(0,0,Game.tileSize * Game.col,Game.tileSize * Game.row));
    }


    public void render(Graphics g){
        Area temp = new Area(outter);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double innerCircle = new Ellipse2D.Double(player.x + (Game.tileSize/2) - radius, player.y + (Game.tileSize/2) - radius, 2 * radius, 2 * radius);
        temp.subtract(new Area(innerCircle));
        g2.setColor(Color.BLACK);
        g2.fill(temp);
    }

}
