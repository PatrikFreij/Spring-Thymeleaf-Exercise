package com.example.accessingdatamysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	public List<Player> loginPlayer(String playerName) {
		return playerRepository.findByName(playerName);
	}

	public void save(Player player) {
		playerRepository.save(player);
	}
	
	
}
