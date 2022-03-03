package ro.utcn.tudor.controller;

import ro.utcn.tudor.model.Polynomial;
import ro.utcn.tudor.operations.*;
import ro.utcn.tudor.view.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private GUI view;

    public Controller(GUI view){
        this.view = view;

        view.addBtnClearAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setResult("");
                view.setPol1("");
                view.setPol2("");
            }
        });

        view.addBtnAddAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str1 = view.getPolynomial1();
                String str2 = view.getPolynomial2();

                String val1 = validate(str1);
                String val2 = validate(str2);

                Polynomial p1 = null, p2 = null;
                boolean ok = true;

                if(val1 != null){
                    view.showMessage(val1);
                    ok = false;
                } else if(val2 != null){
                    view.showMessage(val2);
                    ok = false;
                } else{
                    p1 = new Polynomial(str1);
                    p2 = new Polynomial(str2);
                }

                if(ok){
                    BinaryOperation add = new AddOperation();
                    Polynomial result = add.perform(p1, p2);
                    view.setResult(result.toString());
                }

            }
        });

        view.addBtnSubAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str1 = view.getPolynomial1();
                String str2 = view.getPolynomial2();

                String val1 = validate(str1);
                String val2 = validate(str2);

                Polynomial p1 = null, p2 = null;
                boolean ok = true;

                if(val1 != null){
                    view.showMessage(val1);
                    ok = false;
                } else if(val2 != null){
                    view.showMessage(val2);
                    ok = false;
                } else{
                    p1 = new Polynomial(str1);
                    p2 = new Polynomial(str2);
                }

                if(ok){
                    BinaryOperation sub = new SubOperation();
                    Polynomial result = sub.perform(p1, p2);
                    view.setResult(result.toString());
                }
            }
        });

        view.addBtnMulAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str1 = view.getPolynomial1();
                String str2 = view.getPolynomial2();

                String val1 = validate(str1);
                String val2 = validate(str2);

                Polynomial p1 = null, p2 = null;
                boolean ok = true;

                if(val1 != null){
                    view.showMessage(val1);
                    ok = false;
                } else if(val2 != null){
                    view.showMessage(val2);
                    ok = false;
                } else{
                    p1 = new Polynomial(str1);
                    p2 = new Polynomial(str2);
                }

                if(ok){
                    BinaryOperation mul = new MultiplyOperation();
                    Polynomial result = mul.perform(p1, p2);
                    view.setResult(result.toString());
                }
            }
        });

        view.addBtnIntegrAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str1 = view.getPolynomial1();
                String val1 = validate(str1);

                Polynomial p1 = null;
                boolean ok = true;

                if(val1 != null){
                    view.showMessage(val1);
                    ok = false;
                } else{
                    p1 = new Polynomial(str1);
                }

                if(ok){
                    UnaryOperation integrate = new IntegrateOperation();
                    Polynomial result = integrate.perform(p1);
                    view.setResult(result.toString());
                }
            }
        });


        view.addBtnDerivAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str1 = view.getPolynomial1();
                String val1 = validate(str1);

                Polynomial p1 = null;
                boolean ok = true;

                if(val1 != null){
                    view.showMessage(val1);
                    ok = false;
                } else{
                    p1 = new Polynomial(str1);
                }

                if(ok){
                    UnaryOperation deriv = new DerivateOperation();
                    Polynomial result = deriv.perform(p1);
                    view.setResult(result.toString());
                }
            }
        });

        view.addBtnDivAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str1 = view.getPolynomial1();
                String str2 = view.getPolynomial2();

                String val1 = validate(str1);
                String val2 = validate(str2);

                Polynomial p1 = null, p2 = null;
                boolean ok = true;

                if(val1 != null){
                    view.showMessage(val1);
                    ok = false;
                } else if(val2 != null){
                    view.showMessage(val2);
                    ok = false;
                } else{
                    p1 = new Polynomial(str1);
                    p2 = new Polynomial(str2);
                }

                if(ok){
                    try{
                        DivideOperation div = new DivideOperation();
                        List<Polynomial> result = div.perform(p1, p2);
                        String output = "Q: " + result.get(0).toString() + "  |  " +"R: " + result.get(1).toString();
                        view.setResult(output);
                    }catch(Exception ex){
                        view.showMessage(ex.getMessage());
                    }


                }
            }
        });
    }

    private static String validate(String p){
        if(p.isBlank())
            return "Unul dintre polinoame este nul";
        for(int i = 0; i < p.length(); i ++){
           char c = p.charAt(i);
           if(!Character.isDigit(c) && c != 'x' && c != '^' && c != '+' && c != '-'){
               return "Unul dintre polinoame contine caractere nepermise!";
           }

       }
       return null;
    }

}
