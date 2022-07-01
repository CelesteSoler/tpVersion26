package Prog3_TPE2;
//package tp2Esp;

	import java.util.ArrayList;
import java.util.HashMap;
	import java.util.Iterator;
	import java.util.List;


	public class DFS_Ciclo {
		private Grafo <String> grafo;
		private HashMap<String,String>colores;//la idea es no meterle el color al vertice, guardo los colores de cada de vertice por fuera,
		
		
		public DFS_Ciclo (Grafo <String> grafo) {
			this.grafo = grafo;
			this.colores = new HashMap<>();
			
		}
		
		public boolean hayCiclo(String generoA) {//ejercicio 3
			
			Iterator<String> it = this.grafo.obtenerVertices();
			while (it.hasNext()) {
				String verticeId = it.next();
				colores.put(verticeId, "blanco");
			}
			
			it = this.grafo.obtenerVertices();
			
			boolean encontre= false;
		
			encontre = dfs_visit(generoA,generoA);
		
			return encontre;	
		}
		
		public boolean dfs_visit(String vertice, String generoA) {
		
			colores.put(vertice, "amarillo");
			
			Iterator<String> it = this.grafo.obtenerAdyacentes(vertice);//tengo que recorrer tods los adyacentes
			boolean encontre = false;
			
			while(it.hasNext()&& !encontre) {//mientras tenga adyacente
				String adyacente = it.next();//obtengo el id del vertice adyacente
				
				if(colores.get(adyacente).equals("blanco")) { 
					
					encontre = dfs_visit(adyacente,generoA);
				}
				else if (colores.get(adyacente).equals("amarillo")&& adyacente.equals(generoA)) {//si lo visite y esta en amariillo, quiere decir que ya fue visitado, encontes lo pinto en negro
					encontre = true;//si hay un ciclo donde lo encontre corte, lo retorno
					System.out.println("encontre");
				}
			}
			colores.put(vertice, "negro");
			
			return encontre;
			
		}
		
	
	}

