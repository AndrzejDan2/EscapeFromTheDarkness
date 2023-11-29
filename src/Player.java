import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;




public class Player {
    BufferedImage bufferedImage;

    final int width = 40;
    final int height = 40;
    int x;
    int y;

    double normalSpeed = 2;
    double diagonalSpeed;

    int dx;
    int dy;
    //TODO hitbox
    MapConfigurator mapConfigurator;
    boolean isMapLoaded;

    public Player() {
        x = 50;
        y = 50;
        dx = 0;
        dy = 0;
        diagonalSpeed = 0.707 * normalSpeed;
        isMapLoaded = false;
        setImage();

    }

    public void loadMapData(MapConfigurator mapConfigurator){
        this.mapConfigurator = mapConfigurator;
    }



    public void render(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.bufferedImage,this.x, this.y, this.width, this.height, null);

    }
    public void update(){
        moveX();
        moveY();
    }

    public void moveX(){

        if(this.dx != 0 && this.dy != 0){

            if(dx > 0 && dy > 0
                    && !isSolid(x + dx + Game.tileSize - 1, y + dy + Game.tileSize - 1)
                    && !isSolid(x + dx + Game.tileSize - 1, y + dy)
                    && !isSolid(x + dx, y + dy + Game.tileSize - 1)){
                x += (int)(dx * diagonalSpeed);
            }
            if(dx < 0 && dy > 0
                    && !isSolid(x + dx, y + dy + Game.tileSize - 1)
                    && !isSolid(x + dx + Game.tileSize - 1, y + dy + Game.tileSize - 1)
                    && !isSolid(x + dx, y + dy)){
                x += (int)(dx * diagonalSpeed);
            }
            if(dx > 0 && dy < 0
                    && !isSolid(x + dx + Game.tileSize - 1, y + dy)
                    && !isSolid(x + dx, y + dy)
                    && !isSolid(x + dx + Game.tileSize - 1, y + dy + Game.tileSize - 1)){
                x += (int)(dx * diagonalSpeed);
            }
            if(dx < 0 && dy < 0
                    && !isSolid(x + dx, y + dy)
                    && !isSolid(x + dx + Game.tileSize - 1, y + dy)
                    && !isSolid(x + dx, y + dy + Game.tileSize - 1)){
                x += (int)(dx * diagonalSpeed);
            }

        }else{

            if(dx > 0
                    && !isSolid(x + dx + Game.tileSize - 1, y)
                    && !isSolid(x + dx + Game.tileSize - 1, y + Game.tileSize - 1)){
                x += (int)(dx * normalSpeed);
            }
            if(dx < 0
                    && !isSolid(x + dx, y)
                    && !isSolid(x + dx, y + Game.tileSize - 1)){
                x += (int)(dx * normalSpeed);
            }

        }
    }

    public void moveY(){

        if(this.dx != 0 && this.dy != 0){

            if(dx > 0 && dy > 0
                    && !isSolid(x + dx + Game.tileSize - 1, y + dy + Game.tileSize - 1)
                    && !isSolid(x + dx + Game.tileSize - 1, y + dy)
                    && !isSolid(x + dx, y + dy + Game.tileSize - 1)){
                y += (int)(dy * diagonalSpeed);
            }
            if(dx < 0 && dy > 0
                    && !isSolid(x + dx, y + dy + Game.tileSize - 1)
                    && !isSolid(x + dx + Game.tileSize - 1, y + dy + Game.tileSize - 1)
                    && !isSolid(x + dx, y + dy)){
                y += (int)(dy * diagonalSpeed);
            }
            if(dx > 0 && dy < 0
                    && !isSolid(x + dx + Game.tileSize - 1, y + dy)
                    && !isSolid(x + dx, y + dy)
                    && !isSolid(x + dx + Game.tileSize - 1, y + dy + Game.tileSize - 1)){
                y += (int)(dy * diagonalSpeed);
            }
            if(dx < 0 && dy < 0
                    && !isSolid(x + dx, y + dy)
                    && !isSolid(x + dx + Game.tileSize - 1, y + dy)
                    && !isSolid(x + dx, y + dy + Game.tileSize - 1)){
                y += (int)(dy * diagonalSpeed);
            }

        }else{

            if(dy > 0
                    && !isSolid(x + dx + Game.tileSize - 1, y + Game.tileSize - 1)
                    && !isSolid(x + dx, y + Game.tileSize - 1)){
                y += (int)(dy * normalSpeed);
            }
            if(dy < 0
                    && !isSolid(x + dx, y )
                    && !isSolid(x + dx + Game.tileSize - 1, y)){
                y += (int)(dy * normalSpeed);
            }
        }
    }


    public boolean isSolid(int x, int y){
        int tempX = (int)(x/ Game.tileSize);
        int tempY = (int)(y/ Game.tileSize);
        int tempTile = this.mapConfigurator.mapData[tempX][tempY];
        return mapConfigurator.tile[tempTile].collision;
    }

    public void setImage(){
        try{
            this.bufferedImage = ImageIO.read(new File("res/Guy.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkWin(){
        int tempX = x + Game.tileSize/2;
        int tempY = y + Game.tileSize/2;
        if(mapConfigurator.mapData[(int)tempX/Game.tileSize][(int)tempY/Game.tileSize] == 2){
            GameState.state = GameState.RESULTS;
        }
    }
}
