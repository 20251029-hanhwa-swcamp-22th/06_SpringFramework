package com.my.section02.annotation.subsection02.qualifier;

import com.my.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier") //component bean등록
public class PokemonService {
  /*@Qualifier("Bean Name")
  * 이름이 일치하는 Bean을 의존성 주입(DI)
  * 필드, 생성자 주입 가능
  * */
//  // 필드
//  @Autowired
//  @Qualifier("squirtle")
//  private Pokemon pokemon;

  private final Pokemon pokemon;

  /* @Qualifier 어노테이션을 사용하여 squirtle 빈 객체를 지정한다. */
  @Autowired
  public PokemonService(@Qualifier("squirtle") Pokemon pokemon) {
    this.pokemon = pokemon;
  }

  public void pokemonAttack(){
    pokemon.attack();
  }
}
