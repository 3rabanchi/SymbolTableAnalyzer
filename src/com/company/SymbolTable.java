package com.company;

import sun.awt.image.ImageWatched;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SymbolTable {

     static int SIZE = 8;

     static LinkedList[] table;


    static void initialize(){
        table = new LinkedList[SIZE];
        int i =0;
        while(i<SIZE) {
            table[i] = new LinkedList();
            i++;
        }
    }

     static void initialize(int size){
         table = new LinkedList[size];
         int i =0;
         while(i<size) {
             table[i] = new LinkedList();
             i++;
         }
     }
    static int hashFunction(String input){
        int key = 0;
        for (int i = 0; i < input.length(); i++) {
            key = key + input.charAt(i);
        }
        return key%table.length;
    }
    static boolean insertSymbol(String input){
        if (input.trim().equals("")){
            System.out.println("The symbol is empty!");
            return false;
        }
         String[] splitInput = clearString(input);
         return Arrays
                 .stream(splitInput)
                 .allMatch(x->checkInput(x));
    }
    static String getSymbol(String input){
        int key = hashFunction(input);
        String symbol= "";
        try{
            if(findSymbol(input))
                symbol = input;
            else
                System.out.println("Get symbol: There is no element with value\""+input +"\" in the symbol table");
        }
        catch (NullPointerException e)
        {
            System.out.println("Get symbol: Something went wrong!");
        }
        return symbol;
    }
    static boolean deleteSymbol(String input) {

        int key = hashFunction(input);
        boolean flag = false;
        try {
            if (!findSymbol(input))
                System.out.println("Delete symbol : Symbol with \"" + input + "\" doesn't exist!");
            else {
                loop:
                for(LinkedList linkedList: table)
                    for(int i = 0; i<linkedList.size();i++) {
                        String symbol = table[key].get(i).data;
                        if (input.equals(symbol)) {
                            table[key].deleteNodeWithData(symbol);
                            flag = true;
                            break loop;
                        }
                    }
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("Something went wrong with the deletion of the symbol!");
        }
        return flag;
    }

    static boolean findSymbol(String input){
        {
            int key = hashFunction(input);
            boolean flag = false;
            try{
                for(LinkedList linkedList: table)
                    for(int i = 0; i<linkedList.size();i++)
                    {
                        String symbol = table[key].get(i).data;
                        if(input.equals(symbol)) {
                            flag= true;
                            break;
                        }
                    }
            }
            catch (NullPointerException e)
            {
                return false;
            }
            return flag;
        }
    }
    static void printTable(){
         AtomicInteger i = new AtomicInteger();
         Arrays.stream(table).forEach(x->{
            System.out.println("Value of "+i.getAndIncrement()+" contains list with symbols:");
            x.print();
            });
    }
    static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner fileContent = new Scanner(file);
        int count = 0;
        while (fileContent.hasNext()) {
            String word  = fileContent.next();
            if(word.matches("(^[a-zA-Z].*$)")) {
                insertSymbol(word);
            }
            count = count + 1;
        }
    }

    private static boolean checkInput(String input){
        int key = hashFunction(input);
        boolean flag = false;
        if(!findSymbol(input)){
            table[key].add(input);
            flag = true;
        }
        else
            flag = false;
        return flag;
    }

    private static String[] clearString(String input){
        String[] splitInput;
        if(input.contains(";"))
            input = input.replace(";","");

        if(input.contains(")"))
            input = input.replace(")","");

        if(input.contains("("))
            splitInput = input.split("\\(");
        else
            splitInput = new String[]{input};
        return splitInput;
    }

}
