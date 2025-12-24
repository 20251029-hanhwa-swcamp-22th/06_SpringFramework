package com.jinosoft.section02.annotation.subsection05.inject;

import com.jinosoft.section02.annotation.common.Pokemon;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.stereotype.Service;

@Service("pokemonServiceInject")
public class PokemonService {

  /* 1. 필드 주입 */
  @Inject
  @Named("pikachu")
  private Pokemon pokemon;

  public void pokemonAttack() {
    pokemon.attack();
  }
}