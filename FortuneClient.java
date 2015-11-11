package lab8;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FortuneClient extends JFrame {

	public FortuneClient() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);

		
		JButton fortuneButton = new JButton("Get fortunate");
		fortuneButton.setBounds(50, 60, 80, 30);
		
		panel.add(fortuneButton);
		setTitle("Fortunes");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		FortuneClient fc = new FortuneClient();
		fc.setVisible(true);
	}

}
