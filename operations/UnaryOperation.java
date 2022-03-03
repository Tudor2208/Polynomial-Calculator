package ro.utcn.tudor.operations;

import ro.utcn.tudor.model.Polynomial;

public interface UnaryOperation {
    Polynomial perform(Polynomial p);
}
