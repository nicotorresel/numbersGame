package backend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InputNumberTest {
	
	private Juego juego;
		
	// primero inicializo el tablero para todos los test
	@Before
	public void initialize() {
		this.juego = new Juego(4,4);
	}
	
	// test para ver si agrego al tablero un numero menor a 1
	@Test(expected = IllegalArgumentException.class)
	public void invalidNumberTest() {
		juego.inputNumber(0,1,4);
	}
	
	//test para ver si agrego al tablero en un fila menor a 0
	@Test(expected = IllegalArgumentException.class)
	public void negativeRowTest() {
		juego.inputNumber(6,-1,2);
	}
	
	//test para ver si agrego al tablero en una fila mayor a la existentes
	@Test(expected = IllegalArgumentException.class)
	public void exceededRowTest() {
		juego.inputNumber(70,4,2);
	}
	
	//test para ver si agrego al tablero en una columna menor a 0
	@Test(expected = IllegalArgumentException.class)
	public void negativeColumnTest() {
		juego.inputNumber(34,2,-1);
	}
	
	//test para ver si agrego al tablero en una columna mayor a las existentes
	@Test(expected = IllegalArgumentException.class)
	public void exceededColumnTest() {
		juego.inputNumber(26,2,4);
	}
	
	//test para corroborar que se agrega un numero valido en la primera posicion
	@Test
	public void inputNumberTest() {
		juego.inputNumber(78,0,0);
	}
	
	//test para corroborar que se agrega un numero valido en la ultima posicion
	@Test
	public void inputnumber2Test() {
		juego.inputNumber(6,3,3);
	}
	//test para ver si agrego un numero en un lugar ocupado
	@Test(expected = IllegalArgumentException.class)
	public void lugarOcupado() {
		Juego juego4 = new Juego(4,4);
		juego4.inputNumber(5, 2, 2);
		juego4.inputNumber(5, 2, 2);
	}
	
	//corroborar que agrego el numero al array de los resultados de la fila
	@Test
	public void correctRowResultTest() {
		Juego juego2 = new Juego (4,4);
		
		juego2.inputNumber(27, 0, 0);
		int[] array = juego2.getRowsInput();
		int ret = array[0];
		
		assertEquals(27, ret);
	}
	
	@Test
	public void correctColumnResultTest() {
		Juego juego3 = new Juego (4,4);
		
		juego3.inputNumber(33, 3, 3);
		int [] array2 = juego3.getColumnsInput();
		int ret2 = array2[3];
		
		assertEquals(33, ret2);
	}
	

}
