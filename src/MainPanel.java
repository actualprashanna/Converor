import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * The main graphical panel used to display conversion components.
 * 
 * This is the starting point for the assignment.
 * 
 * The variable names have been deliberately made vague and generic, and most comments have been removed.
 * 
 * You may want to start by improving the variable names and commenting what the existing code does.
 * 
 * @author mdixon
 */
@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	private JTextField txtValue;	
	private JButton btnConvert;
	private JButton btnExit;
	private JCheckBox chkReverse;
	private JLabel lblResult;
	private JLabel counter;

	private final static String[] list = { "inches/cm","Miles/Nautical Miles","Acres/Hectares","Miles per hour/Kilometres per hour","Yards/Metres","Celsius/Fahrenheit","Degrees/Radians" };
	int count = 0;

	private JComboBox<String> combo;


	JMenuBar setupMenu() {

		JMenuBar menuBar = new JMenuBar();

		JMenu m1 = new JMenu("File");
		menuBar.add(m1);
		
		JMenuItem item1=new JMenuItem("new");
		m1.add(item1);
		
		JMenuItem item4=new JMenuItem("print");
		m1.add(item4);
		
		JMenuItem item2 = new JMenuItem("Exit");
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}});
		m1.add(item2);
		
		
		JMenu m2 = new JMenu("Help");
		JMenuItem item3=new JMenuItem("About");
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This application is used to convert numeric values to different numeric values using different conditions \n Author: Prashanna Nepal \n © Prashanna",null,JOptionPane.PLAIN_MESSAGE);
			}});
		m2.add(item3);
		
		menuBar.add(m2);



		return menuBar;
	}

	MainPanel() {
        
		setLayout(null);
		ActionListener listener = new ConvertListener();
		
		JLabel lblSelectYourChoice = new JLabel("Select Your Choice:");
		lblSelectYourChoice.setFont(new Font("Open Sans", Font.BOLD, 20));
		lblSelectYourChoice.setForeground(new Color(3,3,3));
		lblSelectYourChoice.setBounds(31, 29, 187, 27);
		add(lblSelectYourChoice);


		combo = new JComboBox<String>(list);
		combo.setBounds(273, 29, 100, 20);
		//combo.addActionListener(listener); //convert values when option changed
		add(combo);
		
		JLabel lblEnterAValue = new JLabel("Enter a numerical  value");
		lblEnterAValue.setForeground(new Color(0,0,0));
		lblEnterAValue.setFont(new Font("Open Sans", Font.BOLD, 19));
		lblEnterAValue.setBounds(31, 73, 237, 27);
		add(lblEnterAValue);

		txtValue = new JTextField();
		txtValue.setToolTipText("put a value to convert ");
		txtValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					btnConvert.doClick();
			}
		});
		txtValue.setBounds(273, 73, 237, 27);
		add(txtValue);
		txtValue.setColumns(10);
		
	
		btnConvert = new JButton("Convert");
		btnConvert.setToolTipText("Press here");
		btnConvert.setMnemonic(KeyEvent.VK_C);
		btnConvert.addActionListener(listener);
				
		btnConvert.setForeground(new Color(0,0,0));
		btnConvert.setFont(new Font("Comic sans ms", Font.BOLD, 19));
		btnConvert.setBackground(new Color(210,0,0));
		btnConvert.setBounds(273, 117, 119, 29);
		add(btnConvert);

		btnExit = new JButton("Exit");
		
		btnExit.setToolTipText("Press here to exit");
		btnExit.setMnemonic(KeyEvent.VK_E);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(210,0,0));
		btnExit.setFont(new Font("Open Sans", Font.BOLD, 19));
		btnExit.setForeground(new Color(0,0,0));
		btnExit.setBounds(415, 232, 95, 29);
		add(btnExit);

		chkReverse = new JCheckBox("Reverse");
		chkReverse.setToolTipText("select to reverse the operation");
		chkReverse.setBounds(415, 117, 95, 29);
		add(chkReverse);



		JLabel lblCount = new JLabel("Count : ");
		lblCount.setForeground(new Color(0,0,0));
		lblCount.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblCount.setBounds(31, 236, 71, 27);
		add(lblCount);

		counter = new JLabel("");
		counter.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		counter.setFont(new Font("Open Sans", Font.BOLD, 19));
		counter.setBounds(117, 236, 71, 27);
		add(counter);
		
		JLabel output = new JLabel("Result:");
		output.setForeground(new Color(0,0,0));
		output.setFont(new Font("Open Sans", Font.BOLD, 19));
		add(output);

		lblResult = new JLabel("");
		lblResult.setToolTipText("your results will be published in this area.");
		lblResult.setForeground(new Color(0,0,0));
		lblResult.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblResult.setBounds(31, 175, 398, 27);
		add(lblResult);

		
		JButton btnReset = new JButton("Reset");
		btnReset.setToolTipText("Press here to reset values");
		btnReset.setMnemonic(KeyEvent.VK_R);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				combo.setSelectedIndex(0);
				txtValue.setText(null);
				chkReverse.setSelected(false);
				lblResult.setText(null);
				counter.setText(null);
				count = 0;
				txtValue.grabFocus();
			}
		});
		btnReset.setForeground(new Color(0,0,0));
		btnReset.setBackground(new Color(210,0,0));
		btnReset.setFont(new Font("Open Sans", Font.BOLD, 19));
		btnReset.setBounds(273, 232, 119, 29);
	    add(btnReset);
	     
		setBackground(Color.WHITE);
	}

	private class ConvertListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			String text = txtValue.getText().toString().trim();
			Boolean b = chkReverse.isSelected();
			NumberFormat formatter = new DecimalFormat("#.##");
			
			
			if (text.isEmpty() == b) {
				try {
				double value = Double.parseDouble(text);

				// the factor applied during the conversion
				double factor = 0;

				// the offset applied during the conversion.
				double offset = 0;

				// Setup the correct factor/offset values depending on required conversion
				switch (combo.getSelectedIndex()) {

				case 0: // inches/cm
					factor = 2.54;
					break;
					
				case 1:	//miles to nautical miles
					factor=0.594;
					break;
					
				case 2: //acre to hectors
					factor=0.404686;
					break;
				case 3: //miles per hour to km per hour
					factor=1.60934;
					break;
				case 4: //Yards to meters
					factor=0.9144;
					break;
				case 5: //Celcius to farenheit
					factor=0.404686;
					offset=32;
					break;
				case 6: //Degrees to radian
					factor=0.0174533;
					break;
				}
				double result = factor * value + offset;
				
				lblResult.setText(formatter.format(result));
				}catch (NumberFormatException e) {
					
					JOptionPane.showMessageDialog(null, "Please Enter Correctly!!");
					return;
				}
				
				
		}else {
					double value = Double.parseDouble(text);

					// the factor applied during the conversion
					double factor = 0;

					// the offset applied during the conversion.
					double offset = 0;

					// Setup the correct factor/offset values depending on required conversion
					switch (combo.getSelectedIndex()) {

					case 0: // cm to inches
						factor = 0.236;
						break;
						
					case 1:
						factor=0.393701;
						break;
					case 2:
						factor=1.15078;
						break;
					case 3:
						factor=2.47105;
						break;
					case 4:
						factor=0.621371;
						break;
					case 5:
						factor=0.404686;
						offset=-32;
						break;
					case 6:
						factor=57.2958;
						break;
					
				}
					
					double result = factor * value + offset;
					lblResult.setText(formatter.format(result));
					
				}
			
			
			
			count++;
			counter.setText(String.valueOf(count));
		
				}
	}
}





