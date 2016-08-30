package Figures;

import org.newdawn.slick.opengl.Texture;

public interface Figure {

	public float getHealth();
	
	public void setHealth(float health);
	
	public int getMaxMovements();
	
	public void setMaxMovements(int maxMove);
	
	public String getName();
	
	public Texture getTexture();
	
}
