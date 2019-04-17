import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class login extends javax.swing.JFrame {

    private Connection connection = null;
    private ResultSet rs =null;
    private Statement s = null;
    public login() {
        initComponents();
    }

   public void Conexion(){

        if (connection != null) {
            return;
        }
        String url = "jdbc:postgresql://localhost:5432/clase";
       
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, "postgres", "admin");
            if (connection != null){
                     System.out.println("conectado a base de datos.....");
            }
        }
         catch  (Exception e) {
             System.out.println("problemas de conexion");

       }


    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("registrar nuevo usuario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("nombre");

        jLabel2.setText("contraseña");

        jLabel3.setText("ingresar usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(62, 62, 62))))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jButton2)
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel3)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                      this.setVisible(false);
                      registro_usuario v = new registro_usuario();
                      v.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Conexion ();
            
            try {
                  String name = jTextField1.getText();
                  String pass = jTextField2.getText();
                  s = connection.createStatement();
                  rs = s.executeQuery("SELECT U.id_usuario,R.id_rol, U.nom_usuario, pass_usuario " +
                                                   "FROM usuario U,rol R,usuario_has_rol UR " +
                                                   "WHERE U.nom_usuario ='"+name+"' and U.pass_usuario = '"+pass+"' and U.id_usuario = UR.usuario_id_usuario and UR.rol_id_rol = R.id_rol;");
                  
                  int num;
                  int num5;
                  while(rs.next()){
                  num = rs.getInt(1);
                  num5 = rs.getInt(2);
                    if(num5 == 1){
                      
                      this.setVisible(false);
                      interfaz_docente v = new interfaz_docente();
                      v.setVisible(true);
                    }else{
                  System.out.println(""+num+"");
                   rs = s.executeQuery("SELECT distinct funcion_has_interfaz.interfaz_id_interfaz" +
                                                    " FROM (SELECT distinct rol_has_funcion.funcion_id_funcion" +
                                                                 " FROM (SELECT distinct usuario_has_rol.rol_id_rol" +
                                                                              " FROM (SELECT usuario.id_usuario" +
                                                                                           " FROM usuario" +
                                                                                           " WHERE usuario.id_usuario = "+num+")uno, usuario_has_rol" +
                                                                              " WHERE uno.id_usuario = usuario_has_rol.usuario_id_usuario)dos, rol_has_funcion" +
                                                                 " WHERE dos.rol_id_rol = rol_has_funcion.rol_id_rol)tres, funcion_has_interfaz" +
                                                    " WHERE tres.funcion_id_funcion = funcion_has_interfaz.funcion_id_funcion ;");
                                                   // " GROUP BY funcion_has_i_u.i_u_id_i_u" +
                                                    //" HAVING count(*)>1;");
                  
                   int num1;
                         while(rs.next()) {
                                 
                             num1 = rs.getInt(1);
                              if(num1== 2){
                                  
                                   this.setVisible(false);
                                   interfaz_estudiante v = new interfaz_estudiante();
                                   v.setVisible(true);
                            }
                              
                          
                       }
                   
                    }
               
                  }
                 
                   
                      
            }catch (Exception e) {
                  System.out.println("problema al conectar");
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
