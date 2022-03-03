package ro.utcn.tudor.operations;

import ro.utcn.tudor.model.Monomial;
import ro.utcn.tudor.model.Polynomial;

import java.util.ArrayList;
import java.util.List;

public class DivideOperation {

    public List<Polynomial> perform(Polynomial p1, Polynomial p2) throws Exception{

        Polynomial zero = new Polynomial("0");
        if(p2.equals(zero))
            throw new Exception("Can't divide by 0!");

        Polynomial quotient = new Polynomial("0");
        Polynomial remainder = new Polynomial(p1.getMonomials());
        Polynomial aux, prod;


        BinaryOperation sub = new SubOperation();
        BinaryOperation mul = new MultiplyOperation();

        while(lead(remainder) != null && remainder.getDegree() >= p2.getDegree()){
            aux = div(lead(remainder), lead(p2));
            quotient.addMonomial(new Monomial(aux.getMonomials().get(0).getCoefficient(), aux.getMonomials().get(0).getExp()));
            prod = mul.perform(aux, p2);
            remainder = sub.perform(remainder, prod);
        }
        List<Polynomial> result = new ArrayList<>();
        if(!quotient.equals(zero))
         quotient.getMonomials().remove(0);
        result.add(quotient);
        if(lead(remainder) != null)
            result.add(remainder);
        else
            result.add(zero);
        return result;
    }

    private static Polynomial div(Monomial m1, Monomial m2){
        Monomial result = new Monomial((double)m1.getCoefficient() / m2.getCoefficient(), m1.getExp() - m2.getExp());
        List<Monomial> list = new ArrayList<>();
        list.add(result);
        return new Polynomial(list);
    }

    private static Monomial lead(Polynomial p){
        for(Monomial m: p.getMonomials()){
            if(m.getExp() == p.getDegree()) {
               return new Monomial(m.getCoefficient(), m.getExp());
            }
        }
       return null;
    }

}
