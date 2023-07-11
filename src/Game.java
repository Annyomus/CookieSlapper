import javax.swing.*;
import java.awt.event.MouseListener;


public class Game extends JFrame {

    Game(String title, int width){
        Game_panel panel = new Game_panel();
        this.add(panel);
        this.setTitle(title);
        //noinspection SuspiciousNameCombination
        this.setSize(width, width);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }



}
