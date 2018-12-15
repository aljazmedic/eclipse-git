package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {
	private Handler handler;
	Random r = new Random();

	private int timer = 60;
	private int timer2 = 50;

	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		velX = 0;
		velY = 2;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 96, 96);
	}

	public void tick() {
		x += velX;
		y += velY;
		if (timer <= 0)
			velY = 0;
		else
			timer--;

		if (timer <= 0)
			timer2--;
		if (timer2 <= 0) {
			if (velX == 0)
				velX = 2;
			velX *= 1.001f;
			
			velX = Game.clamp(velX, -10, 10);
			
			int spawn = r.nextInt(10);
			if (spawn == 0)
				handler.addObject(new EnemyBossBullet((int) x + 48, (int) y + 48, ID.EnemyBossBullet, handler));
		}
		// if(y <= 0 || y >= Game.HEIGHT - 87) velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 96)
			velX *= -1;
		// handler.addObject(new Trail((int)x,(int) y, ID.Trail, Color.red, 64, 64,
		// 0.02f,handler));
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 96, 96);
	}
}