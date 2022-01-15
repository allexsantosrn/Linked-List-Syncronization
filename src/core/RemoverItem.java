package core;

public class RemoverItem extends Thread {

	// Lista compartilhada.
	private ListaCompartilhada lista;

	// Construtor.
	public RemoverItem(String name, ListaCompartilhada lista) {
		super(name);
		this.lista = lista;
	}

	// Gera um n�mero aleat�rio (at� o valor de 50) e invoca o m�todo de
	// remo��o do item na lista compartilhada.
	@Override
	public void run() {
		int valor = (int) (Math.random() * 50);
		lista.removerItem(valor);
	}
}
