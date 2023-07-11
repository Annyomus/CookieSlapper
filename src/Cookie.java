import java.awt.*;

public class Cookie extends Rectangle {

    Color color;
    Cookie(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;

    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);

        g.setColor(Color.BLACK);
/*        g.drawRect(x+17, y+9, 1,1);
        g.drawRect(x+22, y+13, 1,1);
        g.drawRect(x+18, y+17, 1,1);
        g.drawRect(x+18, y+24, 1,1);*/

    }




}
