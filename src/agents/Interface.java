package agents;

import jade.core.Agent;
import jade.core.ContainerID;
import jade.core.Location;

import java.io.IOException;
import java.util.ArrayList;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import messages.message_utilizador_request;

import java.util.HashMap;


public class Interface extends Agent{
	
	private HashMap<AID, ArrayList> info_estacao; //identificação, coordenadas
	private HashMap<AID, ArrayList> info_utilizadores; //identificação, coordenadas
	private ArrayList<Integer> coordenadas; //coordenadas e area da APE
	
	protected void setup() {
		super.setup();
		this.addBehaviour(new Utilizador_Request_Receiver());
		//this.addBehaviour(new Request_Stations());
	}

	protected void takeDown() {
		super.takeDown();
	}
	
	
	
	private class Utilizador_Request_Receiver extends CyclicBehaviour {
		private int x_u, y_u, x_u_destino, y_u_destino;
		private AID id_utilizador;
		
		public void action() {
			ACLMessage msg = receive();
			if (msg != null && msg.getPerformative() == ACLMessage.REQUEST) {
				System.out.println("Interface: utilizador pediu bicleta");
				
				try {
					message_utilizador_request content = (message_utilizador_request) msg.getContentObject();
					x_u = content.getX();
					y_u = content.getY();
					x_u_destino = content.getX_destination();
					y_u_destino = content.getY_destination();
					id_utilizador = content.getAgent();
					
					coordenadas = new ArrayList<Integer>();
					coordenadas.add(x_u);
					coordenadas.add(y_u);
					coordenadas.add(x_u_destino);
					coordenadas.add(x_u_destino);
					
					info_utilizadores = new HashMap<AID, ArrayList>();
					if (info_utilizadores.containsKey(id_utilizador)) {
						info_utilizadores.replace(id_utilizador, coordenadas);
					} else {
						info_utilizadores.put(id_utilizador, coordenadas);
					}
					
					System.out.println("Interface: info do utilizador");
					System.out.println("________________"+id_utilizador.getLocalName()+"____________");
					System.out.println("origem: "+ x_u +", "+ y_u);
					System.out.println("destino: "+ x_u_destino +", "+ y_u_destino);
					
				} catch (UnreadableException e1) {
					e1.printStackTrace();
				}
				
				
			}
		}

		
		

	}

}
