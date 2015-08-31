package webinar.commandline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import webinar.HelloProperties;
import webinar.HelloService;

import javax.validation.constraints.NotNull;

import static java.lang.String.format;

/**
 * Created by Alison on 31/08/15.
 */
@Service
public class HelloCommandLine implements CommandLineRunner {

    @NotNull
    private final HelloProperties properties;
    @NotNull
    private final HelloService service;

    @Autowired
    public HelloCommandLine(HelloProperties properties,
                            HelloService service) {

        this.properties = properties;
        this.service = service;
    }


    @Override
    public void run(String... strings) throws Exception {
        System.out.println(service.getGreeting(properties.getTemplate(), properties.getTarget(), properties.getFrom()));
    }
}
