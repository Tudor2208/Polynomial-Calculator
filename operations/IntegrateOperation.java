package ro.utcn.tudor.operations;

import ro.utcn.tudor.model.Monomial;
import ro.utcn.tudor.model.Polynomial;

import java.util.ArrayList;
import java.util.List;

public class IntegrateOperation implements UnaryOperation{
    @Override
    public Polynomial perform(Polynomial p) {
        List<Monomial> monomials = new ArrayList<>();
        p.getMonomials().forEach(m->{
            int exp = m.getExp();
            double coef = m.getCoefficient();
            exp ++;
            coef = (double) coef / exp;
            monomials.add(new Monomial(coef, exp));
        });

        return new Polynomial(monomials);
    }
}
