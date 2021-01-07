/*
 * To change this license header, choose License Headers in Project Properties.``sort
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryPackage;

/**
 *
 * @author Ayub
 */

import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class LibrarianHomepage extends javax.swing.JFrame{

    private static Librarian libHeadNode;
    private static Librarian libTailNode;
    Librarian currentLib;
    
    private static Users headNode;
    private static Users tailNode;
    private Users currentUser = new Users();
    
    private static Book bookHeadNode;
    private static Book bookTailNode;
    
    
    //private static ArrayList<Users> list = new ArrayList<>();//list for all the users in the library
    //private static ArrayList<Book> booklist = new ArrayList<>();//list for all the books in the library
    //private static ArrayList<Librarian> apple = new ArrayList<>(); //list of all the librarians that have access to the database
    //private ArrayList<Book> printList = new ArrayList<>(); //list of the books to print on the screen


    
  
    
    public LibrarianHomepage(Librarian current, Librarian headNode, Librarian tailNode){
        initComponents();
        currentLib = current;
        libHeadNode = headNode;
        libTailNode = tailNode;
        initializeUserList(); //read the usernames from a file
        initializeBookList(); //read the books from a file 
    }
    
    public LibrarianHomepage(Librarian current){
        initComponents();
        currentLib = current;
        initializeLibrarianList();
        initializeUserList(); //read the usernames from a file
        initializeBookList(); //read the books from a file 
    }
    
    private void initializeUserList(){
        //reads the users into an arraylist
        File te = new File("User Info");
        if(te.exists() == true){
            try
            {
                FileInputStream fis = new FileInputStream("User Info");
                ObjectInputStream ois = new ObjectInputStream(fis);
                headNode = (Users) ois.readObject();
                
                Users currentNode = headNode;
                if(headNode != null){
                    do{
                        if (currentNode.nextNode == null){
                            tailNode = currentNode;
                        }
                        currentNode = currentNode.nextNode;
                    }while(currentNode != null);
                }
                
                ois.close();
                fis.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
                return;
            }catch(ClassNotFoundException c){
                System.out.println("Class not found");
                c.printStackTrace();
                return;
            }
            
            DefaultListModel m = new DefaultListModel();
            Users currentNode = headNode;
            boolean found = false;
            if(headNode != null){//always checks if the headNode is not empty before going anyfurther
                do{
                    m.addElement(currentNode.getName());
                    currentNode = currentNode.nextNode;
                }while(currentNode != null);    
                userList.setModel(m);  
            }
        }else{
            //needs to be changed to show me as a default user
            System.out.println("The library is empty.");
            DefaultListModel ab = new DefaultListModel();
            ab.addElement("There are no Users. Please add them.");
            userList.setModel(ab);
        }
    }
    
    private void initializeBookList(){
        //reads the files in to its respected arraylist
        File tempo = new File("Book Info");
        if(tempo.exists() == true){
            try{
                FileInputStream fis = new FileInputStream("Book Info");
                ObjectInputStream ois = new ObjectInputStream(fis);
                bookHeadNode = (Book) ois.readObject();
                
                Book currentBookNode = bookHeadNode;
                if(bookHeadNode != null){
                    do{
                        if (currentBookNode.nextNode == null){
                            bookTailNode = currentBookNode;
                        }
                        currentBookNode = currentBookNode.nextNode;
                    }while(currentBookNode != null);
                }
                
                ois.close();
                fis.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
                return;
            }catch(ClassNotFoundException c){
                System.out.println("Class not found");
                c.printStackTrace();
                return;
            }
            
            DefaultListModel ab = new DefaultListModel();
            if(bookHeadNode == null){
                ab.addElement("The Catalog is empty. There are no books. Please add them.");
                System.out.println("The file exists but the catalog is empty.");
                displayBookList.setModel(ab);
            }else{
                publishBookList();
            }
        }else{ //if the book file doesn't exist
            System.out.println("The library is empty.");
            DefaultListModel a = new DefaultListModel();
            a.addElement("The Catalog is empty. There are no books. Please add them.");
            displayBookList.setModel(a);
        }
    }
    
    private void initializeLibrarianList(){
        //reads the files in to its respected arraylist
        File temp = new File("Librarian Info");
        if(temp.exists()== true){
            //if the file exists, read it it into the arraylist of users
            try
            {
                FileInputStream fis = new FileInputStream("Librarian Info");
                ObjectInputStream ois = new ObjectInputStream(fis);
                libHeadNode = (Librarian) ois.readObject();
                
                Librarian currentNode = libHeadNode;
                if(libHeadNode != null){
                    do{
                        if(currentNode.nextNode == null){
                            libTailNode = currentNode;
                        }
                        currentNode = currentNode.nextNode;
                    }while(currentNode != null);
                }
                ois.close();
                fis.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
                return;
            }catch(ClassNotFoundException c){
                System.out.println("Class not found");
                c.printStackTrace();
                return;
            }
        }
    }
    
    public void publishBookList(){
        DefaultListModel mnm = new DefaultListModel();
        Book currentBookNode = bookHeadNode;
        if(currentBookNode != null){
            do{
                System.out.println(currentBookNode.title +" Follows: " + currentBookNode.nextNode);
                mnm.addElement(currentBookNode.title);
                currentBookNode = currentBookNode.nextNode;
            }while(currentBookNode != null);
        }
        displayBookList.setModel(mnm);
    }
    
    public void publishUserList(){
        DefaultListModel mnm = new DefaultListModel();
        Users currentUserNode = headNode;
        if(currentUserNode != null){
            do{
                mnm.addElement(currentUserNode.getName());
                currentUserNode = currentUserNode.nextNode;
            }while(currentUserNode != null);
        }
        displayBookList.setModel(mnm);
    }
    
    public void publishBookArrayList(ArrayList<Book> list){
        DefaultListModel mnm = new DefaultListModel();
        for(int i = 0; i< list.size(); i++){
            mnm.addElement(list.get(i).title);
        }
        displayBookList.setModel(mnm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayBookList = new javax.swing.JList<>();
        sortCMB = new javax.swing.JComboBox<>();
        mystery = new javax.swing.JButton();
        fiction = new javax.swing.JButton();
        nFic = new javax.swing.JButton();
        horror = new javax.swing.JButton();
        tech = new javax.swing.JButton();
        romance = new javax.swing.JButton();
        young = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        searchN = new javax.swing.JTextField();
        logout = new javax.swing.JButton();
        createBk = new javax.swing.JButton();
        addUserBook = new javax.swing.JButton();
        RemoveUserBook = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        booksUser = new javax.swing.JList<>();
        selectedUser = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        allGenre = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookInfoDisplay = new javax.swing.JTextArea();
        remLBk = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        titleInput = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jButton7.setText("jButton7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Homepage");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Legacy Library Catalog");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 450, -1));

        displayBookList.setBackground(new java.awt.Color(240, 240, 240));
        displayBookList.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        displayBookList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayBookListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(displayBookList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 410, 160));

        sortCMB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/a", "Author", "Title", "ISBN" }));
        sortCMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortCMBActionPerformed(evt);
            }
        });
        getContentPane().add(sortCMB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, -1));

        mystery.setText("Mystery");
        mystery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mysteryActionPerformed(evt);
            }
        });
        getContentPane().add(mystery, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, -1));

        fiction.setText("Fiction");
        fiction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fictionActionPerformed(evt);
            }
        });
        getContentPane().add(fiction, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, -1));

        nFic.setText("Non-Fiction");
        nFic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nFicActionPerformed(evt);
            }
        });
        getContentPane().add(nFic, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 100, -1));

        horror.setText("Horror");
        horror.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horrorActionPerformed(evt);
            }
        });
        getContentPane().add(horror, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 100, -1));

        tech.setText("Technology");
        tech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                techActionPerformed(evt);
            }
        });
        getContentPane().add(tech, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 100, -1));

        romance.setText("Romance");
        romance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                romanceActionPerformed(evt);
            }
        });
        getContentPane().add(romance, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 100, -1));

        young.setText("Young Adult");
        young.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youngActionPerformed(evt);
            }
        });
        getContentPane().add(young, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Current Users");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, 30));

        searchN.setBackground(new java.awt.Color(240, 240, 240));
        searchN.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        searchN.setText("Search by Last Name");
        searchN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchNActionPerformed(evt);
            }
        });
        searchN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchNKeyTyped(evt);
            }
        });
        getContentPane().add(searchN, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 210, -1));

        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 100, -1));

        createBk.setText("Add Book");
        createBk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBkActionPerformed(evt);
            }
        });
        getContentPane().add(createBk, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 90, 40));

        addUserBook.setText("Add");
        addUserBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBookActionPerformed(evt);
            }
        });
        getContentPane().add(addUserBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 80, -1));

        RemoveUserBook.setText("Remove");
        RemoveUserBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveUserBookActionPerformed(evt);
            }
        });
        getContentPane().add(RemoveUserBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 80, -1));

        booksUser.setBackground(new java.awt.Color(240, 240, 240));
        booksUser.setFocusable(false);
        jScrollPane2.setViewportView(booksUser);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 210, 90));

        selectedUser.setEditable(false);
        selectedUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(selectedUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 210, 30));

        userList.setBackground(new java.awt.Color(240, 240, 240));
        userList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(userList);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 210, 110));

        allGenre.setText("All Genres");
        allGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allGenreActionPerformed(evt);
            }
        });
        getContentPane().add(allGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, -1));

        bookInfoDisplay.setEditable(false);
        bookInfoDisplay.setBackground(new java.awt.Color(240, 240, 240));
        bookInfoDisplay.setColumns(20);
        bookInfoDisplay.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        bookInfoDisplay.setRows(5);
        jScrollPane3.setViewportView(bookInfoDisplay);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 310, -1));

        remLBk.setText("Remove");
        remLBk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remLBkActionPerformed(evt);
            }
        });
        getContentPane().add(remLBk, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 323, 90, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Return Date             Title");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 210, -1));

        titleInput.setBackground(new java.awt.Color(204, 204, 204));
        titleInput.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(titleInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 310, 30));

        searchButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        searchButton.setText("Search");
        searchButton.setToolTipText("");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 90, 30));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LibraryPackage/Bookshelves-Background2.jpg"))); // NOI18N
        jLabel9.setFocusable(false);
        jLabel9.setMaximumSize(new java.awt.Dimension(801000, 445580));
        jLabel9.setMinimumSize(new java.awt.Dimension(800, 480));
        jLabel9.setPreferredSize(new java.awt.Dimension(800, 480));
        jLabel9.setRequestFocusEnabled(false);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
       
    private void romanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_romanceActionPerformed
        boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = bookHeadNode;
        if(bookHeadNode != null){
            do{
                if(currentNode.genre.equals("Romance")){
                    d.addElement(currentNode.title);
                    foundBook = true;
                }
            currentNode = currentNode.nextNode;
            }while(currentNode != null);
                displayBookList.setModel(d);
        }
           
        if(foundBook == false){
            d.addElement("There are no books for the genre Romance.");
            displayBookList.setModel(d);
        }
    }//GEN-LAST:event_romanceActionPerformed

    private void searchNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchNActionPerformed
        // This method searches for the desired name
        DefaultListModel a = new DefaultListModel();
        String text = searchN.getText();
        
        boolean foundUser = false;
        Users currentNode = headNode;
        if(currentNode!= null && !text.equals("")){
            do{
                if(currentNode.last.equalsIgnoreCase(text.trim())){
                    a.addElement(currentNode.getName());
                    foundUser = true;
                }
                currentNode= currentNode.nextNode;
            }while(currentNode != null);
            userList.setModel(a);
        }else if(text.equals("")){
            if(currentNode != null){
                do{
                    a.addElement(currentNode.getName());
                    currentNode = currentNode.nextNode;
                }while(currentNode != null);
                userList.setModel(a);
            }
        }
        if(foundUser == false && !text.equals("")){
            a.addElement("User not found.");
            userList.setModel(a);
        }
        
    }//GEN-LAST:event_searchNActionPerformed

    private void youngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_youngActionPerformed
        boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = bookHeadNode;
        if(bookHeadNode != null){
            do{
                if(currentNode.genre.equals("Young Adult")){
                    d.addElement(currentNode.title);
                    foundBook = true;
                }
            currentNode = currentNode.nextNode;
            }while(currentNode != null);
                displayBookList.setModel(d);
        }
           
        if(foundBook == false){
            d.addElement("There are no books for the genre Young Adult.");
            displayBookList.setModel(d);
        }
    }//GEN-LAST:event_youngActionPerformed

    private void RemoveUserBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveUserBookActionPerformed
        // removes the Book from the user and adds it to the data base
        
        Book temp = null;
        ArrayList<Book> tempArr = currentUser.getArray();//gets the book array of the current user selected
        DefaultListModel example = new DefaultListModel();
        
        String j = booksUser.getSelectedValue();//get the selected Book
        String title ="";
        if(j!=null){
            String [] arr =j.split(" ",2);
            title = arr[1];
        }
        //breaks it up into 2 parts to get the title
        
        System.out.println("Book Title to remove is: "+ title);

        if( title!= null && !title.equalsIgnoreCase("No books checked out.")){ //if the selected value is not null && NO books checked out(default option)
            for(int i = 0; i < tempArr.size(); i++){
                System.out.println(i+ " "+tempArr.get(i).title);
                if(title.trim().equalsIgnoreCase(tempArr.get(i).title.trim())){
                    System.out.println("found a match");
                    temp = tempArr.remove(i);
                    System.out.println(temp.title);//it got here
                }
            }

            if(temp != null){
                System.out.println(temp.title);
                currentUser.setArray(tempArr);
                currentUser.checkedout--;
                System.out.println("Down Here;"); 
                Book newNode = new Book (temp.title, temp.an1, temp.an2,temp.number, temp.date, temp.genre, null);
                if(bookHeadNode == null){
                    bookHeadNode = newNode;
                    
                }else{
                    Book currentNode = bookHeadNode;
                    boolean added = false;
                    do{
                        if(currentNode.nextNode== null){
                            currentNode.nextNode = newNode;
                            added = true;
                        }
                        currentNode = currentNode.nextNode;
                        System.out.println(currentNode.title);
                    }while(added == false);
                }
                bookTailNode = newNode;
                System.out.println("The title is " + bookTailNode.title);
            }
            publishBookList();
            
            Users currentNode = headNode;
            do{
                if(currentNode.userName.equals(currentUser.userName) && currentNode.first.equalsIgnoreCase(currentUser.first)&& currentNode.last.equalsIgnoreCase(currentUser.last)){
                    currentNode = currentUser;
                }
                currentNode = currentNode.nextNode;
            }while(currentNode != null);
            
            
            for(int i = 0; i< currentUser.getArray().size(); i++){
                example.addElement("["+currentUser.getArray().get(i).returndate+"]  " +currentUser.getArray().get(i).title);
            }
            booksUser.setModel(example);

            publishBookList();
        }
        
        File temp1 = new File("User Info");
        File temp2 = new File("Book Info");
        if(temp1.exists() == true && temp2.exists() == true){
            try{
                FileOutputStream fos= new FileOutputStream("Book Info");
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                oos.writeObject(bookHeadNode); //this is a way to store the arraylist in a file
                oos.close();
                fos.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        
            try{
                FileOutputStream fos= new FileOutputStream("User Info");
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                oos.writeObject(headNode); //this is a way to store the arraylist in a file
                oos.close();
                fos.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }//GEN-LAST:event_RemoveUserBookActionPerformed

    private void addUserBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBookActionPerformed
        //checkout books to user
        DefaultListModel a = new DefaultListModel();
        Calendar cad = Calendar.getInstance();
        cad.add(Calendar.WEEK_OF_YEAR, +3); //the date after 3 weeks have gone by
        
        String t = displayBookList.getSelectedValue();//the title of the Book we want to add to the user
        if(!selectedUser.getText().equals("") && selectedUser.getText() != null && displayBookList.getSelectedValue() != null && !displayBookList.getSelectedValue().equalsIgnoreCase("The Catalog is empty. There are no books. Please add them.")){
            if(t!= null && !t.equalsIgnoreCase("No books checked out.")){ //if the title isn't a null pointer 
                Book currentNode = bookHeadNode;
                do{
                    if(t.equalsIgnoreCase(currentNode.title)){
                        currentNode.returndate = ""+(cad.get(Calendar.MONTH) + 1) + "-" + cad.get(Calendar.DATE) + "-" + cad.get(Calendar.YEAR);
                        currentUser.addBook(currentNode);
                        currentUser.checkedout++;
                        removeBook(currentNode);
                        //add the book to the user and remove the currentBook node from the linked list of book
                    }
                    currentNode = currentNode.nextNode;
                }while(currentNode!= null);
                publishBookList();
                
                /*for(int i = 0; i < booklist.size(); i++){ //loop through the Book list for the selected Book
                    if(t.equalsIgnoreCase(booklist.get(i).title)){ //if the books match
                        //booklist.get(i).returndate = ""+(cad.get(Calendar.MONTH) + 1) + "-" + cad.get(Calendar.DATE) + "-" + cad.get(Calendar.YEAR);
                        current.addBook(booklist.get(i)); 
                        current.checkedout++;
                        booklist.remove(i); //remove the Book from the arraylist
                        System.out.println("the user was added the book and the book was removed.");
                    }
                }*/
                /*for(int i = 0; i< printList.size(); i++){
                    if(t.equalsIgnoreCase(printList.get(i).title)){
                        printList.remove(i);//the display is updated with the Book gone
                    }
                }
                publishList();*/
            }
        }
        
        Users currentUserNode = headNode;
        do{
            if(currentUserNode.userName.equalsIgnoreCase(currentUser.userName) && currentUserNode.first.equalsIgnoreCase(currentUser.first) && currentUserNode.last.equalsIgnoreCase(currentUser.last) ){
                currentUserNode = currentUser;
            }
            currentUserNode = currentUserNode.nextNode;
        }while(currentUserNode != null);
        
        /*for(int i = 0; i< list.size(); i++){
            if(list.get(i).userName.equalsIgnoreCase(current.userName) && list.get(i).first.equalsIgnoreCase(current.first) && list.get(i).last.equalsIgnoreCase(current.last) ){
                list.set(i, current);
            }
        }*/

        for(int i = 0; i< currentUser.getArray().size(); i++){
            a.addElement("[" +currentUser.getArray().get(i).returndate +"]  "+currentUser.getArray().get(i).title );//write in the list the books that have been added
        }
        booksUser.setModel(a);

        //update the booklist in the file
        File temp1 = new File("User Info");
        File temp2 = new File("Book Info");
        if(temp1.exists() == true && temp2.exists() == true){
            try{
                FileOutputStream fos= new FileOutputStream("Book Info");
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                oos.writeObject(bookHeadNode); //this is a way to store the arraylist in a file
                oos.close();
                fos.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        
            try{
                FileOutputStream fos= new FileOutputStream("User Info");
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                oos.writeObject(headNode); //this is a way to store the arraylist in a file
                oos.close();
                fos.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }//GEN-LAST:event_addUserBookActionPerformed

    public void removeBook(Book temp){
        Book currentNode = bookHeadNode;
        if(currentNode !=null){//headnode
            if(currentNode.nextNode == null && temp.title.equals(currentNode.title)){
                bookHeadNode = null;
                bookTailNode = null;
                currentNode = null;
                System.out.println("Was down here");
            }
            publishBookList();
        }
        if(bookHeadNode != null){
            if(temp.title.equals(currentNode.title)){
                bookHeadNode = currentNode.nextNode;
            }
        }
        
        if(bookHeadNode != null){
                do{
                    if(currentNode.nextNode != null){
                        if(currentNode.nextNode.title.equals(temp.title) ){
                            currentNode.nextNode = currentNode.nextNode.nextNode;
                        }
                    }
                currentNode = currentNode.nextNode;
                }while(currentNode != null);    
      }
      publishBookList();
    }
    
    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        //takes you back to the start gui page//here we need to be updating the Book info file
        
        File temp1 = new File("User Info");
        File temp2 = new File("Book Info");
        File temp3 = new File("Librarian Info");
        if(temp1.exists() == true && temp2.exists() == true && temp3.exists()){
            try{
                FileOutputStream fos= new FileOutputStream("Book Info");
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                oos.writeObject(bookHeadNode); //this is a way to store the arraylist in a file
                oos.close();
                fos.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        
            try{
                FileOutputStream fos= new FileOutputStream("User Info");
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                oos.writeObject(headNode); //this is a way to store the arraylist in a file
                oos.close();
                fos.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
            
            try{
                FileOutputStream fos= new FileOutputStream("Librarian Info");
                ObjectOutputStream oos= new ObjectOutputStream(fos);
                oos.writeObject(libHeadNode); //this is a way to store the arraylist in a file
                oos.close();
                fos.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        this.dispose();
        LibrarianLogin start = new LibrarianLogin();
        start.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void createBkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBkActionPerformed
        // add a new Book to the library
        this.dispose();
        CreateBooks nbook = new CreateBooks(bookHeadNode, bookTailNode, currentLib);
        //the booklist is passed in so the new Book will be added to the booklist
        nbook.setVisible(true);
    }//GEN-LAST:event_createBkActionPerformed

    private void allGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allGenreActionPerformed
        // TODO add your handling code here
        DefaultListModel d = new DefaultListModel();
        if(bookHeadNode == null){
            d.addElement("The Library is Empty. Please add a book.");
            displayBookList.setModel(d);
        }else{
            publishBookList();
        }
    }//GEN-LAST:event_allGenreActionPerformed

    private void mysteryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mysteryActionPerformed
        boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = bookHeadNode;
        if(bookHeadNode != null){
            do{
                if(currentNode.genre.equals("Mystery")){
                    d.addElement(currentNode.title);
                    foundBook = true;
                }
            currentNode = currentNode.nextNode;
            }while(currentNode != null);
                displayBookList.setModel(d);
        }
           
        if(foundBook == false){
            d.addElement("There are no books for the genre Mystery.");
            displayBookList.setModel(d);
        }
    }//GEN-LAST:event_mysteryActionPerformed

    private void fictionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fictionActionPerformed
        boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = bookHeadNode;
        if(bookHeadNode != null){
            do{
                if(currentNode.genre.equals("Fiction")){
                    d.addElement(currentNode.title);
                    foundBook = true;
                }
            currentNode = currentNode.nextNode;
            }while(currentNode != null);
                displayBookList.setModel(d);
        }
           
        if(foundBook == false){
            d.addElement("There are no books for the genre Fiction.");
            displayBookList.setModel(d);
        }
    }//GEN-LAST:event_fictionActionPerformed

    private void nFicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nFicActionPerformed
        boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = bookHeadNode;
        if(bookHeadNode != null){
            do{
                if(currentNode.genre.equals("Non-Fiction")){
                    d.addElement(currentNode.title);
                    foundBook = true;
                }
            currentNode = currentNode.nextNode;
            }while(currentNode != null);
                displayBookList.setModel(d);
        }
           
        if(foundBook == false){
            d.addElement("There are no books for the genre Non-Fiction.");
            displayBookList.setModel(d);
        }
    }//GEN-LAST:event_nFicActionPerformed

    private void horrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horrorActionPerformed
       boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = bookHeadNode;
        if(bookHeadNode != null){
            do{
                if(currentNode.genre.equals("Horror")){
                    d.addElement(currentNode.title);
                    foundBook = true;
                }
            currentNode = currentNode.nextNode;
            }while(currentNode != null);
                displayBookList.setModel(d);
        }
           
        if(foundBook == false){
            d.addElement("There are no books for the genre Horror.");
            displayBookList.setModel(d);
        }
    }//GEN-LAST:event_horrorActionPerformed

    private void techActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_techActionPerformed
        boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = bookHeadNode;
        if(bookHeadNode != null){ //if the head node is not null
            do{
                if(currentNode.genre.equals("Technology")){//if the currentNode's genre is equal to Technology
                    d.addElement(currentNode.title); //addi it to the model 
                    foundBook = true; //there is at least one Technology book
                }
            currentNode = currentNode.nextNode;
            }while(currentNode != null); //will run until node is equal to null
                displayBookList.setModel(d);
        }
           
        if(foundBook == false){
            d.addElement("There are no books for the genre Technology.");
            displayBookList.setModel(d);
        }
    }//GEN-LAST:event_techActionPerformed

    private void remLBkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remLBkActionPerformed
        //remove book from the libraray
        String tt = ""; //title of the Book that you want to remove
        if(displayBookList.getSelectedValue() != null){
            tt = displayBookList.getSelectedValue();
        }
         
        Book currentNode = bookHeadNode;
        if(currentNode !=null){//headnode
            if(currentNode.nextNode == null && tt.equals(currentNode.title)){
                bookHeadNode = null;
                bookTailNode = null;
                currentNode = null;
                System.out.println("Was down here");
            }
            publishBookList();
        }
        if(bookHeadNode != null){
            if(tt.equals(currentNode.title)){
                bookHeadNode = currentNode.nextNode;
            }
        }
        
        if(bookHeadNode != null){
                do{
                    if(currentNode.nextNode != null){
                        if(currentNode.nextNode.title.equals(tt) ){
                            currentNode.nextNode = currentNode.nextNode.nextNode;
                        }
                    }
                currentNode = currentNode.nextNode;
                }while(currentNode != null);    
      }
        publishBookList();
        try{
            FileOutputStream fos= new FileOutputStream("Book Info");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(bookHeadNode); //this is a way to store the arraylist in a file
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }//GEN-LAST:event_remLBkActionPerformed

    private void searchNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchNKeyTyped
        //limits the characters to only alphabets
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
            evt.consume();
    }//GEN-LAST:event_searchNKeyTyped

    private void displayBookListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayBookListMouseClicked
        // TODO add your handling code here:
        String tt = "";
        if(displayBookList.getSelectedValue() != null){
            tt = displayBookList.getSelectedValue();
        }
        
        Book currentNode = bookHeadNode;
        if(!(tt.equals(""))){ //if the selcted value is not null
            if(bookHeadNode != null){
                do{
                    if (currentNode.title.equals(tt)){
                         bookInfoDisplay.setText("Title: " +currentNode.title+"\nAuthor: "+currentNode.an1 +" " + currentNode.an2+"\nGenre: "+currentNode.genre+"\nISBN: "+currentNode.number+"\nYear Published: "+ currentNode.date);
                        }
                currentNode = currentNode.nextNode;
                }while(currentNode != null);
            }
        }
    }//GEN-LAST:event_displayBookListMouseClicked

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DefaultListModel a = new DefaultListModel();
        JFrame frame = new JFrame();
        
        String search = titleInput.getText();//gets the inputted last Name
        
        Book currentNode = bookHeadNode;
        boolean found = false;
        if(search.isEmpty()== false){
            if(currentNode != null){//always checks if the headNode is not empty before going anyfurther
                do{
                    if(currentNode.title.toUpperCase().trim().matches(search.toUpperCase().trim())){
                        a.addElement(currentNode.title);
                        found = true;
                    }
                    currentNode = currentNode.nextNode;
                }while(currentNode != null);    
                    
                //if found the Player update the list, or else keep it empty
                if(found == true){
                    displayBookList.setModel(a);
                }
            }
        }
            
        if(search.isEmpty() == false){//if inputed something
            if(found == false){//if Player not found
                displayBookList.setModel(a); //sets the display list to nothing
                JOptionPane.showMessageDialog(frame,"Book not Found.");
            }
        }
            
        if(search.isEmpty() == true){//if the search Field is blank then display all the players
            publishBookList();
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void sortCMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortCMBActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String item = (String)sortCMB.getSelectedItem();//gets the selected sort option
        
        //turning all the nodes in to an arryalist for easier sorting
        ArrayList<Book> bookList = new ArrayList<>();

        Book currentNode = bookHeadNode;
        int nodeNum = -1; //loops through the linked list and turns it into an arraylist
        if(bookHeadNode != null){ //loop through the entire node list and add it to an arraylist
            do
            {//do while loop is used to traverse the linked list 
                nodeNum++;              
                bookList.add(currentNode);//the elements of the linked list are added to the booklist
                currentNode = currentNode.nextNode;
            }while(currentNode != null);
        }//all the nodes added to a book List
        
        if(item != null){
            //the bubble sort is used here
            if(item.equals("ISBN")){
                Book temp = null;
                for(int i = 0; i< bookList.size()-1; i++){
                    for(int j = 0; j < bookList.size()-(i+1); j++ ){
                        if(bookList.get(j).number > bookList.get(j+1).number){
                            temp = bookList.get(j);
                            bookList.set(j, bookList.get(j+1));
                            bookList.set(j+1, temp); 
                        }
                    }
                }
                publishBookArrayList(bookList);
            }else if(item.equals("Title")){
            Book temp = null;
            for(int i = 0 ; i < bookList.size(); i++){
                for(int j = 1; j < bookList.size()-i; j++){
                    if(bookList.get(j-1).title.toLowerCase().compareTo(bookList.get(j).title.toLowerCase()) > 0){
                        temp = bookList.get(j-1);
                        bookList.set(j-1, bookList.get(j));
                        bookList.set(j, temp);
                    }
                }
            }
            publishBookArrayList(bookList);
        }else if(item.equals("Author")){
            Book temp = null;
            for(int i = 0; i < bookList.size(); i++){
                for(int j = 1; j < bookList.size()-1; j++){
                    if(bookList.get(j-1).an2.toLowerCase().compareTo(bookList.get(j).an2.toLowerCase()) > 0){
                        temp = bookList.get(j-1);
                        bookList.set(j-1, bookList.get(j));
                        bookList.set(j, temp);
                    }
                }
            }
            publishBookArrayList(bookList);
        }
        }
    }//GEN-LAST:event_sortCMBActionPerformed

    private void userListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userListMouseClicked
        // TODO add your handling code here:
        DefaultListModel a = new DefaultListModel();
        
        boolean yesBooks = false; 
        String st = "";
        if(userList.getSelectedValue() != null && !userList.getSelectedValue().equalsIgnoreCase("User Not Found.")){
            st = userList.getSelectedValue();//get the name of the selected user
            System.out.println("This is the selected User: " + userList.getSelectedValue());
        }
        
        selectedUser.setText(st); //so we know what user we're looking at
        
        Users currentNode = headNode;
        if(currentNode!= null){
            do{
                if(currentNode.getName().equalsIgnoreCase(st.trim())){
                    currentUser = currentNode;
                    for(int i = 0; i < currentUser.getArray().size(); i++ ){
                        a.addElement("["+currentUser.getArray().get(i).returndate +"]  "+currentUser.getArray().get(i).title );
                        yesBooks = true;
                    }
                }
                currentNode = currentNode.nextNode;
            }while(currentNode != null);    
        }
        
        if(yesBooks == false && !(selectedUser.getText().equals(""))){
            a.addElement("No books checked out."); //if the user has no books
        }
        booksUser.setModel(a);
    }//GEN-LAST:event_userListMouseClicked
   
   
    /**
     * @param the command line arguments
     
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel 
        

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUser().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RemoveUserBook;
    private javax.swing.JButton addUserBook;
    private javax.swing.JButton allGenre;
    private javax.swing.JTextArea bookInfoDisplay;
    private javax.swing.JList<String> booksUser;
    private javax.swing.JButton createBk;
    private javax.swing.JList<String> displayBookList;
    private javax.swing.JButton fiction;
    private javax.swing.JButton horror;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton logout;
    private javax.swing.JButton mystery;
    private javax.swing.JButton nFic;
    private javax.swing.JButton remLBk;
    private javax.swing.JButton romance;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchN;
    private javax.swing.JTextField selectedUser;
    private javax.swing.JComboBox<String> sortCMB;
    private javax.swing.JButton tech;
    private javax.swing.JTextField titleInput;
    private javax.swing.JList<String> userList;
    private javax.swing.JButton young;
    // End of variables declaration//GEN-END:variables

    
}

