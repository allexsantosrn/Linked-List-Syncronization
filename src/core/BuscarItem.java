package core;

public class BuscarItem extends Thread {

	// Lista compartilhada.
	private ListaCompartilhada lista;

	// Construtor.
	public BuscarItem(String name, ListaCompartilhada lista) {
		super(name);
		this.lista = lista;
	}

	@Override
	public void run() {
		int valor = (int) (Math.random() * 10);
		lista.buscarItem(valor);
	}

}
