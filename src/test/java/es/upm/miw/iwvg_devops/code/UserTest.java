package es.upm.miw.iwvg_devops.code;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(3, 4));
        user = new User("1", "John", "Doe", fractions);
    }

    @Test
    void testGetId() {
        assertEquals("1", user.getId());
    }

    @Test
    void testGetName() {
        assertEquals("John", user.getName());
    }

    @Test
    void testSetName() {
        user.setName("Alice");
        assertEquals("Alice", user.getName());
    }

    @Test
    void testGetFamilyName() {
        assertEquals("Doe", user.getFamilyName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("Smith");
        assertEquals("Smith", user.getFamilyName());
    }

    @Test
    void testGetFractions() {
        List<Fraction> fractions = user.getFractions();
        assertEquals(2, fractions.size());
        assertEquals(1, fractions.get(0).getNumerator());
        assertEquals(2, fractions.get(0).getDenominator());
        assertEquals(3, fractions.get(1).getNumerator());
        assertEquals(4, fractions.get(1).getDenominator());
    }

    @Test
    void testSetFractions() {
        List<Fraction> newFractions = new ArrayList<>();
        newFractions.add(new Fraction(2, 3));
        user.setFractions(newFractions);
        List<Fraction> fractions = user.getFractions();
        assertEquals(1, fractions.size());
        assertEquals(2, fractions.get(0).getNumerator());
        assertEquals(3, fractions.get(0).getDenominator());

    }

    @Test
    void testAddFraction() {
        user.addFraction(new Fraction(2, 3));
        List<Fraction> fractions = user.getFractions();
        assertEquals(3, fractions.size());
        assertEquals(2, fractions.get(2).getNumerator());
        assertEquals(3, fractions.get(2).getDenominator());
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("J.", user.initials());
    }

    @Test
    void testToString() {
        String expectedString = "User{id='1', name='John', familyName='Doe', fractions=[Fraction{numerator=1, denominator=2}, Fraction{numerator=3, denominator=4}]}";
        assertEquals(expectedString, user.toString());
    }
}

