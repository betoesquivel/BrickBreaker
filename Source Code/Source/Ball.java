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

//This "Ball" class extends the "Structure" class. It is for the ball used in the game.

//Imports
import java.awt.*;
import javax.swing.ImageIcon;

//Class definition
public class Ball extends Structure implements Constants {
	//Variables
	private boolean onScreen;
	private double xDir = 1, yDir = -1;
        private int speed = BALL_DEFAULT_SPEED;
        private final Animacion animacion;

	//Constructor
	public Ball(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		setOnScreen(true);
                
                Image ball1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Source/images/bomb13_13.png"));
                Image ball2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Source/images/bomb14_14.png"));
                Image ball3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Source/images/bomb15_15.png"));
                Image ball4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Source/images/bomb16_16.png"));
                Image ball5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Source/images/bomb17_17.png"));
                Image ball6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Source/images/bomb18_18.png"));

                animacion = new Animacion();
                animacion.sumaCuadro(ball1, 100);
                animacion.sumaCuadro(ball2, 100);
                animacion.sumaCuadro(ball3, 100);
                animacion.sumaCuadro(ball4, 100);
                animacion.sumaCuadro(ball5, 100);
                animacion.sumaCuadro(ball6, 100);
                
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

	//Draw the ball
	@Override
	public void draw(Graphics g) {
		//g.setColor(color);
		//g.fillOval(x, y, width, height);
                g.drawImage(this.getImagenI(), x, y, null);
	}

	//Moves the ball
	public void move() {
		x += xDir;
		y += yDir;
	}

	//Resets the ball to original position at center of screen
	public void reset() {
		x = BALL_X_START;
		y = BALL_Y_START;
		xDir = 1;
		yDir = -1;
	}

	//Mutator methods
	public void setXDir(int xDir) {
		this.xDir = xDir;
	}

	public void setYDir(int yDir) {
		this.yDir = yDir;
	}

	public void setOnScreen(boolean onScreen) {
		this.onScreen = onScreen;
	}

	//Accessor methods
	public double getXDir() {
		return xDir;
	}

	public double getYDir() {
		return yDir;
	}

	public boolean isOnScreen() {
		return onScreen;
	}
}
