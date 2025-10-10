package QualifierAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaController {

//	@Autowired // using field injection
//	@Qualifier("nonVegPizza")
	private Pizza pizza;

//	@Autowired // using constructor
//	public PizzaController(@Qualifier("vegPizza")Pizza pizza) {
//		this.pizza=pizza;
//	}

	
	@Autowired // using setter
	public void setPizza(@Qualifier("nonVegPizza") Pizza pizza) {
		this.pizza = pizza;
	}

	public String getPizza() {
		return pizza.getPizza();
	}

}
