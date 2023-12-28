import javax.swing.*;
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

    public void showFinalState(Graphics g){
        String time = String.format("Czas rozgrywki: %.2f s", this.gameTime);
        Font font = new Font("Serif", Font.PLAIN, 36);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(time, 10, 10 + font.getSize());
    }

    public void showQuest(){
        Quest quest = game.getQuest();
        game.getGameWindow().remove(game.getGameArea());
        game.getGameWindow().add(quest);
        quest.setFocusable(true);
        //game.getGameArea().setFocusable(false);
        //quest.setFocusable(true);
        //quest.requestFocus();
        quest.revalidate();
        quest.repaint();

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
