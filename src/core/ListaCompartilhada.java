package core;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ListaCompartilhada {

	// Lista compartilhada.
	private LinkedList<Integer> lista;

	// Atributo ReentrantReadWriteLock
	private ReentrantReadWriteLock rrwLock;

	// Atributo ReentrantLock
	private ReentrantLock reentrantLock;

	// Construtor da lista compartilhada.
	public ListaCompartilhada() {
		lista = new LinkedList<>();
		rrwLock = new ReentrantReadWriteLock(true);
		reentrantLock = new ReentrantLock(true);
	}

	// Realiza a remoção de um item da lista informado.
	public void removerItem(Integer valor) {

		rrwLock.writeLock().lock();
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " adquiriu acesso para remoção do item " + valor + ".");

		try {
			if (lista.remove(valor)) {
				System.out.println("Elemento " + valor + " removido da lista.");
			} else {
				System.out.println("Elemento " + valor + " não foi removido porque não se encontra na lista.");
			}

		} finally {
			rrwLock.writeLock().unlock();
			System.out.println(threadName + " finalizou e liberou acesso.");
		}

	}

	// Realiza a consulta de um item da lista informado.
	public void buscarItem(Integer valor) {

		rrwLock.readLock().lock();
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " adquiriu acesso para consulta do item " + valor + ".");

		try {
			if (lista.contains(valor)) {
				System.out.println("Elemento " + valor + " localizado na lista.");
			} else {
				System.out.println("Elemento " + valor + " não foi localizado na lista.");
			}

		} finally {
			rrwLock.readLock().unlock();
			System.out.println(threadName + " finalizou e liberou acesso.");
		}

	}

	// Realiza a inserção de um item no final da lista.
	public void inserirItem(Integer valor) {

		rrwLock.readLock().lock();
		reentrantLock.lock();
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " adquiriu acesso para inserção do item " + valor + ".");

		try {
			lista.add(valor);
			System.out.println("Elemento " + valor + " inserido na lista.");

		} finally {
			rrwLock.readLock().unlock();
			reentrantLock.unlock();
			System.out.println(threadName + " finalizou e liberou acesso.");
		}

	}

}
