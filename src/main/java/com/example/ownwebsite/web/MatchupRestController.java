package com.example.ownwebsite.web;

import com.example.ownwebsite.repositories.MatchupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/matchups")
@RestController
public class MatchupRestController {

    private final MatchupRepository matchupRepository;
    private final ModelMapper modelMapper;

    public MatchupRestController(MatchupRepository matchupRepository, ModelMapper modelMapper) {
        this.matchupRepository = matchupRepository;
        this.modelMapper = modelMapper;
    }




}
