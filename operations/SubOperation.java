package ro.utcn.tudor.operations;

import ro.utcn.tudor.model.Monomial;
import ro.utcn.tudor.model.Polynomial;

import java.util.*;

public class SubOperation implements BinaryOperation{
    @Override
    public Polynomial perform(Polynomial p1, Polynomial p2) {
        Map<Integer, Double> myHash = new LinkedHashMap<>();
        accumulate(myHash, p1);
        subtract(myHash, p2);
        List<Monomial> monomials = new ArrayList<>();
        myHash.forEach((exp, coef)->{
            if(coef != 0){
                monomials.add(new Monomial(coef, exp));
            }
        });

        monomials.sort(new Comparator<Monomial>() {
            @Override
            public int compare(Monomial o1, Monomial o2) {
                if(o1.getExp() == o2.getExp()) return 0;
                else if(o1.getExp() < o2.getExp()) return 1;
                else return -1;
            }
        });

        return new Polynomial(monomials);
    }

    private static void accumulate(Map<Integer, Double> myHash, Polynomial p){
        List<Monomial> monomials = p.getMonomials();
        monomials.forEach(monomial->{
            int exp = monomial.getExp();
            double coef = monomial.getCoefficient();
            myHash.put(exp, coef);
        });
    }

    private static void subtract(Map<Integer, Double> myHash, Polynomial p){
        List<Monomial> monomials = p.getMonomials();
        monomials.forEach(monomial->{
            int exp = monomial.getExp();
            double coef = monomial.getCoefficient();
            if(myHash.containsKey(exp)){
                myHash.put(exp, myHash.get(exp) - coef);
            }else{
                myHash.put(exp, -coef);
            }

        });
    }
}
