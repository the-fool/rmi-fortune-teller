package lab8;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FortuneClient extends JFrame {

	public FortuneClient() {
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		getContentPane().add(panel);

		JButton fortuneButton = new JButton("Get fortunate");
		panel.add(fortuneButton);
		
		JLabel fortune = new JLabel();
		fortune.setText("Fortunate are you");
		panel.add(fortune);
		
		setTitle("Fortunes");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		FortuneClient fc = new FortuneClient();
		fc.setVisible(true);
	}

}
