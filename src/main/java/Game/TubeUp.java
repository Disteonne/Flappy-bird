package Game;

import javax.swing.*;
import java.awt.*;

public class TubeUp  {
    int x;
    int y;
    int v;


    Image tube;//=new ImageIcon("C:\\Users\\huawei\\IdeaProjects\\FlappyBird\\src\\main\\java\\Game\\res\\tube_up_1.png").getImage();
    Sky sky;
    public TubeUp(int x, int y, int v, Sky sky){
        this.x=x;
        this.y=y;
        this.v=v;
        this.sky=sky;
        tube=new ImageIcon("C:\\Users\\huawei\\IdeaProjects\\FlappyBird\\src\\main\\java\\Game\\res\\both_tube_1.png").getImage();
    }

    public TubeUp(int x,int y,int v,Sky sky,String str){
        this.x=x;
        this.y=y;
        this.v=v;
        this.sky=sky;
        tube=new ImageIcon("C:\\Users\\huawei\\IdeaProjects\\FlappyBird\\src\\main\\java\\Game\\res\\tube_down.png").getImage();

    }

    public void see(){
        x=x-sky.bird.v+v;
    }

}
