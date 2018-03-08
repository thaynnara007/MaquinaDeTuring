package executor;

import java.util.ArrayList;

public class Estado {
	
	private ArrayList<FuncaoDeTransicao> funcoes;
	private String estado;
	
	public Estado( String estado, ArrayList<FuncaoDeTransicao> funcoes){
		
		this.funcoes = funcoes;
		this.estado = estado;
	}
	
	protected FuncaoDeTransicao getFuncaoDeTransicao(String entrada){
		
		for (FuncaoDeTransicao funcaoDeTransicao : funcoes) {
			
				if(funcaoDeTransicao.getSimboloAtual().equals(entrada)){
					
					return funcaoDeTransicao;
				}
			}
		
		for (FuncaoDeTransicao funcaoDeTransicao : funcoes) {
			if(funcaoDeTransicao.getSimboloAtual().equals("*")){
				
				return funcaoDeTransicao;
			}
		}		
		return null;
	}
	
	public String toString(){
		
		return this.estado;
	}

	public ArrayList<FuncaoDeTransicao> getFuncoes() {
		return funcoes;
	}

	private void setFuncoes(ArrayList<FuncaoDeTransicao> funcoes) {
		this.funcoes = funcoes;
	}

	public String getEstado() {
		return estado;
	}

	private void setEstado(String estado) {
		this.estado = estado;
	}

	public void addFuncao(FuncaoDeTransicao ft) {
		
		this.funcoes.add(ft);
		
	}
}
