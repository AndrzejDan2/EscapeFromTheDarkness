import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler {

    private GameArea gameArea;
    private Game game;

    private Gameplay gameplay;

    public KeyHandler(GameArea gameArea, Game game, Gameplay gameplay) {
        this.gameArea = gameArea;
        this.game = game;
        this.gameplay = gameplay;
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

        gameArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "keyPressedEnter");
        gameArea.getActionMap().put("keyPressedEnter", new EnterActionPressed());
        gameArea.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,true), "keyReleasedEnter");
        gameArea.getActionMap().put("keyReleasedEnter", new EnterActionReleased());

    }

    public class UpActionPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getGameplay().setDY(-1);
        }
    }

    public class UpActionReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getGameplay().setDY(0);
        }
    }

    public class DownActionPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getGameplay().setDY(1);
        }
    }

    public class DownActionReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getGameplay().setDY(0);
        }
    }
    public class LeftActionPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getGameplay().setDX(-1);
        }
    }

    public class LeftActionReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getGameplay().setDX(0);
        }
    }
    public class RightActionPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getGameplay().setDX(1);
        }
    }

    public class RightActionReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getGameplay().setDX(0);
        }
    }

    public class EnterActionPressed extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            gameplay.getPlayer().checkQuest();
        }
    }

    public class EnterActionReleased extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
