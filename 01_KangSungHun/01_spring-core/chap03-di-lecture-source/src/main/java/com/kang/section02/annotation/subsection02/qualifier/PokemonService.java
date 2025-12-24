package com.kang.section02.annotation.subsection02.qualifier;

import com.kang.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    /* @Qualifier("Bean Name")
    * - 이름이 일치하는 Bean을 의존성 주입(
    * */
//
//    @Autowired
//    @Qualifier("pikachu")
	private Pokemon pokemon;

  /* @Qualifier 어노테이션을 사용하여 squirtle 빈 객체를 지정한다. */
	@Autowired
    public PokemonService(@Qualifier("pikachu") Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public void pokemonAttack() {
		pokemon.attack();
	}
}