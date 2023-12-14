import java.awt.*;

public class Game implements Runnable{
    private Thread gameThread;
    static final int tileSize = 40; //40x40
    static final int row = 17;
    static final int col = 25;
    private final int FPS = 120;
    private GameArea ga;
    private GameWindow gw;
    private Gameplay gameplay;
    private boolean stopCount = true;

    public Game() {
        gameplay = new Gameplay(this);
        ga = new GameArea(this);
        gw = new GameWindow(ga);
        ga.setFocusable(true);
        ga.requestFocus();
        startGameLoop();
    }



    public void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void update(){

        switch (GameState.state){
            case PLAY:
                gameplay.update();
                ga.requestFocus();
                if(stopCount){
                    gameplay.previousTime = System.currentTimeMillis();
                    stopCount = false;
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
                gameplay.getPlayer().initPosition(50,50);
                //TODO MapMask config
                GameState.state = GameState.PAUSE;
                ga.requestFocus();
                stopCount = true;
                break;
            case QUEST:
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
}
