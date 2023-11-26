import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean is_play = false;
    private int score = 0;
    private int total_bricks = 21;
    private MapGenerator map_generator;
    private Timer time;
    private int delay = 8;
    private int player_x = 310;
    private int ball_position_x = 120;
    private int ball_position_y = 350;
    private int ball_direction_x = -1;
    private int ball_direction_y = -2;


    public GamePlay() {
        map_generator = new MapGenerator(3 , 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time =  new Timer(delay , this);
        time.start();
    }

    public void paint(Graphics g) {
        //draw background
        g.setColor(Color.black);
        g.fillRect(1 , 1 , 692 , 592);

        //draw the map
        map_generator.draw((Graphics2D) g);

        //draw borders
        g.setColor(Color.black);
        g.fillRect(0 , 0, 3 , 592);
        g.fillRect(0 , 0, 692 , 3);
        g.fillRect(692 , 0 , 3 , 592);

        //the bottom
        g.setColor(Color.green);
        g.fillRect(player_x , 550 , 100 , 8);

        //the ball
        g.setColor(Color.yellow);
        g.fillOval(ball_position_x , ball_position_y , 20 , 20);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();

        if (is_play) {
            if (new Rectangle(ball_position_x , ball_position_y , 20 , 20).intersects(new Rectangle(player_x , 555, 100 , 8))) {
                ball_direction_y = -ball_direction_y;
            }

            //A it is like a label and it helps us to know who is the loop that break (instead of write 'break' several times)
            A: for (int i = 0; i < map_generator.map.length; i++) {
                for (int j = 0; j < map_generator.map[0].length; j++) {
                    if(map_generator.map[i][j] > 0) {
                        int brick_x = j*map_generator.brick_width + 80;
                        int brick_y = i*map_generator.brick_height + 50;
                        int brick_width = map_generator.brick_width;
                        int bruck_height = map_generator.brick_height;


                        Rectangle rect = new Rectangle(brick_x , brick_y , brick_width , bruck_height);
                        Rectangle ball_rect = new Rectangle(ball_position_x , ball_position_y , 20 , 20);
                        Rectangle brick_rect = rect;

                        if (brick_rect.intersects(brick_rect)) {
                            map_generator.set_brick_value(0 , i , j);
                            total_bricks--;
                            score += 5;

                            if ((ball_position_x+19) <= brick_rect.x || (ball_position_x+1) >= (brick_rect.x+ brick_rect.width)) {
                                ball_direction_x = -ball_direction_x;
                            }

                            else {
                                ball_direction_y = -ball_direction_y;
                            }

                            break A;
                        }
                    }
                }
            }

            ball_position_x += (ball_direction_x+ball_direction_x);
            ball_position_y += (ball_direction_y+ball_direction_y);

            if (ball_position_x < 0) {
                ball_direction_x = -ball_direction_x;
            }

            if (ball_position_y < 0) {
                ball_direction_y = -ball_direction_y;
            }

            if (ball_position_x > 670) {
                ball_direction_x = -ball_direction_x;
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (player_x >= 600) {
                player_x = 600;
            }
            else {
                move_right();
            }
        }

        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (player_x < 10) {
                player_x = 10;
            }
            else {
                move_left();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public void move_right() {
        is_play = true;
        player_x += 20;
    }


    public void move_left() {
        is_play = true;
        player_x -= 20;
    }

}
