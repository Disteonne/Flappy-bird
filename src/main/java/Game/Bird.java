package Game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Bird {

    public static final int MAX_TOP = 0;
    public static final int MAX_BOT = 680;

    Image bird = new ImageIcon("C:\\Users\\huawei\\IdeaProjects\\FlappyBird\\src\\main\\java\\Game\\res\\bird_right.png").getImage();
    boolean isPassed = false;

    int v = 3;
    int a = 0;
    int s = 0;

    int x = 100;
    int y = 230;

    int changeX = 0;
    int changeY = 0;


    int layer1 = 0;
    int layer2 = 1560;

    public void fly() {
        v += a;
        s += v;
        x += changeX;
        y -= changeY;
        if(y<=0){
            y=MAX_TOP;
            bird=new ImageIcon("C:\\Users\\huawei\\IdeaProjects\\FlappyBird\\src\\main\\java\\Game\\res\\bird_right.png").getImage();
        }
        if(y>=680){
            y=MAX_BOT;
            bird=new ImageIcon("C:\\Users\\huawei\\IdeaProjects\\FlappyBird\\src\\main\\java\\Game\\res\\bird_right.png").getImage();
        }
        if (layer2 - v <= 0) {
            layer1 = 0;
            layer2 = 1560;
        } else {
            layer1 -= v;
            layer2 -= v;
        }
    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            a = 0;
            changeX = 0;
            changeY = 8;
            //bird_up.png
            bird = new ImageIcon("C:\\Users\\huawei\\IdeaProjects\\FlappyBird\\src\\main\\java\\Game\\res\\bird_up.png").getImage();
            isPassed = true;
        }

    }

    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            a = 0;
            changeX = 0;
            changeY = -8;
            //bird_down.png
            bird = new ImageIcon("C:\\Users\\huawei\\IdeaProjects\\FlappyBird\\src\\main\\java\\Game\\res\\bird_down.png").getImage();
            //if(isPassed){
            //    a=-1;
            //    isPassed=false;
            //}

        }
    }
}
