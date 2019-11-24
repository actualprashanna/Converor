import javax.swing.JFrame;

/**
 * The main driver program for the GUI based conversion program.
 * 
 * @author mdixon
 */
public class Converter {
	 
    public static void main(String[] args) {
    	
        JFrame frame = new JFrame("Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500,200,700,400);
        
        MainPanel panel = new MainPanel();
        
        frame.setJMenuBar(panel.setupMenu());
    
        frame.getContentPane().add(panel);
        
      
        frame.setVisible(true);
    }
}


