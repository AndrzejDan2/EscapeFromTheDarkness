import javax.swing.*;
import java.awt.*;

public class GameArea extends JPanel {
    int x = 40;
    int y = 40;
    final int tileSize = 40; //40x40
    final int row = 17;
    final int col = 25;
    Game game;

    Player player;

    KeyHandler keyHandler;
    //MapConfigurator mapConfigurator = new MapConfigurator(this);
    public GameArea(Game game, Player player) {
        super();
        this.game = game;
        this.player = player;
        setBackground(Color.darkGray);
        setBounds(10,68, 1000, 680);
        keyHandler = new KeyHandler(this);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //mapConfigurator.draw(g2);
        //player.draw(g2);
        game.render(g);
    }

    public void setDX(int val){
        player.dx = val;
    }

    public void setDY(int val){
        player.dy = val;
    }
}
