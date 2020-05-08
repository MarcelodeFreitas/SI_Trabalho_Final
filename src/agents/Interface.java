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
	
	private HashMap<AID, ArrayList> station_locations; //identificação, coordenadas
	private ArrayList<Integer> coordinates;
	
	protected void setup() {
		super.setup();
		this.addBehaviour(new User_Request_Receiver());
		this.addBehaviour(new Request_Stations());
	}

	protected void takeDown() {
		super.takeDown();
	}
	
	
	
	private class User_Request_Receiver extends CyclicBehaviour {
		private int x, y, numStations, x_destination, y_destination;
		private int minDistance = 1000;
		private int taxisProcessed = 0;
		private AID closestStation;
		private AID customerName;

		
		

	}

}
