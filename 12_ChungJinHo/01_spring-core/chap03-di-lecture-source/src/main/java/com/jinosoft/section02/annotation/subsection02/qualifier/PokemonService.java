package com.jinosoft.section02.annotation.subsection02.qualifier;

import com.jinosoft.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

  /* @Qualifier 어노테이션을 사용하여 pikachu 빈 객체를 지정한다. */
  /*@Autowired
  @Qualifier("charmander")*/
  private Pokemon pokemon;

  public PokemonService(@Qualifier("charmander") Pokemon pokemon) {
    this.pokemon = pokemon;
  }

  public void pokemonAttack() {
    pokemon.attack();

  }
}