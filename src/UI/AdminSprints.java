package UI;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSprints extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminSprints() {
		setLayout(null);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazGrafica.getInstance().abrirIndex();
			}
		});
		button.setBounds(10, 11, 46, 23);
		add(button);

	}
}
