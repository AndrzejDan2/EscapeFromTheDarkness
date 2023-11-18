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
        gameArea.setDY(0);
        gameArea.setDX(0);

        switch (e.getKeyCode()){
            case KeyEvent.VK_W -> gameArea.setDY(-5);
            case KeyEvent.VK_S -> gameArea.setDY(5);
            case KeyEvent.VK_A -> gameArea.setDX(-5);
            case KeyEvent.VK_D -> gameArea.setDX(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W, KeyEvent.VK_S -> gameArea.setDY(0);
            case KeyEvent.VK_A, KeyEvent.VK_D -> gameArea.setDX(0);
        }
    }
}
