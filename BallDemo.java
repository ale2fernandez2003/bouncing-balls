import java.awt.Color;
import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBalls)
    {
        int ground = 400;   // position of the ground line
        
        Random random = new Random();
        
        
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall[] balls = new BouncingBall[numBalls];
        for (int i = 0; i < numBalls; i++) {
            int radio = random.nextInt(20) + 10;
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            int X = random.nextInt(550/2);
            int Y = random.nextInt(201);
            balls[i] = new BouncingBall(X, Y, radio, color, ground, myCanvas);
            balls[i].draw();
        }
        
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for (BouncingBall ball : balls) {
                ball.move();
                if (ball.getXPosition() >= 550) {
                    finished = true;
                }
                // stop once ball has travelled a certain distance on x axis

            }
        }
    }
}
