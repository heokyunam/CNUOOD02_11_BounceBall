package GameRes;

import java.awt.Color;
import java.awt.Graphics;

public class Schanze extends GameObject{
        private Color color = Color.blue;
        @Override
        public void draw(Graphics g) {
                g.setColor(color);
                g.drawLine(x,y,x+width,y);
        }

        @Override
        public void collisionCheck(Ball ball) {
                // TODO Auto-generated method stub
                
        }

}