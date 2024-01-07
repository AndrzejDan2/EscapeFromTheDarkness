import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Button extends JButton {
    private final String text;
    private final int x,y;
    private final int width, height;

    public Button(String text, int x, int y, int width, int height, ImageIcon icon) {
        super(text, icon);
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setBounds(this.x, this.y, this.width, this.height);
        setMargin(new Insets(0, 17, 0, 0));
    }

}
