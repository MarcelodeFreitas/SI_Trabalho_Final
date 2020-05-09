package messages;

import jade.core.AID;

public class message_estacao_inform implements java.io.Serializable {

	public AID agent;
	public int x;
	public int y;
	public AID id_bike;
	public int nr_bike_avail;
	public int nr_stations;
	public int nr_dock;
	public int ape;
	
	public message_estacao_inform(AID agent, int x, int y, AID id_bike, int nr_bike_avail, int nr_stations, int nr_dock,
			int ape) {
		super();
		this.agent = agent;
		this.x = x;
		this.y = y;
		this.id_bike = id_bike;
		this.nr_bike_avail = nr_bike_avail;
		this.nr_stations = nr_stations;
		this.nr_dock = nr_dock;
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

	public int getNr_stations() {
		return nr_stations;
	}

	public void setNr_stations(int nr_stations) {
		this.nr_stations = nr_stations;
	}

	public int getNr_dock() {
		return nr_dock;
	}

	public void setNr_dock(int nr_dock) {
		this.nr_dock = nr_dock;
	}

	public int getApe() {
		return ape;
	}

	public void setApe(int ape) {
		this.ape = ape;
	}
	
	
	
	
	

	
}
