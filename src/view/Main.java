package view;

import controller.DistroController;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        DistroController dc = new DistroController();
        System.out.println(dc.exibeDistro());
        JOptionPane.showMessageDialog(null,dc.exibeDistro());
    }
}
