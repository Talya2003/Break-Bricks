import java.awt.*;

public class MapGenerator {

    public int map[][];
    public int brick_width;
    public int brick_height;


    public MapGenerator(int row , int col) {
        map = new int[row][col];

        //initialization of the matrix of bricks
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
            }
        }

        //initialization the dimensions of the brick
        brick_width = 540/col;
        brick_height = 150/row;
    }


    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    g.setColor(new Color(110 , 75 , 0));
                    g.fillRect(j*brick_width+80 , i*brick_height+50 , brick_width , brick_height);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*brick_width+80 , i*brick_height+50 , brick_width , brick_height);
                }
            }
        }
    }

    //set the value of the bricks
    public void set_brick_value(int value , int row , int col) {
        map[row][col] = value;
    }

}
