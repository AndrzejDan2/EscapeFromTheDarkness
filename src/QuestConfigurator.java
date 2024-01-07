import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class QuestConfigurator {
    Quest[] array = new Quest[5];
    boolean[] isSolved = new boolean[5];

    boolean[] buffer = new boolean[3];
    public MapConfigurator mapConfigurator;

    public MapMask mapMask;
    public Player player;

    public int questCounter;
    public double mistakes;

    public QuestConfigurator(MapConfigurator mapConfigurator, Player player, MapMask mapMask) {
        this.mapConfigurator = mapConfigurator;
        this.player = player;
        this.mapMask = mapMask;
        initQuests();
        questCounter = 0;
        Arrays.fill(buffer, false);
    }

    public void initQuests() {
        array[0] = new Quest(this);
        array[0].setBackground(Color.white);
        array[0].image.setIcon(new ImageIcon("res/quest1.png"));


        array[1] = new Quest(this);
        array[1].setBackground(Color.white);
        array[1].image.setIcon(new ImageIcon("res/quest2.png"));

        array[2] = new Quest(this);
        array[2].setBackground(Color.white);
        array[2].image.setIcon(new ImageIcon("res/quest3.png"));

        array[3] = new Quest(this);
        array[3].setBackground(Color.white);
        array[3].image.setIcon(new ImageIcon("res/quest4.png"));

        array[4] = new Quest(this);
        array[4].setBackground(Color.white);
        array[4].image.setIcon(new ImageIcon("res/quest5.png"));

    }

    public boolean quest1Solution(boolean[] tab){
        boolean a = tab[0];
        boolean b = tab[1];
        boolean c = tab[2];

        boolean xorBC = (c && !b) || (!c && b);

        return xorBC || c;
    }

    public boolean quest2Solution(boolean[] tab){
        boolean a = tab[0];
        boolean b = tab[1];
        boolean c = tab[2];

        return (!a^c) && ((!a^c)^b) && (a^((!a^c)^b));
    }

    public boolean quest3Solution(boolean[] tab){
        boolean a = tab[0];
        boolean b = tab[1];
        boolean c = tab[2];

        return (a && b) || ((b || c) && (b && c));
    }

    public boolean quest4Solution(boolean[] tab){
        boolean a = tab[0];
        boolean b = tab[1];
        boolean c = tab[2];

        return !(((a || b) ^ (b || c)) || !(b && c));
    }

    public boolean quest5Solution(boolean[] tab){
        boolean a = tab[0];
        boolean b = tab[1];
        boolean c = tab[2];

        return ((a && b)^(b && c)) && (b || c) && !(b && c);
    }

    public void update(){
        if(isSolved[0]){
            mapConfigurator.mapData[4][9] = 0;
            mapConfigurator.mapData[5][9] = 0;
            Rectangle room = new Rectangle(0,0,360,400);
            mapMask.outter.subtract(new Area(room));
        }
        if(isSolved[1]){
            mapConfigurator.mapData[8][11] = 0;
            mapConfigurator.mapData[8][12] = 0;
            Rectangle room = new Rectangle(0,360,360,320);
            mapMask.outter.subtract(new Area(room));
        }
        if(isSolved[2]){
            mapConfigurator.mapData[16][13] = 0;
            mapConfigurator.mapData[16][12] = 0;
            Rectangle room = new Rectangle(360,200,320,480);
            mapMask.outter.subtract(new Area(room));
        }
        if(isSolved[3]){
            mapConfigurator.mapData[13][5] = 0;
            mapConfigurator.mapData[14][5] = 0;
            Rectangle room = new Rectangle(320,360,680,320);
            mapMask.outter.subtract(new Area(room));
        }
        if(isSolved[4]){
            mapConfigurator.mapData[24][5] = 2;
            mapConfigurator.mapData[24][6] = 2;
            Rectangle shape1 = new Rectangle(360,0,640,240);
            mapMask.outter.subtract(new Area(shape1));
            Rectangle shape2 = new Rectangle(640,0,360,360);
            mapMask.outter.subtract(new Area(shape2));
        }

    }


    public void checkCorrectness(){
        if (selectQuest().equals(array[0])) {
            boolean solution = quest1Solution(buffer);
            if(solution){
                isSolved[0] = true;
                mapConfigurator.mapData[(int)(player.x + Game.tileSize/2)/Game.tileSize][(int)(player.y + Game.tileSize/2)/Game.tileSize] = 0;
                Arrays.fill(buffer, false);
            }
        } else if (selectQuest().equals(array[1])) {
            boolean solution = quest2Solution(buffer);
            if(solution){
                isSolved[1] = true;
                mapConfigurator.mapData[(int)(player.x + Game.tileSize/2)/Game.tileSize][(int)(player.y + Game.tileSize/2)/Game.tileSize] = 0;
                Arrays.fill(buffer, false);
            }
        } else if (selectQuest().equals(array[2])) {
            boolean solution = quest3Solution(buffer);
            if(solution){
                isSolved[2] = true;
                mapConfigurator.mapData[(int)(player.x + Game.tileSize/2)/Game.tileSize][(int)(player.y + Game.tileSize/2)/Game.tileSize] = 0;
                Arrays.fill(buffer, false);
            }
        } else if (selectQuest().equals(array[3])) {
            boolean solution = quest4Solution(buffer);
            if(solution){
                isSolved[3] = true;
                mapConfigurator.mapData[(int)(player.x + Game.tileSize/2)/Game.tileSize][(int)(player.y + Game.tileSize/2)/Game.tileSize] = 0;
                Arrays.fill(buffer, false);
            }
        } else if (selectQuest().equals(array[4])) {
            boolean solution = quest5Solution(buffer);
            if(solution){
                isSolved[4] = true;
                mapConfigurator.mapData[(int)(player.x + Game.tileSize/2)/Game.tileSize][(int)(player.y + Game.tileSize/2)/Game.tileSize] = 0;
                Arrays.fill(buffer, false);
            }
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
