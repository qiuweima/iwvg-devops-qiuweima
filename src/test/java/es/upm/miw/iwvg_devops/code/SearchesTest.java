package es.upm.miw.iwvg_devops.code;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class SearchesTest {
    private Searches searches;
    private UsersDatabase usersDatabase;

    @BeforeEach
    void setUp() {
        usersDatabase = new UsersDatabase();
        searches = new Searches();
    }
    @Test
    void testFindDecimalImproperFractionByUserName() {
        assertEquals(List.of(2.0, 1.3333333333333333), searches.findDecimalImproperFractionByUserName("Ana")
                .collect(Collectors.toList()));
    }
    @Test
    void testFindFirstDecimalFractionByUserName() {
        assertEquals(0.0, searches.findFirstDecimalFractionByUserName("Oscar"));
    }
    @Test
    void testFindFractionSubtractionByUserName() {
        Fraction expected = new Fraction(0, 0);
        Fraction actual = new Searches().findFractionSubtractionByUserName("Paula");
        assertEquals(0,actual.getNumerator());
        assertEquals(0,actual.getDenominator());
    }

}

