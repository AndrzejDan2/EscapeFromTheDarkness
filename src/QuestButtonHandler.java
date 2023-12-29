import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestButtonHandler implements ActionListener {

    public QuestConfigurator questConfigurator;

    public QuestButtonHandler(QuestConfigurator questConfigurator) {
        this.questConfigurator = questConfigurator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof JButton clickedButton){
            switch (clickedButton.getText()){
                case "B1":
                    questConfigurator.isSolved[questConfigurator.questCounter] = true;
                    GameState.state = GameState.PLAY;
                    break;
                case "B2":
                    break;
            }
            System.out.println(GameState.state);
        }
    }
}
