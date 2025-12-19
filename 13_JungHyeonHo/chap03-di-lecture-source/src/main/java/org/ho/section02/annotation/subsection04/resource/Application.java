package org.ho.section02.annotation.subsection04.resource;

import org.ho.section02.annotation.subsection04.resource.PokemonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("org.ho.section02");

    PokemonService pokemonService = context.getBean("pokemonServiceResource", PokemonService.class);

    pokemonService.pokemonAttack();
  }
}
