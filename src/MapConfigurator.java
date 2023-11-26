import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MapConfigurator {
    Game game;
    Tile[] tile = new Tile[3];

    public int[][] mapData;

    public MapConfigurator(Game game) {
        this.game = game;
        mapData = new int[Game.col][Game.row];
        getImage();
        loadMap();
    }

    public void getImage(){
        try{
            tile[0] = new Tile();
            tile[0].bufferedImage = ImageIO.read(new File("res/Tilev1.png"));

            tile[1] = new Tile();
            tile[1].bufferedImage = ImageIO.read(new File("res/Tilev2.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].bufferedImage = ImageIO.read(new File("res/Tilev3.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for(int i = 0; i < game.row; i++){
            for(int j = 0; j < game.col; j++){
                g2.drawImage(tile[mapData[j][i]].bufferedImage,j * game.tileSize, i * game.tileSize ,game.tileSize, game.tileSize, null);
            }
        }


    }
    //g2.drawImage(tile.bufferedImage,col * gameArea.tileSize, row * gameArea.tileSize ,gameArea.tileSize, gameArea.tileSize, null);
    public void loadMap(){
        int row = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("config.txt")));
            String line;
            String[] splitLine;
            String[] parsedLine;

            while((line = bufferedReader.readLine()) != null){
                splitLine = line.split(" ");
                for(int i = 0; i < Game.col; i++){
                    mapData[i][row] = Integer.parseInt(String.valueOf(splitLine[i]));
                }
                row++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
