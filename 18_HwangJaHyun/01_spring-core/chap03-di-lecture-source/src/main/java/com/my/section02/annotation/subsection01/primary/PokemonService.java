package com.my.section02.annotation.subsection01.primary;

import com.my.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary") //component bean등록
public class PokemonService {

  private final Pokemon pokemon;

  @Autowired
  public PokemonService(Pokemon pokemon) {
    this.pokemon = pokemon; // 피카츄(1순위)
  }

  public void pokemonAttack(){
    pokemon.attack();
  }
}
