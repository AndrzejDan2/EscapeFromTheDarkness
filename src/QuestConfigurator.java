import java.awt.*;

public class QuestConfigurator {
    Quest[] array = new Quest[4];
    boolean[] isSolved = new boolean[4];
    public MapConfigurator mapConfigurator;

    public int questCounter;

    public QuestConfigurator(MapConfigurator mapConfigurator) {
        this.mapConfigurator = mapConfigurator;
        initQuests();
        questCounter = 0;
    }

    public void initQuests() {
        array[0] = new Quest(this);
        array[0].setBackground(Color.BLACK);

        array[1] = new Quest(this);
        array[1].setBackground(Color.WHITE);

        array[2] = new Quest(this);
        array[2].setBackground(Color.YELLOW);

        array[3] = new Quest(this);
        array[3].setBackground(Color.GREEN);

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

    public Quest selectQuest(){
        //System.out.println("tee: " + array[questCounter].getBackground());
        return array[questCounter];
    }

    public void questRequestFocus(Quest quest){
        quest.requestFocus();
    }


}
