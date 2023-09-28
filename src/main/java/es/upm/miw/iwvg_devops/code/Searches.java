package es.upm.miw.iwvg_devops.code;
import java.util.stream.Stream;
import java.util.Optional;
    public class Searches {
        public Stream<Double> findDecimalImproperFractionByUserName(String name) {
            return new UsersDatabase().findAll()
                    .filter(user -> name.equals(user.getName()))
                    .flatMap(user -> user.getFractions().stream()
                            .filter(fraction -> !fraction.isProper())
                            .map(fraction -> (double) fraction.getNumerator() / fraction.getDenominator())
                    );
        }

    }


