package Player;

import background.Tile;
import background.TileGrid;
import background.TileType;
import movement.Movement;

import static helpers.Artist.*;

import java.util.Arrays;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import Figures.Figure;

public class Player {
	
	private TileType[] types;
	private TileGrid tileGrid;
	private int index;
	private Tile selected; 
	private boolean prevMouseState;
	
	public Player(TileGrid grid) {
		this.tileGrid = grid;
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Sand;
		this.types[2] = TileType.Water;
		this.index = 0;
		
	}
	
	public void setTile(){
		tileGrid.setTile((int) Math.floor(Mouse.getX() / 64),
				(int) Math.floor(HEIGHT - Mouse.getY() -1) / 64,
				types[index]);
	}
	
	public Tile getTile(){
		return tileGrid.getTile((int) Math.floor(Mouse.getX() / 64),
				(int) Math.floor(HEIGHT - Mouse.getY() -1) / 64);
	} 
	
	public void update() {
		mouseClick();
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				moveIndex();
			}
		}
	}
	
	private void mouseClick(){
		
		
		
		
		if (Mouse.isButtonDown(0) && !prevMouseState) {
			prepareField();
			onCLick();

		}
		prevMouseState = Mouse.isButtonDown(0);
	}
	
	private void prepareField(){
		System.out.println("prepare Field");
		tileGrid.setAllColorsNormal();
	}
	
	private void onCLick(){
	
		if (getTile() != selected) {
			if(selected == null){
				selected = getTile();
				if (getTile() != null) {
					Movement.showPossibleMoves(tileGrid, (int) getTile().getPosX(), (int) getTile().getPosY());
				};
			}else {	
				if (selected.getFigure() != null && makeMove()){
					selected = null;
					tileGrid.setAllColorsNormal();
				} else {
					selected = getTile();
					if (getTile().getFigure() != null){
						Movement.showPossibleMoves(tileGrid, (int) getTile().getPosX(), (int) getTile().getPosY());
						System.out.println("Figure is on the Fields");
						// Zeichne Umriss um Figure
						// show possible movements
					} else if (getTile().getBuilding() != null){
						System.out.println("Building is on the Fields");
						// Zeige "Action" des Gebaeudes and
					} else {
						System.out.println("Nothing is on the Fields");
						tileGrid.setAllColorsNormal();
					}
				}		
			}
		}
	}
	
	public boolean makeMove(){
		if (Arrays.asList(Movement.showPossibleMoves(tileGrid, (int) selected.getPosX(), (int) selected.getPosY())).contains(getTile())){
			Figure helpFigure = selected.getFigure();
			selected.setFigure(null);
			getTile().setFigure(helpFigure);
			return true;
		}
		return false;
	}
	
	private void moveIndex() {
		index++;
		if (index > types.length - 1) {
			index = 0;
		}
	}


}
