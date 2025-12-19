package org.ho.section02.annotation.subsection01.primary;

import org.ho.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Bean 등록
@Service("pokemonServicePrimary")
public class PokemonService {

  private final Pokemon pokemon;

  @Autowired
  public PokemonService(Pokemon pokemon) {
    this.pokemon = pokemon; // Pikachu가 primary로 빈등록되서, Pikachu가 들어갈거임
  }

  public void pokemonAttak(){
    pokemon.attack();
  }
}
