package UI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public final class Index extends JPanel {

	/**
	 * Create the panel.
	 */
	public Index() {
		setLayout(null);
		
		JButton btnABMSprints = new JButton("ABM Sprints");
		btnABMSprints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazGrafica.getInstance().abrirABMSprint();
				
			}
		});
		btnABMSprints.setBounds(268, 80, 89, 23);
		add(btnABMSprints);

	}

}
