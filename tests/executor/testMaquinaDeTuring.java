package executor;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class testMaquinaDeTuring {

	FuncaoDeTransicao funcao1;
	FuncaoDeTransicao funcao2;
	FuncaoDeTransicao funcao3;
	FuncaoDeTransicao funcao4;
	FuncaoDeTransicao funcao5;
	FuncaoDeTransicao funcao6;
	FuncaoDeTransicao funcao7;
	FuncaoDeTransicao funcao8;
	FuncaoDeTransicao funcao9;
	FuncaoDeTransicao funcao10;
	FuncaoDeTransicao funcao11;
	FuncaoDeTransicao funcao12;
	FuncaoDeTransicao funcao13;
	FuncaoDeTransicao funcao14;
	FuncaoDeTransicao funcao15;
	FuncaoDeTransicao funcao16;
	FuncaoDeTransicao funcao17;
	FuncaoDeTransicao funcao18;
	FuncaoDeTransicao funcao19;
	
	Estado estado0;
	Estado estadolo;
	Estado estadoli;
	Estado estado2o;
	Estado estado2i;
	Estado estado3;
	Estado estado4;
	Estado estadoAccept;
	Estado estadoReject;
	
	ArrayList<FuncaoDeTransicao> funcoes = new ArrayList<>();
	ArrayList<FuncaoDeTransicao> funcoes1 = new ArrayList<>();
	ArrayList<FuncaoDeTransicao> funcoes2 = new ArrayList<>();
	ArrayList<FuncaoDeTransicao> funcoes3 = new ArrayList<>();
	ArrayList<FuncaoDeTransicao> funcoes4 = new ArrayList<>();
	ArrayList<FuncaoDeTransicao> funcoes5 = new ArrayList<>();
	ArrayList<FuncaoDeTransicao> funcoes6 = new ArrayList<>();
	ArrayList<FuncaoDeTransicao> funcoes7 = new ArrayList<>();
	ArrayList<FuncaoDeTransicao> funcoes8 = new ArrayList<>();
	ArrayList<Estado> estados = new ArrayList<>();
	
	MaquinaDeTuring machine;
	
	@Before
	public void setup(){
		
		this.funcao1 = new FuncaoDeTransicao("0 0 _ r 1o");
		this.funcao2 =  new FuncaoDeTransicao("0 1 _ r 1i");
		this.funcao3 =  new FuncaoDeTransicao("0 _ _ * accept");
		this.funcoes.add(funcao1);
		this.funcoes.add(funcao2);
		this.funcoes.add(funcao3);
		
		this.estado0 = new Estado("0", funcoes);
		this.estados.add(estado0);
		
		this.funcao4 = new FuncaoDeTransicao("1o _ _ l 2o");
		this.funcao5 = new FuncaoDeTransicao("1o * * r 1o");
		this.funcoes1.add(funcao4);
		this.funcoes1.add(funcao5);
		
		this.estadolo = new Estado("1o", funcoes1);
		this.estados.add(estadolo);
		
		this.funcao6 = new FuncaoDeTransicao("1i _ _ l 2i");
		this.funcao7 = new FuncaoDeTransicao("1i * * r 1i");
		this.funcoes2.add(funcao6);
		this.funcoes2.add(funcao7);
		
		this.estadoli = new Estado("1i", funcoes2);
		this.estados.add(estadoli);
		
		this.funcao8 = new FuncaoDeTransicao("2o 0 _ l 3");
		this.funcao9 = new FuncaoDeTransicao("2o _ _ * accept");
		this.funcao10 = new FuncaoDeTransicao("2o * * * reject");
		this.funcoes3.add(funcao8);
		this.funcoes3.add(funcao9);
		this.funcoes3.add(funcao10);
		
		this.estado2o = new Estado("2o", funcoes3);
		this.estados.add(estado2o);
		
		this.funcao11 = new FuncaoDeTransicao("2i 1 _ l 3");
		this.funcao12 = new FuncaoDeTransicao("2i _ _ * accept");
		this.funcao13 = new FuncaoDeTransicao("2i * * * reject");
		this.funcoes4.add(funcao11);
		this.funcoes4.add(funcao12);
		this.funcoes4.add(funcao13);
		
		this.estado2i = new Estado("2i", funcoes4);
		this.estados.add(estado2i);
		
		this.funcao14 = new FuncaoDeTransicao("3 _ _ * accept");
		this.funcao15 = new FuncaoDeTransicao("3 * * l 4");
		this.funcoes5.add(funcao14);
		this.funcoes5.add(funcao15);
		
		this.estado3 =  new Estado("3", funcoes5);
		this.estados.add(estado3);
		
		this.funcao16 = new FuncaoDeTransicao("4 * * l 4");
		this.funcao17 = new FuncaoDeTransicao("4 _ _ r 0");
		this.funcoes6.add(funcao16);
		this.funcoes6.add(funcao17);
		
		this.estado4 = new Estado("4", funcoes6);
		this.estados.add(estado4);
		
		this.funcao18 = new FuncaoDeTransicao("accept * : r accept");
		this.funcoes7.add(funcao18);
		
		this.estadoAccept = new Estado("accept", funcoes7);
		this.estados.add(estadoAccept);
		
		this.funcao19 = new FuncaoDeTransicao("reject _ : r reject");
		this.funcoes8.add(funcao19);
		
		this.estadoReject = new Estado("reject", funcoes8);
		this.estados.add(estadoReject); 
		
		this.machine = new MaquinaDeTuring(estados, "10101", true);
		
	}
	
	@Test
	public void numeroPalindrome(){
		
		machine.start();
	}
	
}
