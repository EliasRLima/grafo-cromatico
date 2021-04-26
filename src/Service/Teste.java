package Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import estruturas.Aresta;

public class Teste {
   
	public static void main(String[] args) throws FileNotFoundException {
		
		//usado um arquivo onde cada linha esta com a estrutura "GRAFO1;GRAFO2;DISTANCIA_ENTRE_ELES"
		ServiceGrafo g = new ServiceGrafo("src/arquivos/ligacoes.txt");
		
		int cromatico = g.getCromatico();
		System.out.println("O sistema possui valor cromatico = " + cromatico);
		
	} 
}
