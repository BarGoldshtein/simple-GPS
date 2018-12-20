package Map;

public class Pixel {
	
	private int x;
	private int y;
	
	public Pixel (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pixel(Pixel temp) {
		
	this.x=temp.getX();
	this.y=temp.getY();
	
	}
	
	public Pixel() {
		
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}
