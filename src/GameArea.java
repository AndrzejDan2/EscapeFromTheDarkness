import javax.swing.*;
import java.awt.*;

public class GameArea extends JPanel {


    Game game;

    Player player;

    KeyHandler keyHandler;

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
        game.render(g);
    }

    public void setDX(int val){
        player.dx = val;
    }

    public void setDY(int val){
        player.dy = val;
    }
}
