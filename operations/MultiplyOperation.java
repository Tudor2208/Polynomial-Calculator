package ro.utcn.tudor.operations;

import ro.utcn.tudor.model.Monomial;
import ro.utcn.tudor.model.Polynomial;

import java.util.*;

public class MultiplyOperation implements BinaryOperation{
    @Override
    public Polynomial perform(Polynomial p1, Polynomial p2) {
        Polynomial zero = new Polynomial("0");
        if(p1.equals(zero) || p2.equals(zero))
            return new Polynomial("0");
        else{
            List<Monomial> monomials = new ArrayList<>();
            Map<Integer, Double> myHash = new LinkedHashMap<>();
            p1.getMonomials().forEach(m1->{
                p2.getMonomials().forEach(m2->{
                    Monomial myMonomial = mul(m1, m2);
                    int exp = myMonomial.getExp();
                    double coef = myMonomial.getCoefficient();
                    if(!myHash.containsKey(exp)){
                        myHash.put(exp, coef);
                    }else{
                        myHash.put(exp, coef + myHash.get(exp));
                    }

                });
            });
            myHash.forEach((exp, coefficient) -> {
                if(coefficient != 0){
                    monomials.add(new Monomial(coefficient, exp));
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

    }

     private static Monomial mul(Monomial m1, Monomial m2){
        return new Monomial(m1.getCoefficient() * m2.getCoefficient(), m1.getExp() + m2.getExp());
    }
}
