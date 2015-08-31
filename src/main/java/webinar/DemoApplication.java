package webinar;

import org.apache.catalina.servlets.WebdavServlet;
import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
// Need this to ensure that this class is the one where properties are stored.
// This makes sure is registered as a spring bean.
// So that then AutoWiring in the HelloCommandLine will work
@EnableConfigurationProperties(HelloProperties.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    @Profile("dev")
    public ServletRegistrationBean h2Console(){
        ServletRegistrationBean reg = new ServletRegistrationBean(new WebServlet(), "/console/*");
        reg.setLoadOnStartup(1);
        return reg;
    }
}
