import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(10 , 10 , 700 , 600);
        frame.setTitle("Brick breaker");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //adding the game board to the frame we created
        GamePlay game_play = new GamePlay();
        frame.add(game_play);
    }

}
