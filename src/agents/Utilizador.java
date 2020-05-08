package agents;

import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import messages.message_utilizador_request;

public class Utilizador extends Agent{
	private long start, end;
	
	protected void setup() {
		super.setup();
		start = (Calendar.getInstance()).getTimeInMillis();
		System.out.println("Starting Customer");
		this.addBehaviour(new Request_bike());
	}
	
	private class Request_bike extends SimpleBehaviour {

		public void action() {
			Random rand = new Random();
			int xOrigin = rand.nextInt(150);
			int yOrigin = rand.nextInt(150);
			int xDestination = rand.nextInt(150);
			int yDestination = rand.nextInt(150);
			System.out.println("Requesting bike from (" + xOrigin + "," + yOrigin + ") to (" + xDestination + ","
					+ yDestination + ")");


			
			try {
				AID receiver = new AID();
				receiver.setLocalName("Interface");
				
				message_utilizador_request created_instance = new message_utilizador_request(getAID(), xOrigin, yOrigin, xDestination, yDestination);

				ACLMessage mensagem = new ACLMessage(ACLMessage.REQUEST);
				mensagem.setContentObject(created_instance);
				mensagem.addReceiver(receiver);
				
				myAgent.send(mensagem);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public boolean done() {
			return true;
		}
	}
	
	
	protected void takeDown() {
		super.takeDown();
		System.out.println("Ending Utilizador");
		end = (Calendar.getInstance()).getTimeInMillis();
		start = end - start;
		System.out.println("Riding time:" + start);
	}

		
}
