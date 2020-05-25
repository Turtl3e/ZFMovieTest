package com.example.zf.integrationTests;
import com.example.zf.models.dto.MovieInput;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;


@ActiveProfiles("integration")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class MovieControllerIntegrationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testGetAllMovies() throws JSONException {
        MovieInput movieInput=MovieInput.builder().countryOfProduction("X").description("X").director("X").genre("X").posterUrl("X")
                .releaseDate(LocalDate.of(2020,1,1)).title("X").build();

//        HttpHeaders postHeaders = new HttpHeaders();
//        postHeaders.setContentType(MediaType.APPLICATION_JSON);

//        String request="{\"releaseDate\": \"2007-06-28\",\"title\": \"TestTitle\",\"description\": \"Desc\",\"posterUrl\": \"https://\",\"director\": \"TestDirectior\",\"genre\": \"Genree\",\"countryOfProduction\": \"USA\"}";
//        HttpEntity<String> moviePostEntity = new HttpEntity<String>(request,headers);
//        restTemplate.exchange(createURLWithPort("/movies"), HttpMethod.POST,moviePostEntity,String.class);

//        restTemplate.postForEntity(createURLWithPort("/movies"),movieInput,String.class);

        HttpEntity<String> entity = new HttpEntity<String>(null,headers);
        ResponseEntity<String> response=restTemplate.exchange(createURLWithPort("/movies"),HttpMethod.GET,entity,String.class);

        //https://www.baeldung.com/jsonassert
        String expected="[{\"pieceId\": 1,\"releaseDate\": \"2007-06-28\",\"title\": \"TestTitle\",\"description\": \"Desc\",\"posterUrl\": \"https://\",\"director\": \"TestDirectior\",\"genre\": \"Genree\",\"countryOfProduction\": \"USA\"}]";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
