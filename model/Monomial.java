package ro.utcn.tudor.model;

import java.text.DecimalFormat;
import java.util.Objects;

public class Monomial {
    private double coefficient;
    private int exponent;

    public Monomial(double coefficient, int exp) {
        this.coefficient = coefficient;
        this.exponent = exp;
    }

    public Monomial(String s){
        String[] tokens = s.split("x\\^");
        if(tokens[0].equals("+") || tokens[0].isBlank())
            this.coefficient = 1;
        else if(tokens[0].equals("-"))
            this.coefficient = -1;
        else
            this.coefficient = Double.parseDouble(tokens[0]);
        if(tokens.length == 2){
            this.exponent = Integer.parseInt(tokens[1]);
        }else{
           this.exponent = 0;
        }

    }

    public double getCoefficient() {
        return coefficient;
    }

    public int getExp() {
        return exponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        return (Math.abs(coefficient - monomial.coefficient) < 0.01) && exponent == monomial.exponent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coefficient, exponent);
    }

    @Override
    public String toString() {
        String result = "";
        DecimalFormat format = new DecimalFormat("0.##");
        if(coefficient > 0) result += "+";
        if(exponent == 0){
            result += String.valueOf(format.format(coefficient));
        }else if(exponent == 1){
            result += String.valueOf(format.format(coefficient)) + "x";
        }else{
            result += String.valueOf(format.format(coefficient)) + "x^" + exponent;
        }

        return result;
    }
}
