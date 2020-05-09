package agents;

import java.util.Random;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class Estacao extends Agent{
	int x_estacao, y_estacao, id_bicicleta, numero_bicicletas, numero_docas, ape;
	String id_estacao;
	
	protected void setup() {
		super.setup();
		System.out.println("Estação criada");
		//this.addBehaviour(new Request());
		this.addBehaviour(new Reply());
	}
	
	private class Reply extends CyclicBehaviour {
		
		@Override
		public void action() {
			ACLMessage msg = receive();
			if (msg != null) {
				if (msg.getPerformative() == ACLMessage.CONFIRM) {
					System.out.println("Estação disponível!");
					myAgent.doDelete();
				}
			} else {
				block();
			}
		}
	}
	
	/*
	
	private class Request extends SimpleBehaviour {
		@Override
		public void action() {
			Random rand = new Random();
			Estacao_Pedidos ep = new Estacao_Pedidos();
			ep.setx_estacao(rand.nextInt(100));
			ep.sety_estacao(rand.nextInt(100));
			ep.setnumero_bicicletas(rand.nextInt(100));
			ep.setnumero_docas(rand.nextInt(100));

			//AID receiver = new AID(); // O manager recebe o pedido
			//receiver.setLocalName("Manager");

			//ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			//msg.addReceiver(receiver);
			//try {
			//	msg.setContentObject(cr);

			//} catch (Exception ex) {
				//ex.printStackTrace();

			}
			//myAgent.send(msg);
		}
		*/
	
	
	
	
	
	
	
	
	
	//Criar o agente
	//Informar localizacao estacao
	//Informar numero bikes
	//Informar ape
	//Sugerir incentivos
	//Informar docas disponiveis
	//Remover bicicletas
}