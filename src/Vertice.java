
public class Vertice<T> {
	
	protected T data;
	protected int label; 	
	protected ListaEnlazada<Arista<T>> AdyList;
	
	public Vertice(T data) {
		setData(data);
		setLista();
	}
	
	public T getData() {
		return this.data; 
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public ListaEnlazada<Arista<T>> getLista(){
		return this.AdyList;
	}
	
	public void setLista() {
		this.AdyList = new ListaEnlazada<Arista<T>>();
	}
	
	public int getLabel() {
		return this.label;
	}
	
	public void setLabel(int label) {
		this.label = label;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Vertice<?>) {
			Vertice<T> vertice = (Vertice<T>) obj;
			return getData().equals(vertice.getData());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return getData() + " ---> " + getLista() + "\n";
	}
	
}
