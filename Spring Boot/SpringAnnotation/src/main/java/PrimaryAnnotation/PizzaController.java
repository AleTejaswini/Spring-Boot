package PrimaryAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaController {

//	@Autowired // using field injection
	private Pizza pizza;

//	@Autowired // using constructor
//	public PizzaController(Pizza pizza) {
//		this.pizza=pizza;
//	}

	
	@Autowired // using setter
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public String getPizza() {
		return pizza.getPizza();
	}

}
