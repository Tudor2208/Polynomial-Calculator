package ro.utcn.tudor.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private static final String POLYNOMIAL_PATTERN = "(\\s*[+-]*\\s*\\d*x\\^\\d+)|([+-]\\d*[x])|([+-]\\d*)|(\\d*)";
    private List<Monomial> monomials = new ArrayList<>();
    private int degree;

    public Polynomial(List<Monomial> monomials) {
        this.monomials = monomials;
        int deg = 0;
        for(Monomial m : monomials){
            if(m.getExp() > deg){
                deg = m.getExp();
            }
        }
        this.degree = deg;
    }

    public Polynomial(String s){
        Pattern p = Pattern.compile(POLYNOMIAL_PATTERN);
        Matcher m = p.matcher(s);
        while(m.find()){
            monomials.add(new Monomial(m.group()));
        }
        monomials.remove(monomials.size() - 1);
        int deg = 0;
        for(Monomial mon : monomials){
            if(mon.getExp() > deg){
                deg = mon.getExp();
            }
        }
        this.degree = deg;
    }

    public List<Monomial> getMonomials() {
        return monomials;
    }

    public int getDegree() {
        return degree;
    }

    public void addMonomial(Monomial m){
        monomials.add(m);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomial that = (Polynomial) o;
        return Objects.equals(monomials, that.monomials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monomials);
    }

    public String toString(){
       String result = "";
       for(Monomial m:monomials){
           result += m.toString();
       }
       if(result.charAt(0) == '+')
           result = result.substring(1, result.length());
       return result;
    }
}
