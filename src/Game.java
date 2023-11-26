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
                break;
            case PAUSE:
                break;
            case QUEST:
                break;
            case RESULTS:
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
