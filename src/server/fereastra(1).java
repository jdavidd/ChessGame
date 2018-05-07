import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class fereastra {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fereastra window = new fereastra();
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
	public fereastra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 204));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(15, 37, 205, 162);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JTextArea textArea = new JTextArea();
		textArea.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(textArea, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(236, 37, 80, 162);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JTextArea textArea_1 = new JTextArea();
		panel_2.add(textArea_1, BorderLayout.CENTER);

		JButton btnProvoaca = new JButton("Provoaca");
		panel_2.add(btnProvoaca, BorderLayout.SOUTH);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(326, 37, 98, 222);
		panel.add(panel_3);

		JButton btnNewButton = new JButton("Joc nou");
		btnNewButton.setBounds(10, 236, 90, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Adera");
		btnNewButton_1.setBounds(110, 236, 98, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Vizioneaza");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(218, 236, 98, 23);
		panel.add(btnNewButton_2);

		JButton btnReimprospateaza = new JButton("Reimprospateaza");
		btnReimprospateaza.setBounds(15, 11, 32, 23);
		panel.add(btnReimprospateaza);
	}
}
