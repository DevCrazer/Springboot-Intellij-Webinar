package webinar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

// prefix all properties with hello.
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {

    /**
     * This is the javadoc that is used by the properties annotation compiler, not the getter
     * so that you can have one message for annotator and another for developers using class directly
     */
    @NotNull
    private String template = "Hello %s from %s";

    @NotNull
    private String target;

    @NotNull
    private String from;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String target) {
        this.template = target;
    }

    public String getTarget() {

        return target;
    }

    public void setTarget(String target) {

        this.target = target;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
