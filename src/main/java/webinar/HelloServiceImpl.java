package webinar;

import org.springframework.stereotype.Service;

/**
 * Created by Alison on 31/08/15.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String getGreeting(String template, String from, String to) {
        return String.format(template,from, to);
    }
}
