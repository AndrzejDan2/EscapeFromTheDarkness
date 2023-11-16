import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GameArea gameArea;

    public KeyHandler(GameArea gameArea) {
        this.gameArea = gameArea;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W -> gameArea.addPlayerY(-5);
            case KeyEvent.VK_S -> gameArea.addPlayerY(5);
            case KeyEvent.VK_A -> gameArea.addPlayerX(-5);
            case KeyEvent.VK_D -> gameArea.addPlayerX(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
