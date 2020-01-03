package face;

import java.awt.BorderLayout;
import java.awt.EventQueue;
//import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

/**
 * Class contains the frame and layouts of the face application.
 * @author Heberto Rodriguez, Assignment A06 Face
 *
 */
public class Face extends JFrame {

	private JPanel contentPane;
	private ImagePanel facePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Face frame = new Face();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}		

	/**
	 * Create the frame.
	 */
	public Face() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel controlPanel = createControlPanel();
		contentPane.add(controlPanel, BorderLayout.WEST);
		
		facePanel = createFacePanel();
		contentPane.add(facePanel, BorderLayout.CENTER);

	}

	/**
	 * creates the facePanel which displays the images.
	 * @return
	 */
	private ImagePanel createFacePanel() {
		ImagePanel facePanel = new ImagePanel();
		facePanel.setBorder(new EmptyBorder(8, 8, 8, 8));
		facePanel.setBackground(Color.BLUE);
		return facePanel;
	}
	
	/**
	 * creates the controlPanel which displays all the buttons and action listeners.
	 * @return
	 */
	private JPanel createControlPanel() {
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		controlPanel.setLayout(new GridLayout(10, 0, 0, 0));
		
		JLabel lblYouChoose = new JLabel("You Choose .. ");
		lblYouChoose.setFont(new Font("Tahoma", Font.PLAIN, 24));
		controlPanel.add(lblYouChoose);
		
		JCheckBox chckbxEyes = new JCheckBox("Eyes");
		chckbxEyes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		chckbxEyes.setSelected(false);
		controlPanel.add(chckbxEyes);
		
		JCheckBox chckbxNose = new JCheckBox("Nose");
		chckbxNose.setFont(new Font("Tahoma", Font.PLAIN, 24));
		chckbxNose.setSelected(false);
		controlPanel.add(chckbxNose);
		
		JCheckBox chckbxMouth = new JCheckBox("Mouth");
		chckbxMouth.setFont(new Font("Tahoma", Font.PLAIN, 24));
		chckbxMouth.setSelected(false);
		controlPanel.add(chckbxMouth);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!chckbxEyes.isSelected() && !chckbxNose.isSelected() && !chckbxMouth.isSelected())
					facePanel.changeFace();
				
				if(chckbxEyes.isSelected())
				facePanel.changeEyes();
				
				if(chckbxNose.isSelected())
					facePanel.changeNose();
				
				if(chckbxMouth.isSelected())
					facePanel.changeMouth();
			}
		});
		controlPanel.add(btnUpdate);
		
		JLabel label = new JLabel("");
		controlPanel.add(label);
		
		JLabel label_1 = new JLabel("");
		controlPanel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		controlPanel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		controlPanel.add(label_3);
		return controlPanel;
	}

}
