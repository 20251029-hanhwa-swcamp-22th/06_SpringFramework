package com.my.section02.annotation.subsection04.resource;

import com.my.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceResource")
public class PokemonService {

  /* pikachu 이름의 빈 지정 */
  @Resource(name = "pikachu")
  private Pokemon pokemon;

  public void pokemonAttack() {
    pokemon.attack();
  }
}
