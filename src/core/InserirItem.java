package core;

public class InserirItem extends Thread {
	
	// Lista compartilhada. //
	private ListaCompartilhada lista;

	public InserirItem(String name, ListaCompartilhada lista) {
		super(name);
		this.lista = lista;
	}

	@Override
	public void run() {
		int valor = (int) (Math.random() * 10);
		lista.inserirItem(valor);
	}
	
}
