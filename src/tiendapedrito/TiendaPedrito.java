package tiendapedrito;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 * Clase principal de la aplicación TiendaPedrito, que simula una pequeña tienda
 * donde los usuarios pueden seleccionar productos, agregar cantidades y generar
 * un recibo en PDF. La clase extiende JFrame para proporcionar una interfaz
 * gráfica.
 *
 * @author david
 */
public class TiendaPedrito extends javax.swing.JFrame {

    // Array de productos disponibles en la tienda
    String productos[] = {"Papitas", "Coca-Cola", "Galletas", "Chicle", "Jabon", "Shampoo", "Acondicionador", "Agua", "Helado", "Pan"};
    // Array de precios correspondientes a cada producto
    double precios[] = {5.5, 3, 0.80, 0.40, 2.0, 8.0, 7.0, 1.5, 3.5, 1.0};
    double precio = 0; // Precio del producto seleccionado
    int cantidad = 0;  // Cantidad del producto seleccionada
    DefaultTableModel modelo = new DefaultTableModel(); // Modelo de la tabla que muestra los productos seleccionados
    ArrayList<Venta> listaVentas = new ArrayList<Venta>(); // Lista de ventas realizadas

    /**
     * Constructor de TiendaPedrito. Configura los componentes iniciales de la
     * interfaz.
     */
    public TiendaPedrito() {
        initComponents();
        this.setTitle("TIENDITA PEDRITO");

        // Configuración del ícono de la ventana y el logo en la interfaz
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tienda.png"));
        this.setIconImage(icono);
        Image logo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tienda.png"));
        lblLogo.setIcon(new ImageIcon(logo.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH)));

        // Configuración del tamaño y posición de la ventana
        this.setSize(670, 700);
        this.setLocationRelativeTo(null);

        // Configuración del botón "Agregar" con un ícono
        Image iconoAgregar = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/mas.png"));
        btnAgregar.setIcon(new ImageIcon(iconoAgregar.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));

        // Inicialización del comboBox con los productos
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel(productos);
        cboProductos.setModel(comboModel);

        // Configuración de las columnas en la tabla de productos seleccionados
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("PRECIO.U");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("IMPORTE");

