
package compilador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import executor.Estado;
import executor.FuncaoDeTransicao;
import executor.MaquinaDeTuring;

public class Main {

	private static Scanner sc = new Scanner(System.in);
		
	
	public static void main(String[] args) throws IOException {


		System.out.println("                           ==========================\n                           |Turing Machine Simulator|\n                           ==========================\n");
		System.out.print("Informe o caminho para o código: ");
		String caminho = sc.nextLine();
		System.out.print("Insira fita: ");
		String fita = sc.nextLine();
		System.out.println("Deseja a funcao passo por passo? s/n");
		String resposta = sc.nextLine();
		boolean stepByStep;
		
		if(resposta.toLowerCase().equals("s") || resposta.toLowerCase().equals("sim")){
			
			stepByStep = true;
		}
		else{
			
			stepByStep = false;
		}
		System.out.println("\n\n                         ===============================\n                         |Programa da Maquina de Turing|\n                         ===============================\n\n");
		MaquinaDeTuring turingMachine = new MaquinaDeTuring(leArquivo(caminho), fita, stepByStep);
		
		System.out.println("\n\nExecução: \n\n");
		
		turingMachine.start();
		

	}

	public static ArrayList<Estado> leArquivo(String caminho) throws IOException {

		FileReader arquivo = new FileReader(caminho);

		BufferedReader leituraArquivo = new BufferedReader(arquivo);

		String linhaDoArquivo = leituraArquivo.readLine();
		ArrayList<Estado> estados = new ArrayList<Estado>();
		ArrayList<String> estadosString = new ArrayList<>();
		int count = 1;
		
		while (linhaDoArquivo != null) {

			System.out.println(count+"- " + linhaDoArquivo);
			
			if(verificaLinhaComando(linhaDoArquivo)){
				
				criaElementos(linhaDoArquivo, estados, estadosString);
			}

			linhaDoArquivo = leituraArquivo.readLine();
			count++;
		}

		arquivo.close();
		
		return estados;
	}
	
	private static void criaElementos(String linhaDoArquivo, ArrayList<Estado> estados, ArrayList<String> estadosString) {
	
		FuncaoDeTransicao ft = new FuncaoDeTransicao(linhaDoArquivo);
		String[] linha = linhaDoArquivo.split(" ");
		
		if(estadosString.contains(linha[0])){
			
			for (int i = 0; i < estadosString.size(); i++) {
				
				if(linha[0].equals(estadosString.get(i))){
					
					estados.get(i).addFuncao(ft);
				}
			}
		}
		else{
			
			ArrayList<FuncaoDeTransicao> funcao = new ArrayList<>();
			funcao.add(ft);
			Estado estado = new Estado(linha[0], funcao);
			estados.add(estado);
			estadosString.add(linha[0]);
		}
		
	}

	public static boolean verificaLinhaComando(String linhaEntrada){
		
		String[] linha = linhaEntrada.split(" ");
		ArrayList<String> retorno = new ArrayList<>();
		int cont = 0;
		
		if(linha.length > 1){
			
			while( retorno.size() < 5 && !linha[cont].equals(";")){
				
				retorno.add(linha[cont]);
				cont++;
			}
			
			if(retorno.size() == 5){
				
				return true;
			}
		}
		return false;
	}
}

