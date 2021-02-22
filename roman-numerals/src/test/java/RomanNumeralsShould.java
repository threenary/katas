import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsShould {

    @ParameterizedTest
    @CsvSource({"1,I",
            "2,II",
            "3,III",
            "4,IV",
            "5,V",
            "6,VI",
            "7,VII",
            "8,VIII",
            "9,IX",
            "10,X",
            "14,XIV",
            "15,XV",
            "16,XVI",
            "19,XIX",
            "20,XX",
            "40,XL",
            "50,L",
            "80,LXXX",
            "90,XC",
            "100,C",
            "400,CD",
            "500,D",
            "900,CM",
            "1000, M",
            "1956,MCMLVI",
            "867,DCCCLXVII"})
    void convert_numeral_to_roman_notation(int input, String expected) {
        assertEquals(expected, new RomanNumerals().convert(input));
    }
}
