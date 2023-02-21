/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project01;

import java.util.*;
import java.io.*;
import javax.swing.*;

//
public class Project01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        String choice;
        //Scanner
        Scanner object = new Scanner(System.in);

        //Opening and reading File
        File inputFile = new File("netflix.txt");
        Scanner input = new Scanner(inputFile);

        //User prompt while loop
        System.out.println("What would you like to do");
        System.out.println("Menu (Choose the following or Q to quit):");
        System.out.println("F -Filter on Type");
        System.out.println("D -Filter on Date");
        System.out.println("S -Search by show");
        System.out.println("H -Highest Days in Top Ten");
        System.out.print("Choice: ");
        choice = object.next();
        while (choice != "q") {

            System.out.println();
            System.out.print("Choice: ");
            choice = object.next();
        }

    }

}
