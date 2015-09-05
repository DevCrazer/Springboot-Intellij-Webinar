package webinar

import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

// http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
// Please note that you cannot use the @SpringApplicationConfiguration annotation that was described
// above as Spock does not find the @ContextConfiguration meta-annotation. To work around this limitation,
// you should use the @ContextConfiguration annotation directly and configure it to use the Spring Boot
// specific context loader:
@ContextConfiguration(loader = SpringApplicationContextLoader.class)
class HelloApplicationIntegrationSpecification extends Specification {

}