
public class TestEjr4 {
	
	public static void main(String[] args) {
		//ejercicio 4 testing
		Grafo<String> graf = new Grafo<String>();
		
		graf.insertVertice("words");
		graf.insertVertice("cords");
		graf.insertVertice("corps");
		graf.insertVertice("coops");
		graf.insertVertice("crops");
		graf.insertVertice("drops");
		graf.insertVertice("drips");
		graf.insertVertice("grips");
		graf.insertVertice("gripe");
		graf.insertVertice("grape");
		graf.insertVertice("graph");
		
		graf.insertArista("words", "cords");
		graf.insertArista("cords", "corps");
		graf.insertArista("corps", "coops");
		graf.insertArista("coops", "crops");
		graf.insertArista("crops", "drops");
		graf.insertArista("drops", "drips");
		graf.insertArista("drips", "grips");
		graf.insertArista("grips", "gripe");
		graf.insertArista("gripe", "grape");
		graf.insertArista("grape", "graph");
		
		System.out.println("Lista de Adyacencia:\n");
		System.out.println(graf);
		
	}
	
}
