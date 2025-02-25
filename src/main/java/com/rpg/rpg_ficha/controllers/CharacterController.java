package com.rpg.rpg_ficha.controllers;

import com.rpg.rpg_ficha.models.CharacterModel;
import com.rpg.rpg_ficha.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personagens")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public List<CharacterModel> findAll(){
        return characterService.findAll();
    }

    @GetMapping("/{id}")
    public CharacterModel findById(@PathVariable Long id){
        return characterService.findById(id).get();
    }
    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id){
        characterService.deleteCharacter(id);
    }
    @PostMapping
    public CharacterModel saveCharacter(@RequestBody CharacterModel characterModel){
        return characterService.saveCharacter(characterModel);
    }


}
