package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	Random r = new Random();
	Handler handler;
	final Color playerCol = Color.white;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	@SuppressWarnings("unused")
	private Color getOppositeColor(Color c) {
		return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
	}

	public void tick() {
		x += velX;
		y += velY;
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		handler.addObject(new Trail(x, y, ID.Trail, playerCol, 32, 32, 0.05f, handler));
		collision();
	}
	
	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy
					|| tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.EnemyBoss
					|| tempObject.getId() == ID.EnemyBossBullet) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH1 -= 2;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(playerCol);
		g.fillRect((int) x, (int) y, 32, 32);
	}
}