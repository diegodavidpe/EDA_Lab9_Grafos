
public class ListaEnlazada<T> {
	
	protected Nodo<T> inicio;
	
	public ListaEnlazada() {
		setInicio(null);
	}
	
	public void setInicio(Nodo<T> inicio) {
		this.inicio = inicio;
	}
	
	public Nodo<T> getInicio() {
		return this.inicio;
	}
	
	public boolean isEmpty() {
		return getInicio() == null;
	}
	
	public T search(T data) {
		Nodo<T> aux = getInicio();
		while(aux != null && !aux.getData().equals(data))
			aux = aux.getNext();
		if(aux != null) {
			return aux.getData();
		} else
			return null;
	}
	
	public void insert(T data) {
		setInicio(new Nodo<T>(data, getInicio()));
	}
	
	public void lastIns(T data) {
		Nodo<T> aux = getInicio();
		if(aux == null) {
			insert(data);
		} else {
			while(aux.getNext() != null)
				aux = aux.getNext();
			aux.setNext(new Nodo<T>(data));
		}
	}
	
	public T remove(T data) {
		T temp = null;
		Nodo<T> aux = getInicio();
		if(getInicio().getData().equals(data)) {
			setInicio(getInicio().getNext());
			temp = null;
		} else {
			while(aux.getNext() != null) {
				if(aux.getNext().getData().equals(data)) {
					temp = aux.getNext().getData();
					aux.setNext(aux.getNext().getNext());
				} else
					aux = aux.getNext();
			}
		}
		return temp;
	}
	
	@Override
	public String toString() {
		String temp = "";
		Nodo<T> aux = getInicio();
		while(aux != null) {
			temp += aux.getData();
			aux = aux.getNext();
		}
		return temp;
	}
	
	public ListaEnlazada<T> copy() {
		Nodo<T> inicio = getInicio();
		ListaEnlazada<T> c = new ListaEnlazada<T>();
		while(inicio != null) {
			c.lastIns(inicio.getData());
			inicio = inicio.getNext();
		}
		return c;
	}
	
	public boolean incluye(ListaEnlazada<T> otraLista) {
		boolean retornar = false;
		Nodo<T> inicioP = otraLista.getInicio();
		ListaEnlazada<T> copia = copy();
		while(inicioP != null) {
			T buscar = copia.search(inicioP.getData());
			if(buscar != null) {
				System.out.println(inicioP.getData() 
					+ ", esta en el grafo!!");
				copia.remove(inicioP.getData());
				retornar = true;
			} else {
				System.out.println(inicioP.getData() 
				+ ", no esta en el grafo!!");
				retornar = false;
				break;
			}
			inicioP = inicioP.getNext();
		}
		return retornar;
	}
	
}
