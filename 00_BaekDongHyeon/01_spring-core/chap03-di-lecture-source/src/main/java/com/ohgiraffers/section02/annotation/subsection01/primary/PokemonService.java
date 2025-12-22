package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Bean 등록
@Service("pokemonServicePrimary")
public class PokemonService {

  private final Pokemon pokemon;

  @Autowired
  public PokemonService(Pokemon pokemon){
    this.pokemon = pokemon; // 피카츄가 1순위
  }

  public void pokemonAttack(){
    pokemon.attack();
  }


}
