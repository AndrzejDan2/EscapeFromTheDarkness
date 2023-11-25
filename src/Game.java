import java.awt.*;

public class Game implements Runnable{
    private Thread gameThread;
    static final int tileSize = 40; //40x40
    static final int row = 17;
    static final int col = 25;
    private final int FPS = 120;
    private GameArea ga;
    private Player player;
    private MapConfigurator mapConfigurator;
    private MapMask mapMask;
    private GameWindow gw;

    public Game() {
        mapConfigurator = new MapConfigurator(this);
        player = new Player();
        ga = new GameArea(this, player);
        gw = new GameWindow(ga);
        ga.requestFocus();
        mapMask = new MapMask(player);
        player.loadMapData(mapConfigurator);

        startGameLoop();
    }

    public void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void render(Graphics g){
        mapConfigurator.draw(g);
        player.render(g);
        //mapMask.render(g); //TODO uncomment if necessary
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

}
