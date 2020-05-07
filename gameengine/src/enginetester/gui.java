package enginetester;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.text.NumberFormatter;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class gui implements ActionListener, ItemListener {

	private boolean reactskipper = true;
	private String currentaspectratio = "16:9";
	private String[] aspectratios = new String[] {"16:9", "4:3"};
	private String[][] resolutions = new String[][] {{"1920 x 1080", "1600 x 900", "1388 x 868", "1280 x 720", "1280 x 600"}, {"1400 x 1050", "1280 x 1024", "1280 x 960", "1152 x 864", "1024 x 768", "800 x 600", "640 x 480"}};
	private JButton runbutton;
	private JComboBox<String> aspectratiobox;
	private JComboBox<String> resolutionbox;
	private JFrame frame;
	private JFormattedTextField mousesensetivityformattedtextfield;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				guidesign window = new guidesign();
	//				window.frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		System.out.println("gui");
		try  {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception ex) {
			
		}
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 10));
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setTitle("gameengine");
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel resolutionlabel = new JLabel("resolution");
		//resolutionlabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		resolutionlabel.setBounds(50, 50, 66, 13);
		frame.getContentPane().add(resolutionlabel);
		
		resolutionbox = new JComboBox<String>();
		resolutionbox.setBounds(50, 75, 82, 21);
		resolutionbox.setModel(new DefaultComboBoxModel<String>(resolutions[0]));
		frame.getContentPane().add(resolutionbox);
		
		JLabel aspectratiolabel = new JLabel("aspect ratio");
		//aspectratiolabel.setFont(new Font("Verdana", Font.PLAIN, 15));
		aspectratiolabel.setBounds(50, 125, 78, 13);
		frame.getContentPane().add(aspectratiolabel);
		
		aspectratiobox = new JComboBox<String>();
		aspectratiobox.setBounds(50, 150, 47, 21);
		aspectratiobox.setModel(new DefaultComboBoxModel<String>(aspectratios));
		aspectratiobox.addItemListener(this);
		frame.getContentPane().add(aspectratiobox);
		
		runbutton = new JButton("run");
		runbutton.setBounds(461, 401, 85, 21);
		runbutton.addActionListener(this);
		frame.getContentPane().add(runbutton);
		
		JLabel mousesensetivitylabel = new JLabel("mouse sensetivity");
		mousesensetivitylabel.setBounds(200, 50, 82, 13);
		frame.getContentPane().add(mousesensetivitylabel);
		
		mousesensetivityformattedtextfield = new JFormattedTextField();
		mousesensetivityformattedtextfield.setText("1.10");
		mousesensetivityformattedtextfield.setBounds(200, 76, 34, 19);
		frame.getContentPane().add(mousesensetivityformattedtextfield);
		
		NumberFormat format = NumberFormat.getNumberInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Double.class);
	    formatter.setMinimum(0.00);
	    formatter.setMaximum(10.00);
	    formatter.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatter.setCommitsOnValidEdit(true);
		mousesensetivityformattedtextfield = new JFormattedTextField(formatter);
		mousesensetivityformattedtextfield.setBounds(200, 76, 34, 19);
		frame.getContentPane().add(mousesensetivityformattedtextfield);
		
		frame.setVisible(true);
		

		//JLabel label = new JLabel(new ImageIcon("C:\\Users\\axelv\\OneDrive\\Dokument\\GitHub\\3d-game-engine\\gameengine\\src\\enginetester\\TonyStark.png"));
		//label.setBounds(323, 10, 263, 452);
		//frame.getContentPane().add(label);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
				if (reactskipper == true) {
					reactskipper = false;
				}
				else {
					currentaspectratio = (String) e.getItem();
					if (currentaspectratio == "16:9") {
					
						resolutionbox.setModel(new DefaultComboBoxModel<String>(resolutions[0]));
					}
					if (currentaspectratio == "4:3") {

						resolutionbox.setModel(new DefaultComboBoxModel<String>(resolutions[1]));
					}
					reactskipper = true;
				}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String resolution = (String) resolutionbox.getSelectedItem();
		frame.dispose();
		maingameloop.gameloop((String) resolutionbox.getSelectedItem(), (Double) mousesensetivityformattedtextfield.getValue());
		
	}
}
