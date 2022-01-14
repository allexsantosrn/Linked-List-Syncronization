package core;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ListaCompartilhada {

	private LinkedList<Integer> lista;

	private ReentrantReadWriteLock acessoLock;
	
	private ReentrantLock inserirLock;

	public ListaCompartilhada() {

		lista = new LinkedList<>();
		acessoLock = new ReentrantReadWriteLock(true);
		inserirLock = new ReentrantLock(true);
	}

	public void removerItem(Integer valor) {

		acessoLock.writeLock().lock();
		System.out.println(Thread.currentThread().getName() + " adquiriu acesso para remoção do item " + valor + ".");

		try {
			if (lista.remove(valor)) {
				System.out.println("Elemento " + valor + " removido da lista.");
			} else {
				System.out.println("Elemento " + valor + " não foi removido porque não se encontra na lista.");
			}
		} finally {
			acessoLock.writeLock().unlock();
			System.out.println(Thread.currentThread().getName() + " finalizou e liberou acesso.");
		}

	}

	public void buscarItem(Integer valor) {

		acessoLock.writeLock().lock();
		System.out.println(Thread.currentThread().getName() + " adquiriu acesso para consulta do item " + valor + ".");

		try {
			if (lista.contains(valor)) {
				System.out.println("Elemento " + valor + " localizado na lista.");
			} else {
				System.out.println("Elemento " + valor + " não foi localizado na lista.");
			}
		} finally {
			acessoLock.writeLock().unlock();
			System.out.println(Thread.currentThread().getName() + " finalizou e liberou acesso.");
		}

	}
	
	public void inserirItem(Integer valor) {
		
		acessoLock.writeLock().lock();
		inserirLock.lock();
		System.out.println(Thread.currentThread().getName() + " adquiriu acesso para inserção do item " + valor + ".");		
		
		try {
			lista.add(valor);
			System.out.println("Elemento " + valor + " inserido na lista.");
		} finally {
			acessoLock.writeLock().unlock();
			inserirLock.unlock();
			System.out.println(Thread.currentThread().getName() + " finalizou e liberou acesso.");
		}

	}
}
