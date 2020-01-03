package rentACar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class represents the password and username needed to gain access to the database located in the order window. 
 * @author Niel Francis and Heberto Rodriguez
 *
 */
public class PasswordWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField userPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordWindow frame = new PasswordWindow();
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
	public PasswordWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCompanyName = createPnlCompanyName();
		contentPane.add(pnlCompanyName, BorderLayout.NORTH);

		JPanel pnlMenuName = createPnlMenuName();
		contentPane.add(pnlMenuName, BorderLayout.CENTER);

	}

	/**
	 * creates the labels to display what the user needs to do.
	 * @return
	 */
	private JPanel createPnlMenuName() {
		JPanel pnlMenuName = new JPanel();
		pnlMenuName.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel pnlLblName = new JPanel();
		pnlLblName.setBorder(new EmptyBorder(20, 0, 0, 0));
		pnlMenuName.add(pnlLblName);
		
		JLabel lblCreateMenue = new JLabel("CREATE MENUE");
		lblCreateMenue.setFont(new Font("Tahoma", Font.PLAIN, 34));
		pnlLblName.add(lblCreateMenue);
		
		JPanel pnlUserPrompt = new JPanel();
		pnlUserPrompt.setBorder(new EmptyBorder(50, 0, 0, 0));
		pnlMenuName.add(pnlUserPrompt);
		
		JLabel lblNewLabel_1 = new JLabel("PLEASE ENTER USER NAME AND PASSWORD");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		pnlUserPrompt.add(lblNewLabel_1);
		
		JPanel logins = new JPanel();
		logins.setBorder(new EmptyBorder(0, 0, 50, 0));
		pnlMenuName.add(logins);
		logins.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
		
		txtUserName = new JTextField();
		logins.add(txtUserName);
		txtUserName.setColumns(10);
		
		userPassword = new JPasswordField();
		userPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					userName_Password_Check();
				}
			}
		});
		userPassword.setColumns(10);
		logins.add(userPassword);
		
		JPanel pnlEnterBtn = new JPanel();
		pnlMenuName.add(pnlEnterBtn);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userName_Password_Check();
			}
		});
		pnlEnterBtn.add(btnEnter);
		return pnlMenuName;
	}

	/**
	 * Displays the company logo on the top of the window
	 * @return
	 */
	private JPanel createPnlCompanyName() {
		JPanel pnlCompanyName = new JPanel();
		
		JLabel lblRentacar = new JLabel("RENT-A-CAR");
		lblRentacar.setFont(new Font("Tahoma", Font.BOLD, 50));
		pnlCompanyName.add(lblRentacar);
		return pnlCompanyName;
	}

	/**
	 * Creates the user-name and password needed to gain access into order window.
	 */
	private void userName_Password_Check() {
		String userName = txtUserName.getText();
		String password = userPassword.getText();
		
		if(userName.contains("MPosch") && password.contains("C$1410")) {
			txtUserName.setText(null);
			userPassword.setText(null);
			
			dispose();
			OrderWindow orderWindow = new OrderWindow();
			orderWindow.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "User Name or Password is incorrect", "Login Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
