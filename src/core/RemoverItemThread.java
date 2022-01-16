package core;

public class RemoverItemThread extends Thread {

	// Lista compartilhada.
	private ListaCompartilhada lista;

	// Construtor.
	public RemoverItemThread(String name, ListaCompartilhada lista) {
		super(name);
		this.lista = lista;
	}

	// Gera um número aleatório (até o valor de 50) e invoca o método de
	// remoção do item na lista compartilhada.
	@Override
	public void run() {
		int valor = (int) (Math.random() * 50);
		lista.removerItem(valor);
	}
}
