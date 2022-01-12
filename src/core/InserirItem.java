package core;

public class InserirItem extends Thread {
	
	private ListaCompartilhada lista;

	public InserirItem(String name, ListaCompartilhada lista) {
		super(name);
		this.lista = lista;
	}

	@Override
	public void run() {
		int valor = (int) (Math.random() * 50);
		System.out.println(valor);
	}
	
}
