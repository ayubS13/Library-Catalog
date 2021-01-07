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

public class Users implements Serializable{
    //class fields of a user
    String first = "";
    String last = "";
    int ag = 0;
    String userName = "";
    int password = 0;
    String phonenumber = "";
    int checkedout = 0;
    
    public Users nextNode;
    public ArrayList<Book> out = new ArrayList<>();//the books that the user has checked out
    //the constructor
    public Users(){}
    public Users(String fn, String ln, int age, String userN, int pass, String pnumber, Users ptr){
        first = fn;
        last = ln;
        ag = age;
        userName = userN;
        password = pass;
        phonenumber = pnumber;
        checkedout = 0;
        nextNode = ptr;
    }
    
    public void update(String f, String l, int a, String uN, int p, String pn){
        first = f;
        last = l;
        ag = a;
        userName = uN;
        password = p;
        phonenumber = pn;
    }
   
    
    public ArrayList<Book> getArray(){
        return out;
    }
    
    public void setArray(ArrayList<Book> input){
        out = input;
    }
    
    public String getName(){
        return first +" "+ last;
    }
    public String getUsername(){
        return userName;
    }
    
    public int getPassword(){
        return password;
    }
    public void addBook(Book bk){
        out.add(bk);
    }
    public Book removeBook(Book bk){
        for(int i = 0; i < out.size(); i++) {
            if(bk.title.equalsIgnoreCase(out.get(i).title)){
                return out.remove(i);
            }
        }
        return null; //this almost never returns null
    }
    
}
