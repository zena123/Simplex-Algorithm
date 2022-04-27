package symplex1;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class project extends javax.swing.JFrame {

    
    public project() {
        initComponents();
        jButton1.setEnabled(true);
      jButton2.setEnabled(false);
      solve.setEnabled(false);
      
    }
    public static String[][]x; //string values
    public static String [] y; // header array
    public static int i,j,m,n,step=0,bi,bj;
    public static double [][]simplex; //from x to simplex..string to double
    public static double [][]help; // to put the values of operation
    static double z=0,base; //base=simplex[bi][bj]
    
    // 1: string x[][] to double simplex[][]
    public static void x_to_simplex(){
    for(i=0;i<m+1;i++){
            for(j=1;j<n+2;j++)
        simplex[i][j]=Double.parseDouble(x[i][j]);}}
    
    
    // check if all cj<0 & bi>0 (ideal solution)
   public static boolean is_ideal(){
       int c=0,bb=0;
    for(i=0;i<m;i++)
        if(simplex[i][n+1]<0){bb=1;break;}
   for(j=1;j<n+1;j++)
       if(simplex[m][j]>0){c=1;break;}
   if(c==0 && bb==0)
       return true;
   else return false;
   }
   
   
   // if there is negative Bi then select bi..
  public static boolean bi_negative(){
     
  for(i=0;i<m;i++)
      if(simplex[i][n+1]<0){
        
          bi=i;
          return true;}

  return false;
  }
  
  
  // to know if we have no solution at all
  public static boolean no_solution(){
      int test;
  for(i=0;i<m;i++){
      test=0;
  for(j=1;j<n+1;j++){
          
  if(simplex[i][j]>=0){test=1; break;}}
  
  if(simplex[i][n+1]>0 && test==0) {
              
                  return true;  }
          }
  
  return false;
  }
  
  
  // to know if the solution unlimited...open area
  public static boolean  unlimitted(){
      boolean test=true;
  for(i=0;i<m;i++){
  if(simplex[i][bj]>0){test=false; break;}}
  
  if(test==true && simplex[m][bj]>0)
     return true;
  else return false;  
}
  
  
// select base colum if bi is negative
   public static int select_min_ci(){
       int num=1;
       double d,min=(simplex[m][1]/simplex[bi][1]);
   for(j=2;j<n+1;j++){
     d=(simplex[m][j]/simplex[bi][j]) ;
       if(d <min){min=d;num=j;}}
   return num;}
  
   
   //select base colum_max cj
  public static void select_max_cj(){
    int f=0; bj=1;
      double max=simplex[m][1];
  for(j=2;j<n+1;j++){
  if(simplex[m][j]>max){
  max=simplex[m][j];bj=j;}}
  
  for(j=1;j<n+1;j++){
  if(j!=bj)
      if(max==simplex[m][j])
          for(i=0;i<m;i++)
              if(simplex[i][j]>0)
                  f++;
  if(f==m)
      bj=j;
  }
  
 
  
  }
  
  
  //select min Bi(and bi) after selecting max cj and bj
  public static void select_min_b_ais(){
     double d,min=1000000000;
    for(i=0;i<m;i++){
    if(simplex[i][bj]>0){
    d=simplex[i][n+1]/simplex[i][bj];
    if(d<min){min=d; bi=i;}}
    }
  }
  

// put operation values in help[][]
  public static void make_operation(){
  help[bi][bj]=1/base; // we selected base in solve button
  
  for(j=1;j<n+2;j++){
      if(j== bj) continue;
      help[bi][j]=(simplex[bi][j]/base);}
  
  for(i=0;i<m+1;i++) {
      if(i== bi) continue;
      help[i][bj]=-1*(simplex[i][bj]/base);}
  
  for(i=0;i<m+1;i++){
      for(j=1;j<n+2;j++){
          if(i==bi || j==bj) continue;
      help[i][j]=(( (simplex[i][j]*base) - (simplex[bi][j]*simplex[i][bj]) )/base);}}
  z=help[m][n+1];
  }
 
  
  //swap between Xi and Yj
  public static void swap_X_y(){
      String s=x[bi][0];
      x[bi][0]=y[bj];
      y[bj]=s;}
  
  
  // refill simplex[][] with new values of help[][]
  public static void help_to_simplex(){
  for(i=0;i<m+1;i++){
  for(j=1;j<n+2;j++)
      simplex[i][j]=help[i][j];}}
  
  // make values of simplex[][] string and fill x[][] with new values
  public static void simplex_to_x(){
  for(i=0;i<m+1;i++){
  for(j=1;j<n+2;j++)
      x[i][j]=String.valueOf(simplex[i][j]);}
  
  }
   
  
  
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        text1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        text2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        solve = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("the project");

        jLabel1.setText("enter the number of variables");

        jLabel2.setText("enter number of constraints");

        jButton1.setText("make primary table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("first table");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        solve.setText("solve");
        solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solveActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(186, 186, 186))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(solve))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jButton1)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(solve))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(334, 334, 334))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(text1.getText().isEmpty()||text2.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please complete all fields!");
            return;} 
      
      n=Integer.parseInt(text1.getText());
      m=Integer.parseInt(text2.getText());
      
      if(m<1 || n<1){
            JOptionPane.showMessageDialog(this,"Enter valid values!");
            return;}
      
      String [] h= new String[n+2];
      String [] [] x1=new String[m+1][n+2];
      
      
      for(i=0;i<n;i++)h[i]="X"+(i+1);
      h[n]=""; h[n+1]="bi";
      
      for(i=0;i<m;i++)x1[i][n]="<=";
      x1[m][n]="--->";x1[m][n+1]="MAX Z";
      
    jTable1.setModel(new DefaultTableModel(x1,h));
     jButton2.setEnabled(true);
        solve.setEnabled(false);
        z=0;
        step=0;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       y=new String[n+2]; 
       x=new String[m+1][n+2];
       simplex = new double [m+1][n+2];
      help = new double[m+1][n+2];
       
       for(i=0;i<m;i++)x[i][0]="y"+(i+1);

        x[m][0]="Z";
       for(i=0;i<=m;i++)
        {for(j=0;j<=n+1;j++){

            if(jTable1.getValueAt(i,j)==null){
                JOptionPane.showMessageDialog(this,"complete all fields  ^_^ ");
           return;}}}
       for(i=0;i<m;i++)for(j=0;j<n;j++)
        x[i][j+1]=(String) jTable1.getValueAt(i,j);
       
        for(i=0;i<m;i++)x[i][n+1]=(String) jTable1.getValueAt(i,n+1);
        
        for(j=0;j<n;j++){x[m][j+1]=(String) jTable1.getValueAt(m,j);}
        
        y[0]=" ";
        for(i=1;i<=n;i++)y[i]="X"+i; y[n+1]="bi";
        x[m][n+1]="-"+String.valueOf(z);
       
        jTable1.setModel(new DefaultTableModel(x,y));
        solve.setEnabled(true);
        jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void solveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solveActionPerformed
       
        for(i=0;i<m+1;i++)
        {for(j=0;j<n+2;j++){
            x[i][j]=(String) jTable1.getValueAt(i,j);}}
       
       x_to_simplex();
       
       if(no_solution()){
  JOptionPane.showMessageDialog(null, " there is no solution :0 ");
  solve.setEnabled(false);
  return;
  }
  
            if(bi_negative()) // bi is selected in this method
            {  
                bj=select_min_ci();
            base=simplex[bi][bj];
            }
            
            else{
            select_max_cj();
            select_min_b_ais();
            base=simplex[bi][bj];}
            
            swap_X_y();
            make_operation();
            help_to_simplex();
            simplex_to_x();
            
       
          
             if(unlimitted()){
                  JOptionPane.showMessageDialog(null, "unlimitted solution -_- !");
  solve.setEnabled(false);
  return;
             }
            
        
        jTable1.setModel(new DefaultTableModel(x,y));
        step++;
         solve.setEnabled(true);
        jButton2.setEnabled(false);
        z*=-1;
        if(is_ideal()){
        JOptionPane.showMessageDialog(null,"Z= "+z +" number of steps "+step);
       solve.setEnabled(false);
      }
        
        
        
        
    }//GEN-LAST:event_solveActionPerformed

    
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
            java.util.logging.Logger.getLogger(project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new project().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton solve;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    // End of variables declaration//GEN-END:variables
}
