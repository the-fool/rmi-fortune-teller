package lab8;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FortuneClient extends JFrame {
	private FortuneServerIntf fs = null;
	public FortuneClient() {
		try {
			String serverObjectName = "//127.0.0.1/Server";
			System.err.println("Getting Connected to the server: "+ serverObjectName );
			fs = (FortuneServerIntf) Naming.lookup(serverObjectName);
			System.err.println("Connected to server.");
		} catch (java.rmi.ConnectException ce) {
			System.err.println("Connection to server failed. " + "Server may be temporarily unavailable.");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		initUI();
		
	}
	private void initUI() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		getContentPane().add(panel);

		JButton fortuneButton = new JButton("Get fortunate");
		panel.add(fortuneButton);
		
		JLabel fortune = new JLabel();
		fortune.setText("Click and foresee..");
		panel.add(fortune);
		
		fortuneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try{
					fortune.setText(fs.tellFortune());
				} catch (RemoteException re) {
					System.out.println("Error retrieving server response: " + re);
				}
			}
		});
		
		setTitle("Fortunes");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		FortuneClient fc = new FortuneClient();
		fc.setVisible(true);
	}

}
