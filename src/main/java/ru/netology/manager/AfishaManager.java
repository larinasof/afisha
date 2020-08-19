package ru.netology.manager;

import lombok.Getter;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;


public class AfishaManager {
  @Getter
  private int quantityOfFilms = 10;
  private Film[] films = new Film[0];

  private AfishaRepository repository;

  public AfishaManager(AfishaRepository repository) {
    this.repository = repository;
  }

  public AfishaManager() {
  }

  public AfishaManager(int quantityOfFilms) {
    if (quantityOfFilms > 0) {
      this.quantityOfFilms = quantityOfFilms;
    }
  }

  public void addFilm(Film film) {
    repository.save(film);
  }

  public Film[] getLast() {
    Film[] films = repository.findAll();
    int lengthFilm = Math.min(films.length, quantityOfFilms);
    Film[] result = new Film[lengthFilm];
    for (int i = 0; i < result.length; i++) {
      int index = result.length - i - 1;
      result[i] = films[index];
    }
    return result;
  }

}
