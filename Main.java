import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(10 , 10 , 700 , 600);
        frame.setTitle("Brick breaker");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        //create the menu bar
//        JMenuBar menu_bar = new JMenuBar();
//
//        JMenu menu_home = new JMenu("Home");
//        JMenu menu_settings = new JMenu("Settings");
//        JMenu menu_help = new JMenu("Help");
//        JMenu menu_profile = new JMenu("Profile");
//
//        JMenuItem exit_item = new JMenuItem("Exit");
//        JMenuItem how_play_item = new JMenuItem("How to play");
//
//        exit_item.addActionListener(this);
//

//        menu_home.add(exit_item);
//        menu_help.add(how_play_item);

//        //add the menu items to the manu bar
//        menu_bar.add(menu_home);
//        menu_bar.add(menu_settings);
//        menu_bar.add(menu_help);
//        menu_bar.add(menu_profile);
//
//        //add the manu bar to the frame we created
//        frame.setJMenuBar(menu_bar);

        //adding the game board to the frame we created
        GamePlay game_play = new GamePlay();
        frame.add(game_play);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
