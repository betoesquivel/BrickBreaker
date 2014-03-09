package Source;

/*
 *    Brick Breaker, Version 1.2
 *    By Ty-Lucas Kelley
 *	
 *	 **LICENSE**
 *
 *	 This file is a part of Brick Breaker.
 *
 *	 Brick Breaker is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    Brick Breaker is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with Brick Breaker.  If not, see <http://www.gnu.org/licenses/>.
 */
//This "Paddle" class extends the "Structure" class. It is used for the player's paddle in the game.
//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.ImageObserver;

//Class definition
public class Paddle extends Structure implements Constants {

    //Variables
    private int xSpeed;
    private int direction;
    private ImageIcon icono1;    //icono.
    private ImageIcon icono2;    //icono.
    private ImageIcon icono3;    //icono.
    private int agrandar;
    private final Animacion animacion;
    

    //Constructor
    public Paddle(int x, int y, int width, int height, Color color, Image paddle1, Image paddle2, Image paddle3) {
        super(x, y, width, height, color);
        direction = PADDLE_STOP;
        xSpeed = PADDLE_DEFAULT_SPEED;
        //icono1 = new ImageIcon(paddle1);
        //icono2 = new ImageIcon(paddle2);
        //icono3 = new ImageIcon(paddle3);
        agrandar = 0;
        
        //Image barra1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesbueno/nino1.gif"));
        //Image barra2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesbueno/nino2.gif"));
        //Image barra3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesbueno/nino3.gif"));
        
        animacion = new Animacion();
        animacion.sumaCuadro(paddle1, 100);
        animacion.sumaCuadro(paddle2, 100);
        animacion.sumaCuadro(paddle3, 100);
    }
    
    /*
     * Metodo de acceso que regresa la imagen del icono 
     * @return un objeto de la clase <code>Image</code> que es la imagen del icono.
     */
   public Image getImagenI() {
           //return icono.getImage();
       return (new ImageIcon(animacion.getImagen())).getImage();
   }
    
    public void actualiza(long tiempo) {
        animacion.actualiza(tiempo);
    }

    //Getters and Setters
    /**
     * Access function getxSpeed
     * @return variable xSpeed type <code>int</code>
     */
    public int getxSpeed() {
        return xSpeed;
    }

    /**
     * Modify function setxSpeed
     * @param xSpeed type <code>int</code>
     */
    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }
    
    /**
     * Modify function setxSpeed
     * @param agrandar type <code>int</code>
     */
    public void setAgrandar(int a) {
        agrandar = a;
    }
    /**
     * Access function getxSpeed
     * @return variable agrandar type <code>int</code>
     */
    public int getAgrandar() {
        return agrandar;
    }

    /**
     * Access function getDirection
     * @return variable direction type <code>int</code>
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Modify function setDirection
     * @param direction type <code>int</code>
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    //Draws the paddle
    @Override
    public void draw(Graphics g) {
        //g.setColor(color);
        //g.fillRect(x, y, width, height);
        g.drawImage(this.getImagenI(), x, y, null);
        
        if (agrandar==1) {
            g.drawImage(this.getImagenI(), x + PADDLE_WIDTH, y, null);
        }
        
        if (agrandar==2) {
            g.drawImage(this.getImagenI(), x + PADDLE_WIDTH, y, null);
            g.drawImage(this.getImagenI(), x + 2 * PADDLE_WIDTH, y, null);
        }
    }
    

    //Places the paddle back in starting position at center of screen
    public void reset() {
        x = PADDLE_X_START;
        y = PADDLE_Y_START;
    }

    //Checks if the ball hit the paddle
    public boolean hitPaddle(int ballX, int ballY) {
        if ((ballX >= x) && (ballX <= x + width) && ((ballY + 27 >= y) && (ballY + 27 <= y + height))) {
            return true;
        }
        return false;
    }

    //Resizes the paddle if it touches an item, then returns true or false
    public boolean caughtItem(Item i) {
        if ((i.getX() < x + width) && (i.getX() + i.getWidth() > x) && (y == i.getY() || y == i.getY() - 1)) {
            i.resizePaddle(this);
            return true;
        }
        return false;
    }

    //Moves the paddle in the direction it should move
    public void move() {
        switch (direction) {
            case PADDLE_LEFT:
                setX(getX() - xSpeed);
                break;
            case PADDLE_RIGHT:
                setX(getX() + xSpeed);
                break;
            case PADDLE_STOP: //no hago nada
                break;
        }
    }
}
