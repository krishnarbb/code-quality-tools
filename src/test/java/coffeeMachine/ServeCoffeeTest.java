package coffeeMachine;

import com.tngtech.jgiven.annotation.CaseAs;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.model.TestTimedOutException;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.jgiven.StepFunction;
import com.tngtech.jgiven.annotation.Description;
import com.tngtech.jgiven.junit.ScenarioTest;
import coffeeMachine.steps.GivenCoffee;
import coffeeMachine.steps.ThenCoffee;
import coffeeMachine.steps.WhenCoffee;

@RunWith( DataProviderRunner.class )
@Description( "In order to refresh myself</br>" +
        "as a customer</br>" +
        "I want coffee to be served" )
public class ServeCoffeeTest extends ScenarioTest<GivenCoffee, WhenCoffee, ThenCoffee> {

	@Test
    public void an_empty_coffee_machine_cannot_serve_any_coffee() throws Exception {

        given().an_empty_coffee_machine();

        when().I_insert_$_one_euro_coins( 5 )
                .and().I_press_the_coffee_button();

        then().an_error_should_be_shown()
                .and().no_coffee_should_be_served();
    }
	
	@Test
    @DataProvider( {
            "0, 0, Error: No coffees left",
            "0, 1, Error: No coffees left",
            "1, 0, Error: Insufficient money",
            "0, 5, Error: No coffees left",
            "1, 5, Enjoy your coffee!",
    } )
    public void correct_messages_are_shown( int coffees_left, int number_of_coins, String message ) throws Exception {
        given().a_coffee_machine()
                .and().there_are_$_coffees_left_in_the_machine( coffees_left );
        when().I_insert_$_one_euro_coins( number_of_coins )
                .and().I_press_the_coffee_button();
        then().the_message_$_is_shown( message );
    }
	
}
