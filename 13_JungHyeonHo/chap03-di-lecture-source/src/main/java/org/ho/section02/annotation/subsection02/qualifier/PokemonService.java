package org.ho.section02.annotation.subsection02.qualifier;

import org.ho.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

  /* @Qualifier("Bean Name")
   * - 이름이 일치하는 Bean을 의존성 주입(DI)
   * - 필드, 생성자 주입 가능
   *  */
  // @Autowired
  // @Qualifier("squirtle")
  private Pokemon pokemon;

  @Autowired
  public PokemonService(@Qualifier("charmander")Pokemon pokemon) {
    this.pokemon = pokemon;
  }

  public void pokemonAttack() {
    pokemon.attack();
  }
}