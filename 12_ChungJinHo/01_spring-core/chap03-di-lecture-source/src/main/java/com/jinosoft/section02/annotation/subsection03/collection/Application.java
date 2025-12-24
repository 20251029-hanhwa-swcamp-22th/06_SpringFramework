package com.jinosoft.section02.annotation.subsection03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;


public class Application {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext("com.jinosoft.section02");
    PokemonService pokemonService = context.getBean("pokemonServiceCollection",PokemonService.class);
    pokemonService.pokemonAttack();

  }
}
