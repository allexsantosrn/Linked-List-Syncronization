package core;

public class BuscarItem extends Thread {

	private ListaCompartilhada lista;

	public BuscarItem(String name, ListaCompartilhada lista) {
		super(name);
		this.lista = lista;
	}
	
	@Override
	public void run() {
		int valor = (int) (Math.random() * 10);
		System.out.println(valor);
	}
	
}
