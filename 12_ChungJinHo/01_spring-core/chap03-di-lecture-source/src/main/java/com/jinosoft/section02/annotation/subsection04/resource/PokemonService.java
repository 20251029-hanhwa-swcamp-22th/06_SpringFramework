package com.jinosoft.section02.annotation.subsection04.resource;

import com.jinosoft.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("pokemonServiceResource")
public class PokemonService {

  /* squirtle 이름의 빈 지정 */
  @Resource(name = "squirtle")
  private Pokemon pokemon;


  public void pokemonAttack() {
    pokemon.attack();
  }
}