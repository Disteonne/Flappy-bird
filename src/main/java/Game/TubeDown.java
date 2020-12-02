package Game;

import javax.swing.*;
import java.awt.*;

public class TubeDown {
    int x;
    int y;
    int v;

    Image tubeDown=new ImageIcon("C:\\Users\\huawei\\IdeaProjects\\FlappyBird\\src\\main\\java\\Game\\res\\tube_down.png").getImage();
    Sky sky;
    public TubeDown(int x, int y, int v, Sky sky){
        this.x=x;
        this.y=y;
        this.v=v;
        this.sky=sky;
    }

    public void see(){
        x=x-sky.bird.v+v;
    }
}
