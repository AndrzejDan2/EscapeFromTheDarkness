import java.awt.*;

public class Game implements Runnable{
    private Thread gameThread;
    private final int FPS = 120;
    private GameArea ga;
    private Player player;
    private MapConfigurator mapConfigurator;
    private GameWindow gw;
    public Game() {

        player = new Player();
        ga = new GameArea(this, player);
        mapConfigurator = new MapConfigurator(ga);
        gw = new GameWindow(ga);
        ga.requestFocus();
        startGameLoop();
    }

    public void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void render(Graphics g){
        mapConfigurator.draw(g);
        player.render(g);
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
