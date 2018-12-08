import javax.swing.*;
import java.awt.*;



public class GamePanel extends JPanel {
    Snake snake;
    JLabel score;
    public static int currentScore = 0;
    public static boolean gameState = true;
    Color background = Color.decode("#3E3C45");


    public GamePanel(Snake snake, JLabel score){
        this.snake = snake;
        this.score = score;

        add(score);
        score.setForeground(Color.white);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the head square on the board
        g.setColor(snake.snakeColour);

        for (Point p : snake.snakePosArray) {
            System.out.println("Drawing snake @ x:"+ p.x +" & y:" + p.y);
            g.fillRect(p.x, p.y, snake.partSize, snake.partSize);
        }

        setBackground(background);
    }

    //TODO next, Update score TODO

}
