package coffeeMachine;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoffeeMachineTest {

	@Test
	public void test() {
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		//given
		coffeeMachine.coffees = 1;
		coffeeMachine.on = true;  
		coffeeMachine.insertOneEuroCoin(2);
		
		//when
		boolean coffeeServed = coffeeMachine.pressButton();
		
		System.out.println(coffeeMachine.message);
		
		//then
		assertTrue(coffeeServed);
	}

}
