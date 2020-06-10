package com.tutorial.springboot.survey.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorial.springboot.SpringbootAdvanceProjectApplication;
import com.tutorial.springboot.survey.model.Question;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootAdvanceProjectApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

	@LocalServerPort
    private int port;

    private TestRestTemplate template = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Before
    public void setupJSONAcceptType() {
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    }

    @Test
    public void retrieveSurveyQuestion() throws Exception {

        String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia,options:[India,Russia,United States,China]}";

        ResponseEntity<String> response = template.exchange(
                createUrl("/surveys/Survey1/questions/Question1"),
                HttpMethod.GET, 
                new HttpEntity<String>("DUMMY_DOESNT_MATTER", headers), 
                String.class);

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
    
    @Test
    public void retrieveSurveyQuestions() throws Exception {
    	
        ResponseEntity<List<Question>> response = template.exchange(
                createUrl("/surveys/Survey1/questions/"), HttpMethod.GET,
                new HttpEntity<String>("DUMMY_DOESNT_MATTER", headers),
                new ParameterizedTypeReference<List<Question>>() {
                });

        Question sampleQuestion = new Question("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                        "India", "Russia", "United States", "China"));

        assertTrue(response.getBody().contains(sampleQuestion));
    }
    
    @Test
    public void createSurveyQuestion() throws Exception {
        Question question = new Question("DOESN'T MATTER", "Smallest Number",
                "1", Arrays.asList("1", "2", "3", "4"));

        ResponseEntity<String> response = template.exchange(
                createUrl("/surveys/Survey1/questions/"), HttpMethod.POST,
                new HttpEntity<Question>(question, headers), String.class);

        assertThat(response.getHeaders().get(HttpHeaders.LOCATION).get(0),
                containsString("/surveys/Survey1/questions/"));
    }

    private String createUrl(String uri) {
        return "http://localhost:" + port + uri;
    }

}
