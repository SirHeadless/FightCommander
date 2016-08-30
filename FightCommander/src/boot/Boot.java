package boot;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import Figures.Enemy;
import Figures.Figure;
import Figures.FirstWarrior;
import Player.Player;
import background.Color;
import background.TileGrid;
import background.TileType;
import movement.Movement;

import static helpers.Artist.*;

public class Boot {
	
	int[][] map = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	};

	public TileGrid tileGrid;
	
	public static void main(String[] args) {
		new Boot();
	}
	
	public Boot() {

		BeginSession();
		
		
	
		tileGrid = new TileGrid(map);
		tileGrid.setTile(3,3, TileType.Sand);
		Enemy e = new Enemy(QuickLoad("enemy"), tileGrid.getTile(10, 10), 64, 64, 100, 2);
		Figure Fw  = new FirstWarrior();
		Figure Fw2  = new FirstWarrior();
		tileGrid.setFigure(Fw, 5, 5);
		tileGrid.setFigure(Fw2, 10, 10);
		Object grid;
		Player player = new Player(tileGrid);
			
		while(!Display.isCloseRequested()) {

			getInput();
			
			
			tileGrid.Draw();
			e.Draw();
			player.update();
			
//			testMoves(5, 5);

//			DrawTransQuad(2*64,2*64,64,64);
//			DrawQuadTex(tileGrid.getTile(2,2).getTexture(),null, null, 2*64,2*64,64,64,Color.Blue);
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	

	
	private void getInput() {
		
		
	}



}
