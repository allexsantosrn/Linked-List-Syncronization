package core;

public class InserirItem extends Thread {

	// Lista compartilhada. //
	private ListaCompartilhada lista;

	public InserirItem(String name, ListaCompartilhada lista) {
		super(name);
		this.lista = lista;
	}

	// Gera um n�mero aleat�rio (at� o valor de 50) e invoca o m�todo de
	// inserir o item na lista compartilhada.
	@Override
	public void run() {
		int valor = (int) (Math.random() * 50);
		lista.inserirItem(valor);
	}

}
