package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Film;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AfishaRepositoryTest {
        AfishaRepository repository = new AfishaRepository();

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
            repository.save(first);
            repository.save(second);
            repository.save(third);
            repository.save(fourth);
            repository.save(fifth);
            repository.save(sixth);
            repository.save(seventh);
            repository.save(eight);
            repository.save(ninth);
            repository.save(tenth);
        }

        @Test
        public void shouldFindAll() {
            Film[] actual = repository.findAll();
            Film[] expected = {first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth};

            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldFindIfNotExist(){
            int idToFind = 11;
            Film actual = repository.findById(idToFind);

            assertNull(actual);
        }

        @Test
        void shouldFindById() {
            int idToFind = 5;
            Film actual = repository.findById(idToFind);

            assertEquals(fifth, actual);
        }

        @Test
        void shouldRemoveById() {
            int idToRemove = 5;
            repository.removeById(idToRemove);

            Film[] actual = repository.findAll();
            Film[] expected = {first, second, third, fourth, sixth, seventh, eight, ninth, tenth};

            assertArrayEquals(expected, actual);
        }

        @Test
        void shouldRemoveAll() {
            repository.removeAll();

            Film[] actual = repository.findAll();
            Film[] expected = {};

            assertArrayEquals(expected, actual);
        }

        @Test
        void shouldRemoveByIdIfNotExist() {
            int idToRemove = 11;

            repository.removeById(idToRemove);

            Film[] actual = repository.findAll();
            Film[] expected = {first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth};

            assertArrayEquals(expected, actual);
        }
    }

