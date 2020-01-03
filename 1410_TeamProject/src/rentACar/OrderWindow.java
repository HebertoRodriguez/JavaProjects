package rentACar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;

import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * This class represents the window where the manager receives all the orders
 * and creates a file for the employees to see.
 * @author Heberto Rodriguez and Niel Francis
 *
 */
public class OrderWindow extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private String[] line;
	private String [] line2;
	private String temp;
	private String temp2;
	private JScrollPane scrollBar;
	private JLabel lblTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderWindow frame = new OrderWindow();
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
	public OrderWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EmptyBorder(0, 5, 0, 12));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel tabCreate = new JPanel();
		tabCreate.setName("Create");
		tabbedPane.addTab("Create", null, tabCreate, null);
		tabCreate.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCreateOrder = createOrderPnl();
		tabCreate.add(pnlCreateOrder, BorderLayout.CENTER);
		
		
		JPanel totalPnl = createsTotalPnl();
		contentPane.add(totalPnl, BorderLayout.EAST);
		
		JPanel homePnl = createHomePnl();
		contentPane.add(homePnl, BorderLayout.NORTH);

	}
	
	/**
	 * creates home button so that the user goes to main screen
	 * @return
	 */
	private JPanel createHomePnl() {
		JPanel homePnl = new JPanel();
		homePnl.setLayout(new BorderLayout(0, 0));
		
		JButton btnHome = new JButton("");
		btnHome.setBackground(new Color(240,240,240));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				CarRental home = new CarRental();
				home.setVisible(true);
			}
		});
		
		btnHome.setIcon(new ImageIcon(OrderWindow.class.getResource("/rentACar/Resources/home.png")));
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		homePnl.add(btnHome, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		homePnl.add(panel_1, BorderLayout.NORTH);
		return homePnl;
	}

	/**
	 * Displays the number of orders we have received from the database.
	 * @return
	 */
	private JPanel createsTotalPnl() {
		JPanel totalPnl = new JPanel();
		totalPnl.setBorder(new EmptyBorder(0, 12, 0, 12));
		
		totalPnl.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblTotalReservation = new JLabel("Total reservations for the day");
		lblTotalReservation.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTotalReservation.setFont(new Font("Tahoma", Font.BOLD, 19));
		totalPnl.add(lblTotalReservation);
		
		lblTotal = new JLabel("None.");
		lblTotal.setVerticalAlignment(SwingConstants.TOP);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		totalPnl.add(lblTotal);
		return totalPnl;
	}
	
	/*
	 * Create Order Panel.
	 * 
	 */
	private JPanel createOrderPnl() {
		JPanel pnlCreateOrder = new JPanel();
		pnlCreateOrder.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 19));
		textArea.setEditable(false);
		textArea.setText("Select sync to start the retreiving process" );
		scrollBar = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnlCreateOrder.add(scrollBar, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		panel.setBorder(new EmptyBorder(12, 0, 12, 0));
		pnlCreateOrder.add(panel, BorderLayout.SOUTH);
		
		JButton btnSync = new JButton("Sync");
		btnSync.setPreferredSize(new Dimension(121, 25));
		btnSync.setMinimumSize(new Dimension(121, 25));
		btnSync.setMaximumSize(new Dimension(121, 25));
		panel.add(btnSync);
		btnSync.addActionListener(new ActionListener() {
			private StringBuilder lines;
			private StringBuilder csv;
			private int line1Cnt;
			private int line2Cnt;

			public void actionPerformed(ActionEvent e) {
				syncWithDatabase();		
				String total = String.valueOf(line1Cnt+line2Cnt);
				lblTotal.setText(total);
				line1Cnt = line2Cnt = 0;
			}
			
			/*
			 * Retrieve reservations from multiply database and combine into one file.
			 * 
			 */
			private void syncWithDatabase() {
				try(PrintWriter write = new PrintWriter("src/rentACar/Resources/todayReservation.txt");
						PrintWriter writeCsv = new PrintWriter("src/rentACar/Resources/todayReservation.csv")) {
					try(Scanner reader = new Scanner(new File("src/rentACar/Resources/KAYEE.csv"));
							Scanner reader2 = new Scanner(new File("src/rentACar/Resources/Book1.csv"))) {
						lines = new StringBuilder();
						csv = new StringBuilder();
						while(reader2.hasNextLine() || reader.hasNextLine()) {			
							if(reader.hasNextLine() && reader2.hasNext()) {
									line = reader.nextLine().split(",");
									line2 = reader2.nextLine().split(",");	
									line1Cnt++;
									line2Cnt++;
							}else if(reader.hasNextLine() && !reader2.hasNextLine()) {
									line = reader.nextLine().split(",");
									line1Cnt++;
							}else if(!reader.hasNextLine() && reader2.hasNextLine()) {
								line2 = reader2.nextLine().split(",");
								line2Cnt++;
							}
								temp = String.format(" %s\t\t %s\t %s\t %10s\t %15s",line[0],line[1],line[2],line[3],line[4]);
								String csvtemp = String.format("%s%s%s%s%s%s%s%s%s",line[0],",",line[1],",",line[2],",",line[3],",",line[4]);
								temp2 = String.format(" %s\t\t %s\t %s\t %10s\t %15s",line2[0],line2[1],line2[2],line2[3],line2[4]);
								String csvtemp2 = String.format("%s%s%s%s%s%s%s%s%s",line2[0],",",line2[1],",",line2[2],",",line2[3],",",line2[4]);
								lines.append(temp).append("\n").append(temp2).append("\n");
								csv.append(csvtemp).append("\n").append(csvtemp2).append("\n");		
						}
					textArea.setText(String.format("%5s\t%25s\t %16s\t %16s %13s%n%s%n%n%s", "NAME", "EMAIL", "PHONE #", "CAR CLASS", "TIME",
								" ==============================================================================================",lines.toString()));	
					}
					write.printf("%s",lines );
					writeCsv.print(csv);
					System.out.println("Data was receive and File was created successfully.");	
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}//end of Sync method	
		});
		
		/*
		 * Create and write to a file that will be read by Class DisplayMenue.
		 * 
		 */
		JButton btnDisplayOrder = new JButton("Send to Display");
		btnDisplayOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeToFile();
				System.out.println("done");
			}
		});
		panel.add(btnDisplayOrder);
		return pnlCreateOrder;
	}
	
	/*
	 * Check time frame of reservations.
	 */
	private String timeFrame() {
		String[] num = line[4].split(":");
		
		int time = Integer.parseInt(num[0]);
		if(time >= 8 && time <= 10 ) 
			return String.valueOf(time);
		
		else if(time > 10 && time <= 12)
			return String.valueOf(time);	
		else if(time > 12 && time <= 14)
			return String.valueOf(time);	
		else if(time > 14 && time <= 16)
			return String.valueOf(time);	
		else if(time > 16 && time <= 18)
			return String.valueOf(time);
		return null;
	}

	/**
	 * Read from file that was create from the Sync method, then write.
	 * 
	 */
	private void writeToFile() {
		StringBuilder vehicleType = new StringBuilder();	
		try(PrintWriter write = new PrintWriter("src/rentACar/Resources/Display.txt")) {
			try(Scanner reader = new Scanner(new File("src/rentACar/Resources/todayReservation.csv"))) {
				while(reader.hasNextLine()) {							
					line =	reader.nextLine().split(",");	
					 for(String el : line) {
						 switch(el) {	 
						 case "CC":
							 vehicleType.append(el+": ").append(timeFrame()+"\n");
							 break;
						 case "FC":
							 vehicleType.append(el+": ").append(timeFrame()+"\n");
							 break;
						 case "LC":
							 vehicleType.append(el+": ").append(timeFrame()+"\n");
							 break;
						 case "MV":
							 vehicleType.append(el+": ").append(timeFrame()+"\n");
							 break;
						 case "IF":
							 vehicleType.append(el+": ").append(timeFrame()+"\n");
							 break;
						 case "SF":
							 vehicleType.append(el+": ").append(timeFrame()+"\n");
							 break;
						 case "FF":
							 vehicleType.append(el+": ").append(timeFrame()+"\n");
							 break;
						 case "PU":
							 vehicleType.append(el+": ").append(timeFrame()+"\n");
							 break;
						 case "LF":
							 vehicleType.append(el+": ").append(timeFrame()+"\n");
							 break;		 
				 		} 
					 }//end of for loop
				}
			}
			write.printf("%s",vehicleType );
			System.out.println("File was send successfully.");		
		} catch (FileNotFoundException | NullPointerException | ArrayIndexOutOfBoundsException e1) {
			e1.printStackTrace();
		}
	}
}
