import javax.swing.*;
import java.awt.*;

public class GameArea extends JPanel {


    Game game;

    KeyHandler keyHandler;

    public GameArea(Game game) {
        super();
        this.game = game;
        setBackground(Color.darkGray);
        setBounds(10,68, 1000, 680);
        keyHandler = new KeyHandler(this, game, game.getGameplay());
        setFocusable(true);
        requestFocus();

    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        game.render(g);
    }


}
