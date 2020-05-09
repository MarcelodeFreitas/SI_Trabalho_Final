package messages;

import jade.core.AID;

public class message_estacao_inform implements java.io.Serializable {

	public AID agent;
	public int x;
	public int y;
	public int nr_stations;
	public int nr_docks;
	public AID id_bike;
	public int nr_bike_avail;
	public int ape;
	
	public message_estacao_inform(AID agent, int x, int y, AID id_bike, int nr_bike_avail, int nr_stations, int nr_docks,
			int ape) {
		super();
		this.agent = agent;
		this.x = x;
		this.y = y;
		this.nr_stations = nr_stations;
		this.nr_docks = nr_docks;
		this.id_bike = id_bike;
		this.nr_bike_avail = nr_bike_avail;
		this.ape = ape;
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
	
	public int getNr_stations() {
		return nr_stations;
	}

	public void setNr_stations(int nr_stations) {
		this.nr_stations = nr_stations;
	}

	public int getNr_docks() {
		return nr_docks;
	}

	public void setNr_docks(int nr_docks) {
		this.nr_docks = nr_docks;
	}

	public int getApe() {
		return ape;
	}

	public void setApe(int ape) {
		this.ape = ape;
	}
	
	public AID getId_bike() {
		return id_bike;
	}

	public void setId_bike(AID id_bike) {
		this.id_bike = id_bike;
	}

	public int getNr_bike_avail() {
		return nr_bike_avail;
	}

	public void setNr_bike_avail(int nr_bike_avail) {
		this.nr_bike_avail = nr_bike_avail;
	}
	
}
