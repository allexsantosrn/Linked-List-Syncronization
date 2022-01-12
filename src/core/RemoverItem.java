package core;

public class RemoverItem extends Thread {

	private ListaCompartilhada lista;

	public RemoverItem(String name, ListaCompartilhada lista) {
		super(name);
		this.lista = lista;
	}

	@Override
	public void run() {
		int valor = (int) (Math.random() * 100);
		System.out.println(valor);
	}
}
