package ru.netology.manager;

import lombok.Getter;
import ru.netology.domain.Film;


public class AfishaManager {
  @Getter
  private int quantityOfFilms = 10;
  private Film[] films = new Film[0];

  public AfishaManager() {
  }

  public AfishaManager(int quantityOfFilms) {
    if (quantityOfFilms > 0) {
      this.quantityOfFilms = quantityOfFilms;
    }
  }

  public void addFilm(Film film) {
    int length = films.length + 1;
    Film[] tmp = new Film[length];
    System.arraycopy(films, 0, tmp, 0, films.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = film;
    films = tmp;
  }

  public Film[] getLast() {
    int lengthFilm = Math.min(films.length, quantityOfFilms);
    Film[] result = new Film[lengthFilm];
    for (int i = 0; i < result.length; i++) {
      int index = result.length - i - 1;
      result[i] = films[index];
    }
    return result;
  }

}
