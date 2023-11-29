import java.awt.*;

public class Gameplay {
    private Player player;
    private MapConfigurator mapConfigurator;
    private MapMask mapMask;
    private Game game;

    public double gameTime;
    public long previousTime;
    public long currentTime;

    public Gameplay(Game game) {
        this.game = game;
        mapConfigurator = new MapConfigurator(game);
        player = new Player();
        mapMask = new MapMask(player);
        player.loadMapData(mapConfigurator);
        initTimeParameters();
    }

    public void initTimeParameters(){
        gameTime = 0;
        previousTime = 0;
        currentTime = 0;
    }

    public void update(){
        player.update();
    }

    public void render(Graphics g){
        mapConfigurator.draw(g);
        player.render(g);
        //mapMask.render(g); //TODO uncomment if necessary
    }

    public void setDX(int val){
        player.dx = val;
    }

    public void setDY(int val){
        player.dy = val;
    }

    public Player getPlayer(){
        return player;
    }
}
