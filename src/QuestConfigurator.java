import java.awt.*;
import java.util.Arrays;

public class QuestConfigurator {
    Quest[] array = new Quest[4];
    boolean[] isSolved = new boolean[4];

    boolean[] buffer = new boolean[3];
    public MapConfigurator mapConfigurator;

    public Player player;

    public int questCounter;
    public double mistakes;

    public QuestConfigurator(MapConfigurator mapConfigurator, Player player) {
        this.mapConfigurator = mapConfigurator;
        this.player = player;
        initQuests();
        questCounter = 0;
        Arrays.fill(buffer, false);
    }

    public void initQuests() {
        array[0] = new Quest(this);
        array[0].setBackground(Color.BLACK);
        array[0].answers[0] = true;
        array[0].answers[1] = true;
        array[0].answers[2] = true;

        array[1] = new Quest(this);
        array[1].setBackground(Color.WHITE);
        array[1].answers[0] = true;
        array[1].answers[1] = true;
        array[1].answers[2] = true;

        array[2] = new Quest(this);
        array[2].setBackground(Color.YELLOW);
        array[2].answers[0] = true;
        array[2].answers[1] = true;
        array[2].answers[2] = true;

        array[3] = new Quest(this);
        array[3].setBackground(Color.GREEN);
        array[3].answers[0] = true;
        array[3].answers[1] = true;
        array[3].answers[2] = true;

    }

    public void update(){
        if(isSolved[0]){
            mapConfigurator.mapData[4][11] = 0;
            mapConfigurator.mapData[5][11] = 0;
        }
        if(isSolved[1]){
            mapConfigurator.mapData[11][5] = 0;
            mapConfigurator.mapData[12][5] = 0;
        }
        if(isSolved[2]){
            mapConfigurator.mapData[16][12] = 0;
            mapConfigurator.mapData[16][13] = 0;
        }
        if(isSolved[3]){
            mapConfigurator.mapData[24][5] = 2;
            mapConfigurator.mapData[24][6] = 2;
        }

    }

    public void checkCorrectness(){
        if(Arrays.equals(buffer, array[questCounter].answers)){
            isSolved[questCounter] = true;
            mapConfigurator.mapData[(int)(player.x + Game.tileSize/2)/Game.tileSize][(int)(player.y + Game.tileSize/2)/Game.tileSize] = 0;
            Arrays.fill(buffer, false);
        }

    }

    public Quest selectQuest(){
        //System.out.println("tee: " + array[questCounter].getBackground());
        return array[questCounter];
    }

    public void questRequestFocus(Quest quest){
        quest.requestFocus();
    }


}
