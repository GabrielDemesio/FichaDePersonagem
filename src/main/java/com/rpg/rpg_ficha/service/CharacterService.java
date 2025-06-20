package com.rpg.rpg_ficha.service;


import com.rpg.rpg_ficha.exeption.ResourceNotFoundException;
import com.rpg.rpg_ficha.models.CharacterModel;
import com.rpg.rpg_ficha.repository.CharacterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public List<CharacterModel> findAll(){
        return characterRepository.findAll();
    }
    public CharacterModel findById(Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Personagem não encontrado com o id: " + id));
    }
    public CharacterModel saveCharacter(CharacterModel character) {
        character.setId(null);
        return characterRepository.save(character);
    }
    public void deleteCharacter(Long id){
        characterRepository.deleteById(id);
    }

    public CharacterModel updateCharacter(Long id, CharacterModel characterDetails) {
        CharacterModel existingCharacter = characterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Personagem não encontrado com o id: " + id));
        existingCharacter.setNome(characterDetails.getNome());
        existingCharacter.setRaca(characterDetails.getRaca());
        existingCharacter.setClasse(characterDetails.getClasse());
        existingCharacter.setNivel(characterDetails.getNivel());
        existingCharacter.setExperiencia(characterDetails.getExperiencia());
        existingCharacter.setForca(characterDetails.getForca());
        existingCharacter.setDestreza(characterDetails.getDestreza());
        existingCharacter.setInteligencia(characterDetails.getInteligencia());
        existingCharacter.setCarisma(characterDetails.getCarisma());
        existingCharacter.setVida(characterDetails.getVida());
        existingCharacter.setEnergia(characterDetails.getEnergia());
        existingCharacter.setMana(characterDetails.getMana());
        return characterRepository.save(existingCharacter);
    }
}
