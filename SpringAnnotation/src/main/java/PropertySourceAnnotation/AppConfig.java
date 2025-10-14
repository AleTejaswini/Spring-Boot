package PropertySourceAnnotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:propertysource.properties"),
	@PropertySource("classpath:propertysource2.properties")
})

public class AppConfig {

}
