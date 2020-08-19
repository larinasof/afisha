package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaManagerTestOneFilmExist {


        private AfishaManager manager = new AfishaManager();
        private Film first = new Film(1, 1, "Бладшот", "Боевик","https://www.photo.ru/google-search-350.jpg", false);

        @BeforeEach
        public void showFilm(){
            manager.addFilm(first);
        }

        @Test
        public void shouldDisplayOneFilm(){
            Film[] actual = manager.getLast();
            Film[] expected = new Film[]{first};

            assertArrayEquals(expected, actual);

        }


    }
