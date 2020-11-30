package Game;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame=new JFrame("Flappy Bird vers by Di");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1320,980);
        mainFrame.add(new Sky());

        mainFrame.setVisible(true);


    }
}
