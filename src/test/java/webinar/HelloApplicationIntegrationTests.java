package webinar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {HelloApplication.class})
@WebIntegrationTest({"server.port=0", "management.port=0", "management.security.enabled=false"})
public class HelloApplicationIntegrationTests {

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
}
