package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Sky extends JPanel  implements ActionListener,Runnable {
    //Доработать вызова картинки из любой дирректории пользователя
    ArrayList<Tube> listTube=new ArrayList<Tube>();
    Image image=new ImageIcon("C:\\Users\\huawei\\IdeaProjects\\FlappyBird\\src\\main\\java\\Game\\res\\Sky.jpg").getImage();

    Bird bird=new Bird();
    Thread tube=new Thread(this);


    Timer timer=new Timer(20,this);
    @Override
    public void paint(Graphics g) {
        g= (Graphics2D) g;
        g.drawImage(image,bird.layer1,0,null);
        g.drawImage(image,bird.layer2,0,null);
        g.drawImage(bird.bird, bird.x,bird.y,null);

        Iterator<Tube> iterator=listTube.iterator();
        while (iterator.hasNext()){
            Tube tube=iterator.next();
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
                int newX=1050;//random.nextInt(1200);
                int newY=-random.nextInt(500);
                listTube.add(new Tube(newX,newY,0,this));
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
