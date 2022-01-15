package core;

public class BuscarItem extends Thread {

	// Lista compartilhada.
	private ListaCompartilhada lista;

	// Construtor.
	public BuscarItem(String name, ListaCompartilhada lista) {
		super(name);
		this.lista = lista;
	}

	// Gera um n�mero aleat�rio (at� o valor de 50) e invoca o m�todo de busca
	// do item na lista compartilhada.
	@Override
	public void run() {
		int valor = (int) (Math.random() * 50);
		lista.buscarItem(valor);
	}

}
