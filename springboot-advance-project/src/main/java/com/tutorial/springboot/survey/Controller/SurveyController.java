package com.tutorial.springboot.survey.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tutorial.springboot.survey.model.Question;
import com.tutorial.springboot.survey.model.Survey;
import com.tutorial.springboot.survey.service.SurveyService;

@RestController
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@GetMapping(value = "/surveys", produces=MediaType.APPLICATION_XML_VALUE)
	public List<Survey> retrieveAllSurveys(){
		return surveyService.retrieveAllSurveys();
	}
	
	@GetMapping(value = "/surveys/{surveyId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Survey retrieveSurvey(@PathVariable String surveyId ){
		return surveyService.retrieveSurvey(surveyId);
	}
	
	@GetMapping(value = "/surveys/{surveyId}/Questions", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Question> retrieveQuestions(@PathVariable String surveyId ){
		return surveyService.retrieveQuestions(surveyId);
	}
	
	@GetMapping(value = "/surveys/{surveyId}/Questions/{questionId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Question retrieveQuestion(@PathVariable String surveyId, @PathVariable String questionId ){
		return surveyService.retrieveQuestion(surveyId, questionId);
	}
	
	@PostMapping(value = "/surveys/{surveyId}/Questions", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addQuestion(@RequestBody Question question, @PathVariable String surveyId){
		Question questionCr =  surveyService.addQuestion(surveyId, question);
		if (questionCr == null) {
            return ResponseEntity.noContent().build();
        }
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(questionCr.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
