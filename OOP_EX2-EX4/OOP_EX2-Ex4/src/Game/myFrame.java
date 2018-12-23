package Game;

	import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

	public class myFrame extends JPanel
	        implements Runnable {

	    private final int B_WIDTH = 1920;
	    private final int B_HEIGHT = 1080;
	    private final int INITIAL_X = -40;//start point
	    private final int INITIAL_Y = -40;
	    private final int DELAY = 25;

	    private Image pac;
	    private Thread animator;
	    private int x, y;

	    public myFrame() throws IOException {

	        initBoard();
	    }

	    private void loadImage(String name) {

	        ImageIcon ii = new ImageIcon(name);
	        pac = ii.getImage();
	    }

	    private void initBoard() throws IOException {

	        setBackground(Color.BLACK);
	        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
	        BufferedImage img = ImageIO.read(new File("Ariel1.png"));
	        
	        loadImage("smallPac.jpg");

	        x = INITIAL_X;
	        y = INITIAL_Y;
	    }

	    @Override
	    public void addNotify() {
	        super.addNotify();

	        animator = new Thread(this);
	        animator.start();
	    }

	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        drawMap(g);
	    }

	    private void drawMap(Graphics g) {

	        g.drawImage(pac, x, y, this);
	        Toolkit.getDefaultToolkit().sync();
	    }

	    private void cycle(double angle) {

	        x += 5*Math.cos(angle); // cos
	        y += 5*Math.sin(angle);; // sin

	        if (y > B_HEIGHT) {

	            y = INITIAL_Y;
	            x = INITIAL_X;
	        }
	    }

	    @Override
	    public void run() {

	        long beforeTime, timeDiff, sleep;

	        beforeTime = System.currentTimeMillis();

	        while (true) {

	            cycle(270);
	            repaint();

	            timeDiff = System.currentTimeMillis() - beforeTime;
	            sleep = DELAY - timeDiff;

	            if (sleep < 0) {
	                sleep = 2;
	            }

	            try {
	                Thread.sleep(sleep);
	            } catch (InterruptedException e) {
	                
	                String msg = String.format("Thread interrupted: %s", e.getMessage());
	                
	                JOptionPane.showMessageDialog(this, msg, "Error", 
	                    JOptionPane.ERROR_MESSAGE);
	            }

	            beforeTime = System.currentTimeMillis();
	        }
	    }
//	    @Override
//	    public void addNotify() {
//	        super.addNotify();
//
//	        animator = new Thread(this);
//	        animator.start();
//	        
//	        timeDiff = System.currentTimeMillis() - beforeTime;
//	        sleep = DELAY - timeDiff;
//	    }
	}
	

