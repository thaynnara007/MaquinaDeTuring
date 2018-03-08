
package executor;

import java.util.ArrayList;
import java.util.Scanner;

public class MaquinaDeTuring {
	
	private static Scanner sc = new Scanner(System.in);
	private Estado estadoAtual;
	private int step;
	private Fita fita;
	private ArrayList<Estado> estados;
	private Estado estadoInicial;
	private boolean stepByStep;

	public MaquinaDeTuring(ArrayList<Estado> estados, String entrada, boolean stepByStep) {
		
		this.estados = estados;
		this.fita = new Fita(entrada);
		this.estadoAtual = estados.get(0);
		this.step = 0;
		this.estadoInicial = estados.get(0);
		this.stepByStep = stepByStep;
	}

	private Estado getEstado(String nome) {
		
		for (Estado estado : estados) {
			
			if (estado.getEstado().equals(nome)) {
				
				return estado;
			}
		}
		return null;
	}

	private void start(int index, Estado estado) {
		
		System.out.println(this.toString());
		

	if (!estadoAtual.getEstado().equals("accept") && 
			!estadoAtual.getEstado().equals("reject")) {

			String simbolo = fita.getFita().get(index);
			FuncaoDeTransicao funcao = estado.getFuncaoDeTransicao(simbolo);
			
			if(funcao != null){
				
				fita.substitui(funcao.getSimboloAtual(), funcao.getNovoSimbolo());
				fita.anda(funcao.getDirecao());
			}
			
			Estado proximoEstado = this.getEstado(funcao.getProximoEstado());

			this.step++;
			this.estadoAtual = proximoEstado;
			
			if(this.stepByStep){
				
				String push = sc.nextLine();
				this.start(fita.getIndex(), proximoEstado);
			} 
			else {
			
				this.start(fita.getIndex(), proximoEstado);
			}
		}
	}

	public void start() {

		 start(0, this.estados.get(0));

	}

	@Override
	public String toString() {
		
		String espaco = "                                                              ";
		String retorno = "";
		fita.ESPACO = daEspaco(50 - fita.getFita().size() /2);
		
		retorno += fita.toString() + "\nEstado Atual: " + this.estadoAtual.getEstado() 
		+ espaco + "Steps: " + this.step;
		
		return retorno;
	}
	
	private String daEspaco(int qntd){
		
		String espaco = "";
		
		for(int i = 0; i < qntd; i++){
			                                                                                            
			espaco += " ";
		}
		
		return espaco;
	}

}

