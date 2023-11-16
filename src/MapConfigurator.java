import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MapConfigurator {
    GameArea gameArea;
    Tile[] tile = new Tile[2];

    int[][] mapData;

    public MapConfigurator(GameArea gameArea) {
        this.gameArea = gameArea;
        mapData = new int[gameArea.col][gameArea.row];
        getImage();
        loadMap();
    }

    public void getImage(){
        try{
            tile[0] = new Tile();
            tile[0].bufferedImage = ImageIO.read(new File("res/Tilev1.png"));

            tile[1] = new Tile();
            tile[1].bufferedImage = ImageIO.read(new File("res/Tilev2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for(int i = 0; i < gameArea.row; i++){
            for(int j = 0; j < gameArea.col; j++){
                if(mapData[j][i] == 0){
                    g2.drawImage(tile[0].bufferedImage,j * gameArea.tileSize, i * gameArea.tileSize ,gameArea.tileSize, gameArea.tileSize, null);
                } else if (mapData[j][i] == 1) {
                    g2.drawImage(tile[1].bufferedImage,j * gameArea.tileSize, i * gameArea.tileSize ,gameArea.tileSize, gameArea.tileSize, null);
                }
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
                for(int i = 0; i < gameArea.col; i++){
                    mapData[i][row] = Integer.parseInt(String.valueOf(splitLine[i]));
                }
                row++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
