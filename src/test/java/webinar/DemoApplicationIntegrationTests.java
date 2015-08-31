package webinar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import  webinar.DemoApplicationIntegrationTests.TestConfiguration;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {HelloApplication.class, TestConfiguration.class})
@WebAppConfiguration
@IntegrationTest({"server.port=0", "management.port=0"})
public class DemoApplicationIntegrationTests {

	private RestTemplate restTemplate = new TestRestTemplate();

	@Value("http://localhost:${local.management.port}")
	private String baseUrl;

	@Test
	public void healthCheck_isOK() {

		// ARRANGE

		// ACT
		ResponseEntity<String> entity =	restTemplate.getForEntity(baseUrl + "/health", String.class);

		// ASSERT
		assertTrue(entity.getStatusCode().is2xxSuccessful());
		assertTrue(entity.getBody().toString().toLowerCase().contains("up"));

	}

	@PropertySource("classpath:test.properties")
	@Configuration
	protected static class TestConfiguration {
	}
}
