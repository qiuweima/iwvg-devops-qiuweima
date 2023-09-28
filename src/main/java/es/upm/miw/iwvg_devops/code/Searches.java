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
        public Double findFirstDecimalFractionByUserName(String name) {
            Optional<Double> result = new UsersDatabase().findAll()
                    .filter(user -> name.equals(user.getName()))
                    .flatMap(user -> user.getFractions().stream()
                            .filter(fraction -> fraction.getDenominator() != 0)
                            .map(fraction -> (double) fraction.getNumerator() / fraction.getDenominator())
                    )
                    .findFirst();
            return result.orElse(null);
        }
        public Fraction findFractionSubtractionByUserName(String name) {
            Stream<Fraction> fractions = new UsersDatabase().findAll()
                    .filter(user -> name.equals(user.getName()))
                    .flatMap(user -> user.getFractions().stream());
            Fraction result = new Fraction(0, 1);
            result = fractions.reduce(result, (fraction1, fraction2) -> {
                int commonDenominator = fraction1.getDenominator() * fraction2.getDenominator();
                int numerator1 = fraction1.getNumerator() * fraction2.getDenominator();
                int numerator2 = fraction2.getNumerator() * fraction1.getDenominator();
                int newNumerator = numerator1 - numerator2;
                return new Fraction(newNumerator, commonDenominator);
            });
            return result;
        }
        public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
            return new UsersDatabase().findAll()
                    .filter(user -> user.getFractions().stream().anyMatch(fraction -> fraction.getNumerator() < 0))
                    .map(User::getFamilyName)
                    .distinct();
        }
    }


