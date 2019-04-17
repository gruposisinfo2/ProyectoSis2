import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class lista_estudiantes extends javax.swing.JFrame {
    private Connection connection = null;
    ResultSet rs;
    PreparedStatement ps;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    public lista_estudiantes() {
        initComponents();
    }

    public void Conexion(){

        if (connection != null) {
            return;
        }
        String url = "jdbc:postgresql://localhost:5432/clase";
        String password = "admin";
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, "postgres", password);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("lista estudiantes");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "numero", "apellido", "nombre"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("mostrar lista");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(301, 301, 301)
                        .addComponent(jLabel1)
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Conexion();
         try
        {
          Class.forName("org.postgresql.Driver");
          ps = connection.prepareStatement("SELECT id_estudiante, ape_estudiante,nom_estudiante " +
                                                                   "FROM estudiante E;");

          rs=ps.executeQuery();
          rsm=rs.getMetaData();
          ArrayList<Object[]> data=new ArrayList<Object[]>();
         while (rs.next()){
                Object [] rows = new Object[rsm.getColumnCount()];
                for(int i = 0;i < rows.length;i++){
                           rows[i]=rs.getObject(i+1);
                }

                data.add(rows);
          }
          dtm =(DefaultTableModel)this.jTable1.getModel();
          for(int i = 0; i < data.size(); i++){
                dtm.addRow(data.get(i));
          }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());


        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lista_estudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
