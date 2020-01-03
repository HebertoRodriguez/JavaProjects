package rentACar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * This class represents the display menu of all the cars needed in certain time frames.
 * This is the window that the employees will use.
 * @author Niel Francis and Heberto Rodriguez
 *
 */
public class DisplayMenu extends JFrame {

	private JPanel contentPane;
	private JLabel lblThree;
	private JLabel lblOne;
	private JLabel lblTwo;
	private JLabel lblFour;
	private JLabel lblFive;
	private JLabel lblSix;
	private JLabel lblSeven;
	private JLabel lblEight;
	private JLabel lblNine;
	private int cc;;
	private int fc;
	private int lc;
	private int mv;
	private int ms;
	private int sf;
	private int ff;
	private int lf;
	private int pu;
	private JButton btn8_10;
	private JButton btn10_12;
	private JButton btn12_14;
	private JButton btn14_16;
	private JButton btn16_18;
	private Color btnDefaultColor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayMenu frame = new DisplayMenu();
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
	public DisplayMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCompanyName = createPnlCompanyName();
		contentPane.add(pnlCompanyName, BorderLayout.NORTH);

		
		JPanel pnlMenuDisplay = createMenuDisplay();
		contentPane.add(pnlMenuDisplay, BorderLayout.CENTER);

	}
	
	/**
	 * Creates the display where all the number of vehicles names and quantity are needed.
	 * @return
	 */
	private JPanel createMenuDisplay() {
			
		JPanel pnlControlPanel = new JPanel();
		pnlControlPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTime = new JPanel();
		pnlTime.setOpaque(false);
		pnlTime.setBorder(new EmptyBorder(10, 10, 10, 10));
		pnlControlPanel.add(pnlTime, BorderLayout.WEST);
		pnlTime.setLayout(new GridLayout(6, 0, 0, 10));
		
		JLabel lblTime = new JLabel("TIME");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		pnlTime.add(lblTime);
			
		btn8_10 = new JButton("8:00 - 10:00");
		btn8_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn8_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeBtnColor(btn8_10);
				checkTimeFrame(btn8_10);
				vehicleTypes();	
			}
		});
		pnlTime.add(btn8_10);
		
		btn10_12 = new JButton("10:00 - 12:00");
		btn10_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn10_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeBtnColor(btn10_12);
				checkTimeFrame(btn10_12);
				vehicleTypes();	
			}
		});
		pnlTime.add(btn10_12);
		
		btn12_14 = new JButton("12:00 - 14:00");
		btn12_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn12_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeBtnColor(btn12_14);
				checkTimeFrame(btn12_14);
				vehicleTypes();
			}
		});
		pnlTime.add(btn12_14);
		
		btn14_16 = new JButton("14:00 - 16:00");
		btn14_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn14_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeBtnColor(btn14_16);
				checkTimeFrame(btn14_16);
				vehicleTypes();
			}
		});
		pnlTime.add(btn14_16);
		
		btn16_18 = new JButton("16:00 - 18:00");
		btn16_18.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn16_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeBtnColor(btn16_18);
				checkTimeFrame(btn16_18);
				vehicleTypes();
			}
		});
		pnlTime.add(btn16_18);
		
		JPanel pnlDisplayLabel = new JPanel();
		pnlControlPanel.add(pnlDisplayLabel, BorderLayout.NORTH);
		
		JLabel lblDisplayMenu = new JLabel("DISPLAY MENU");
		lblDisplayMenu.setFont(new Font("Tahoma", Font.PLAIN, 34));
		pnlDisplayLabel.add(lblDisplayMenu);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(0, 47, 0, 0));
		pnlControlPanel.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		lblOne = new JLabel("");
		lblOne.setFont(new Font("Tahoma", Font.BOLD, 19));
		mainPanel.add(lblOne);
		
		lblTwo = new JLabel("");
		lblTwo.setFont(new Font("Tahoma", Font.BOLD, 19));
		mainPanel.add(lblTwo);
		
		lblThree = new JLabel("");
		lblThree.setFont(new Font("Tahoma", Font.BOLD, 19));
		mainPanel.add(lblThree);
		
		lblFour = new JLabel("");
		lblFour.setFont(new Font("Tahoma", Font.BOLD, 19));
		mainPanel.add(lblFour);
		
		lblFive = new JLabel("");
		lblFive.setFont(new Font("Tahoma", Font.BOLD, 19));
		mainPanel.add(lblFive);
		
		lblSix = new JLabel("");
		lblSix.setFont(new Font("Tahoma", Font.BOLD, 19));
		mainPanel.add(lblSix);
		
		lblSeven = new JLabel("");
		lblSeven.setFont(new Font("Tahoma", Font.BOLD, 19));
		mainPanel.add(lblSeven);
		
		lblEight = new JLabel("");
		lblEight.setFont(new Font("Tahoma", Font.BOLD, 19));
		mainPanel.add(lblEight);
		
		lblNine = new JLabel("");
		lblNine.setFont(new Font("Tahoma", Font.BOLD, 19));
		mainPanel.add(lblNine);
		return pnlControlPanel;
		
	}
	
	/*
	 * Change button color base on selection.
	 * 
	 */
	private void changeBtnColor(JButton btnPress) {
		JButton[] btns = {btn8_10,btn10_12,btn12_14,btn14_16,btn14_16,btn16_18};
		btnDefaultColor = btnPress.getForeground();
		for(JButton el : btns) {
			if(el.equals(btnPress)) {
				el.setBackground(Color.LIGHT_GRAY);	
			}else {
				el.setBackground(btnDefaultColor);
			}	
		}	
	}
	
	/*
	 * Set label text.
	 * 
	 */
	private void vehicleTypes() {
		lblOne.setText("Compact Sudan " + cc);
		lblTwo.setText("Full Size Sudan " + fc);
		lblThree.setText("Luxury Sudan " + lc);
		lblFour.setText("Minivan "+ mv);
		lblFive.setText("Mid Size SUV " + ms);
		lblSix.setText("Standard Size SUV " + sf);
		lblSeven.setText("Full Size SUV " + ff);
		lblEight.setText("Luxury SUV " + lf);
		lblNine.setText("Pickup Truck " + pu);	
	}

	/*
	 * Create label rent a car.
	 * 
	 */
	private JPanel createPnlCompanyName() {
		JPanel pnlCompanyName = new JPanel();
		pnlCompanyName.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRentacar = new JLabel("RENT-A-CAR");
		lblRentacar.setForeground(Color.RED);
		lblRentacar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRentacar.setIconTextGap(0);
		lblRentacar.setIcon(new ImageIcon(DisplayMenu.class.getResource("/rentACar/Resources/race wave.png")));
		lblRentacar.setBorder(new EmptyBorder(0, 0, 0, 125));
		lblRentacar.setFont(new Font("Tahoma", Font.BOLD, 50));
		pnlCompanyName.add(lblRentacar, BorderLayout.CENTER);
		return pnlCompanyName;
	}

	/*
	 * Check the time of each reservation.
	 * 
	 * @param btnNewButton
	 */
	private void checkTimeFrame(JButton btnNewButton) {
		cc=fc=lc=mv=ms=sf=ff=lf=pu = 0;
		try(Scanner reader = new Scanner(new File("src/rentACar/Resources/Display.txt"))) {	
			while(reader.hasNextLine()) {
				String [] line = reader.nextLine().split(":");
				int time = Integer.parseInt(line[1].trim());
				if(btnNewButton.equals(btn8_10)&&(time >= 8 && time <=10)){	
					carType(line);
				}else if(btnNewButton.equals(btn10_12)&&(time > 10 && time <=12)){
					carType(line);	
				}else if(btnNewButton.equals(btn12_14)&&(time > 12 && time <=14)){
					carType(line);
				}else if(btnNewButton.equals(btn14_16)&&(time > 14 && time <=16)){
					carType(line);
				}else if(btnNewButton.equals(btn16_18)&&(time > 16 && time <=18)){
					carType(line);
				}
			}
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
	}

	/*
	 * Check the amount of each car type.
	 * 
	 * @param line
	 */
	private void carType(String[] line) {
		if(line[0].equals("CC")){ //checking for compact cars
			cc++;
		}else if(line[0].equals("FC")) { //checking for full size cars		
			fc++;
		}else if(line[0].equals("LC")) { // checking for luxury cars
			lc++;
		}else if(line[0].equals("MV")) { //checking for mini van cars
			mv++;
		}else if(line[0].equals("IF")) { // checking for mid size suv
			ms++;
		}else if(line[0].equals("SF")) { // checking for stardard size suv
			sf++;
		}else if(line[0].equals("FF")){ // checking for full size suv
			ff++;
		}else if(line[0].equals("LF")) { // checking for luxury suv
			lf++;
		}else if(line[0].equals("PU")) { // checking for pick up truck
			pu++;
		}	
	}
}
