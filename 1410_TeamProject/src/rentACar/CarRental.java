package rentACar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * This class represents the main window of our program. 
 * It creates the main buttons to navigate through the program.
 * @author Heberto Rodriguez and Niel Francis
 *
 */
public class CarRental extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarRental frame = new CarRental();
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
	public CarRental() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setMaximumSize(getMaximumSize());
		setContentPane(contentPane);
		
		JPanel panel = createLblMainPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JPanel panel_1 = createBtnsMain();
		contentPane.add(panel_1, BorderLayout.CENTER);

	}

	/**
	 * Creates the main page label of our program name
	 * @return
	 */
	private JPanel createLblMainPanel() {
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(240, 240, 240));
		panel.setBorder(new EmptyBorder(20, 12, 12, 12));
		
		JLabel lblCarRental = new JLabel("RENT-A-CAR");
		lblCarRental.setBorder(new EmptyBorder(0, 0, 0, 175));
		lblCarRental.setIcon(new ImageIcon(CarRental.class.getResource("/rentACar/Resources/race wave.png")));
		lblCarRental.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCarRental.setForeground(Color.RED);
		lblCarRental.setFont(new Font("Cambria", Font.PLAIN, 47));
		panel.add(lblCarRental);
		return panel;
	}

	/**
	 * creates the two main buttons. The create button for the manager 
	 * and the display button for the employees
	 * @return
	 */
	private JPanel createBtnsMain() {
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240,240,240));
		panel_1.setBorder(new EmptyBorder(35, 25, 35, 25));
		panel_1.setLayout(new GridLayout(0, 2, 25, 25));
		
		JButton btnPlaceOrder = new JButton("CREATE ORDER");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PasswordWindow pword = new PasswordWindow();
				pword.setVisible(true);
			}
		});
		btnPlaceOrder.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnPlaceOrder.setForeground(Color.WHITE);

		btnPlaceOrder.setBackground(Color.GRAY);
		panel_1.add(btnPlaceOrder);
		
		JButton btnDisplayOrder = new JButton("DISPLAY ORDER");
		btnDisplayOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DisplayMenu display = new DisplayMenu();
				display.setVisible(true);
			}
		});
		btnDisplayOrder.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnDisplayOrder.setForeground(Color.WHITE);
		btnDisplayOrder.setBackground(Color.GRAY);
		panel_1.add(btnDisplayOrder);
		return panel_1;
	}


}
