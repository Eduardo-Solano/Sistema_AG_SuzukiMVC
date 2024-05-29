/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import conexion.ConectionDB;
import java.sql.Connection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author jc389
 */
public class Graficos extends javax.swing.JInternalFrame {
String nombre="";
    /**
     * Creates new form Graficos
     */
    public Graficos() {
        initComponents();
           this.setClosable(false);
        this.setIconifiable(false);
                           this.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE); //no permite el movimiento del internal
           ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); // desactiva la abrra de titulo
    }
      public void showLineChart(){
          panelLineChart.setVisible(true);
          panelBarChart.setVisible(false);
        //create dataset for the graph
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         Connection cx = ConectionDB.conectar();
        String sql = "SELECT idProducto, SUM(Cantidad) AS totalCantidad "
                       + "FROM detalle_venta "
                       + "GROUP BY idProducto "
                       + "ORDER BY idProducto";
        Statement st;
        int contador = 0;
        try
        {
            st = cx.createStatement();
       
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                int idProducto = rs.getInt("idProducto");
                int totalCantidad = rs.getInt("totalCantidad");

     
                 dataset.setValue(totalCantidad, "Amount", buscarId(idProducto));
        dataset.setValue(totalCantidad, "Amount",buscarId(idProducto));
        dataset.setValue(totalCantidad, "Amount",buscarId(idProducto));
        dataset.setValue(totalCantidad, "Amount", buscarId(idProducto));
        
 
            }
            cx.close();
        } catch (SQLException e)
        {
            System.out.println("Error al cargar motocicleta al comboBox " + e);
        }
      
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Motos más vendidas","MODELOS","Cantidad", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelLineChart.removeAll();
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.validate();
    }
    public void showPieChart() {
          panelLineChart.setVisible(false);
          panelBarChart.setVisible(true);
        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();
        Connection cx = ConectionDB.conectar();
        String sql ="SELECT idProducto, SUM(Cantidad) AS totalCantidad "
                       + "FROM detalle_venta "
                       + "GROUP BY idProducto "
                       + "ORDER BY idProducto";
             String sql1 = "select *from detalle_venta";
        Statement st;
        int contador = 0;
        try
        {
            st = cx.createStatement();
            ResultSet rs1=st.executeQuery(sql1);
            while(rs1.next()){
                int cantidad= rs1.getInt("cantidad");
               contador=contador+cantidad;
            }
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            {
                int idProducto = rs.getInt("idProducto");
                int cantidad = rs.getInt("totalCantidad");
           int aux=100/(contador/cantidad);
                   int aux2=100/(contador/cantidad);
                       int aux3=100/(contador/cantidad);
                       int aux4=100/(contador/cantidad);
                barDataset.setValue(buscarId(idProducto), new Double(aux));
                  barDataset.setValue(buscarId(idProducto), new Double(aux2));
                    barDataset.setValue(buscarId(idProducto), new Double(aux3));
                         barDataset.setValue(buscarId(idProducto), new Double(aux4));
            }
            cx.close();
        } catch (SQLException e)
        {
            System.out.println("Error al generar " + e);
        }
        JFreeChart piechart = ChartFactory.createPieChart("Motos más vendidas", barDataset, false, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();

        //changing pie chart blocks colors
        

        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelBarChart.removeAll();
        panelBarChart.add(barChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();

    }
    
    public String buscarId(int id) {
        try
        {
            String sql = "select * from producto where id_motocicleta='" + id + "';";
            Connection cx = ConectionDB.conectar();
            Statement st;
            st = cx.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {

                nombre = rs.getString("nombre");

                //
            }
        } catch (SQLException e)
        {
            System.out.println("Error al consultar datos:" + e);
        }
        return nombre;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLineChart = new javax.swing.JPanel();
        panelBarChart = new javax.swing.JPanel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLineChart.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelLineChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 600, 600));

        panelBarChart.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 600, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JPanel panelLineChart;
    // End of variables declaration//GEN-END:variables
}
