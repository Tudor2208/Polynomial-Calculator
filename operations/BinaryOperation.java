package ro.utcn.tudor.operations;

import ro.utcn.tudor.model.Polynomial;

public interface BinaryOperation {
    Polynomial perform(Polynomial p1, Polynomial p2);
}
