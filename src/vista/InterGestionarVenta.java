/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import conexion.ConectionDB;
import controlador.Ctrl_Cliente;
import controlador.Ctrl_RegistrarVenta;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Modelo_CabeceraVenta;
import modelo.Modelo_Cliente;

/**
 *
 * @author Edward
 */
public class InterGestionarVenta extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterGestionarCategoria
     */
    private int idCliente = 0;
    private int idVenta;
    private String cliente="";
    String auxImagen = "";

    public InterGestionarVenta() {
        initComponents();
        this.setSize(new Dimension(940, 500));
        this.setTitle("GESTIONAR_VENTAS");
        this.cargarTablaVentas();
               this.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE); //no permite el movimiento del internal
           ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); // desactiva la abrra de titulo
    }

    //Para poner el logo de suzuki a escala en el bar menu
    private void fondoEtiqueta() {
        ImageIcon logo = new ImageIcon("src/img/GRIS.jpg");
        Icon icon = new ImageIcon(logo.getImage().getScaledInstance(940, 500, WIDTH));
        lblFondo.setIcon(icon);
        lblFondo.repaint();
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
        jPanel1 = new javax.swing.JPanel();
        scrollVentas = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        lblMoto = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Ventas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollVentas.setViewportView(tablaVentas);

        jPanel1.add(scrollVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 390));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 730, 390));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnActualizar.setBackground(new java.awt.Color(0, 153, 153));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addComponent(btnActualizar)
                        .addGap(35, 35, 35))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnActualizar)
                .addGap(62, 62, 62)
                .addComponent(lblMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 170, 270));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FONDO.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        Modelo_CabeceraVenta cabeceraVenta = new Modelo_CabeceraVenta();
        Ctrl_RegistrarVenta ctrl_RegistrarVenta = new Ctrl_RegistrarVenta();
        String cliente;


        //Obtener ID ciente
   

        //Actualizar datos
       
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblMoto;
    public static javax.swing.JScrollPane scrollVentas;
    public static javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables

    //Metodo Limpiar 
  

    //Metodo para motrar todas los clientes registrados
    public void cargarTablaVentas() {
        Connection cx = conexion.ConectionDB.conectar();
        DefaultTableModel dfT = new DefaultTableModel();
        String sql = "select cv.idVenta as id, concat(c.nombre,' ',c.apellido) as cliente, "
                + "cv.cantidadPagar as total, cv.fecha as fecha "
                + "from venta as cv, cliente as c where cv.idCliente=c.idCliente;";
        Statement st;

        try {
            st = cx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarVenta.tablaVentas = new JTable(dfT);
            InterGestionarVenta.scrollVentas.setViewportView(InterGestionarVenta.tablaVentas);

            dfT.addColumn("ID");
            dfT.addColumn("Cliente");
            dfT.addColumn("Total Pagar");
            dfT.addColumn("Fecha Venta");

            while (rs.next()) {

                Object fila[] = new Object[4];

                for (int i = 0; i < 4; i++) {
                        fila[i] = rs.getObject(i + 1);
                }
                dfT.addRow(fila);
            }
            cx.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla ventas: " + e);
        }

       
    }

    //Para mostrar informacion del cliente
  

    //Metodo asignar Imagen Moto
    private void asignarImagen() {
        ImageIcon logo = new ImageIcon("src/motos/" + auxImagen + ".png");
        Icon icon = new ImageIcon(logo.getImage().getScaledInstance(lblMoto.getWidth(), lblMoto.getHeight(), Image.SCALE_DEFAULT));
        lblMoto.setIcon(icon);
        //lblMoto.repaint();
    }

    //Metodo para llenar el comboBox
  
}
