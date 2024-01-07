import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.util.Arrays;

public class Game implements Runnable{
    private Thread gameThread;
    static final int tileSize = 40; //40x40
    static final int row = 17;
    static final int col = 25;
    private final int FPS = 120;
    private GameArea ga;
    private GameWindow gw;
    private Gameplay gameplay;

    private QuestConfigurator questConfigurator;

    private boolean stopCount = true;

    public Game() {
        gameplay = new Gameplay(this);
        ga = new GameArea(this);
        gw = new GameWindow(ga);
        questConfigurator = new QuestConfigurator(gameplay.getMapConfigurator(), gameplay.getPlayer(), gameplay.getMapMask());
        startGameLoop();
    }



    public void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void update(){

        switch (GameState.state){
            case PLAY:
                if(!isComponentAdded(gw, ga)){
                    System.out.println(isComponentAdded(gw, ga));
                    questConfigurator.update();
                    gw.remove(questConfigurator.selectQuest());
                    gw.add(ga);
                    questConfigurator.questCounter += 1;
                }

                gameplay.update();
                ga.revalidate(); //must be here
                ga.requestFocus();
                if(stopCount){
                    gameplay.previousTime = System.currentTimeMillis();
                    stopCount = false;
                    //ga.revalidate(); //must be here
                }
                break;
            case RESULTS:
            case PAUSE:
                if(!stopCount){
                    gameplay.currentTime = System.currentTimeMillis();
                    gameplay.gameTime += (double)(gameplay.currentTime - gameplay.previousTime)/1000;
                    System.out.println("czas gry: " + gameplay.gameTime);
                    gameplay.previousTime = gameplay.currentTime;
                    stopCount = true;
                }
                break;
            case RESTART:
                gameplay.initTimeParameters();
                questConfigurator.questCounter = 0;
                getGameplay().getMapConfigurator().loadMap();
                Arrays.fill(questConfigurator.buffer, false);
                Arrays.fill(questConfigurator.isSolved, false);
                questConfigurator.mistakes = 0;
                for(int i = 0; i < questConfigurator.array.length; i++ ){
                    questConfigurator.array[i].reinitButtonsText();
                }
                gameplay.getMapMask().outter = new Area(new Rectangle(0,0,Game.tileSize * Game.col,Game.tileSize * Game.row));
                gameplay.getPlayer().initPosition(50,50);
                //TODO MapMask config
                GameState.state = GameState.PAUSE;
                ga.requestFocus();
                stopCount = true;
                break;
            case QUEST:
                //ga.setFocusable(false);
                //questConfigurator.checkCorrectness(); // <----- sprawdzenie poprawnosci jest rozwiazane po nacisnieciu przycisku B4
                questConfigurator.questRequestFocus(questConfigurator.selectQuest());

                break;

        }
    }

    public void render(Graphics g){
        switch(GameState.state){
            case PLAY:
            case PAUSE:
                gameplay.render(g);
                break;
            case QUEST:
                gameplay.showQuest();
                break;
            case RESULTS:
                gameplay.showFinalState(g);
                break;
        }
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0/FPS;
        long lastFrameTime = System.nanoTime();
        long now;
        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        while(gameThread != null){
            now = System.nanoTime();
            if(now - lastFrameTime >= timePerFrame){
                update();
                ga.repaint();
                gameplay.getPlayer().checkWin();
                lastFrameTime = now;
                frames++;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
    }

    public Gameplay getGameplay(){
        return gameplay;
    }

    public GameArea getGameArea(){
        return ga;
    }

    public GameWindow getGameWindow(){
        return gw;
    }

    public Quest getQuest(){
        return questConfigurator.selectQuest();
    }

    public boolean isComponentAdded(Container container, Component component){
        return SwingUtilities.isDescendingFrom(component, container);

    }

    public QuestConfigurator getQuestConfigurator() {
        return questConfigurator;
    }
}
