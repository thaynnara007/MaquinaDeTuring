package executor;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testFuncaoDeTransicao {
	
	FuncaoDeTransicao funcao;
	
	@Before
	public void setUp(){
		
		funcao = new FuncaoDeTransicao("0 1 _ r li");
	}
	
	@Test public void testFuncao(){
		
		assertEquals("0", funcao.getEstadoAtual());
		assertEquals("1", funcao.getSimboloAtual());
		assertEquals("_", funcao.getNovoSimbolo());
		assertEquals("r", funcao.getDirecao());
		assertEquals("li", funcao.getProximoEstado());
		assertEquals("0 1 _ r li", funcao.toString());
		
	}

}
