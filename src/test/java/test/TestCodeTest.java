package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TestCodeTest {

    @DisplayName("CSVSource 통합 테스트")
    @ParameterizedTest
    @CsvSource(value = {"378 123:1 볼", "378 348:2 스트라이크", "378 148:1 스트라이크", "378 378:3 스트라이크", "378 734:2 볼",
            "378 837:3 볼", "378 387:1 스트라이크 2 볼"}, delimiter = ':')
    void testFunction(String input, String expected) {
        //given
        System.out.print("input: " + input + " expected: " + expected);

        //when

        //then
    }

    @DisplayName("CSVSource 변수 테스트 ")
    @ParameterizedTest
    @CsvSource(value = {"378:123:1:볼", "378:348:2:스트라이크"}, delimiter = ':')
    void testFunction2(String s1, String s2, String s3, String s4) {
        //given
        System.out.print(s1 + " " + s2 + " " + s3 + " " + s4);

        //when

        //then
    }

    @DisplayName("ValueSource 변수 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "d", "e"})
    void testValueSource(String a) {
        //given
        System.out.println(a);

        //when

        //then
    }
}
