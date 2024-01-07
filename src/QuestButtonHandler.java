import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestButtonHandler implements ActionListener {

    public QuestConfigurator questConfigurator;

    public QuestButtonHandler(QuestConfigurator questConfigurator) {
        this.questConfigurator = questConfigurator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "B1":
                questConfigurator.buffer[0] = !questConfigurator.buffer[0];
                if(questConfigurator.buffer[0]){
                    questConfigurator.selectQuest().b1.setText("H");
                }else{
                    questConfigurator.selectQuest().b1.setText("L");
                }
                System.out.println(questConfigurator.buffer[0]);
                break;
            case "B2":
                questConfigurator.buffer[1] = !questConfigurator.buffer[1];
                if(questConfigurator.buffer[1]){
                    questConfigurator.selectQuest().b2.setText("H");
                }else{
                    questConfigurator.selectQuest().b2.setText("L");
                }
                System.out.println(questConfigurator.buffer[1]);
                break;
            case "B3":
                questConfigurator.buffer[2] = !questConfigurator.buffer[2];
                if(questConfigurator.buffer[2]){
                    questConfigurator.selectQuest().b3.setText("H");
                }else{
                    questConfigurator.selectQuest().b3.setText("L");
                }
                break;
            case "B4":
                questConfigurator.checkCorrectness();
                if(questConfigurator.isSolved[questConfigurator.questCounter]){
                    GameState.state = GameState.PLAY;
                }else{
                    questConfigurator.mistakes += 1;
                    questConfigurator.selectQuest().b4.setBackground(Color.red);
                }
                break;
        }
        System.out.println(GameState.state);
    }
}
