package background;

import static helpers.Artist.*;

import Figures.Figure;

public class TileGrid {

	public Tile[][] map;

	public TileGrid() {
		map = new Tile[20][15];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass, null, null);
			}
		}
	}

	public TileGrid(int[][] newMap) {
		map = new Tile[20][15];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (newMap[j][i]) {
				case 0:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass, null, null);
					break;
				case 1:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Sand, null, null);
					break;
				case 2:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Water, null, null);
					break;
				}
			}
		}
	}

	public void setTile(int xCoord, int yCoord, TileType type) {
		map[xCoord][yCoord] = new Tile(xCoord * 64, yCoord * 64, 64, 64, type, null, null);
	}

	public Tile getTile(int xCoord, int yCoord) {
		try {
			return map[xCoord][yCoord];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The Coordinates " + xCoord + ", " + yCoord + " are out of bounds");
			throw new ArrayIndexOutOfBoundsException("Out of Bound condition for map in TileGrid x:" + xCoord + ", y:" + yCoord );
		}
		
	}

	public void Draw() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getBuilding() != null ? t.getBuilding().getTexture() : null,
						t.getFigure() != null ? t.getFigure().getTexture() : null, t.getX(), t.getY(), t.getWidth(),
						t.getHeight(), t.getColor());
			}
		}
	}

	public void setFigure(Figure figure, int x, int y) {
		map[x][y].setFigure(figure);
	}
	
	public void setAllColorsNormal(){
		for (Tile[] row : map)
		{
		    for (Tile tile : row)
		    {
		         tile.setColor(Color.Normal);
		    }
		}
	}

}
