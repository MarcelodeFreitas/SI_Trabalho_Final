package messages;

import jade.core.AID;

public class message_utilizador_request implements java.io.Serializable {
	
	public AID agent;
	public int x;
	public int y;
	public int y_destination;
	public int x_destination;
	
	public message_utilizador_request(AID agent, int x, int y, int x_destination, int y_destination) {
		super();
		this.agent = agent;
		this.x = x;
		this.y = y;
		this.x_destination = x_destination;
		this.y_destination = y_destination;
	}

	public AID getAgent() {
		return agent;
	}

	public void setAgent(AID agent) {
		this.agent = agent;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY_destination() {
		return y_destination;
	}

	public void setY_destination(int y_destination) {
		this.y_destination = y_destination;
	}

	public int getX_destination() {
		return x_destination;
	}

	public void setX_destination(int x_destination) {
		this.x_destination = x_destination;
	}

	

}
