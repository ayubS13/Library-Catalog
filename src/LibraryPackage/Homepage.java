/*
 * Ayub Shahab
 * Computer Science IA
 * 08/28
 */
package LibraryPackage;

import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.io.Serializable;
public class Homepage extends javax.swing.JFrame implements Serializable {
    //head and tail nodes used to traverse books linked list
    private static Book headNode;
    private static Book tailNode; 
    
    private static Users userHeadNode;
    private static Users userTailNode;
    
    private Users userLogIn = null; //the current user logged in
    
    //private ArrayList<Users> some = new ArrayList<>();//all the users
    //private ArrayList<Book> bklist = new ArrayList<>(); //all the books in the system.
    //private ArrayList<Book> displaylist = new ArrayList<>(); //the books being displayed
    
    public Homepage(Users currentUser, Users userHeadNode, Users userTailNode) { //pass in the arraylist and the current user that has logged in
        initComponents();
        printUserInfo(currentUser); //print al the info of the user logged in to the screen
        userLogIn = currentUser; //the user gets set to a class user object for easier management
        //some = hello; //the arraylist gets set to class arraylist for easier management
        this.userHeadNode = userHeadNode;
        this.userTailNode = userTailNode;
        readBookInfo();
    }
    
    //prints the info associated with the user at the left side of the screen int  he database upon login
    private void printUserInfo(Users john){
        myStats.append("Name: " + john.first + " " + john.last);
        myStats.append("\nAge: "+ john.ag);
        myStats.append("\nUsername: " + john.userName);
        myStats.append("\nPassword: "+john.password);
        myStats.append("\nPhone Number: ");
        myStats.append("\n     "+john.phonenumber);
        myStats.append("\nBooks Checked Out: "+ john.checkedout);
        myStats.append("\nReturn Date     Title");
        if(john.checkedout > 0){
            for(int i = 0; i < john.getArray().size(); i++){
                myStats.append("\n"+john.getArray().get(i).returndate+"       "+john.getArray().get(i).title);
            }
        }
    }
    
