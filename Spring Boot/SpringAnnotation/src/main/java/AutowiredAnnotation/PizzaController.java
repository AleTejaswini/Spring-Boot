package AutowiredAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("P")
public class PizzaController {

	@Autowired // using field injection
	private VegPizza vegpizza;

	
//	@Autowired // using constructor
//	public PizzaController(VegPizza vegpizza) {
//		this.vegpizza=vegpizza;
//	}

	
	
//@Autowired // using setter
//public void setVegpizza(VegPizza vegpizza) {
//	this.vegpizza = vegpizza;
//}

	public String getPizza() {
		return vegpizza.getPizza();
	}

}
