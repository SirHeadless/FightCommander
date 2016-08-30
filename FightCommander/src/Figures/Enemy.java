package Figures;

import org.newdawn.slick.opengl.Texture;

import background.Tile;

import static helpers.Artist.*;

public class Enemy {
	
	private int width, height, health;
	private float x, y, speed;
	private Texture texture;
	private Tile startTile;
	
	public Enemy(Texture texture, Tile startTile, int width, int height, int health, float speed) {
		super();
		this.width = width;
		this.height = height;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.health = health;
		this.speed = speed;
		this.texture = texture;
	}
	
	public void Draw() {
		DrawQuadTex(texture, x, y, width, height);
	}


}
