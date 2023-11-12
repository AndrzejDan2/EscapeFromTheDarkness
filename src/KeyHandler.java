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
            case KeyEvent.VK_W -> gameArea.y -= 5;
            case KeyEvent.VK_S -> gameArea.y += 5;
            case KeyEvent.VK_A -> gameArea.x -= 5;
            case KeyEvent.VK_D -> gameArea.x += 5;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
