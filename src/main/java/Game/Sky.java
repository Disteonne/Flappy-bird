package Game;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class Sky extends JPanel  implements ActionListener,Runnable {
    //Доработать вызова картинки из любой дирректории пользователя
    ArrayList<TubeUp> listTube=new ArrayList<TubeUp>();
    Map<TubeUp, TubeDown> tubeMap=new HashMap<TubeUp, TubeDown>();

    Image image=new ImageIcon("C:\\Users\\huawei\\IdeaProjects\\FlappyBird\\src\\main\\java\\Game\\res\\Sky.jpg").getImage();

    Bird bird=new Bird();
    Thread tube=new Thread(this);


    Timer timer=new Timer(40,this);
    @Override
    public void paint(Graphics g) {
        g= (Graphics2D) g;
        g.drawImage(image,bird.layer1,0,null);
        g.drawImage(image,bird.layer2,0,null);
        g.drawImage(bird.bird, bird.x,bird.y,null);

        /*
        Iterator<TubeUp> iteratorUp=tubeMap.keySet().iterator();
        Iterator<TubeDown> iteratorDown=tubeMap.values().iterator();
        while (iteratorUp.hasNext()){
            TubeUp tube=iteratorUp.next();
            tube.see();
            g.drawImage(tube.tube, tube.x, tube.y, null);
        }
        while (iteratorDown.hasNext()){
            TubeDown tube=iteratorDown.next();
            tube.see();
            g.drawImage(tube.tubeDown, tube.x, tube.y, null);
        }

         */


        Iterator<TubeUp> iterator=listTube.iterator();
        while (iterator.hasNext()){
            TubeUp tube=iterator.next();
                tube.see();
                g.drawImage(tube.tube, tube.x, tube.y, null);

        }

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        bird.fly();
        repaint();
    }

    public Sky(){
        timer.start();
        tube.start();
        addKeyListener(new myKeyAdapter());
        setFocusable(true);
    }


    public void run() {
        while (true) {
            Random random = new Random();
            try {
                Thread.sleep(2500);
                int newX=1450;//1050;//random.nextInt(1200);
                int newY=-random.nextInt(300);
                //int newXtubeDown=1540;
                //int newYtubeDown=random.nextInt(1200);
                if(newY!=0 && newY<-50) {
                    listTube.add(new TubeUp(newX, newY, 0, this));
                    //if(newXtubeDown>800 && (newXtubeDown+newY)<=400) {
                    //    tubeMap.put(new TubeUp(newX,newY,0,this),new TubeDown(newXtubeDown,newYtubeDown,0,this));
                    //}
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class myKeyAdapter extends KeyAdapter{
        /**
         * Invoked when a key has been pressed.
         *
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            bird.keyPressed(e);
        }

        /**
         * Invoked when a key has been released.
         *
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            bird.keyReleased(e);
        }
    }
}
