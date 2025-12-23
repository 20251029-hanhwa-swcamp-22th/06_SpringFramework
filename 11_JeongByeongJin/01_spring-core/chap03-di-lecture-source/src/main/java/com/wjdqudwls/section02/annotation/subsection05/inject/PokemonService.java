package com.wjdqudwls.section02.annotation.subsection05.inject;

import com.wjdqudwls.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.stereotype.Service;

import java.util.List;

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