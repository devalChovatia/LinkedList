import java.util.LinkedList;

public class Polynomial {
    public LinkedList<Term> getTerms() {
        return terms;
    }

    private LinkedList<Term> terms;

    public Polynomial(String poly) {
        terms = parse(poly);
    }

    public String addPolynomial(String poly1, String poly2) {
        LinkedList<Term> termListOfPoly1 = parse(poly1);
        LinkedList<Term> termListOfPoly2 = parse(poly2);

        LinkedList<Term> resultTerms = new LinkedList<>();

        while (!termListOfPoly1.isEmpty() && !termListOfPoly2.isEmpty()) {
            Term term1 = termListOfPoly1.peek();
            Term term2 = termListOfPoly2.peek();

            if (term1.exponent > term2.exponent) {
                resultTerms.add(term1);
                termListOfPoly1.remove();
            } else if (term1.exponent < term2.exponent) {
                resultTerms.add(term2);
                termListOfPoly2.remove();
            } else {
                int combinedCoefficient = term1.coefficient + term2.coefficient;
                if (combinedCoefficient != 0) {
                    resultTerms.add(new Term(combinedCoefficient, term1.exponent));
                }
                termListOfPoly1.remove();
                termListOfPoly2.remove();
            }
        }
        return formatPolynomialExpression(resultTerms);
    }

    private LinkedList<Term> parse(String poly) {
        LinkedList<Term> terms = new LinkedList<>();
        String[] stringTerms = poly.split(";");

        for (String stringTerm : stringTerms) {
            String[] parts = stringTerm.split("x\\^");
            int coefficient = Integer.parseInt(parts[0]);
            int exponent = Integer.parseInt(parts[1]);
            terms.add(new Term(coefficient, exponent));
        }
        return terms;
    }

    public String formatPolynomialExpression(LinkedList<Term> terms) {
        StringBuilder finalString = new StringBuilder();

        for (Term term : terms) {
            if (term.coefficient > 0 && finalString.length() > 0) {
                finalString.append("+");
            }
            if (term.exponent == 1) {
                finalString.append(term.coefficient).append("x");
            } else if (term.exponent == 0) {
                finalString.append(term.coefficient);
            } else if (term.exponent > 1) {
                finalString.append(term.coefficient).append("x^").append(term.exponent);
            }
        }
        return finalString.toString();
    }

    public String toString(LinkedList<Term> terms) {
        StringBuilder finalString = new StringBuilder();

        for (Term term : terms) {
            if (term.exponent == 1) {
                finalString.append(term.coefficient).append("x^1");
            } else if (term.exponent == 0) {
                finalString.append(term.coefficient).append("x^0");
            } else if (term.exponent > 1) {
                finalString.append(term.coefficient).append("x^").append(term.exponent);
            }
            finalString.append(";");
        }
        return finalString.toString();
    }

    private class Term {
        private int coefficient;
        private int exponent;

        public Term(int coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
        }
    }
}