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
public class Book implements Serializable {
    String title = "";
    String an1 = "";
    String an2 = "";
    int number = 0;
    int date = 0;
    String genre = "";
    String returndate = "";
    public Book nextNode;
    
    public Book(String t, String authorF, String authorL, int n, int d, String g, Book ptr ){
        title = t; an1 = authorF; an2 = authorL; number = n; date = d; genre = g; nextNode = ptr;
    }
    
    public String getdate(){
        return returndate;
    }
    public void setdate(String dt){
        returndate = dt;
    }

}
