
public class Nodo<T> {
	
	protected T data;
	protected Nodo<T> next;
	
	public Nodo(T data) {
		this(data, null);
	}
	
	public Nodo(T data, Nodo<T> next) {
		setData(data);
		setNext(next);
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public Nodo<T> getNext() {
		return this.next;
	}
	
	public void setNext(Nodo<T> next) {
		this.next = next;
	}
}
