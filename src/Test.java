
public class Test {

	public static void main(String[] args) {

		Grafo<String> grafo = new Grafo<String>();

		grafo.insertVertice("Madrid");
		grafo.insertVertice("Lisboa");
		grafo.insertVertice("Roma");
		grafo.insertVertice("Turin");
		grafo.insertVertice("Paris");

		grafo.insertArista("Madrid", "Lisboa", 8);
		grafo.insertArista("Roma", "Lisboa", 4);
		grafo.insertArista("Turin", "Madrid", 5);
		grafo.insertArista("Roma", "Madrid", 6);
		grafo.insertArista("Turin", "Paris", 3);

		System.out.println("Grafo:\n");
		System.out.println(grafo);
		
		//probando ejercicio3
		System.out.println("Recorrido BFS para Roma");
		grafo.BFS("Roma");

		System.out.println();

		System.out.println("Recorrido DFS para Paris");
		grafo.DFS("Paris");

		System.out.println("\n");
		
		//probando ejercicio5
				//grafo 1
		Grafo<String> grafoEjr5 = new Grafo<String>();

		grafoEjr5.insertVertice("Madrid");
		grafoEjr5.insertVertice("Lisboa");
		grafoEjr5.insertVertice("Roma");
		grafoEjr5.insertVertice("Turin");
		grafoEjr5.insertVertice("Paris");
		grafoEjr5.insertVertice("Ibiza");
		grafoEjr5.insertVertice("Barcelona");

		grafoEjr5.insertArista("Madrid", "Lisboa", 8);
		grafoEjr5.insertArista("Ibiza", "Barcelona", 10);
		grafoEjr5.insertArista("Roma", "Lisboa", 4);
		grafoEjr5.insertArista("Turin", "Madrid", 5);
		grafoEjr5.insertArista("Madrid", "Barcelona", 5);
		grafoEjr5.insertArista("Roma", "Madrid", 6);
		grafoEjr5.insertArista("Turin", "Paris", 3);

		System.out.println("\nGrafo 1 de ciudades:\n");
		System.out.println(grafoEjr5);


		System.out.println("El Grafo 1 incluye a 'grafo': " + grafoEjr5.incluye(grafo));

		
				//grafo 2
		Grafo<String> grafo2Ejr5 = new Grafo<String>();

		grafo2Ejr5.insertVertice("Madrid");
		grafo2Ejr5.insertVertice("Lisboa");
		grafo2Ejr5.insertVertice("Roma");
		grafo2Ejr5.insertVertice("Turin");
		grafo2Ejr5.insertVertice("Paris");
		grafo2Ejr5.insertVertice("Ibiza");
		grafo2Ejr5.insertVertice("Barcelona");

		grafo2Ejr5.insertArista("Madrid", "Lisboa", 8);
		grafo2Ejr5.insertArista("Ibiza", "Barcelona", 10);
		grafo2Ejr5.insertArista("Roma", "Lisboa", 4);
		grafo2Ejr5.insertArista("Madrid", "Barcelona", 5);
		grafo2Ejr5.insertArista("Roma", "Madrid", 6);
		grafo2Ejr5.insertArista("Turin", "Paris", 3);

		System.out.println("\nGrafo 2 de ciudades:\n");
		System.out.println(grafo2Ejr5);

		System.out.println("El Grafo 2 incluye a 'grafo': " + grafo2Ejr5.incluye(grafo));		
	}

}
