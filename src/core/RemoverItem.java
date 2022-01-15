package core;

public class RemoverItem extends Thread {

	// Lista compartilhada.
	private ListaCompartilhada lista;

	// Construtor.
	public RemoverItem(String name, ListaCompartilhada lista) {
		super(name);
		this.lista = lista;
	}

	@Override
	public void run() {
		int valor = (int) (Math.random() * 50);
		lista.removerItem(valor);
	}
}
