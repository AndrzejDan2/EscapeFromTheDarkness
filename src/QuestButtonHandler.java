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
                    questConfigurator.buffer[0] = !questConfigurator.buffer[0];
                    break;
                case "B2":
                    questConfigurator.buffer[1] = !questConfigurator.buffer[1];
                    break;
                case "B3":
                    questConfigurator.buffer[2] = !questConfigurator.buffer[2];
                    break;
                case "B4":
                    if(questConfigurator.isSolved[questConfigurator.questCounter]){
                        GameState.state = GameState.PLAY;
                    }else{
                        questConfigurator.mistakes += 1;
                    }
                    break;
            }
            System.out.println(GameState.state);
        }
    }
}
