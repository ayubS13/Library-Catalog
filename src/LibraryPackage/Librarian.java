/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryPackage;

/**
 *
 * @author Ayub
 */
import java.io.*;
import java.util.*;
public class Librarian implements Serializable{
    //class fields of a user
    String first = "";
    String last = "";
    int age = 0;
    String userName = "";
    int password = 0;
    String number = "";
    public Librarian nextNode;
    //boolean librarian = false;

    //the constructor
    public Librarian(){}
    public Librarian(String fn, String ln,int ag, String userN, int pass, String n, Librarian ptr){
        first = fn;
        last = ln;
        age = ag;
        userName = userN;
        password = pass;
        number = n;
        nextNode = ptr;
    }
    
    public String getUsername(){
        return userName;
    }
    
    public int getPassword(){
        return password;
    }
}
