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

        double value = game.getQuestConfigurator().array.length/ (game.getQuestConfigurator().array.length + game.getQuestConfigurator().mistakes)*100;

        String effectiveness = String.format("Skuteczność: %.2f%%", value);
        Font font2 = new Font("Serif", Font.PLAIN, 36);
        g.setFont(font2);
        g.setColor(Color.WHITE);
        g.drawString(effectiveness, 10, 50 + font.getSize());

    }

    public void showQuest(){
        Quest quest = game.getQuest();
        game.getGameWindow().remove(game.getGameArea());
        game.getGameWindow().add(quest);
        //game.getQuestConfigurator().questCounter += 1;
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

    public MapConfigurator getMapConfigurator() {
        return mapConfigurator;
    }
}
