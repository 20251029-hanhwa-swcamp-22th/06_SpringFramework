package com.my.section02.annotation.subsection03.Collection;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("com.my.section02");

    PokemonService pokemonService
        = context.getBean("pokemonServiceCollection", PokemonService.class);

    pokemonService.pokemonAttack();
  }
}
