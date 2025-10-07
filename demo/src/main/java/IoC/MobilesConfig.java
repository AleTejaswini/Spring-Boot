package IoC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MobilesConfig {
	@Bean
	public Mobiles getOneplus() {
		return new OnePlus();
	}
	@Bean
	public Mobiles getIphone() {
		return new IPhone();
	}

}
