package com.rpg.rpg_ficha.controllers;

import com.rpg.rpg_ficha.models.CharacterModel;
import com.rpg.rpg_ficha.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

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
        return characterService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id){
        characterService.deleteCharacter(id);
    }

    @PostMapping
    public CharacterModel saveCharacter(@Valid @RequestBody CharacterModel characterModel){
        return characterService.saveCharacter(characterModel);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CharacterModel> updateCharacter(@PathVariable Long id, @RequestBody CharacterModel characterDetails) {
        CharacterModel updatedCharacter = characterService.updateCharacter(id, characterDetails);
        return ResponseEntity.ok(updatedCharacter);
    }
}
