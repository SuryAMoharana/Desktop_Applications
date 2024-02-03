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
public class IssueBooks_Page extends javax.swing.JFrame {

    /**
     * Creates new form Issue_Books
     */
    public IssueBooks_Page() {  
        initComponents();
    }
    
    public void getBookDetails(){
        int bookId=Integer.parseInt(lbl_bookId.getText());
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("Select * from book_details where book_id=?");
            pst.setInt(1, bookId);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next()){
                txt_bookId.setText(rs.getString("book_id"));
                txt_bookName.setText(rs.getString("book_name"));
                txt_authorName.setText(rs.getString("author_name"));
                txt_quantity.setText(rs.getString("quantity"));                
            }else{
                JOptionPane.showMessageDialog(this, "Invalid Book ID");
            }
            
        } catch (Exception e) {
        }
    }
    
    public void getStudentDetails(){
        String studentId=lbl_studentId.getText();
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("Select * from student_details where student_id=?");
            pst.setString(1, studentId);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next()){
                txt_studentId.setText(rs.getString("student_id"));
                txt_studentName.setText(rs.getString("name"));
                txt_tradeName.setText(rs.getString("trade"));          
            }
            else{
                JOptionPane.showMessageDialog(this, "Invalid Student ID");
            }
            
        } catch (Exception e) {
        }
    }
    
    public boolean issueBook(){
        boolean isIssued=false;
        int bookId=Integer.parseInt(lbl_bookId.getText());
        String studentId=lbl_studentId.getText();
        String bookName=txt_bookName.getText();
        String studentName=txt_studentName.getText();
        
        Date uIssueDate=issue_date.getDatoFecha();
        Date uDueDate=due_date.getDatoFecha();
        
        Long l1=uIssueDate.getTime();
        Long l2=uDueDate.getTime();
        
        java.sql.Date sIssueDate=new java.sql.Date(l1);
        java.sql.Date sDueDate=new java.sql.Date(l2);
        
        try{
            Connection con=DBConnection.getConnection();
            String sql="insert into issue_book_details(bookId, bookName, studentId, studentName, issueDate, dueDate, status) value(?,?,?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setString(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7,"Pending");
            
            int rowCount=pst.executeUpdate();
            if(rowCount>0){
                isIssued=true;
            }
            else{
                isIssued=false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return isIssued;       
    }
    
    public void updateBookCount(){
        int bookId=Integer.parseInt(lbl_bookId.getText());
        try{
            Connection con=DBConnection.getConnection();
            String sql="update book_details set quantity = quantity-1 where book_Id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            int rowCount=pst.executeUpdate();
            
            if(rowCount>0){
                JOptionPane.showMessageDialog(this, "Book Count updated");
                int initialCount=Integer.parseInt(txt_quantity.getText());
                txt_quantity.setText(Integer.toString(initialCount-1));
            }else{
                JOptionPane.showMessageDialog(this, "Boom count not updated");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean isAlreadyIssued(){
        boolean isAlreadyIssued=false;
        int bookId=Integer.parseInt(lbl_bookId.getText());
        String studentId=lbl_studentId.getText();
        
        try {
            Connection con=DBConnection.getConnection();
            String sql="Select * from issue_book_details where bookId=? and studentId=? and status=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, studentId);
            pst.setString(3, "Pending");
            
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                isAlreadyIssued=true;
            }else{
                isAlreadyIssued=false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return isAlreadyIssued;
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JLabel();
        txt_bookId = new javax.swing.JLabel();
        txt_bookName = new javax.swing.JLabel();
        txt_authorName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_studentId = new javax.swing.JLabel();
        txt_studentName = new javax.swing.JLabel();
        txt_tradeName = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_studentId = new app.bolivia.swing.JCTextField();
        lbl_bookId = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        issue_date = new rojeru_san.componentes.RSDateChooser();
        jLabel19 = new javax.swing.JLabel();
        due_date = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("HP Simplified", 0, 12)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

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
        jLabel2.setText("Book Details");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 260, -1));

        jLabel3.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Quantity :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 80, 40));

        jLabel5.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Book Name :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 110, 40));

        jLabel6.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Author Name :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 120, 40));

        txt_quantity.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        txt_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 220, 30));

        txt_bookId.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        txt_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 220, 30));

        txt_bookName.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        txt_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 220, 30));

        txt_authorName.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        txt_authorName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_authorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 220, 30));

        jLabel7.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Book ID :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 80, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 690));

        jPanel5.setBackground(new java.awt.Color(0, 0, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 300, 5));

        jLabel12.setFont(new java.awt.Font("HP Simplified", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel12.setText("Student Details");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 260, -1));

        jLabel15.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Student Name :");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 120, 40));

        jLabel16.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Trade Name :");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 110, 40));

        txt_studentId.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        txt_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 220, 30));

        txt_studentName.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        txt_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 220, 30));

        txt_tradeName.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        txt_tradeName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_tradeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 220, 30));

        jLabel17.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Student ID :");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 100, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 380, 690));

        jLabel13.setFont(new java.awt.Font("HP Simplified", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel13.setText("Issue Books");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, 180, -1));

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

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Book ID :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 260, 80, 40));

        jLabel14.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("Issue Date :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, 100, 40));

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
        jPanel1.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 330, 280, 30));

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
        jPanel1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 260, 280, -1));

        jLabel18.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Student ID :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 330, 100, 40));

        issue_date.setColorBackground(new java.awt.Color(255, 0, 0));
        issue_date.setColorForeground(new java.awt.Color(0, 0, 0));
        issue_date.setFont(new java.awt.Font("HP Simplified", 0, 12)); // NOI18N
        issue_date.setFormatoFecha("dd/MM/yyyy");
        issue_date.setFuente(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        issue_date.setPlaceholder("Enter Issue Date");
        jPanel1.add(issue_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 390, 280, -1));

        jLabel19.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("Due Date :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, 100, 40));

        due_date.setColorBackground(new java.awt.Color(255, 0, 0));
        due_date.setColorForeground(new java.awt.Color(0, 0, 0));
        due_date.setFont(new java.awt.Font("HP Simplified", 0, 12)); // NOI18N
        due_date.setFormatoFecha("dd/MM/yyyy");
        due_date.setFuente(new java.awt.Font("HP Simplified", 1, 12)); // NOI18N
        due_date.setPlaceholder("Enter Due Date");
        jPanel1.add(due_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 460, 280, -1));

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonRectangle3.setText("ISSUE BOOK");
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
        jPanel1.add(rSMaterialButtonRectangle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 550, 170, 50));

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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Home_Page home=new Home_Page();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lbl_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_studentIdFocusLost
        if(!lbl_studentId.getText().equals("")){
            getStudentDetails();
        }
    }//GEN-LAST:event_lbl_studentIdFocusLost

    private void lbl_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentIdActionPerformed

    private void lbl_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_bookIdFocusLost
        if(!lbl_bookId.getText().equals("")){
            getBookDetails();
        }
    }//GEN-LAST:event_lbl_bookIdFocusLost

    private void lbl_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookIdActionPerformed

    private void rSMaterialButtonRectangle3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3FocusLost

    private void rSMaterialButtonRectangle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3MouseClicked
        
        if(txt_quantity.getText().equals("0")){
            JOptionPane.showMessageDialog(this, "Book is not available");
        }
        else{
            if(isAlreadyIssued()==false){
            if(issueBook()==true){
            JOptionPane.showMessageDialog(this, "Book issued successfully");
            updateBookCount();
            }else{
                JOptionPane.showMessageDialog(this, "Book issue failed");
            }
        }else{
            JOptionPane.showMessageDialog(this, "This student already issued this book");
        }
        }
        
        
    }//GEN-LAST:event_rSMaterialButtonRectangle3MouseClicked

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBooks_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBooks_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBooks_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBooks_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBooks_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser due_date;
    private rojeru_san.componentes.RSDateChooser issue_date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private app.bolivia.swing.JCTextField lbl_bookId;
    private app.bolivia.swing.JCTextField lbl_studentId;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private javax.swing.JLabel txt_authorName;
    private javax.swing.JLabel txt_bookId;
    private javax.swing.JLabel txt_bookName;
    private javax.swing.JLabel txt_quantity;
    private javax.swing.JLabel txt_studentId;
    private javax.swing.JLabel txt_studentName;
    private javax.swing.JLabel txt_tradeName;
    // End of variables declaration//GEN-END:variables
}
