package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
public class CyclingEnemy extends GameObject{
        private Handler handler;
        private Point center;
        private float centerX, centerY;
        public CyclingEnemy(float x, float y, ID id, Handler handler){
                super(x,y,id);
                this.handler = handler;
                centerX = x;
                centerY = y;
                velX = 5;
                velY = 5;
        }
        
        public Rectangle getBounds(){
                return new Rectangle((int) x,(int) y, 16, 16);
        }
        
        public void tick(){
                x += velX;
                y += velY;     
                //if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
                //if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
                handler.addObject(new Trail((int)x,(int) y, ID.Trail, Color.red, 16, 16, 0.02f,handler));
        }
        public void render(Graphics g){
                g.setColor(Color.red);
                g.fillRect((int)centerX,(int) centerY,16,16);
        }
}