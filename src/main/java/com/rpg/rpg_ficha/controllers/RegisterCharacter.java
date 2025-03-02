package com.rpg.rpg_ficha.controllers;


import com.rpg.rpg_ficha.models.CharacterModel;
import com.rpg.rpg_ficha.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterCharacter {

    @Autowired
    private CharacterService characterService;
    @PostMapping
    public CharacterModel saveCharacter(@RequestBody CharacterModel characterModel){
        return characterService.saveCharacter(characterModel);
    }
}
