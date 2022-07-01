package Prog3_TPE2;
//package tp2Esp;

	import java.util.ArrayList;
import java.util.HashMap;
	import java.util.Iterator;
	import java.util.List;


	public class DFS_Ciclo {
		private Grafo <String> grafo;
		private HashMap<String,String>colores;//la idea es no meterle el color al vertice, guardo los colores de cada de vertice por fuera,
		private Grafo<String> grafoCiclo;
		
		public DFS_Ciclo (Grafo <String> grafo) {
			this.grafo = grafo;
			this.colores = new HashMap<>();
			
		}
		
		public  ArrayList<String>   hayCiclo(String generoA) {//ejercicio 3
			
			Iterator<String> it = this.grafo.obtenerVertices();
			while (it.hasNext()) {
				String verticeId = it.next();
				colores.put(verticeId, "blanco");
			}
			
			ArrayList< ArrayList<String> >  caminos  = dfs_visit(generoA,generoA);
		
			return caminos;	
		}
		
		public  ArrayList<String>   dfs_visit(String vertice, String generoA){//le paso tambien por parametro un camino parcial) {
			 ArrayList<String>   todosLosCiclos = new ArrayList<>();
			colores.put(vertice, "amarillo");
			
			Iterator<String> it = this.grafo.obtenerAdyacentes(vertice);//tengo que recorrer tods los adyacentes
			//boolean encontre = false;
			
			while(it.hasNext()) {//mientras tenga adyacente
				String adyacente = it.next();//obtengo el id del vertice adyacente
				
				if(colores.get(adyacente).equals("blanco")) { 
					
					 ArrayList<String>  todosLosSubCaminos =dfs_visit(adyacente,generoA);
					
					for(ArrayList<String> SubCamino: todosLosSubCaminos) {
						SubCamino.add(0,vertice);	
						todosLosCiclos.add(SubCamino);
					}
				}
				else if (colores.get(adyacente).equals("amarillo")&& adyacente.equals(generoA)) {//si lo visite y esta en amariillo, quiere decir que ya fue visitado, encontes lo pinto en negro
					//retorno el camino parcial
					//encontre = true;//si hay un ciclo donde lo encontre corte, lo retorno
					//System.out.println("encontre");
					//return todos 
				}
			}
			//colores.put(vertice, "negro");
			
			return todosLosCiclos;
			
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

