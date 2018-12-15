package main;

import java.awt.Color;
import java.awt.Graphics;
public class HUD {
        public static float HEALTH1 = 100;
        private float greenValue = 255;
        private int score = 0;
        private int level = 1;
        public void tick(){
                HEALTH1 = (int) Game.clamp(HEALTH1, 0, 100);
                greenValue = (int) Game.clamp(greenValue, 0, 255);
                greenValue = HEALTH1 * 2;       
                score++;
        }
        public void render(Graphics g){
                g.setColor(Color.gray);
                g.fillRect(15, 15, 200, 32);
                g.setColor(new Color(75,(int) greenValue, 0));
                g.fillRect(15, 15,(int) HEALTH1 * 2, 32);
                g.setColor(Color.white);
                g.drawRect(15, 15, 200, 32);
                g.drawString("Score: " + score, 15, 64);
                g.drawString("Level: " + level, 15, 80);       
        }
        public void score(int score){
                this.score = score;
        }
        public int getScore(){
                return score;
        }
        public int getLevel(){
                return level;
        }
        public void setLevel(int level){
                this.level = level;
        }
}
