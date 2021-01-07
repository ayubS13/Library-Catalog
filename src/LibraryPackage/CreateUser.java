/*
 * Ayub Shahab
 * Computer Science IA
 * 08/28
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


public class CreateUser extends javax.swing.JFrame {

    private static Users headNode;
    private static Users tailNode;
    
    private static Librarian libHeadNode;
    private static Librarian libTailNode;
    
    
   
    private String creating ="";
    
    public CreateUser(Users headNode, Users tailNode) { //used for created users 
        initComponents();
        creating = "User";

    }
    public CreateUser(String create){ //used for creating librarians
         initComponents();
         creating = create;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        newFName = new javax.swing.JTextField();
        newAge = new javax.swing.JTextField();
        newLName = new javax.swing.JTextField();
        newUserName = new javax.swing.JTextField();
        newPass = new javax.swing.JTextField();
        phoneNumber = new javax.swing.JTextField();
        create = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create User Account");
        setMinimumSize(new java.awt.Dimension(800, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Account");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 349, 33));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Age");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone  Number");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, -1));

        newFName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        newFName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newFNameKeyTyped(evt);
            }
        });
        getContentPane().add(newFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 150, 30));

        newAge.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        newAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newAgeKeyTyped(evt);
            }
        });
        getContentPane().add(newAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 150, 30));

        newLName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        newLName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newLNameKeyTyped(evt);
            }
        });
        getContentPane().add(newLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 150, 30));

        newUserName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(newUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 150, 30));

        newPass.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        newPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newPassKeyTyped(evt);
            }
        });
        getContentPane().add(newPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 150, 30));

        phoneNumber.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        phoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneNumberKeyTyped(evt);
            }
        });
        getContentPane().add(phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 150, 30));

        create.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        create.setText("Create Account");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        getContentPane().add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 130, 30));

        cancel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 130, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LibraryPackage/Bookshelves-Background2.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        jLabel9.setMaximumSize(new java.awt.Dimension(800, 450));
        jLabel9.setMinimumSize(new java.awt.Dimension(800, 450));
        jLabel9.setPreferredSize(new java.awt.Dimension(800, 450));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*
    Precondition: The user or Librarian is not in the system or file
    Postcondition: A new user or Librarian is added to the system
    Activity: when the create user button is clicked, all the inputes by the user are taken
              into account and a new user is created based on that. the list of user file is updated
              to include the new user. the string "creating" controls the type of account creating because
              librarian and user share this create account page. Based on creating seperate lists are read and 
              seperate files are written to.
    */
    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        
        String fi = newFName.getText();     //gets the first name
        String li = newLName.getText();     //gets the last name       
        String ag = newAge.getText(); //the string needs to be parsed for an int
        
        int aget = 0;
            if(!(ag.equals(""))){//error check if it's empty it wont parse int
                aget = Integer.parseInt(ag); //turns the string into a number
            }    
        
        String use = newUserName.getText(); //gets the username
        String pa = newPass.getText();
        int passw = 0;
        
        if(!(pa.equals(""))){//error check if its empty it wont parse int
                passw = Integer.parseInt(pa); //turns the string into a number
        }   
        
        String phone = phoneNumber.getText();
        boolean createLibrarian = true; //if this is true, a new user is made, however it can be set to false with mistakes on the input fields
        boolean makeNewUser = true;
        
        if(fi.equals("")||li.equals("")||ag.equals("")||use.equals("")||pa.equals("")||phone.equals("")){ //check to see if all fields are filled
            JOptionPane.showMessageDialog(null, "Please input all fields");  //if something is blank if won't allow you to make a new user
            createLibrarian = false;
            makeNewUser = false;
        }else if(aget > 100 || aget < 1){ //if the age is too high or too low, can't make a new user
            JOptionPane.showMessageDialog(null, "Please put a reasonable age."); //check to see if the age is reasonable
            createLibrarian = false;
            makeNewUser = false;
        }
        
        if(creating.equalsIgnoreCase("librarian")){
            Librarian currentLibNode = libHeadNode;
            if(libHeadNode != null){
                do{
                    if (passw == currentLibNode.getPassword() && use.equals(currentLibNode.getUsername())){
                        createLibrarian = false;
                        JOptionPane.showMessageDialog(null, "You might already have an account.");
                    }else if(use.equals(currentLibNode.getUsername()) && !(passw == currentLibNode.getPassword())){
                        createLibrarian = false;
                        JOptionPane.showMessageDialog(null, "Username is already taken.");
                    }
                currentLibNode = currentLibNode.nextNode;
                }while(currentLibNode != null);
            }
            if(createLibrarian == true){
                Librarian newLibNode = new Librarian(fi, li, aget, use, passw, phone, null); 
                JOptionPane.showMessageDialog(null, "Account Creation Sucessful. \nA new Librarian has been added to the database.");
                
                if(libHeadNode == null){
                    libHeadNode = newLibNode;
                }else{
                    libTailNode.nextNode = newLibNode;
                }
                libTailNode = newLibNode;
       
                //here we're serializing the arraylist again because it needs to be updated as there is another user added
                //if there is any change to the arraylist in any class, it needs to be updated in the file
                writeLibrarianFile();
                
                this.dispose();
                LibrarianLogin home = new LibrarianLogin();
                home.setVisible(true);
                
} 
        }else if(creating.equals("User")){
            Users currentNode = headNode;
            if(headNode != null){
                do{
                    if (passw == currentNode.getPassword() && use.equals(currentNode.getUsername())){
                        createLibrarian = false;
                        JOptionPane.showMessageDialog(null, "You might already have an account.");
                    }else if(use.equals(currentNode.getUsername()) && !(passw == currentNode.getPassword())){
                        createLibrarian = false;
                        JOptionPane.showMessageDialog(null, "Username is already taken.");
                    }
                currentNode = currentNode.nextNode;
                }while(currentNode != null);
            }
            if(makeNewUser == true){
                Users newNode = new Users(fi, li, aget, use, passw, phone, null); 
                JOptionPane.showMessageDialog(null, "Account Creation Sucessful. \nPlease Login In The Homepage.");
                
                if(headNode == null){
                    headNode = newNode;
                }else{
                    tailNode.nextNode = newNode;
                }
                tailNode = newNode;
                
                writeUserFile();
                
                this.dispose();
                StartPage homepage = new StartPage();
                homepage.setVisible(true);
            } 
        }
    }//GEN-LAST:event_createActionPerformed
    
    //used to writ to file
    private void writeLibrarianFile(){
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
    private void writeUserFile(){
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
    //Activity; limits the input in the age text area to only numbers
    private void newAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newAgeKeyTyped
        // This allows only numbers to be entered
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_newAgeKeyTyped

    //Activity; limits the input in the password text area to only numbers
    private void newPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPassKeyTyped
        // This allows only numbers to be entered
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_newPassKeyTyped
    
    //Activity; limits the input in the phone number text area to only numbers
    private void phoneNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberKeyTyped
        // This allows only numbers to be entered
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_phoneNumberKeyTyped

    //the cancel button cancels the new user screen and takes you to the login or to the librarian screen
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // the cancel button takes you back to the login screen
        if(creating.equalsIgnoreCase("librarian")){
            this.dispose();
            LibrarianLogin hp = new LibrarianLogin();
            hp.setVisible(true);
            
        }else{
            this.dispose();
            StartPage homepage = new StartPage();
            homepage.setVisible(true);
        }
    }//GEN-LAST:event_cancelActionPerformed

    //Activity; limits the input in the name text area to only alphabets
    private void newFNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newFNameKeyTyped
        // only allows letters to be put in
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
            evt.consume();
    }//GEN-LAST:event_newFNameKeyTyped

    //Activity; limits the input in the name text area to only alphabets
    private void newLNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newLNameKeyTyped
        //pnly allows letters to be put in
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
            evt.consume();
    }//GEN-LAST:event_newLNameKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton create;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField newAge;
    private javax.swing.JTextField newFName;
    private javax.swing.JTextField newLName;
    private javax.swing.JTextField newPass;
    private javax.swing.JTextField newUserName;
    private javax.swing.JTextField phoneNumber;
    // End of variables declaration//GEN-END:variables

    
}