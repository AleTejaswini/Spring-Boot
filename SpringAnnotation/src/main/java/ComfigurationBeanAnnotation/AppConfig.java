package ComfigurationBeanAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public Pizza getVegPizza() {
		return new VegPizza();
	}

	@Bean(name ="NonVegPizza") //default bean name is method name
	public Pizza getNonVegPizza() {
		return new NonVegPizza();
	}
	
//	@Bean(initMethod = "init" ,destroyMethod ="destroy")
//	public PizzaController pizzacontroller() {
//		return new PizzaController(getNonVegPizza());
//	}
	
	

}
