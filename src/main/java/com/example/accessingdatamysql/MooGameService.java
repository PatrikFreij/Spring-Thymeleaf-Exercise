package com.example.accessingdatamysql;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class MooGameService {
	
		String goal;
		List<GuessAndAnswer> guessList;
		Player player;
		boolean isLoggedIn = false;
		int g;
		
		@Autowired
		PlayerService playerService;
		
		Logger logger = LoggerFactory.getLogger(MooGameService.class);
		
		public MooGameService() {
		
		}
		
		@PostConstruct
		public void newGame() {
			goal = makeGoal();
			logger.info("secret="  +  goal);
			guessList = new ArrayList<>();
		}
		
		public String makeGoal(){
			String goal = "";
			for (int i = 0; i < 4; i++){
				int random = (int) (Math.random() * 10);
				String randomDigit = "" + random;
				while (goal.contains(randomDigit)){
					random = (int) (Math.random() * 10);
					randomDigit = "" + random;
				}
				goal = goal + randomDigit;
			}
			return goal;
		}
		
		private void registerResult(int i) {
			System.out.println(player.getName());
			System.out.println(player.getId());
			player.addResult(i);
			playerService.save(player);
		}
		
		List<GuessAndAnswer> makeGuess(String guess) {
			if(!isLoggedIn) return null;
			String answer = checkBC(goal, guess);
			guessList.add(new GuessAndAnswer(guess, answer));
			g = guessList.size();
			System.out.println("Gissningar: " + g);
			if (answer.equals("BBBB,")) {
				registerResult(guessList.size());
				List<GuessAndAnswer> temp = guessList;
				newGame();
				return temp;
			}
			return guessList;
		}
		
		public String checkBC(String goal, String guess) {
			int cows = 0, bulls = 0;
			for (int i = 0; i < 4; i++){
				for (int j = 0; j < 4; j++ ) {
					if (goal.charAt(i) == guess.charAt(j)){
						if (i == j) {
							bulls++;
						} else {
							cows++;
						}
					}
				}
			}
			String result = "";
			for (int i = 0; i < bulls; i++){
				result = result + "B";
			}
			result = result + ",";
			for (int i = 0; i < cows; i++){
				result = result + "C";
			}
			return result;
		
		}

		public boolean login(String name) {
			List<Player> players = playerService.loginPlayer(name);
			if(players.size() > 0) {
				player = players.get(0);
				isLoggedIn = true;
				return isLoggedIn;
			} else {
				return isLoggedIn;
			}
		}
}
