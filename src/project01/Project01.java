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

        //Set up to allow user to choose the file
        JFileChooser myChooser = new JFileChooser();
        myChooser.showOpenDialog(null);
        File netflixFile = myChooser.getSelectedFile();

        Scanner file = new Scanner(netflixFile);

        //User prompt while loop
        System.out.println("What would you like to do");
        System.out.println("Menu (Choose the following or Q to quit):");
        System.out.println("F -Filter on Type");
        System.out.println("D -Filter on Date");
        System.out.println("S -Search by show");
        System.out.println("H -Highest Days in Top Ten");
        System.out.print("Choice: ");
        choice = object.next();
        while (!"q".equals(choice)) {
            String[][] netflix = find(file);
            if ("f".equals(choice)) {
                System.out.print("Would you like to filter on TV Show, Movie, or Stand-Up Comedy: ");
                String typeChoice = object.next();
                filterOnType();
            } else if ("d".equals(choice)) {
                System.out.print("What week would you like to search for (mm/dd/yyyy): ");
                String dateChoice = object.next();
                filterOnDate();
            } else if ("s".equals(choice)) {
                System.out.print("What TV Show or Movie would you like to search for: ");
                String mediaChoice = object.next();
                searchForShow(netflix, mediaChoice);

            } else if ("h".equals(choice)) {
                highestDaysInTopTen()
            } else {
                System.out.println("Invalid Input");

                System.out.println();
                System.out.println("What would you like to do");
                System.out.println("Menu (Choose the following or Q to quit):");
                System.out.println("F -Filter on Type");
                System.out.println("D -Filter on Date");
                System.out.println("S -Search by show");
                System.out.println("H -Highest Days in Top Ten");
                System.out.print("Choice: ");
                choice = object.next();
            }

        }

    }

    public static String[][] find(Scanner fileInput) {
        String[][] netflixArray = new String[7100][6];
        while (fileInput.hasNext()) {
            String record = fileInput.nextLine();
            String[] line = record.split(",");
        }
        return netflixArray;
    }

    public static void searchForShow(String[][] dataSet, String show) throws FileNotFoundException {
        int count = 0;
        PrintWriter showFile = new PrintWriter("searchResults.txt");
        for (int i = 1; i < dataSet[i].length; i++) {
            if (dataSet[i][2] == show) {
                count++;
                showFile.printf("%-12s%-7s%-36s%-12s%-6s%-13s%-5s\n", dataSet[i][0], dataSet[i][1], dataSet[i][2], dataSet[i][3]);
            }
        }

        if (count > 0) {
            System.out.println("The number of weeks " + show + "appeared in: " + count);
        } else {
            System.out.println("Show not found");
        }
        showFile.close();
    }

    public static void filterOnType(String[][] dataSet, String type) {

    }

    public static void highestDaysInTopTen(String[][] dataSet) {

    }

}
