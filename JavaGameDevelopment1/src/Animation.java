import java.awt.Image;
import java.util.ArrayList;

public class Animation {
	
	private ArrayList scenes;
	private int sceneIndex;
	private long movieTime;
	private long totalTime;
	private int animationLenght;
	
	//constructor
	public Animation() {
		this.animationLenght = 5000;
		scenes = new ArrayList();
		totalTime = 0;
		start();	
	}
	
	public Animation(int Lenght) {
		this.animationLenght = Lenght;
		scenes = new ArrayList();
		totalTime = 0;
		start();	
	}
	
	
	//add scene to arrayList and set time for each scene
	public synchronized void  addScene(Image i, long t) {
		totalTime += t;
		scenes.add(new OneScene(i, totalTime));
	}
	
	//starts animation from beginning
	private synchronized void start() {
		movieTime = 0;
		sceneIndex = 0;
	}

	public int getAnimationLenght() {
		return animationLenght;
	}
	
	public void setAnimationLenght(int al) {
		this.animationLenght = al;
	}
	
	//change scenes
	public synchronized void update(long timePassed) {
		if(scenes.size()>1) {
			movieTime += timePassed;
			if(movieTime >= totalTime) {
				movieTime = 0;
				sceneIndex = 0;
			}
			while(movieTime > getScene(sceneIndex).endTime){
				sceneIndex++;
			}
		}
	}
	
	//get animation current scene
	public synchronized Image getImage() {
		if(scenes.size()==0) {
			return null;
		}else {
			return getScene(sceneIndex).pic;
		}
	}
	
	//get scene
	private OneScene getScene(int x) {
		return (OneScene)scenes.get(x);
	}
	
	//PRIVATE INNER CLASS
	
	private class OneScene {
		Image pic;
		long endTime;
		
		public OneScene(Image pic, long endTime) {
			this.pic = pic;
			this.endTime = endTime;
		}
	}
	
}
