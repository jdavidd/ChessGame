package server;

import newpackage.singup;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;

public class Login_S {

	private JFrame frame;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
     * @param args
	 */

        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					Login_S window = new Login_S();
                                        singup frame = new singup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
                
	}

	/**
	 * Create the application.
	 */
	public Login_S() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 40));
		frame.setBounds(200, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(179, 11, 89, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUsername.setBounds(48, 94, 153, 29);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(46, 134, 155, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextArea txtUsername = new JTextArea();
		txtUsername.setBounds(238, 107, 149, 16);
		frame.getContentPane().add(txtUsername);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(238, 134, 153, 20);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String password = txtPassword.getText();
			    String username = txtUsername.getText();
				
				if(password.contains("king") && username.contains("one"))
				{
					txtPassword.setText(null);
					txtUsername.setText(null);
					
					// Chess.main(null);
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE); 
					txtPassword.setText(null);
					txtUsername.setText(null);
				}
				 
			}
		});
		btnLogin.setBounds(137, 205, 132, 33);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegister.setBounds(299, 205, 121, 33);
		frame.getContentPane().add(btnRegister);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(56, 189, 364, 8);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(45, 62, 364, 8);
		frame.getContentPane().add(separator_1);
	}
}