        // Actualizar los datos en la tabla y calcular el precio inicial
        actualizarTabla();
        calcularPrecio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        cboProductos = new javax.swing.JComboBox<>();
        spnCantidad = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        lblImporte = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblIgv = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnImportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 100, 80));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Importe");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Producto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 70, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Cantidad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("S/0.00");
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 570, 100, -1));

        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 70, 60));

        cboProductos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cboProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductosActionPerformed(evt);
            }
        });
        getContentPane().add(cboProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 120, -1));

        spnCantidad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        spnCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCantidadStateChanged(evt);
            }
        });
        getContentPane().add(spnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 60, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Precio");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        lblPrecio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrecio.setText("S/0.00");
        getContentPane().add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 90, -1));

        tblProductos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 550, 270));

        lblImporte.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblImporte.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblImporte.setText("S/0.00");
        getContentPane().add(lblImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 90, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("SUBTOTAL");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("IGV");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 540, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("TOTAL");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 570, -1, -1));

        lblSubtotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotal.setText("S/0.00");
        getContentPane().add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, 100, -1));

        lblIgv.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblIgv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIgv.setText("S/0.00");
        getContentPane().add(lblIgv, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 540, 100, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setText("TIENDITA PEDRITO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        btnImportar.setText("PDF");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });
        getContentPane().add(btnImportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 140, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // Crear una nueva venta con los detalles del producto seleccionado
        Venta venta = new Venta();
        venta.setId(cboProductos.getSelectedIndex());  // Id basado en el índice seleccionado
        venta.setDescripcion(cboProductos.getSelectedItem().toString());  // Nombre del producto
        venta.setPrecio(precio);  // Precio unitario
        venta.setCantidad(cantidad);  // Cantidad seleccionada
        venta.setImporte(precio * cantidad);  // Importe total para el producto seleccionado

        // Verificar si el producto ya está en la lista; si no, agregarlo a la lista
        if (!buscarVenta(venta)) {
            listaVentas.add(venta);
        }

        // Actualizar la tabla de productos y limpiar los datos ingresados
        actualizarTabla();
        borrarVenta();
    }//GEN-LAST:event_btnAgregarActionPerformed

    public boolean buscarVenta(Venta nueva) {
        // Recorre cada venta existente en la lista de ventas
        for (Venta v : listaVentas) {
            // Verifica si el ID de la venta actual coincide con el ID de la nueva venta
            if (v.getId() == nueva.getId()) {
                // Si la venta ya existe, actualiza la cantidad sumando la cantidad de la nueva venta
                int nuevaCantidad = v.getCantidad() + nueva.getCantidad();
                v.setCantidad(nuevaCantidad);

                // Actualiza el importe (precio total) de la venta existente
                v.setImporte(v.getPrecio() * nuevaCantidad);

                // Retorna true ya que la venta fue encontrada y actualizada
                return true;
            }
        }
        // Retorna false si la venta no fue encontrada en la lista
        return false;
    }

    /**
     * Restaura la selección de productos y cantidades a sus valores iniciales.
     * También actualiza el precio mostrado en la interfaz.
     */
    public void borrarVenta() {
        precio = 0;        // Reinicia el precio del producto a 0
        cantidad = 1;      // Reinicia la cantidad a 1

        // Restablece el producto seleccionado en el combo box al primer producto de la lista
        cboProductos.setSelectedIndex(0);

        // Restablece el valor del spinner de cantidad a 1
        spnCantidad.setValue(1);

        // Calcula el precio del producto seleccionado con la cantidad predeterminada
        calcularPrecio();
    }

    private void cboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductosActionPerformed
        calcularPrecio();
    }//GEN-LAST:event_cboProductosActionPerformed

    private void spnCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCantidadStateChanged
        calcularPrecio();
    }//GEN-LAST:event_spnCantidadStateChanged

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        Document document = new Document();
        try {
            String filePath = "compras_tienda_pedrito.pdf"; // Nombre del archivo
            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();

            // Título del PDF
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Compras - Tiendita Pedrito", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" ")); // Espacio en blanco

            // Crear tabla para los productos
            PdfPTable table = new PdfPTable(4); // 4 columnas
            table.setWidthPercentage(100);

            // Encabezados de la tabla
            PdfPCell cell;
            cell = new PdfPCell(new Phrase("Descripción", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Precio Unitario", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Cantidad", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Importe", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
            table.addCell(cell);

            // Agregar los datos de la tabla JTable al PDF
            for (Venta venta : listaVentas) {
                table.addCell(venta.getDescripcion());
                table.addCell("S/" + String.format("%.2f", venta.getPrecio()));
                table.addCell(String.valueOf(venta.getCantidad()));
                table.addCell("S/" + String.format("%.2f", venta.getImporte()));
            }

            document.add(table); // Añadir la tabla al documento

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "PDF generado exitosamente en " + filePath);

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar el PDF", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            document.close();
        }
    }//GEN-LAST:event_btnImportarActionPerformed

    /**
     * Calcula el precio y el importe total en función del producto seleccionado
     * y la cantidad. Actualiza la interfaz gráfica para mostrar estos valores.
     */
    public void calcularPrecio() {
        // Obtiene el precio del producto seleccionado en el comboBox 'cboProductos'
        // La posición seleccionada en el comboBox se usa como índice para acceder al array 'precios'
        precio = precios[cboProductos.getSelectedIndex()];

        // Convierte el valor del spinner 'spnCantidad' a entero y lo asigna a la variable 'cantidad'
        cantidad = Integer.parseInt(spnCantidad.getValue().toString());

        // Actualiza la etiqueta 'lblPrecio' para mostrar el precio del producto seleccionado en formato de moneda
        lblPrecio.setText(aMoneda(precio));

        // Calcula el importe total (precio * cantidad) y actualiza la etiqueta 'lblImporte' para mostrarlo en formato de moneda
        lblImporte.setText(aMoneda(precio * cantidad));
    }

    public String aMoneda(double precio) {
        return "S/ " + Math.round(precio * 100.00) / 100.0 + " PEN";
    }

    public void actualizarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        double subtotal = 0;
        for (Venta v : listaVentas) {
            Object x[] = new Object[4];
            x[0] = v.getDescripcion();
            x[1] = aMoneda(v.getPrecio());
            x[2] = v.getCantidad();
            x[3] = aMoneda(v.getImporte());
            subtotal += v.getImporte();
            modelo.addRow(x);
        }
        double iva = subtotal * 0.18;
        double total = subtotal + iva;
        lblSubtotal.setText(aMoneda(subtotal));
        lblIgv.setText(aMoneda(iva));
        lblTotal.setText(aMoneda(total));
        tblProductos.setModel(modelo);

    }

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
            java.util.logging.Logger.getLogger(TiendaPedrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TiendaPedrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TiendaPedrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TiendaPedrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TiendaPedrito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnImportar;
    private javax.swing.JComboBox<String> cboProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIgv;
    private javax.swing.JLabel lblImporte;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}
