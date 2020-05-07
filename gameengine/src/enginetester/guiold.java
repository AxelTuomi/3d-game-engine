package enginetester;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class guiold implements ActionListener, ItemListener {
	
	private boolean reactskipper = true;
	private String currentaspectratio = "16:9";
	private String[] aspectratios = new String[] {"16:9", "4:3"};
	private String[][] resolutions = new String[][] {{"1920 x 1080", "1600 x 900", "1388 x 868", "1280 x 720", "1280 x 600"}, {"1400 x 1050", "1280 x 1024", "1280 x 960", "1152 x 864", "1024 x 768", "800 x 600", "640 x 480"}};
	private JComboBox<String> aspectratioscombo;
	private JComboBox<String> resolutionscombo;
	private JPanel panel; 
	private JFrame frame; 
	
	public guiold() {
		try  {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception ex) {
			
		}
		//frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("gui");
		frame.pack();
		frame.setVisible(true);
		frame.setSize(500, 500);
		
		//initialize components
		JLabel resolutiontext = new JLabel("resolution");
		aspectratioscombo = new JComboBox<>(aspectratios);
		aspectratioscombo.addItemListener(this);
		resolutionscombo = new JComboBox<>(resolutions[0]);
		JButton runbutton = new JButton("run");
		runbutton.addActionListener(this);
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		
		//add components
		frame.add(panel, BorderLayout.CENTER);
		panel.add(resolutiontext);
		panel.add(aspectratioscombo);
		panel.add(resolutionscombo);
		panel.add(runbutton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String resolution = (String) resolutionscombo.getSelectedItem();
		frame.dispose();
		maingameloop.gameloop(resolution);
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
			
				resolutionscombo.setModel(new DefaultComboBoxModel<String>(resolutions[0]));
			}
			if (currentaspectratio == "4:3") {

				resolutionscombo.setModel(new DefaultComboBoxModel<String>(resolutions[1]));
			}
			reactskipper = true;
		}
	}
	
}
