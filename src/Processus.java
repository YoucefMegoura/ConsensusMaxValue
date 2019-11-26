import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.ArrayList;

public class Processus extends Agent {

	private int idProc;
	private ArrayList<Integer> arrayList = new ArrayList<>();

	private ArrayList<String> attendu = new ArrayList<String>();
	private int randomNumber = (int) (Math.random() * 100 + 1);
	private Window frame = new Window();

	public void setup() {

		frame.setResizable(false);
		frame.setVisible(true);
		frame.setMessageSend("randomNumber = " + randomNumber);

		System.out.println("randomNumber = " + randomNumber);
		arrayList.add(randomNumber);

		System.out.println("Je suis l'agent : " + getLocalName());
		frame.setTitle("Agent : " + getLocalName());

		Object[] args = getArguments();
		if (args != null) {
			idProc = Integer.parseInt(args[0].toString());
			for (int i = 1; i < args.length; i++) {
				if (!(getLocalName().equals(args[i].toString())))
					;

				attendu.add(args[i].toString());

			}
		}
		addBehaviour(new Send());
		addBehaviour(new Recieve());
	}

	public class Send extends OneShotBehaviour {

		@Override
		public void action() {
			if (attendu.size() != 0) {
				ACLMessage message = new ACLMessage(ACLMessage.INFORM);
				for (int i = 0; i < attendu.size(); i++) {
					message.addReceiver(new AID(attendu.get(i), AID.ISLOCALNAME));
				}
				message.setContent("requete" + "#" + idProc + "#" + randomNumber);
				send(message);
				frame.setLocalValue(String.valueOf(randomNumber));

			}

		}

	}

	public class Recieve extends Behaviour {
		String tempText = "";
		String tempText2 = String.valueOf(randomNumber);

		@Override
		public void action() {
			ACLMessage msg = receive();
			String[] tab_mess;
			if (msg != null) {
				System.out.println(getLocalName() + " : msg reçu =" + msg.getContent());
				tempText += msg.getContent() + "\n";
				frame.setMessageReceive(tempText);

				tab_mess = msg.getContent().split("#");

				if (tab_mess[0].equals("requete")) {
					int recievedNbr = Integer.parseInt(tab_mess[2]);
					tempText2 += String.valueOf("," + tab_mess[2]);
					frame.setConsensuceValue(tempText2);
					arrayList.add(recievedNbr);
				}
			}

		}

		@Override
		public boolean done() {
			if (arrayList.size() < 3) {
				return false;
			} else {
				System.out.println(getLocalName() + " : got the max = " + getMax(arrayList));
				frame.setChosenValue(String.valueOf(getMax(arrayList)));
				return true;
			}

		}

		public int getMax(ArrayList<Integer> list) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) > max) {
					max = list.get(i);
				}
			}
			return max;
		}

	}

}
