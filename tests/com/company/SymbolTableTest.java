package com.company;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTableTest {

    @Test
    void initializeTest() {
        SymbolTable.initialize();
        assertEquals(SymbolTable.SIZE,Arrays
                .stream(SymbolTable.table)
                .count());
    }
    @Test
    void initializeWithParametersTest() {
        int example = 30;
        SymbolTable.initialize(example);
        assertEquals(example,Arrays
                .stream(SymbolTable.table)
                .count());
    }

    @Test
    void hashFunctionTest1() {
        String example = "A";
        int sizeOfTable = 20;
        SymbolTable.initialize(sizeOfTable);
        int result = SymbolTable.hashFunction(example);
        assertNotEquals(1,result);
    }

    @Test
    void hashFunctionTest2() {
        String example = "A";
        SymbolTable.initialize();
        int result = SymbolTable.hashFunction(example);
        assertEquals(1,result);
    }

    @Test
    void insertSymbolTest1() {
        String example = "Example";
        SymbolTable.initialize();
        boolean result = SymbolTable.insertSymbol(example);
        assertTrue(result);
    }

    @Test
    void insertSymbolTest2() {
        String example = "Example";
        SymbolTable.initialize();
        SymbolTable.insertSymbol(example);
        boolean result = SymbolTable.insertSymbol(example);
        assertFalse(result);
    }
    @Test
    void findSymbolTest1() {
        String example = "Example";
        SymbolTable.initialize();
        SymbolTable.insertSymbol(example);
        boolean result = SymbolTable.findSymbol(example);
        assertTrue(result);
    }
    @Test
    void findSymbolTest2() {
        String example = "Example";
        String exampleTwo = "ExampleTwo";
        SymbolTable.initialize();
        SymbolTable.insertSymbol(example);
        boolean result = SymbolTable.findSymbol(exampleTwo);
        assertFalse(result);
    }
    @Test
    void deleteSymbolTest1() {
        String example = "Example";
        SymbolTable.initialize();
        SymbolTable.insertSymbol(example);
        boolean result= SymbolTable.deleteSymbol(example);
        assertTrue(result);
    }
    @Test
    void deleteSymbolTest2(){
        String example = "Example";
        String exampleTwo = "ExampleTwo";
        SymbolTable.initialize();
        SymbolTable.insertSymbol(example);
        boolean result= SymbolTable.deleteSymbol(exampleTwo);
        assertFalse(result);
    }
    @Test
    void readFileTest1() throws FileNotFoundException {
        String filePath = "./resources/test1.c";
        String existingWord = "File";
        String notExistingWord = "Hello World!";
        SymbolTable.initialize();
        SymbolTable.readFile(filePath);
        assertTrue(SymbolTable.findSymbol(existingWord));
        assertFalse(SymbolTable.findSymbol(notExistingWord));
    }
    @Test
    void readFileTest2() throws FileNotFoundException {
        String filePath = "./resources/test2.c";
        String notExistingWord = "Hello World!";
        SymbolTable.initialize();
        SymbolTable.readFile(filePath);
        assertFalse(SymbolTable.findSymbol(notExistingWord));
    }
}