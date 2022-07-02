package Prog3_TPE2;
//package tp2Esp;

	import java.util.ArrayList;
import java.util.HashMap;
	import java.util.Iterator;
	import java.util.List;


	public class DFS_Ciclo {
		private Grafo <String> grafo;
		private HashMap<String,String>colores;
		private ArrayList<String> verticesAfines;
		
		public DFS_Ciclo (Grafo <String> grafo) {
			this.grafo = grafo;
			this.colores = new HashMap<>();
		}
		
		public  ArrayList<String> hayCiclo(String generoA) {//ejercicio 3
			
			Iterator<String> it = this.grafo.obtenerVertices();
			while (it.hasNext()) {
				String verticeId = it.next();
				colores.put(verticeId, "blanco");
			}
			ArrayList<String> caminoParcial = new ArrayList<String>();
			verticesAfines  = dfs_visit(generoA,generoA,caminoParcial);
			//generar el grafo con la lista de generos de los ciclos
			//va a haber repetidos, controlar
			//crear el grafo y los arcos
			return verticesAfines;	
		}
		
		public  ArrayList<String>   dfs_visit(String vertice, String generoA,ArrayList<String> caminoParcial ){
			colores.put(vertice, "amarillo");
			Iterator<String> it = this.grafo.obtenerAdyacentes(vertice);
			
			while(it.hasNext()) {
				String adyacente = it.next();
				
				if(colores.get(adyacente).equals("blanco")) { 
					caminoParcial=dfs_visit(adyacente,generoA,caminoParcial);
					 caminoParcial.add(0,vertice);	
				}
				
				else if (colores.get(adyacente).equals("amarillo")&& adyacente.equals(generoA)) { 
					System.out.println("lo encontre");
					//caminoParcial.add((caminoParcial.size()-1),adyacente);
					this.verticesAfines.addAll(caminoParcial);
					return caminoParcial; 
				}
			}
			
			return caminoParcial;
			
		}
		
		/*
		 * public ArrayList< ArrayList<Integer> > encontrarCaminos(int origen, int destino) {

		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			this.colores.put(verticeId, "blanco");
		}
		ArrayList< ArrayList<Integer> >  caminos =encontrarCaminos_Visit(origen,destino) ;
		return caminos ;	
	}
	
	public ArrayList< ArrayList<Integer> > encontrarCaminos_Visit(int origen, int destino){
		ArrayList< ArrayList<Integer> >  todosLosCaminos = new ArrayList<>();
		
		if (origen == destino) {
			ArrayList<Integer> salida = new ArrayList<Integer>();
			salida.add(origen);
			todosLosCaminos.add(salida);
		} 
		else {
			
		this.colores.put(origen, "amarillo");
			
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen);
		
			while (it.hasNext()){
				int adyacente = it.next();
				if (this.colores.get(adyacente).equals("blanco")) {
					
					ArrayList< ArrayList<Integer> > todosLosSubCaminos = encontrarCaminos_Visit(adyacente,destino);
					
					for(ArrayList<Integer> SubCamino: todosLosSubCaminos) {
						SubCamino.add(0,origen);	
						todosLosCaminos.add(SubCamino);
					}
				}	
			}
		}
		return todosLosCaminos;	
	}
}
*/
		
		
	
	}

