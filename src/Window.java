import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Window extends JFrame {

	private JPanel contentPane;
	private JTextArea messageReceive;
	private JTextArea messageSend;
	private JTextField chosenValue;
	private JTextField localValue;
	private JTextField consensuceValue;

	public void setMessageReceive(String messageReceive) {
		this.messageReceive.setText(messageReceive);
	}

	public void setMessageSend(String messageSend) {
		this.messageSend.setText(messageSend);
	}

	public void setChosenValue(String chosenValue) {
		this.chosenValue.setText(chosenValue);
	}

	public void setLocalValue(String localValue) {
		this.localValue.setText(localValue);
	}

	public void setConsensuceValue(String consensuceValue) {
		this.consensuceValue.setText(consensuceValue);
	}

	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		messageReceive = new JTextArea();
		messageReceive.setBounds(45, 42, 163, 123);
		contentPane.add(messageReceive);
		messageReceive.setColumns(10);

		messageSend = new JTextArea();
		messageSend.setBounds(218, 42, 163, 121);
		contentPane.add(messageSend);
		messageSend.setColumns(10);

		chosenValue = new JTextField();
		chosenValue.setBounds(122, 195, 86, 20);
		contentPane.add(chosenValue);
		chosenValue.setColumns(10);

		localValue = new JTextField();
		localValue.setBounds(332, 195, 46, 20);
		contentPane.add(localValue);
		localValue.setColumns(10);

		consensuceValue = new JTextField();
		consensuceValue.setBounds(232, 233, 173, 20);
		contentPane.add(consensuceValue);
		consensuceValue.setColumns(10);

		JLabel lblMessagesRecus = new JLabel("Messages reçus");
		lblMessagesRecus.setBounds(45, 11, 104, 14);
		contentPane.add(lblMessagesRecus);

		JLabel lblMessagesEnvoys = new JLabel("Messages envoyés");
		lblMessagesEnvoys.setBounds(262, 11, 104, 14);
		contentPane.add(lblMessagesEnvoys);

		JLabel lblValeurChoisie = new JLabel("Valeur choisie");
		lblValeurChoisie.setBounds(10, 198, 86, 14);

		contentPane.add(lblValeurChoisie);

		JLabel lblValeurLocale = new JLabel("Valeur locale");
		lblValeurLocale.setBounds(232, 198, 90, 14);
		contentPane.add(lblValeurLocale);

		JLabel lblValeurConsonsue = new JLabel("Valeur consonsus");
		lblValeurConsonsue.setBounds(50, 236, 99, 14);
		contentPane.add(lblValeurConsonsue);
	}
}
