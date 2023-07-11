import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Arrays;
import java.lang.Math;
import java.lang.Thread;
public class Game_panel extends JPanel {
    Cookie cookie;

    JTextArea textArea;


    int points = 0;
    Random random;

    Game_panel(){

        Color brown = new Color(150, 75, 0);
        this.cookie = new Cookie(200, 200, 40, 40, brown);
        textArea = new JTextArea();

        this.add(textArea);
        setSize(300, 300);

        // Mouse Listeners
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                random_cookie(e);
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                try {
                    move_cookie(e);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }



    @Override
    public void paint(Graphics g) {
        Toolkit t= Toolkit.getDefaultToolkit();
        Image img = t.getImage("D:\\Java Projects\\CookieSlapper\\src\\cookiee.png");

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 300, 300);
        textArea.setText("Your Score: " + points);
        this.cookie.draw(g);
        g.drawImage(img, this.cookie.x, this.cookie.y, this.cookie.width, this.cookie.height, this);
    }




    public void move_cookie(MouseEvent e) throws InterruptedException {
        get_distance(e);
        double distance = get_distance(e);
        if (distance < 40){
            double[] cookie_location = get_cookie_position();
            System.out.println(Arrays.toString(cookie_location));

            if (cookie_location[0] > e.getX() && cookie_location[0] > 0 && cookie_location[0] < 250){
                this.cookie.x += 1;
                repaint();
            }
            if (cookie_location[0] < e.getX() && cookie_location[0] > 0 && cookie_location[0] < 250){
               this.cookie.x -= 1;
               repaint();
            }
            if (cookie_location[1] > e.getY() && cookie_location[1] > 0 && cookie_location[1] <= 230){
                this.cookie.y += 1;

            }
            if (cookie_location[1] < e.getY() && cookie_location[1] > 0 && cookie_location[1] <= 230){
                this.cookie.y -= 1;

            }
            repaint();
            Thread.sleep(5);
        }
    }


    public double get_distance(MouseEvent e){
        double[] mouse_location = {e.getX(), e.getY()};
        double[] cookie_location = get_cookie_position();
        double x = mouse_location[0] - cookie_location[0] - 19;
        double y = mouse_location[1] - cookie_location[1] - 17;
        double distance= x*x + y*y;
        distance = Math.sqrt(distance);
        return distance;    }


    public double[] get_cookie_position(){
        return new double[]{this.cookie.x, this.cookie.y};
    }

    public void random_cookie(MouseEvent e) {
        if (this.cookie.intersects(e.getX(), e.getY(), 20,20)){
            random = new Random();

            points += 1;
            System.out.println(points);
            this.cookie.x = random.nextInt(250);
            this.cookie.y = random.nextInt(250);
            repaint();

        }

    }

}
