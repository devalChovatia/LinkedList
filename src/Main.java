import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Polynomial polynomial = new Polynomial("3x^4;2x^2;3x^1;7x^0");
        Polynomial polynomial2 = new Polynomial("2x^3;-5x^1;5x^0");
        Polynomial polynomial3 = new Polynomial("6x^5;-7x^3;-2x^2;2x^1;3x^0");
        Polynomial polynomial4 = new Polynomial("-3x^5;-2x^3;6x^4;5x^2;9x^1;-4x^0");

        String result = polynomial.addPolynomial(polynomial.toString(polynomial.getTerms()),
                polynomial2.toString(polynomial2.getTerms()));

        String result2 = polynomial2.addPolynomial(polynomial.toString(polynomial2.getTerms()),
                polynomial3.toString(polynomial3.getTerms()));

        String result3 = polynomial.addPolynomial(polynomial.toString(polynomial.getTerms()),
                polynomial3.toString(polynomial3.getTerms()));

        String result4 = polynomial3.addPolynomial(polynomial.toString(polynomial3.getTerms()),
                polynomial4.toString(polynomial4.getTerms()));

        String result5 = polynomial.addPolynomial(polynomial.toString(polynomial.getTerms()),
                polynomial4.toString(polynomial4.getTerms()));


        System.out.println("---------------------------------\n(" + polynomial.formatPolynomialExpression(polynomial.getTerms())
                + ") + (" + polynomial2.formatPolynomialExpression(polynomial2.getTerms()) + ") = " + result);

        System.out.println("---------------------------------\n(" + polynomial2.formatPolynomialExpression(polynomial2.getTerms())
                + ") + (" + polynomial3.formatPolynomialExpression(polynomial3.getTerms()) + ") = " + result2);

        System.out.println("---------------------------------\n(" + polynomial.formatPolynomialExpression(polynomial.getTerms())
                + ") + (" + polynomial3.formatPolynomialExpression(polynomial3.getTerms()) + ") = " + result3);

        System.out.println("---------------------------------\n(" + polynomial3.formatPolynomialExpression(polynomial3.getTerms())
                + ") + (" + polynomial4.formatPolynomialExpression(polynomial4.getTerms()) + ") = " + result4);

        System.out.println("---------------------------------\n(" + polynomial.formatPolynomialExpression(polynomial.getTerms())
                + ") + (" + polynomial4.formatPolynomialExpression(polynomial4.getTerms()) + ") = " + result5);
    }
}


