package Game;

import javax.swing.*;
import java.awt.*;

public class Tube {
    int x;
    int y;
    int v;

    Image tube=new ImageIcon("C:\\Users\\huawei\\IdeaProjects\\FlappyBird\\src\\main\\java\\Game\\res\\tube_up.png").getImage();
    Sky sky;
    public Tube(int x,int y,int v,Sky sky){
        this.x=x;
        this.y=y;
        this.v=v;
        this.sky=sky;
    }

    public void see(){
        x=x-sky.bird.v+v;
    }
}
