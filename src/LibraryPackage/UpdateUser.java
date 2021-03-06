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
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class UpdateUser extends javax.swing.JFrame {
    private static Users headNode;
    private static Users tailNode;
    private Users userUpdating = null;

    public UpdateUser(Users john, Users headNode, Users tailNode) {   
        initComponents();
        this.headNode = headNode;
        this.tailNode = tailNode;
        userUpdating = john;
        displayOldInfo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        newPhone = new javax.swing.JTextField();
        oldAge = new javax.swing.JTextField();
        oldLName = new javax.swing.JTextField();
        oldUsername = new javax.swing.JTextField();
        oldPassword = new javax.swing.JTextField();
        oldPhone = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        newFName = new javax.swing.JTextField();
        oldFName = new javax.swing.JTextField();
        newLName = new javax.swing.JTextField();
        newAge = new javax.swing.JTextField();
        newUsername = new javax.swing.JTextField();
        newPass = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create User Account");
        setMinimumSize(new java.awt.Dimension(800, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Update Account Information");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 600, 33));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Age");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone Number");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        newPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newPhoneKeyTyped(evt);
            }
        });
        getContentPane().add(newPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, 140, -1));

        oldAge.setEditable(false);
        oldAge.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(oldAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 140, -1));

        oldLName.setEditable(false);
        oldLName.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(oldLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 140, -1));

        oldUsername.setEditable(false);
        oldUsername.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(oldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 140, -1));

        oldPassword.setEditable(false);
        oldPassword.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(oldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 140, -1));

        oldPhone.setEditable(false);
        oldPhone.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(oldPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 140, -1));

        updateButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 110, -1));

        cancel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 110, -1));

        newFName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newFNameKeyTyped(evt);
            }
        });
        getContentPane().add(newFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 140, -1));

        oldFName.setEditable(false);
        oldFName.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(oldFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 140, -1));

        newLName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newLNameKeyTyped(evt);
            }
        });
        getContentPane().add(newLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 140, -1));

        newAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newAgeKeyTyped(evt);
            }
        });
        getContentPane().add(newAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 140, -1));
        getContentPane().add(newUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 140, -1));

        newPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                newPassKeyTyped(evt);
            }
        });
        getContentPane().add(newPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 140, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Old Info");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("New Info");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LibraryPackage/Bookshelves-Background2.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        jLabel9.setMaximumSize(new java.awt.Dimension(700, 450));
        jLabel9.setMinimumSize(new java.awt.Dimension(700, 450));
        jLabel9.setPreferredSize(new java.awt.Dimension(700, 450));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //fills in the corresponding textfields on the interface with the old information when the screen opens up
    public void displayOldInfo(){
        oldFName.setText(userUpdating.first);
        oldLName.setText(userUpdating.last);
        oldAge.setText("" + userUpdating.ag);
        oldUsername.setText(userUpdating.userName);
        oldPassword.setText("" + userUpdating.password);
        oldPhone.setText("" + userUpdating.phonenumber);
    }
    
    /*Precondition: the user's account is filled with old information
      Postcondition: the user's account is filled with the new information
      Activty: takes the new inputs the user enters( name, age, username, password, and phone), goes through
                the user list, finds the account, and updates it with the new information
    */  
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String f = newFName.getText();
        String l = newLName.getText();
        boolean updateUser = true;
        String a = newAge.getText(); //the string needs to be parsed for an int
        
        int age = 0;
            if(!(a.equals(""))){//error check if it's empty it wont parse int
                age = Integer.parseInt(a); //turns the string into a number
            }
            
        String us = newUsername.getText(); //gets the username
        String p = newPass.getText();
        int pass = 0;
        
        if(!(p.equals(""))){//error check if its empty it wont parse int
                pass = Integer.parseInt(p); //turns the string into a number
            } 
        String number = newPhone.getText();
        
        if(f.equals("")||l.equals("")||a.equals("")||us.equals("")||p.equals("")||number.equals("")){ //check to see if all fields are filled
           JOptionPane.showMessageDialog(null, "Please input all fields"); 
           updateUser = false;
        }else if(age > 100 || age < 1){
           JOptionPane.showMessageDialog(null, "Please put a reasonable age."); //check to see if the age is reasonable
           updateUser = false;
        }
        
        Users currentNode = headNode;
        if(headNode != null){
            do{
                if(!(currentNode.first.equals(userUpdating.last) )){
                    if (currentNode.getUsername().equals(us)){
                        updateUser = false;
                        JOptionPane.showMessageDialog(null, "Username is already taken.");
                }
                }
                
                currentNode = currentNode.nextNode;
            }while(currentNode != null);
        }
        
        if(updateUser == true){
            JOptionPane.showMessageDialog(null, "Your account has been sucessfully updated.");
            userUpdating.update(f,l,age, us, pass, number);
            
            writeToFile();
            
            this.dispose();
            Homepage homepage = new Homepage(userUpdating, headNode, tailNode);
            homepage.setVisible(true); 
        }               
    }//GEN-LAST:event_updateButtonActionPerformed

    //write to the file
    private void writeToFile(){
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
   
    //the cancel button cancels the new user screen and takes you to the login
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // the cancel button takes you back to the login screen take care of this later
        this.dispose();
        Homepage homepage = new Homepage(userUpdating, headNode, tailNode);
        homepage.setVisible(true); 
    }//GEN-LAST:event_cancelActionPerformed

    //inside the text field input are only numbers
    private void newPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPhoneKeyTyped
        // only allows letters to be put in
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_newPhoneKeyTyped
    
    //inside the text field input are only letters
    private void newFNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newFNameKeyTyped
        // only allows letters
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
            evt.consume();
    }//GEN-LAST:event_newFNameKeyTyped

    ////inside the text field input are only letters
    private void newLNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newLNameKeyTyped
        // only allows letters
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
            evt.consume();
    }//GEN-LAST:event_newLNameKeyTyped

    //inside the text field input are only numbers
    private void newAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newAgeKeyTyped
        //only allows numbers
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_newAgeKeyTyped

    //inside the text field input are only numbers
    private void newPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPassKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_newPassKeyTyped

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
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField newAge;
    private javax.swing.JTextField newFName;
    private javax.swing.JTextField newLName;
    private javax.swing.JTextField newPass;
    private javax.swing.JTextField newPhone;
    private javax.swing.JTextField newUsername;
    private javax.swing.JTextField oldAge;
    private javax.swing.JTextField oldFName;
    private javax.swing.JTextField oldLName;
    private javax.swing.JTextField oldPassword;
    private javax.swing.JTextField oldPhone;
    private javax.swing.JTextField oldUsername;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    
}
