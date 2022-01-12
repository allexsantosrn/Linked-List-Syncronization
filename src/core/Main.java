package core;

public class Main {

	// Definição das threads a serem utilizadas.
	private static final int NUM_THREADS = 4;

	public static void main(String[] args) {

		ListaCompartilhada listacompartilhada = new ListaCompartilhada();

		// Criando os vetores. 
		BuscarItem[] buscar = new BuscarItem[NUM_THREADS];
		InserirItem[] inserir = new InserirItem[NUM_THREADS];
		RemoverItem[] remover = new RemoverItem[NUM_THREADS];

		// Criando as threads. 
		for (int i = 0; i < NUM_THREADS; i++) {
			buscar[i] = new BuscarItem("ThreadBusca " + (i + 1), listacompartilhada);
			inserir[i] = new InserirItem("ThreadInserção " + (i + 1), listacompartilhada);
			remover[i] = new RemoverItem("ThreadRemoção " + (i + 1), listacompartilhada);
		}

		// Iniciando as threads. 
		for (int i = 0; i < NUM_THREADS; i++) {
			buscar[i].start();
			inserir[i].start();
			remover[i].start();
		}

		// Finalizando as threads. 
		try {
			for (int i = 0; i < NUM_THREADS; i++) {
				buscar[i].join();
				inserir[i].join();
				remover[i].join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
