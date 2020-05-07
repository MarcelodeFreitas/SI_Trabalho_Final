import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class MainContainer {

	Runtime rt;
	ContainerController container;

	public static void main(String[] args) {
		MainContainer a = new MainContainer();

		a.initMainContainerInPlatform("localhost", "9888", "MainContainer");

		a.startAgentInPlatform("Interface", "agents.Interface");

		int n;
		int limit_stations = 50; // Limitar o número de estacoes

		// Começar as estacoes!
		for (n = 0; n < limit_stations; n++) {
			a.startAgentInPlatform("Estacao" + n, "agents.Estacao");
			n++;
		}

		// Esperar que todas as Estcoes estejam prontas
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Começar os primeiros 10 Utilizadores!
		for (n = 0; n < 10; n++) {
			a.startAgentInPlatform("Utilizador" + n, "agents.Utilizador");
			n++;
		}

		int limit_users = 100; // Limitar o número de Utilizadores
		// Começar os utilizadores!
		for (n = 10; n < limit_users; n++) {
			try {
				a.startAgentInPlatform("Utilizador" + n, "agents.Utilizador");
				Thread.sleep(1000);
				n++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public ContainerController initContainerInPlatform(String host, String port, String containerName) {
		// Get the JADE runtime interface (singleton)
		this.rt = Runtime.instance();

		// Create a Profile, where the launch arguments are stored
		Profile profile = new ProfileImpl();
		profile.setParameter(Profile.CONTAINER_NAME, containerName);
		profile.setParameter(Profile.MAIN_HOST, host);
		profile.setParameter(Profile.MAIN_PORT, port);
		// create a non-main agent container
		ContainerController container = rt.createAgentContainer(profile);
		return container;
	}

	public void initMainContainerInPlatform(String host, String port, String containerName) {

		// Get the JADE runtime interface (singleton)
		this.rt = Runtime.instance();

		// Create a Profile, where the launch arguments are stored
		Profile prof = new ProfileImpl();
		prof.setParameter(Profile.CONTAINER_NAME, containerName);
		prof.setParameter(Profile.MAIN_HOST, host);
		prof.setParameter(Profile.MAIN_PORT, port);
		prof.setParameter(Profile.MAIN, "true");
		prof.setParameter(Profile.GUI, "true");

		// create a main agent container
		this.container = rt.createMainContainer(prof);
		rt.setCloseVM(true);

	}

	public void startAgentInPlatform(String name, String classpath) {
		try {
			AgentController ac = container.createNewAgent(name, classpath, new Object[0]);
			ac.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}