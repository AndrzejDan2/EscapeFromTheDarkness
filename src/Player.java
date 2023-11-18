import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;




public class Player {
    BufferedImage bufferedImage;

    GameArea gameArea;
    final int width = 40;
    final int height = 40;
    int x;
    int y;

    double normalSpeed = 5;
    double diagonalSpeed;

    int dx, dy;
    //TODO speed
    //TODO hitbox


    public Player() {
        x = 50;
        y = 50;
        dx = 0;
        dy = 0;
        diagonalSpeed = 0.707 * normalSpeed;
        setImage();

    }

    public void render(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        this.x += this.dx;
        this.y += this.dy;
        g2.drawImage(this.bufferedImage,this.moveX(), this.moveY(), this.width, this.height, null);

    }

    public int moveX(){
        if(this.dx != 0 && this.dy != 0){
            x += (int)(dx * diagonalSpeed);
        }else{
            x += (int)(dx * normalSpeed);
        }
        return x;
    }

    public int moveY(){
        if(this.dx != 0 && this.dy != 0){
            y += (int)(dy * diagonalSpeed);
        }else{
            y += (int)(dy * normalSpeed);
        }
        return y;
    }

    public void setImage(){
        try{
            this.bufferedImage = ImageIO.read(new File("res/Guy.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
