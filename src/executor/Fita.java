
package executor;

import java.util.LinkedList;

public class Fita {
	
	protected String ESPACO = "";
	private final String RIGHT = "r";
	private final String BRANCO = "_";
	private final String LEFT = "l";
	private final int ExtremidadeRight;
	private final int ExtremidadeLeft;
	private LinkedList<String> fita = new LinkedList<>();
	private String root;
	private int index;
	protected int size;
	
	public Fita(String entrada){
		
		this.preencheFita(entrada);
		fita.add(BRANCO);
		this.size = this.fita.size();
		this.root = fita.getFirst();
		this.index = 0;
		this.ExtremidadeLeft = 0;
		this.ExtremidadeRight = fita.size() - 1;
	}
	
	private String daEspaco(int qntd){
		
		String espaco = "";
		
		for(int i = 0; i < qntd; i++){
			                                                                                            
			espaco += " ";
		}
		
		return espaco;
	}
	
	private void preencheFita(String entrada){
		
		String[] entradaDividida = entrada.split("");
		
		for (int i = 0; i < entradaDividida.length; i++) {
			
			fita.add(entradaDividida[i]);
		}
	}
	
	protected void substitui(String simboloAtual, String novoSimbolo){
		
		if(!simboloAtual.equals("*") && !novoSimbolo.equals("*")){
		
			if( this.root.equals(simboloAtual)){
				
				this.fita.remove(this.index);
				this.fita.add(this.index, novoSimbolo);
				this.root = this.fita.get(this.index);
			}
			else{
				
				int i = this.procuraSimbolo(simboloAtual);
				
				if( i != -1 ){
					
					this.fita.remove(i);
					this.fita.add(i, novoSimbolo);
					this.root = this.fita.get(i);
					
				}
			}
		}
	}
	
	private int procuraSimbolo(String simbolo){
		
			for(int i = 0; i < this.fita.size(); i++){
				
				if(this.fita.get(i).equals(simbolo)){
					
					return i;
				}
			}
			return -1;
	}
	
	protected void anda(String direcao){
		
		if(direcao.equals(this.RIGHT)){
			
			if( (this.index + 1) <= this.ExtremidadeRight){
				
				this.index++;
				this.root = this.fita.get(this.index);
			}
		}
		else if(direcao.equals(LEFT)){
			
			if((this.index - 1) >= this.ExtremidadeLeft){
				
				this.index--;
				this.root = this.fita.get(this.index);
			}
		}
		
	}
	
	public String toString(){
		
		String retorno = this.ESPACO;
		String apontador = this.ESPACO;
		
		for (String elemento : fita) {
			
			retorno += elemento;
		}
		
		apontador += this.daEspaco(index) + "^";
		retorno += "\n" + apontador;
		
		return retorno;
		
	}
	
	protected int countBranco(){
		
		int brancos = 0;
		
		for (String simbolo : fita) {
			
			if(simbolo.equals(BRANCO)){
				
				brancos++;
			}
		}
		
		return brancos;
	}

	public LinkedList<String> getFita() {
		return fita;
	}

	private void setFita(LinkedList<String> fita) {
		this.fita = fita;
	}

	public String getRoot() {
		return root;
	}

	private void setRoot(String root) {
		this.root = root;
	}

	public int getIndex() {
		return index;
	}

	private void setIndex(int index) {
		this.index = index;
	}
	
}

