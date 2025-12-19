package com.my.section02.annotation.subsection05.injection;

import com.my.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
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

  /* 2. 생성자 주입 */
//  @Inject
//  public PokemonService(@Named("pikachu") Pokemon pokemon) {
//    this.pokemon = pokemon;
//  }

  /* 3. 세터 주입 */
//  @Inject
//  public void setPokemon(@Named("pikachu") Pokemon pokemon) {
//    this.pokemon = pokemon;
//  }
}
