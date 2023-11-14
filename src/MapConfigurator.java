import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MapConfigurator {
    GameArea gameArea;
    Tile tile = new Tile();

    //int[][] mapData;

    public MapConfigurator(GameArea gameArea) {
        this.gameArea = gameArea;
        getImage();
    }

    public void getImage(){
        try{
            tile.bufferedImage = ImageIO.read(new File("res/Tilev1.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        int col = 0;
        int row = 0;
        while(col < gameArea.col && row < gameArea.row){
            g2.drawImage(tile.bufferedImage,col * gameArea.tileSize, row * gameArea.tileSize ,gameArea.tileSize, gameArea.tileSize, null);
            col++;
            if(col == gameArea.col){
                col = 0;
                row++;
            }
        }

    }


}
