package com.devsuperior.dspesquisa.services;

import com.devsuperior.dspesquisa.dtos.GameDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameDTO> findAll() {
        List<Game> list = repository.findAll();
        return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
    }
}
