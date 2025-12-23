package com.jinosoft.section02.annotation.subsection01.primary;

import com.jinosoft.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {

  private Pokemon pokemon;

  @Autowired
  public PokemonService(Pokemon pokemon) {
    this.pokemon = pokemon;
  }

  public void pokemonAttack() {
    pokemon.attack();
  }

}