package ro.utcn.tudor.operations;
import ro.utcn.tudor.model.Monomial;
import ro.utcn.tudor.model.Polynomial;

import java.util.*;

public class AddOperation implements BinaryOperation{

    @Override
    public Polynomial perform(Polynomial p1, Polynomial p2) {
        Map<Integer, Double> acc = new LinkedHashMap<>();
        accumulate(acc, p1);
        accumulate(acc, p2);
        List<Monomial> monomials = new ArrayList<>();
        acc.forEach((exp, coefficient) -> {
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

    private static void accumulate(Map<Integer, Double> myHash, Polynomial p){
        for (Monomial m : p.getMonomials()) {
            if(myHash.containsKey(m.getExp())){
                myHash.put(m.getExp(), myHash.get(m.getExp()) + m.getCoefficient());
            }else{
                myHash.put(m.getExp(), m.getCoefficient());
            }
        }
    }
}
