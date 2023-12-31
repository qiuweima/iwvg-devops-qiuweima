package es.upm.miw.iwvg_devops.code;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }
    public boolean isProper() {
        return (double) Math.abs(numerator) < Math.abs(denominator);
    }
    public boolean isImproper() {
        return (double) Math. abs(numerator) >= Math.abs(denominator);
    }
    public boolean isEquivalent(Fraction fraction2) {
        return (double) numerator * fraction2.denominator == denominator * fraction2.numerator;
    }
    public Fraction add(Fraction other) {
        int new_numerator = numerator * other.denominator + other.numerator * denominator;
        int new_denominator = denominator * other.denominator;
        return new Fraction( new_numerator, new_denominator);
    }
    public Fraction multiply(Fraction other) {
        int new_numerator = numerator * other.numerator;
        int new_denominator = denominator * other.denominator;
        return new Fraction(new_numerator, new_denominator);
    }
    public Fraction divide(Fraction other){
        if (other.numerator == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        int newNumerator = numerator * other.denominator;
        int newDenominator = denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }
    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

}