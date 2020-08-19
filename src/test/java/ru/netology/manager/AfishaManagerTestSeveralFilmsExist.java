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
public class AfishaManagerTestSeveralFilmsExist {
        @Mock
        AfishaRepository repository;
        @InjectMocks
        private AfishaManager manager;

        private Film first = new Film(1, 1, "Бладшот", "Боевик", "https://www.photo.ru/google-search-350.jpg", false);
        private Film second = new Film(2, 2, "Вперёд", "Мультфильм", "https://www.photo.ru/google-search-350.jpg", false);
        private Film third = new Film(3, 3, "Отель 'Белград'", "Комедия","https://www.photo.ru/google-search-350.jpg", false);
        private Film fourth = new Film(4, 4, "Джентельмены", "Боевик","https://www.photo.ru/google-search-350.jpg", false);
        private Film fifth = new Film(5, 5, "Человек - невидимка", "Ужасы","https://www.photo.ru/google-search-350.jpg", false);
        private Film sixth = new Film(6, 6, "Тролли. Мировой тур", "Мультфильм","https://www.photo.ru/google-search-350.jpg", true);
        private Film seventh = new Film(7, 7, "Номер один", "Комедия","https://www.photo.ru/google-search-350.jpg", true);
        private Film eight = new Film(8, 8, "Американский пирог 10", "Комедия","https://www.photo.ru/google-search-350.jpg", true);
        private Film ninth = new Film(9, 9, "Ведьмак", "Ужасы","https://www.photo.ru/google-search-350.jpg", true);
        private Film tenth = new Film(10, 10, "Доктор Стрэндж","Фантастика", "https://www.photo.ru/google-search-350.jpg", true);



        @BeforeEach
        public void showsUp() {
            manager.addFilm(first);
            manager.addFilm(second);
            manager.addFilm(third);
            manager.addFilm(fourth);
            manager.addFilm(fifth);
            manager.addFilm(sixth);
            manager.addFilm(seventh);
            manager.addFilm(eight);
            manager.addFilm(ninth);
            manager.addFilm(tenth);
        }


        @Test
        public void shouldAddAllFilms() {
            manager = new AfishaManager();
            showsUp();
            Film[] returned = {first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth};
            doReturn(returned).when(repository).findAll();

            Film[] actual = manager.getLast();
            Film[] expected = new Film[]{tenth, ninth, eight, seventh, sixth, fifth, fourth, third, second,first};

            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldAddSeveralFilms() {
            manager = new AfishaManager(5);
            showsUp();
            Film[] returned = {first, second, third, fourth, fifth};
            doReturn(returned).when(repository).findAll();

            Film[] actual = manager.getLast();
            Film[] expected = new Film[]{fifth, fourth, third, second, first};

            assertArrayEquals(expected, actual);
        }
}
