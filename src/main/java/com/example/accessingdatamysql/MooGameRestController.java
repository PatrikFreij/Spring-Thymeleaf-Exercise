package com.example.accessingdatamysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MooGameRestController {
	@Autowired
	MooGameService mgs;
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	ResultService resultService;
	
	public MooGameRestController(MooGameService mgs, PlayerService personService, ResultService resultService) {
		this.mgs = mgs;
		this.playerService = personService;
		this.resultService = resultService;
	}
	
	@GetMapping("/moo/{guess}")
	public  ResponseEntity<List<GuessAndAnswer>> makeGuess(@PathVariable("guess") String guess) {
		List<GuessAndAnswer> guesses = mgs.makeGuess(guess);
		if(guesses != null) {
			return ResponseEntity.accepted().body(guesses);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@GetMapping("/moo/login/{playerName}")
	public ResponseEntity<String> login(@PathVariable("playerName") String name) {
		if(mgs.login(name)) {
			return ResponseEntity.accepted().body("SUCCESS!");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Player not found");
		}
	}
}
