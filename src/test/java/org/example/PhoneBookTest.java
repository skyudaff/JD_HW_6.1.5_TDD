package org.example;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;

public class PhoneBookTest {
    PhoneBook sut;

    public static Stream<Arguments> testAdd() {
        return Stream.of(
                Arguments.of("Ivan", "11111", 1),
                Arguments.of("Petr", "22222", 2),
                Arguments.of("Petr", "33333", 2)
        );
    }

    @BeforeEach
    void bE() {
        sut =  PhoneBook.getInstance();
    }

    @ParameterizedTest
    @MethodSource
    void testAdd(String name, String phoneNumber, int expected) {
        //act
        int result = sut.add(name, phoneNumber);

        //assert
        assertThat(result, Matchers.equalTo(expected));
    }

    @Test
    void testFindByNumber() {
        //arrange
        sut.add("Ivan", "12345");
        sut.add("Petr", "11111");

        //act
        String result = sut.findByNumber("11111");

        //assert
        assertThat(result, Matchers.equalTo("Petr"));
    }

    @Test
    void testFindByName() {
        //arrange
        sut.add("Ivan", "12345");
        sut.add("Petr", "11111");

        //act
        String result = sut.findByName("Ivan");

        //assert
        assertThat(result, Matchers.equalTo("123345"));
    }
}
