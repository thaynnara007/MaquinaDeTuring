package executor;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class testFita {
	
	FuncaoDeTransicao funcao1;
	FuncaoDeTransicao funcao2;
	ArrayList<FuncaoDeTransicao> funcoes = new ArrayList<>();
	Estado estado;
	Fita fita1;
	Fita fita2;
	
	@Before
	public void setup(){
		
		funcao1 = new FuncaoDeTransicao("0 1 _ r li");
		funcao2 = new FuncaoDeTransicao("0 _ _ * accept");
		this.funcoes.add(funcao1);
		this.funcoes.add(funcao2);
		estado = new Estado("0", funcoes );
		fita1 = new Fita("1001001");
		fita2 =  new Fita("_001001");
	}
	
	@Test
	public void testComFuncao1(){
		
		System.out.println("---------Funcao1--------------");
		System.out.println(fita1.toString());
		
		assertEquals("1", fita1.getRoot());
		assertEquals(0, fita1.getIndex());
		
		this.fita1.substitui(
				this.estado.getFuncaoDeTransicao("1").getSimboloAtual(),
				this.estado.getFuncaoDeTransicao("1").getNovoSimbolo());
		assertEquals("_", this.fita1.getRoot());
		assertEquals(0, this.fita1.getIndex());
		
		this.fita1.anda(this.estado.getFuncaoDeTransicao("1").getDirecao());
		assertEquals("0", this.fita1.getRoot());
		assertEquals(1, this.fita1.getIndex());
		System.out.println(this.fita1.toString());
		
		this.fita1.anda("l");
		assertEquals("_", this.fita1.getRoot());
		assertEquals(0, this.fita1.getIndex());
		System.out.println(this.fita1.toString());
		
	}
	
	@Test
	public void testComFuncao2(){
		
		System.out.println("---------Funcao2--------------");
		System.out.println(this.fita2.toString());
		
		assertEquals("_", fita2.getRoot());
		assertEquals(0, fita2.getIndex());
		
		this.fita2.substitui(
				this.estado.getFuncaoDeTransicao("_").getSimboloAtual(),
				this.estado.getFuncaoDeTransicao("_").getNovoSimbolo());
		assertEquals("_", this.fita2.getRoot());
		assertEquals(0, this.fita2.getIndex());
		
		this.fita2.anda(this.estado.getFuncaoDeTransicao("_").getDirecao());
		assertEquals("_", this.fita2.getRoot());
		assertEquals(0, this.fita2.getIndex());
		System.out.println(this.fita2.toString());
		
		this.fita2.anda("l");
		assertEquals("_", this.fita2.getRoot());
		assertEquals(0, this.fita2.getIndex());
		System.out.println(this.fita2.toString());
		
		this.fita2.anda("r");
		assertEquals("0", this.fita2.getRoot());
		assertEquals(1, this.fita2.getIndex());
		System.out.println(this.fita2.toString());
	}

}
