package core;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ListaCompartilhada {

	private LinkedList<Integer> lista;

	private ReentrantReadWriteLock accessoLock;

	public ListaCompartilhada() {

		lista = new LinkedList<>();
		accessoLock = new ReentrantReadWriteLock(true);
	}

	public void removerItem(Integer valor) {

		accessoLock.writeLock().lock();
		System.out.println(Thread.currentThread().getName() + " adquiriu acesso para remoção do item " + valor + ".");

		try {
			if (lista.remove(valor)) {
				System.out.println("Elemento " + valor + " removido da lista.");
			} else {
				System.out.println("Elemento " + valor + " não foi removido porque não se encontra na lista.");
			}
		} finally {
			accessoLock.writeLock().unlock();
			System.out.println(Thread.currentThread().getName() + " finalizou e liberou acesso.");
		}

	}

	public void buscarItem(Integer valor) {

		accessoLock.writeLock().lock();
		System.out.println(Thread.currentThread().getName() + " adquiriu acesso para consulta do item " + valor + ".");

		try {
			if (lista.contains(valor)) {
				System.out.println("Elemento " + valor + " localizado na lista.");
			} else {
				System.out.println("Elemento " + valor + " não foi localizado na lista.");
			}
		} finally {
			accessoLock.writeLock().unlock();
			System.out.println(Thread.currentThread().getName() + " finalizou e liberou acesso.");
		}

	}
}
