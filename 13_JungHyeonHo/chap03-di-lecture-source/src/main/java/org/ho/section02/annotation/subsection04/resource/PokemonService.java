package org.ho.section02.annotation.subsection04.resource;

import jakarta.annotation.Resource;
import org.ho.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceResource")
public class PokemonService {

  /* pikachu 이름의 빈 지정 => JAVA의 어노테이션임, 스프링 아님*/
  @Resource(name = "pikachu")
  private Pokemon pokemon;

  public void pokemonAttack() {
    pokemon.attack();
  }
}