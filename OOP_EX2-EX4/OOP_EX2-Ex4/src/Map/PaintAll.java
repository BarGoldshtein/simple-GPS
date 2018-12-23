package Map;
/**
 * this class will paint all the fruit and packmans on the man
 * 
 * @author Bar Goldshtein ,Hai Hatan and Michael Shapira
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class PaintAll extends Panel{
	Pixel [] locations;
	
	 
    
     
	String ImgLocation;
	public PaintAll (Pixel [] dots, String ImgLocation) {
		this.ImgLocation=ImgLocation;
		locations=new Pixel[dots.length];
		for (int i=0; i<dots.length; i++) {
			locations[i] = new Pixel(dots[i]);
		}
		
	}
	
	public void paint(Graphics g) {
		
		try {
			BufferedImage img = ImageIO.read(new File(ImgLocation));
			g.drawImage(img, 0, 0, null);
		} catch (Exception e) {
			System.err.println(e);
		}
		for (int i=0; i<locations.length; i++) {
			g.setColor(Color.RED);
			g.drawOval(locations[i].getY(), locations[i].getX(), 10, 10);
			g.fillOval(locations[i].getY(), locations[i].getX(), 10, 10);
		}
	}
}
