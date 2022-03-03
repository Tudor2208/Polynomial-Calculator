package ro.utcn.tudor.operations;

import ro.utcn.tudor.model.Monomial;
import ro.utcn.tudor.model.Polynomial;

import java.util.ArrayList;
import java.util.List;

public class DerivateOperation implements UnaryOperation{
    @Override
    public Polynomial perform(Polynomial p) {
        List<Monomial> monomials = new ArrayList<>();
        p.getMonomials().forEach(m->{
            double coef = m.getCoefficient();
            int exp = m.getExp();
            coef = coef * exp;
            exp --;
            if(exp != -1)
                monomials.add(new Monomial(coef, exp));

        });
        if(p.getDegree() == 0) monomials.add(new Monomial(0, 0));
        return new Polynomial(monomials);
    }
}
