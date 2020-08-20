package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerOneFilmExistTest {

        @Mock
        private AfishaRepository repository;
        @InjectMocks
        private AfishaManager manager;
        private Film first = new Film(1, 1, "Бладшот", "Боевик", "https://www.photo.ru/google-search-350.jpg", false);

        @BeforeEach
        public void showFilm(){
            manager.addFilm(first);
        }

        @Test
        public void shouldDisplayOneFilm(){
            Film[] returned = new Film[]{first};
            doReturn(returned).when(repository).findAll();
            Film[] actual = manager.getLast();
            Film[] expected = new Film[]{first};

            assertArrayEquals(expected, actual);

        }

    }