    /*
    Precondition: the book list is empty of books
    Postcondition: the list is filled with books and all the books are displayed on the screen
    Acitvity: reads the file and puts all the books in the list and prints all the books on the screen
    */
    private void readBookInfo(){
        //reads the files in to its respected arraylist
        File tempo = new File("Book Info");
        if(tempo.exists() == true){
            try{ //try -catch  statement
                FileInputStream fis = new FileInputStream("Book Info");
                ObjectInputStream ois = new ObjectInputStream(fis);
                headNode = (Book) ois.readObject(); //read the arraylist of books into bkList
                Book currentNode = headNode;
                int nodeNum = -1;
                if(headNode != null){
                    do{
                        nodeNum++;
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
            }catch(ClassNotFoundException c){ //if the file doesn't exist
                System.out.println("Class not found");
                c.printStackTrace();
                return;
            }
            
            DefaultListModel ab = new DefaultListModel();
            if(headNode == null){
                ab.addElement("The Catalog is empty. There are no books. Please contact the librarian..");
                //System.out.println("The file exists but the catalog is empty.");
                displayBooks.setModel(ab); //print out on the screen the library is empty
            }else{
                displayBookList(); 
            }
        }else{
            System.out.println("The library is empty.");
            
            //if there are no books in the library
            DefaultListModel a = new DefaultListModel();
            a.addElement("The Catalog is empty. There are no books. Please contact the librarian.");
            displayBooks.setModel(a);
        }
    
    }
    /*
    Precondition: the books are in the file but are not visible to the user
    Postcondition: displays the books to the user
    Acitivity: There is a difference between the books that are in the system and the ones that are visible to the user
               if the books are sorted by genre, author, tile, and isbn, they are put in to this array and this is displayed
               instead of the entire books collection
    */
    private void displayBookList(){
        DefaultListModel a = new DefaultListModel();
        Book currentNode = headNode;
            if(headNode != null){
                do{
                    a.addElement(currentNode.title);
            currentNode = currentNode.nextNode;
        }while(currentNode != null);}
        displayBooks.setModel(a);
    }
    
    private void displayBookArrayList(ArrayList<Book> temp){
        DefaultListModel a = new DefaultListModel();
        for(int i = 0; i< temp.size(); i++){
            a.addElement(temp.get(i).title);
        }
        displayBooks.setModel(a);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        fiction = new javax.swing.JButton();
        mystery = new javax.swing.JButton();
        youngA = new javax.swing.JButton();
        nonFic = new javax.swing.JButton();
        horror = new javax.swing.JButton();
        romance = new javax.swing.JButton();
        tech = new javax.swing.JButton();
        sortComboBox = new javax.swing.JComboBox<>();
        logout = new javax.swing.JButton();
        update = new javax.swing.JButton();
        allgenre = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayBooks = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        proptext = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        myStats = new javax.swing.JTextArea();
        titleInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Library Project");
        setBackground(new java.awt.Color(0, 255, 204));
        setMaximumSize(new java.awt.Dimension(880, 540));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Legacy Library Catalog");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        fiction.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fiction.setText("Fiction");
        fiction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fictionActionPerformed(evt);
            }
        });
        getContentPane().add(fiction, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, 110, -1));

        mystery.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mystery.setText("Mystery");
        mystery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mysteryActionPerformed(evt);
            }
        });
        getContentPane().add(mystery, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 110, -1));

        youngA.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        youngA.setText("Young Adult");
        youngA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youngAActionPerformed(evt);
            }
        });
        getContentPane().add(youngA, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 110, -1));

        nonFic.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nonFic.setText("Non-Fiction");
        nonFic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonFicActionPerformed(evt);
            }
        });
        getContentPane().add(nonFic, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 110, -1));

        horror.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        horror.setText("Horror");
        horror.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horrorActionPerformed(evt);
            }
        });
        getContentPane().add(horror, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 110, -1));

        romance.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        romance.setText("Romance");
        romance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                romanceActionPerformed(evt);
            }
        });
        getContentPane().add(romance, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 110, -1));

        tech.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tech.setText("Technology");
        tech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                techActionPerformed(evt);
            }
        });
        getContentPane().add(tech, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, 110, -1));

        sortComboBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        sortComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N/a", "Title", "Author", "ISBN" }));
        sortComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(sortComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 110, -1));

        logout.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 80, -1));

        update.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        update.setText("Edit Info");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 80, -1));

        allgenre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        allgenre.setText("All Genres");
        allgenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allgenreActionPerformed(evt);
            }
        });
        getContentPane().add(allgenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 110, -1));

        displayBooks.setBackground(new java.awt.Color(240, 240, 240));
        displayBooks.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        displayBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayBooksMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(displayBooks);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 380, 170));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("My Portfolio");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        searchButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        searchButton.setText("Search");
        searchButton.setToolTipText("");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 70, 30));

        proptext.setEditable(false);
        proptext.setBackground(new java.awt.Color(240, 240, 240));
        proptext.setColumns(20);
        proptext.setRows(5);
        jScrollPane3.setViewportView(proptext);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 380, -1));

        myStats.setEditable(false);
        myStats.setBackground(new java.awt.Color(240, 240, 240));
        myStats.setColumns(20);
        myStats.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        myStats.setRows(5);
        myStats.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        myStats.setMaximumSize(new java.awt.Dimension(4, 26));
        jScrollPane5.setViewportView(myStats);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 200, 280));

        titleInput.setBackground(new java.awt.Color(204, 204, 204));
        titleInput.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(titleInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 300, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LibraryPackage/Bookshelves-Background2.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setMaximumSize(new java.awt.Dimension(800, 500));
        jLabel5.setMinimumSize(new java.awt.Dimension(800, 500));
        jLabel5.setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 480));

        getAccessibleContext().setAccessibleName("Library Catalog");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*
    Precondition: the display list is filled with other books
    Postcondition: the display list is filled with the correct type of books
    Activity: goes through the list of all the books and adds the ones with the mystery genre to the display list
              there is a difference between the display list of books and the list of all the books
    */
    private void mysteryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mysteryActionPerformed
    boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = headNode;
            if(headNode != null){
                do{
                    if(currentNode.genre.equals("Mystery")){
                        d.addElement(currentNode.title);
                        foundBook = true;
                    }
                currentNode = currentNode.nextNode;
                }while(currentNode != null);
                displayBooks.setModel(d);
            }
        
        if(foundBook == false){
            d.addElement("There are no books for the genre Mystery.");
            displayBooks.setModel(d);
        }
    }//GEN-LAST:event_mysteryActionPerformed

    /*
    Precondition: the display list is filled with other books
    Postcondition: the display list is filled with the correct type of books
    Activity: goes through the list of all the books and adds the ones with the romance genre to the display list
              there is a difference between the display list of books and the list of all the books
    */
    private void romanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_romanceActionPerformed
        boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = headNode;
            if(headNode != null){
                do{
                    if(currentNode.genre.equals("Romance")){
                        d.addElement(currentNode.title);
                        foundBook = true;
                    }
                currentNode = currentNode.nextNode;
                }while(currentNode != null);
                displayBooks.setModel(d);
            }
        
        if(foundBook == false){
            d.addElement("There are no books for the genre Romance.");
            displayBooks.setModel(d);
        }
    }//GEN-LAST:event_romanceActionPerformed
    
    //updates the file with the current user and logs out to the start page
    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // logs out and takes you to the login screen
        this.dispose();
        StartPage homepage = new StartPage();
        homepage.setVisible(true);
        //here the arraylist is serialized as a way to store it in a file
        //it updates the file of any changes with in the arraylist
        try{ //write to file
            //turn the arraylist into a stream of bytes
            FileOutputStream fos= new FileOutputStream("User Info");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(userHeadNode); //this is a way to store the arraylist in a file
            oos.close();
            fos.close();
        }catch(IOException ioe){  //catch exception
        }
        
    }//GEN-LAST:event_logoutActionPerformed

    //takes the user to the update screen 
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        this.dispose();
        UpdateUser upgrade = new UpdateUser(userLogIn, userHeadNode, userTailNode);//pass in the arraylist and the current user
        upgrade.setVisible(true);
    }//GEN-LAST:event_updateActionPerformed

    /*
    Precondition: the display list is filled with other books
    Postcondition: the display list is filled with the all the books
    Activity: goes through the list of all the books and adds them to the display list
              there is a difference between the display list of books and the list of all the books
    */
    private void allgenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allgenreActionPerformed
       boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = headNode;
            if(headNode != null){
                foundBook = true;
                displayBookList();
            }       
        
        if(foundBook == false){
            d.addElement("There are no books in the Library. Please Contact the Librarian");
            displayBooks.setModel(d);
        }
    }//GEN-LAST:event_allgenreActionPerformed

    /*
    Precondition: the display list is filled with other books
    Postcondition: the display list is filled with the correct type of books
    Activity: goes through the list of all the books and adds the ones with the young adult genre to the display list
              there is a difference between the display list of books and the list of all the books
    */
    private void youngAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_youngAActionPerformed
        boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = headNode;
            if(headNode != null){
                do{
                    if(currentNode.genre.equals("Young Adult")){
                        d.addElement(currentNode.title);
                        foundBook = true;
                    }
                currentNode = currentNode.nextNode;
                }while(currentNode != null);
                displayBooks.setModel(d);
            }
        
        if(foundBook == false){
            d.addElement("There are no books for the genre Young Adult.");
            displayBooks.setModel(d);
        }
    }//GEN-LAST:event_youngAActionPerformed

    /*
    Precondition: the display list is filled with other books
    Postcondition: the display list is filled with the correct type of books
    Activity: goes through the list of all the books and adds the ones with the horror genre to the display list
              there is a difference between the display list of books and the list of all the books
    */
    private void horrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horrorActionPerformed
        boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = headNode;
            if(headNode != null){
                do{
                    if(currentNode.genre.equals("Horror")){
                        d.addElement(currentNode.title);
                        foundBook = true;
                    }
            currentNode = currentNode.nextNode;
        }while(currentNode != null);
             displayBooks.setModel(d);
            }
        
        if(foundBook == false){
            d.addElement("There are no books for the genre Horror.");
            displayBooks.setModel(d);
        }
    }//GEN-LAST:event_horrorActionPerformed

    /*
    Precondition: the display list is filled with other books
    Postcondition: the display list is filled with the correct type of books
    Activity: goes through the list of all the books and adds the ones with the technology genre to the display list
              there is a difference between the display list of books and the list of all the books
    */
    private void techActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_techActionPerformed
        boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = headNode;
            if(headNode != null){
                do{
                    if(currentNode.genre.equals("Technology")){
                        d.addElement(currentNode.title);
                        foundBook = true;
                    }
            currentNode = currentNode.nextNode;
        }while(currentNode != null);
             displayBooks.setModel(d);
            }
        
        
        if(foundBook == false){
            d.addElement("There are no books for the genre Technology.");
            displayBooks.setModel(d);
        }
    }//GEN-LAST:event_techActionPerformed

    /*
    Precondition: the display list is filled with other books
    Postcondition: the display list is filled with the correct type of books
    Activity: goes through the list of all the books and adds the ones with the non-fiction genre to the display list
              there is a difference between the display list of books and the list of all the books
    */
    private void nonFicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonFicActionPerformed
        boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = headNode;
            if(headNode != null){
                do{
                    if(currentNode.genre.equals("Non-Fiction")){
                        d.addElement(currentNode.title);
                        foundBook = true;
                    }
            currentNode = currentNode.nextNode;
        }while(currentNode != null);
             displayBooks.setModel(d);
            }
        
        
        if(foundBook == false){
            d.addElement("There are no books for the genre Non-Fiction.");
            displayBooks.setModel(d);
        }
    }//GEN-LAST:event_nonFicActionPerformed

    /*
    Precondition: the display list is filled with other books
    Postcondition: the display list is filled with the correct type of books
    Activity: goes through the list of all the books and adds the ones with the fiction genre to the display list
              there is a difference between the display list of books and the list of all the books
    */
    private void fictionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fictionActionPerformed
        boolean foundBook = false;
        DefaultListModel d = new DefaultListModel();

        Book currentNode = headNode;
            if(headNode != null){
                do{
                    if(currentNode.genre.equals("Fiction")){
                        d.addElement(currentNode.title);
                        foundBook = true;
                    }
            currentNode = currentNode.nextNode;
        }while(currentNode != null);
             displayBooks.setModel(d);
            }
        
        
        if(foundBook == false){
            d.addElement("There are no books for the genre Fiction.");
            displayBooks.setModel(d);
        }
    }//GEN-LAST:event_fictionActionPerformed

    /*
    Precondition: the display list is filled with  books
    Postcondition: the display list is filled with sorted books based on the user selection of title, author, isbn 
    Activity: display list is filled with all the books or the specific genre
              the books in the list are sorted based on the selection of the user and displayed on the screen
    */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DefaultListModel a = new DefaultListModel();
        JFrame frame = new JFrame();
        
        String search = titleInput.getText();//gets the inputted last Name
        
        Book currentNode = headNode;
        System.out.println(headNode.title);
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
                    displayBooks.setModel(a);
                }
            }
        }
            
        if(search.isEmpty() == false){//if inputed something
            if(found == false){//if Player not found
                displayBooks.setModel(a); //sets the display list to nothing
                JOptionPane.showMessageDialog(frame,"Book not Found.");
            }
        }
            
        if(search.isEmpty() == true){//if the search Field is blank then display all the players
            displayBookList();
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void displayBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayBooksMouseClicked
        // TODO add your handling code here:
        //gets the title of the selected book
        String tt = "";
        if(displayBooks.getSelectedValue() != null){
            tt = displayBooks.getSelectedValue();
        }
        
        Book currentNode = headNode;
        int nodeNum = -1;
        if(!(tt.equals(""))){ //if the selcted value is not null
            if(headNode != null){
                do{
                    nodeNum++;
                    if (currentNode.title.equals(tt)){
                         proptext.setText("Title: " +currentNode.title+"\nAuthor: "+currentNode.an1 +" " + currentNode.an2+"\nGenre: "+currentNode.genre+"\nISBN: "+currentNode.number+"\nYear Published: "+ currentNode.date);
                        }
                currentNode = currentNode.nextNode;
                }while(currentNode != null);
            }
        }
      
    }//GEN-LAST:event_displayBooksMouseClicked

    private void sortComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortComboBoxActionPerformed
        // TODO add your handling code here:
        String item = (String)sortComboBox.getSelectedItem();//gets the selected sort option
        
        //turning all the nodes in to an arryalist for easier sorting
        ArrayList<Book> bookList = new ArrayList<>();

        Book currentNode = headNode;
        int nodeNum = -1; //loops through the linked list and turns it into an arraylist
        if(headNode != null){ //loop through the entire node list and add it to an arraylist
            do
            {
                nodeNum++;
                bookList.add(currentNode);
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
            displayBookArrayList(bookList);
        }else if(item.equals("Title")){
            Book temp = null;
            for(int i = 0 ; i < bookList.size(); i++){
                for(int j = 1; j < bookList.size()-i; j++){
                    if(bookList.get(j-1).title.toUpperCase().compareTo(bookList.get(j).title.toUpperCase()) > 0){
                        temp = bookList.get(j-1);
                        bookList.set(j-1, bookList.get(j));
                        bookList.set(j, temp);
                    }
                }
            }
            displayBookArrayList(bookList);
        }else if(item.equals("Author")){
            Book temp = null;
            for(int i = 0; i < bookList.size(); i++){
                for(int j = 1; j < bookList.size()-1; j++){
                    if(bookList.get(j-1).an2.toUpperCase().compareTo(bookList.get(j).an2.toUpperCase()) > 0){
                        temp = bookList.get(j-1);
                        bookList.set(j-1, bookList.get(j));
                        bookList.set(j, temp);
                    }
                }
            }
            displayBookArrayList(bookList);
        }
        }

    }//GEN-LAST:event_sortComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allgenre;
    private javax.swing.JList<String> displayBooks;
    private javax.swing.JButton fiction;
    private javax.swing.JButton horror;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton logout;
    private javax.swing.JTextArea myStats;
    private javax.swing.JButton mystery;
    private javax.swing.JButton nonFic;
    private javax.swing.JTextArea proptext;
    private javax.swing.JButton romance;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> sortComboBox;
    private javax.swing.JButton tech;
    private javax.swing.JTextField titleInput;
    private javax.swing.JButton update;
    private javax.swing.JButton youngA;
    // End of variables declaration//GEN-END:variables
}
