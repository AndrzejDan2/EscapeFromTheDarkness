import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof JButton clickedButton){
            switch (clickedButton.getText()){
                case "Play":
                    GameState.state = GameState.PLAY;
                    break;
                case "Pause":
                    GameState.state = GameState.PAUSE;
                    break;
                case "Restart":
                    GameState.state = GameState.RESTART;
                    break;
                case "Exit":
                    System.exit(0);
                    break;
                case "B1":
                    GameState.state = GameState.PLAY;
                    break;
                case "B2":
                    break;
            }
            System.out.println(GameState.state);
        }
    }

}
