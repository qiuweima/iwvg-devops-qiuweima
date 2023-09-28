package es.upm.miw.iwvg_devops.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {
    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(2, 3);
    }

    @Test
    void testGetNumerator() {
        assertEquals(2, fraction.getNumerator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(4);
        assertEquals(4, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(3, fraction.getDenominator());
    }

    @Test
    void testSetDenominator() {
        fraction.setDenominator(5);
        assertEquals(5, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(2.0 / 3.0, fraction.decimal(), 0.001);
    }

    @Test
    void testToString() {
        assertEquals("Fraction{numerator=2, denominator=3}", fraction.toString());
    }
    @Test
    void testIsProper() {
        Fraction properFraction = new Fraction(1, 2);
        assertTrue(properFraction.isProper());

        Fraction improperFraction = new Fraction(3, 2);
        assertFalse(improperFraction.isProper());
    }

    @Test
    void testIsImproper() {
        Fraction properFraction = new Fraction(1, 2);
        assertFalse(properFraction.isImproper());

        Fraction improperFraction = new Fraction(3, 2);
        assertTrue(improperFraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 4);
        assertTrue(fraction1.isEquivalent(fraction2));

        Fraction fraction3 = new Fraction(3, 5);
        Fraction fraction4 = new Fraction(6, 10);
        assertTrue(fraction3.isEquivalent(fraction4));

        Fraction fraction5 = new Fraction(2, 3);
        Fraction fraction6 = new Fraction(3, 4);
        assertFalse(fraction5.isEquivalent(fraction6));
    }

    @Test
    void testAdd() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 4);
        Fraction result = fraction1.add(fraction2);
        assertEquals(6,result.getNumerator());
        assertEquals(8,result.getDenominator());
    }

    @Test
    void testMultiply() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);
        Fraction result = fraction1.multiply(fraction2);
        assertEquals(2,result.getNumerator());
        assertEquals(6,result.getDenominator());
    }

    @Test
    void testDivide() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);
        Fraction result = fraction1.divide(fraction2);
        assertEquals(4,result.getNumerator());
        assertEquals(6,result.getDenominator());
    }

}

