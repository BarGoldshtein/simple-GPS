package Game;


	import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;

	public class myFrameThread  extends JFrame {

	    public myFrameThread () throws IOException {

	        initUI();
	    }
	    
	    private void initUI() throws IOException {
	        
	        add(new myFrame());

	        setResizable(false);
	        pack();
	        
	        setTitle("Pac");    
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
	    }

	    public static void main(String[] args) {
	        
	        EventQueue.invokeLater(() -> {
	            JFrame ex = null;
				try {
					ex = new myFrameThread ();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            ex.setVisible(true);
	        });
	    }
	}

