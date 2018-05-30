package mmelnik.got.characters.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import mmelnik.got.characters.domain.CharacterEntity;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
}
