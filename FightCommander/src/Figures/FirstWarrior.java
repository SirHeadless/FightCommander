package Figures;

import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;

public class FirstWarrior implements Figure {

	private float health = 100;
	private int maxMove = 3;
	private static String Name = "FirstWarrior";
	private Texture texture = QuickLoad("FirstWarrior");
	
	public FirstWarrior(float health, int maxMove) {
		this.health = health;
		this.maxMove = maxMove;
	}
	
	public FirstWarrior() {
	}
	
	@Override
	public float getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHealth(float health) {
		// TODO Auto-generated method stub
		this.health = health;
	}

	@Override
	public int getMaxMovements() {
		// TODO Auto-generated method stub
		return maxMove;
	}

	@Override
	public void setMaxMovements(int maxMove) {
		// TODO Auto-generated method stub
		this.maxMove = maxMove;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return texture;
	}

}
