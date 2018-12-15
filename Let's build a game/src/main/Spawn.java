package main;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private Random r;
	private int scoreKeep = 0;

	public Spawn(Handler handler, HUD hud, Random rand) {
		this.handler = handler;
		this.hud = hud;
		this.r = rand;
	}

	public void tick() {
		scoreKeep++;
		if (scoreKeep >= 250) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
//			if (hud.getLevel() == 2) {
//				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy,
//						handler));
//			} else if (hud.getLevel() == 3) {
//				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy,
//						handler));
//			} else if (hud.getLevel() == 4) {
//				handler.addObject(
//						new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
//			} else if (hud.getLevel() == 5) {
//				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy,
//						handler));
//			} else if (hud.getLevel() == 6) {
//				handler.addObject(
//						new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
//			} else if (hud.getLevel() == 10) {
//				handler.clearEnemys();
//				handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
//			}
		}
	}
}