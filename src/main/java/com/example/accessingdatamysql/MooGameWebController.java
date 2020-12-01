package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MooGameWebController {
	
	@Autowired
	MooGameService gameService;

	@GetMapping("/login")
	public String loginUser(Model model) {
		model.addAttribute("player", new Player());
		return "register_user";
	}
	
	@PostMapping("/login")
	public String userLoggedIn(@ModelAttribute("player") Player player, Model m) {
		m.addAttribute("guessBean", new GuessBean());
		if(!gameService.login(player.getName())) {
			return "register_user";
		}
		return "guess_game";
	}
	
	@PostMapping("/moogame")
	public String registerGuess(@ModelAttribute("guessBean") GuessBean gb, Model m) {
		m.addAttribute("guessAndAnswer", gameService.makeGuess(gb.getGuess()));
		return "guess_game";
	}
}
