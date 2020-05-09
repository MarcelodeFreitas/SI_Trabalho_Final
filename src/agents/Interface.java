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
import messages.message_estacao_inform;
import messages.message_utilizador_request;

import java.util.HashMap;


public class Interface extends Agent{
	
	private HashMap<AID, ArrayList> info_estacao; //identificação, coordenadas
	private HashMap<AID, ArrayList> info_utilizadores; //identificação, coordenadas
	private ArrayList<Integer> coordenadas_u; //coordenadas
	private ArrayList<Integer> coordenadas_e; //coordenadas e area da APE
	
	protected void setup() {
		super.setup();
		this.addBehaviour(new Utilizador_Request_Receiver());
		//this.addBehaviour(new Estacao_Info_Receiver());
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
					
					coordenadas_u = new ArrayList<Integer>();
					coordenadas_u.add(x_u);
					coordenadas_u.add(y_u);
					coordenadas_u.add(x_u_destino);
					coordenadas_u.add(x_u_destino);
					
					info_utilizadores = new HashMap<AID, ArrayList>();
					if (info_utilizadores.containsKey(id_utilizador)) {
						info_utilizadores.replace(id_utilizador, coordenadas_u);
					} else {
						info_utilizadores.put(id_utilizador, coordenadas_u);
					}
					
					System.out.println("Interface: info do utilizador");
					System.out.println("____________"+id_utilizador.getLocalName()+"____________");
					System.out.println("origem: "+ x_u +", "+ y_u);
					System.out.println("destino: "+ x_u_destino +", "+ y_u_destino);
					
				} catch (UnreadableException e1) {
					e1.printStackTrace();
				}
				
				
			}
		}
	}
	/*
	private class Estacao_Info_Receiver extends CyclicBehaviour {
		private int x_e, y_e;
		private AID id_estacao;
		private int nr_estacoes;
		private int nr_docas;
		private int ape;
		private AID id_bicicleta;
		private int nr_bicicletas_disp;
		

		public void action() {
			ACLMessage msg = receive();
			if (msg != null && msg.getPerformative() == ACLMessage.INFORM) {
				System.out.println("Interface: estação informou");
				
				try {
					message_estacao_inform content = (message_estacao_inform) msg.getContentObject();
					x_e = content.getX();
					y_e = content.getY();
					id_estacao = content.getAgent();
					nr_bicicletas_disp = content.getNr_bike_avail();
					nr_estacoes = content.getNr_stations();
					nr_docas = content.getNr_docks();
					ape = content.getApe();
					id_bicicleta = content.getId_bike();
					nr_bicicletas_disp = content.getNr_bike_avail();
					
					coordenadas_e = new ArrayList<Integer>();
					coordenadas_e.add(x_e);
					coordenadas_e.add(y_e);
					coordenadas_e.add(ape);
					
					info_estacao = new HashMap<AID, ArrayList>();
					if (info_estacao.containsKey(id_estacao)) {
						info_estacao.replace(id_estacao, coordenadas_e);
					} else {
						info_utilizadores.put(id_estacao, coordenadas_e);
					}
					
					System.out.println("Interface: info da estacao");
					System.out.println("____________"+id_estacao.getLocalName()+"____________");
					System.out.println("coordenadas: "+ x_e +", "+ y_e);
					System.out.println("APE: "+ ape);
					
				} catch (UnreadableException e1) {
					e1.printStackTrace();
				}
					
			}
		}
	}*/

}
