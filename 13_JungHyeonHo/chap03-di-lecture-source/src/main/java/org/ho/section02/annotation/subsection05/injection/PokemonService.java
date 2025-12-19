package org.ho.section02.annotation.subsection05.injection;

import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.ho.section02.annotation.common.Pokemon;
import org.springframework.stereotype.Service;

@Service("pokemonServiceInject")
public class PokemonService {

  /* 1. 필드 주입 */
  @Inject
  @Named("squirtle")
  private Pokemon pokemon;

  public void pokemonAttack() {
    pokemon.attack();
  }
}