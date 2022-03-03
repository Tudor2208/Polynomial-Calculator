package ro.utcn.tudor;

import ro.utcn.tudor.controller.Controller;
import ro.utcn.tudor.model.Monomial;
import ro.utcn.tudor.model.Polynomial;
import ro.utcn.tudor.operations.*;
import ro.utcn.tudor.view.GUI;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

      new Controller(new GUI());


    }
}
