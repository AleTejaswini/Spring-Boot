package PropertySourceAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertySourceDemo {
	@Autowired
	private Environment env;
	
	
	@Value("${stdname}")
	 private String Stdname;
	
	@Value("${stdage}")
	private int StdAge;
	
	@Value("${stdaddress}")
	private String Stdaddress;
	
	@Value("${app.name}")
	private String appname;
	
	
	@Value("${app.description}")
	private String appdesc;
	
	
	private String apptopic;
	
	public String getApptopic() {
		return env.getProperty("app.topic");
	}
	public String getAppname() {
		return appname;
	}
	public String getAppdesc() {
		return appdesc;
	}
	public String getStdname() {
		return Stdname;
	}
	public int getStdAge() {
		return StdAge;
	}
	public String getStdaddress() {
		return Stdaddress;
	}
	
	
}
