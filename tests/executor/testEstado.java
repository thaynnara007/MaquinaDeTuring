package executor;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class testEstado {
	
	FuncaoDeTransicao funcao1;
	FuncaoDeTransicao funcao2;
	ArrayList<FuncaoDeTransicao> funcoes = new ArrayList<>();
	Estado estado;
	
	@Before
	public void setup(){
		
		funcao1 = new FuncaoDeTransicao("0 1 _ r li");
		funcao2 = new FuncaoDeTransicao("0 _ _ * accept");
		this.funcoes.add(funcao1);
		this.funcoes.add(funcao2);
		estado = new Estado("0", funcoes );
		
	}
	
	@Test
	public void testEstado(){
		
		assertEquals(this.funcoes, this.estado.getFuncoes());
		assertEquals("0", this.estado.toString());
		assertEquals(this.funcao1, this.estado.getFuncaoDeTransicao("1"));
		assertEquals(this.funcao2, this.estado.getFuncaoDeTransicao("_"));
	}

}
