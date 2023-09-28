package es.upm.miw.iwvg_devops.code;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
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
}

