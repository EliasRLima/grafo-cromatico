package Service;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import estruturas.Aresta;
import estruturas.Percurso;

public class ServiceGrafo {
	ArrayList<Aresta> arestas;

	public ServiceGrafo(String link) throws FileNotFoundException {
		carregaArquivo(link);
	}

	private void carregaArquivo(String link) throws FileNotFoundException {
		arestas = new ArrayList<Aresta>();
		Scanner in = new Scanner(new FileReader(link));
		while (in.hasNextLine()) {
			String aux[] = in.nextLine().toString().split(";");
			arestas.add(new Aresta(aux[0], aux[1], Integer.parseInt(aux[2])));
		}
	}
	
	public int getCromatico() {
		int vc = 0;
		int idx = 0;
		
		for(Aresta a : arestas) {
			a.setCorA(corAresta(a.getIdA()));
			a.setCorB(corAresta(a.getIdB()));
			
			if(a.getCorA() == 0) {
				ArrayList<String> ids = getIdsConectados(a.getIdB());
				int aux = 0;
				for(String idaux : ids) {
					if(idaux.equals(a.getIdB())) {
						continue;
					}
					
					if(!existeConexao(a.getIdA(), idaux)) {
						for(Aresta sub : arestas) {
							if(sub.getIdA().equals(idaux) && sub.getIdB().equals(a.getIdB())) {
								if(sub.getCorA() > 0) {
									a.setCorA(sub.getCorA());
									aux = 1;
									break;
								}else {
									continue;
								}
							}
							
							if(sub.getIdB().equals(idaux) && sub.getIdA().equals(a.getIdB())) {
								if(sub.getCorB() > 0) {
									a.setCorA(sub.getCorB());
									aux = 1;
									break;
								}else {
									continue;
								}
							}
							
						}
						if(aux == 1)
							break;
					}
				}
				if(aux == 0) {
					idx += 1;
					a.setCorA(idx);
				}
			}
			
			if(a.getCorB() == 0) {
				ArrayList<String> ids = getIdsConectados(a.getIdA());
				int aux = 0;
				for(Aresta idaux : arestas) {
					if(idaux.getIdA().equals(a.getIdB()) || idaux.getIdB().equals(a.getIdB())) {
						continue;
					}
					if(!existeConexao(a.getIdB(), idaux.getIdA())) {
						aux = corAresta(idaux.getIdA());
						if(aux > 0) {
							a.setCorB(aux);
							break;
						}
					}else if(!existeConexao(a.getIdB(), idaux.getIdB())) {
						aux = corAresta(idaux.getIdB());
						if(aux > 0) {
							a.setCorB(aux);
							break;
						}
					}
						
				}
				if(aux == 0) {
					idx += 1;
					a.setCorB(idx);
				}
			}
		}
		
		/*for(Aresta a : arestas) {
			System.out.println(""+a.getIdA()+" em " + a.getCorA() + " ## "+a.getIdB()+" em "+a.getCorB());
		}*/
		return idx;
	}
	
	private int corAresta(String id) {
		for(Aresta a : arestas) {
			if(a.getIdA().equals(id)) {
				if(a.getCorA() != 0) {
					return a.getCorA();
				}
			}
			
			if(a.getIdB().equals(id)) {
				if(a.getCorB() != 0) {
					return a.getCorB();
				}
			}
		}
		return 0;
	}
	
	private int numConexoes(String id) {
		int num = 0;
		for(Aresta a : arestas) {
			if(a.getIdA().equals(id))
				num++;
			if(a.getIdB().equals(id))
				num++;
		}
		return num;
	}
	
	private ArrayList<String> getIdsConectados(String id){
		ArrayList<String> ids = new ArrayList<String>();
		for(Aresta a : arestas) {
			if(a.getIdA().equals(id)) {
				if(!ids.contains(a.getIdB()))
					ids.add(a.getIdB());
				continue;
			}
				
			if(a.getIdB().equals(id)) {
				if(!ids.contains(a.getIdA()))
					ids.add(a.getIdA());
			}
		}
		return ids;
	}
	
	private boolean existeConexao(String idA, String idB) {
		for(Aresta a : arestas) {
			if(a.getIdA().equals(idA) && a.getIdB().equals(idB))
				return true;
			if(a.getIdA().equals(idB) && a.getIdB().equals(idA))
				return true;
		}
		return false;
	}
	
	
	
}
