
public class Grafo<T> {
	protected ListaEnlazada<Vertice<T>> listaVertices;
	
	public Grafo() {
		setVertices();
	}
	
	public ListaEnlazada<Vertice<T>> getVertices() {
		return this.listaVertices;
	}
	
	public void setVertices() {
		this.listaVertices = new ListaEnlazada<Vertice<T>>();
	}
	
	public void insertVertice(T data) {
		Vertice<T> n = new Vertice<T>(data);
		if(getVertices().search(n) != null) {
			System.out.println("vértice existente!");
			return;
		} else {
			getVertices().lastIns(n);
		}
	}
	
	public void insertArista(T incio, T fin) {
		insertArista(incio, fin, -1);
	}
	
	public void insertArista(T incio, T fin, int peso) {
		
		Vertice<T> orig = getVertices().search(new Vertice<T>(incio));
		Vertice<T> dest = getVertices().search(new Vertice<T>(fin));
		if(orig == null || dest == null) {
			System.out.println("No existe!");
			return;
		}
		if(orig.getLista().search(new Arista<T>(dest)) != null) {
			System.out.println("Arisata existente!");
			return;
		}
		orig.getLista().lastIns(new Arista<T>(dest));
		dest.getLista().lastIns(new Arista<T>(orig));
	}
	
	public Vertice<T> buscarVertice(Vertice<T> buscar) {
		return getVertices().search(buscar);
	}
	
	@Override
	public String toString() {
		return "Imprimiendo Grafo:\n" + getVertices();
	}
	
	private void inicializarLabel() {
		Nodo<Vertice<T>> aux = getVertices().getInicio();
		for( ; aux != null; aux = aux.getNext()) {
			aux.getData().setLabel(0);
			Nodo<Arista<T>> auxA = aux.getData().getLista().getInicio();
			for( ; auxA != null; auxA = auxA.getNext()) {
				auxA.getData().setLabel(0);
			}
		}
	}
	
	public void DFS(T data) {
		Vertice<T> nuevo = new Vertice<T>(data);
		Vertice<T> auxiliar = getVertices().search(nuevo);
		if(auxiliar == null) {
			System.out.println("Vértice inexistente!");
			return;
		}
		inicializarLabel();
		DFSGrafo(auxiliar);
	}
	
	private void DFSGrafo(Vertice<T> auxiliar) {
		auxiliar.setLabel(1);
		System.out.println(auxiliar.getData() + ", ");
		Nodo<Arista<T>> auxA = auxiliar.getLista().getInicio();
		for( ; auxA != null; auxA = auxA.getNext()) {
			if(auxA.getData().getLabel() == 0) {
				Vertice<T> opuesto = auxA.getData().getDestino();
				if(opuesto.getLabel() == 0) {
					auxA.getData().setLabel(1);
					DFSGrafo(opuesto);
				} else {
					auxA.getData().setLabel(2);
				}
			}
		}
	}
	
	public void BFS(T data) {
		Vertice<T> n = new Vertice<T>(data);
		Vertice<T> aux = getVertices().search(n);
		if(aux == null) {
			System.out.println("Vértice inexistente!");
			return;
		}
		inicializarLabel();
		ListsBFS(aux);
	}
	
	
	private void ListsBFS(Vertice<T> auxiliar) {
		ListaEnlazada<ListaEnlazada<Vertice<T>>> lista =
			new ListaEnlazada<ListaEnlazada<Vertice<T>>>();
		ListaEnlazada<Vertice<T>> i = new ListaEnlazada<Vertice<T>>();
		i.lastIns(auxiliar);
		lista.lastIns(i);
		auxiliar.setLabel(1);
		Nodo<ListaEnlazada<Vertice<T>>> auxL = lista.getInicio();
		while(auxL != null) {
			Nodo<Vertice<T>> auxV = auxL.getData().getInicio();
			ListaEnlazada<Vertice<T>> listaAux = new ListaEnlazada<Vertice<T>>();
			while(auxV != null) {
				Nodo<Arista<T>> auxA = auxV.getData().getLista().getInicio();
				System.out.println(auxV.getData().getData() + ", ");
				while(auxA != null) {
					if(auxA.getData().getLabel() == 0) {
						Vertice<T> opuesto = auxA.getData().getDestino();
						if(opuesto.getLabel() == 0) {
							opuesto.setLabel(1);
							auxA.getData().setLabel(1);
							listaAux.lastIns(opuesto);
						} else
							auxA.getData().setLabel(2);
					}
					auxA = auxA.getNext();
				}
				auxV = auxV.getNext();
			}
			if(listaAux.getInicio() != null) {
				auxL.setNext(new Nodo<ListaEnlazada<Vertice<T>>>(listaAux));
				auxL = auxL.getNext();
			} else
				auxL = auxL.getNext();
		}
	}
	
	public boolean incluye(Grafo<T> otroGrafo) {
		boolean retornar = false;
		ListaEnlazada<Vertice<T>> copiaG = getVertices().copy();
		Nodo<Vertice<T>> inicio = otroGrafo.getVertices().getInicio();
		while(inicio != null) {
			Vertice<T> buscar = copiaG.search(inicio.getData());
			if(buscar != null) {
				System.out.println(buscar.getData() 
					+ ", esta en el grafo!");
				if(buscar.getLista().incluye(inicio.getData().getLista())) {
					System.out.println("!!La Lista de Adyacencia esta incluida!!");
					copiaG.remove(inicio.getData());
					retornar = true;
					inicio = inicio.getNext();
				} else {
					System.out.println("!!La Lista de Adyacencia no esta incluida!!");
					retornar = false;
					break;
				}
			}
		}
		return retornar;
	}
	
}
