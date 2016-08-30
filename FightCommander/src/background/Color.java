package background;

public enum Color {
	
	Normal("normal", new float[] {1f,1f,1f}),
	Blue("blue", new float[] {0,1f,1f}),
	Red("red", new float[]  {1f,0,1f}),
	Yellow("yellow",new float[]  {1f,1f,0});
	
	String colorName;
	float[] color;
	
	Color(String colorName, float[] color) {
		this.colorName = colorName;
		this.color = color;

		
	}

	public float[] getColor() {
		return color;
	}



}
