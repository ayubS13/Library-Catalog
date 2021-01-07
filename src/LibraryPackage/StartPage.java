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

 public class StartPage extends javax.swing.JFrame {
    //head and tail nodes for linked list
    private static Users headNode;
    private static Users tailNode;
    
    
    //private static ArrayList<Users> list  = new ArrayList<Users>();
    
    public StartPage() { 
        initComponents();
        readFile();//gets the input from the file
    }
    /*
    *Precondition: List of all the users is empty at the start of the program
    *Postcondition: the list of users is filled in from file
    *Activity: reads the file user info and fills the list with the users
    */
    private void readFile(){
        File temp = new File("User Info");
        if(temp.exists()== true){
            //if the file exists, read it it into the arraylist of users
            try
            {
                FileInputStream fis = new FileInputStream("User Info");
                ObjectInputStream ois = new ObjectInputStream(fis);
                headNode = (Users) ois.readObject();
                
                Users currentNode = headNode;
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
            }catch(ClassNotFoundException c){
                System.out.println("Class not found");
                c.printStackTrace();
                return;
            }
        }else{ //else make a default user which is me
            Users newNode = new Users("Anthony", "Davis", 23, "anthony123", 599879,"572-239-7190", null); //if the file isn't there
            
            if(headNode == null){
                headNode = newNode;
            }else{
                tailNode.nextNode = newNode;
            }
            tailNode = newNode;
        }
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
        passField = new javax.swing.JTextField();
        userField = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        newAcc = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Screen");
        setBackground(new java.awt.Color(0, 255, 204));
        setMinimumSize(new java.awt.Dimension(800, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 42)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Legacy Library Catalog");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 450, 60));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 120, 20));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        passField.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        passField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passFieldKeyTyped(evt);
            }
        });
        getContentPane().add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 190, -1));

        userField.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        getContentPane().add(userField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 190, -1));

        login.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 70, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("To Close Application");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        newAcc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        newAcc.setText("Click Here");
        newAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAccActionPerformed(evt);
            }
        });
        getContentPane().add(newAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, -1, -1));

        exit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        exit.setText("Exit");
        exit.setToolTipText("");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 100, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("To Create New Account");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LibraryPackage/Bookshelves-Background2.jpg"))); // NOI18N
        jLabel5.setMaximumSize(new java.awt.Dimension(800, 500));
        jLabel5.setMinimumSize(new java.awt.Dimension(910, 500));
        jLabel5.setPreferredSize(new java.awt.Dimension(800, 480));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
     //Activity: takes the user to the create new user screen    
    private void newAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAccActionPerformed
        //if the buttons is clicked it takes you to the screen to create a new user(not an admin)
        this.setVisible(false);
        CreateUser newUser = new CreateUser(headNode, tailNode);
        newUser.setVisible(true);
    }//GEN-LAST:event_newAccActionPerformed
    /*
     Precondition: the user is at the login screen
     Postcondition: the user is loged in to the system and the database screen is displayed
     Activity: loops through the user list and checks if the username and password entered match a user
    */
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        //the program checks the database for the user when the button is pressed
        //if the user is found, he is allowed in 
        String s = passField.getText();//get the password as a string
        String userN = userField.getText();//get the usename
        boolean foundUser = false; //boolean checks if the user is in the system or not
        
        int password = 0; 
        if(!(s.equals(""))){//error check if it's empty it wont parse int
                password = Integer.parseInt(s); //turns the string into a number
        }
        
        //loop through the linked list and find the user
        Users currentNode = headNode;
        Users temp;
        boolean found = false;
        if(headNode != null){//always checks if the headNode is not empty before going anyfurther
                do{
                   if(currentNode.userName.equals(s) && currentNode.password == password){
                        temp = currentNode;
                        foundUser = true;
                        
                        this.setVisible(false);
                        Homepage home = new Homepage(temp, headNode, tailNode);
                        home.setVisible(true);
                   }
                   currentNode = currentNode.nextNode;
                }while(currentNode != null);    
            }
        
        if(s.equals("") || userN.equals("")){//if the username or the password fieldis blank
            JOptionPane.showMessageDialog(null, "Please fill in the required fields");   
        }else if(foundUser == false){
            JOptionPane.showMessageDialog(null, "You are not in the system.");
        }        
    }//GEN-LAST:event_loginActionPerformed
    
   
    //activity: restricts the user input to just numbers, backspace, and delete
    private void passFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passFieldKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_passFieldKeyTyped
    
    //activity: exits the program
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        //write to file incase a new user was created upon closure of the program
        
        String filename = "User Info";
        try {
            FileOutputStream fileStream = new FileOutputStream(filename);
            ObjectOutputStream saveFile = new ObjectOutputStream(fileStream);
            saveFile.writeObject(headNode);//when you save the headNode it saves the entire linked list				
            saveFile.close();
	}catch(Exception x){};
        
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton login;
    private javax.swing.JButton newAcc;
    private javax.swing.JTextField passField;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
