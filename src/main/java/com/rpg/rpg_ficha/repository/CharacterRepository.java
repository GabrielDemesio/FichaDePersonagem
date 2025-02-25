package com.rpg.rpg_ficha.repository;

import com.rpg.rpg_ficha.models.CharacterModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterModel, Long> {

}
