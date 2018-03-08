package executor;

public class FuncaoDeTransicao {
	
	private String estadoAtual;
	private String simboloAtual;
	private String novoSimbolo;
	private String direcao;
	private String proximoEstado;
	private String entradaCompleta;
	
	public FuncaoDeTransicao( String entrada ){
		
		String[] entradaDividida = this.divideEntrada(entrada);
		
		this.entradaCompleta = entrada;
		this.estadoAtual = entradaDividida[0];
		this.simboloAtual = entradaDividida[1];
		this.novoSimbolo = entradaDividida[2];
		this.direcao = entradaDividida[3];
		this.proximoEstado = entradaDividida[4];
		
	}
	
	private  String[] divideEntrada(String entrada){
		
		String[] entradaDividida = entrada.split(" ");
		
		return entradaDividida;
	}

	public String getEstadoAtual() {
		return estadoAtual;
	}

	private void setEstadoAtual(String estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

	public String getSimboloAtual() {
		return simboloAtual;
	}

	private void setSimboloAtual(String simboloAtual) {
		this.simboloAtual = simboloAtual;
	}

	public String getNovoSimbolo() {
		return novoSimbolo;
	}

	private void setNovoSimbolo(String novoSimbolo) {
		this.novoSimbolo = novoSimbolo;
	}

	public String getDirecao() {
		return direcao;
	}

	private void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public String getProximoEstado() {
		return proximoEstado;
	}

	private void setProximoEstado(String proximoEstado) {
		this.proximoEstado = proximoEstado;
	}
	
	public String toString(){
		
		return this.entradaCompleta;
	}


}
