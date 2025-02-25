package com.rpg.rpg_ficha.service;


import com.rpg.rpg_ficha.models.CharacterModel;
import com.rpg.rpg_ficha.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public List<CharacterModel> findAll(){
        return characterRepository.findAll();
    }
    public Optional<CharacterModel> findById(Long id){
        return characterRepository.findById(id);
    }

    public CharacterModel saveCharacter(CharacterModel character){
        return characterRepository.save(character);
    }
    public void deleteCharacter(Long id){
        characterRepository.deleteById(id);
    }
}
