/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author surya
 */
public class ReturnBooks_Page extends javax.swing.JFrame {

    /**
     * Creates new form Issue_Books
     */
    public ReturnBooks_Page() {  
        initComponents();
    }
    
    public void getIssueBookDetails(){
        int bookId=Integer.parseInt(lbl_bookId.getText());
        String studentId=lbl_studentId.getText();
        
        try {
            Connection con=DBConnection.getConnection();
            String sql="select * from issue_book_details where bookId=? and studentId=? and status=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, studentId);
            pst.setString(3, "pending");
            
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                txt_issueId.setText(rs.getString("id"));
                txt_bookName.setText(rs.getString("bookName"));
                txt_studentName.setText(rs.getString("studentName"));
                txt_dueDate.setText(rs.getString("dueDate"));
                txt_issueDate.setText(rs.getString("issueDate"));
                JOptionPane.showMessageDialog(this, "Issue Details Found");
            }
            else{
                txt_issueId.setText("");
                txt_bookName.setText("");
                txt_studentName.setText("");
                txt_dueDate.setText("");
                txt_issueDate.setText("");
                JOptionPane.showMessageDialog(this, "No issue details found for given credentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateBookCount(){
        int bookId=Integer.parseInt(lbl_bookId.getText());
        try{
            Connection con=DBConnection.getConnection();
            String sql="update book_details set quantity = quantity+1 where book_Id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            int rowCount=pst.executeUpdate();
            
            if(rowCount>0){
                JOptionPane.showMessageDialog(this, "Book Count updated");
            }else{
                JOptionPane.showMessageDialog(this, "Boom count not updated");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean returnBook(){
        boolean isReturned=false;
        int bookId=Integer.parseInt(lbl_bookId.getText());
        String studentId=lbl_studentId.getText();
        try{
            Connection con=DBConnection.getConnection();
            String sql="update issue_book_details set status=? where bookId=? and studentId=? and status=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, "returned");
            pst.setInt(2, bookId);
            pst.setString(3, studentId);
            pst.setString(4, "pending");
            
            int rowCount=pst.executeUpdate();
            
            if(rowCount>0){
                isReturned=true;
            }else{
                isReturned=false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isReturned;
        
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_issueDate = new javax.swing.JLabel();
        txt_issueId = new javax.swing.JLabel();
        txt_bookName = new javax.swing.JLabel();
        txt_studentName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_dueDate = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_studentId = new app.bolivia.swing.JCTextField();
        lbl_bookId = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("HP Simplified", 0, 12)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 300, 5));

        jLabel2.setFont(new java.awt.Font("HP Simplified", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel2.setText("Issue Details");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 260, -1));

        jLabel3.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Issue Date :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 100, 40));

        jLabel5.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Name :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 110, 40));

        jLabel6.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Student Name :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 120, 40));

        txt_issueDate.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        txt_issueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 220, 30));

        txt_issueId.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        txt_issueId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_issueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 220, 30));

        txt_bookName.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        txt_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 220, 30));

        txt_studentName.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        txt_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 220, 30));

        jLabel7.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Issue ID :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 80, 40));

        jLabel9.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Due Date :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 80, 40));

        txt_dueDate.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        txt_dueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 220, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 380, 690));

        jLabel13.setFont(new java.awt.Font("HP Simplified", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel13.setText("Return Books");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 120, 200, -1));

        jPanel8.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Book ID :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 260, 80, 40));

        lbl_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
        lbl_studentId.setForeground(new java.awt.Color(255, 0, 0));
        lbl_studentId.setCaretColor(new java.awt.Color(255, 255, 255));
        lbl_studentId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lbl_studentId.setFont(new java.awt.Font("HP Simplified", 0, 12)); // NOI18N
        lbl_studentId.setPhColor(new java.awt.Color(153, 153, 153));
        lbl_studentId.setPlaceholder("Enter Student ID");
        lbl_studentId.setSelectedTextColor(new java.awt.Color(0, 0, 102));
        lbl_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_studentIdFocusLost(evt);
            }
        });
        lbl_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 330, 280, 30));

        lbl_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));
        lbl_bookId.setForeground(new java.awt.Color(255, 0, 0));
        lbl_bookId.setCaretColor(new java.awt.Color(255, 255, 255));
        lbl_bookId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lbl_bookId.setFont(new java.awt.Font("HP Simplified", 0, 12)); // NOI18N
        lbl_bookId.setPhColor(new java.awt.Color(153, 153, 153));
        lbl_bookId.setPlaceholder("Enter Book ID");
        lbl_bookId.setSelectedTextColor(new java.awt.Color(0, 0, 102));
        lbl_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_bookIdFocusLost(evt);
            }
        });
        lbl_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_bookIdActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, 280, -1));

        jLabel18.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Student ID :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 330, 100, 40));

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(0, 0, 255));
        rSMaterialButtonRectangle3.setText("FIND");
        rSMaterialButtonRectangle3.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        rSMaterialButtonRectangle3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rSMaterialButtonRectangle3FocusLost(evt);
            }
        });
        rSMaterialButtonRectangle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle3MouseClicked(evt);
            }
        });
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 470, 200, 60));

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonRectangle4.setText("RETURN BOOK");
        rSMaterialButtonRectangle4.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        rSMaterialButtonRectangle4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rSMaterialButtonRectangle4FocusLost(evt);
            }
        });
        rSMaterialButtonRectangle4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle4MouseClicked(evt);
            }
        });
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 540, 200, 60));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boy-returning-library-books-300x276.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 340, 320));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Close.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 690));

        setSize(new java.awt.Dimension(1223, 692));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_studentIdFocusLost


    }//GEN-LAST:event_lbl_studentIdFocusLost

    private void lbl_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentIdActionPerformed

    private void lbl_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_bookIdFocusLost

    }//GEN-LAST:event_lbl_bookIdFocusLost

    private void lbl_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookIdActionPerformed

    private void rSMaterialButtonRectangle3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3FocusLost

    private void rSMaterialButtonRectangle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3MouseClicked
        getIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonRectangle3MouseClicked

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Home_Page home=new Home_Page();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSMaterialButtonRectangle4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4FocusLost

    private void rSMaterialButtonRectangle4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4MouseClicked
        if(returnBook()==true){
            JOptionPane.showMessageDialog(this, "Return Successful");
        }else{
            JOptionPane.showMessageDialog(this, "Return Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle4MouseClicked

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

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
            java.util.logging.Logger.getLogger(ReturnBooks_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBooks_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ReturnBooks_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private app.bolivia.swing.JCTextField lbl_bookId;
    private app.bolivia.swing.JCTextField lbl_studentId;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private javax.swing.JLabel txt_bookName;
    private javax.swing.JLabel txt_dueDate;
    private javax.swing.JLabel txt_issueDate;
    private javax.swing.JLabel txt_issueId;
    private javax.swing.JLabel txt_studentName;
    // End of variables declaration//GEN-END:variables
}