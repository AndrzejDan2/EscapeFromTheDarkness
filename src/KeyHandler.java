import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler {

    private GameArea gameArea;

    public KeyHandler(GameArea gameArea) {
        this.gameArea = gameArea;
        bindInit();
    }

    private void bindInit() {
        gameArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W,0,false), "keyPressedW");
        gameArea.getActionMap().put("keyPressedW", new UpActionPressed());
        gameArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W,0,true), "keyReleasedW");
        gameArea.getActionMap().put("keyReleasedW", new UpActionReleased());

        gameArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S,0,false), "keyPressedS");
        gameArea.getActionMap().put("keyPressedS", new DownActionPressed());
        gameArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S,0,true), "keyReleasedS");
        gameArea.getActionMap().put("keyReleasedS", new DownActionReleased());

        gameArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A,0,false), "keyPressedA");
        gameArea.getActionMap().put("keyPressedA", new LeftActionPressed());
        gameArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A,0,true), "keyReleasedA");
        gameArea.getActionMap().put("keyReleasedA", new LeftActionReleased());

        gameArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D,0,false), "keyPressedD");
        gameArea.getActionMap().put("keyPressedD", new RightActionPressed());
        gameArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D,0,true), "keyReleasedD");
        gameArea.getActionMap().put("keyReleasedD", new RightActionReleased());

    }

    public class UpActionPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameArea.setDY(-1);
        }
    }

    public class UpActionReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameArea.setDY(0);
        }
    }

    public class DownActionPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameArea.setDY(1);
        }
    }

    public class DownActionReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameArea.setDY(0);
        }
    }
    public class LeftActionPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameArea.setDX(-1);
        }
    }

    public class LeftActionReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameArea.setDX(0);
        }
    }
    public class RightActionPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameArea.setDX(1);
        }
    }

    public class RightActionReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameArea.setDX(0);
        }
    }
}
