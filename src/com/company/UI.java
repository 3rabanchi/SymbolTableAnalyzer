package com.company;

import java.io.IOException;
import java.util.Scanner;

public class UI {

    static public void ui() throws IOException {
        cleaner();
        System.out.println("1.Enter a symbol to the table");
        System.out.println("2.Check if a particular symbol exists");
        System.out.println("3.Read file");
        System.out.println("4.Show table's content");
        System.out.println("5.Delete a symbol");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        switch(input){
            case "1":
                cleaner();
                System.out.println("Please enter the string:");
                input = in.nextLine();
                if(!SymbolTable.insertSymbol(input))
                    System.out.println("Such symbol exists, press anything to return");
                else
                    System.out.println("Symbol added successfully, press anything to return");
                String waiter = in.nextLine();
                ui();
                break;
            case "2":
                cleaner();
                input = in.nextLine();
                if(SymbolTable.findSymbol(input))
                System.out.println("It exists in the table,press anything to return");
                else
                System.out.println("It doesn't exist,press anything to return");
                waiter = in.nextLine();
                ui();
                break;
            case "3":
                cleaner();
                System.out.println("Please enter the full path to the file");
                input = in.nextLine();
                try{
                    SymbolTable.readFile(input);
                    System.out.println("Press anything to return");
                }
                catch (IOException e){
                    System.out.println("No such file exists,press anything to return");
                }
                waiter = in.nextLine();
                ui();
                break;
            case "4":
                cleaner();
                System.out.println("SYMBOL TABLE:");
                SymbolTable.printTable();
                System.out.println("");
                System.out.println("Press anything to return");
                waiter = in.nextLine();
                ui();
                break;
            case "5":
                cleaner();
                System.out.println("Please enter the string:");
                input = in.nextLine();
                SymbolTable.deleteSymbol(input);
                System.out.println("Press anything to return");
                waiter = in.nextLine();
                ui();
                break;
            default:
                System.out.println("Please enter somethine else lol");
                ui();
        }
    }

    private static void cleaner() {
        int i = 0;
        while(i< 50){
            System.out.println("");
            i++;
        }
    }
}
