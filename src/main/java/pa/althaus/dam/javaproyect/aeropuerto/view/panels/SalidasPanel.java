package pa.althaus.dam.javaproyect.aeropuerto.view.panels;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pa.althaus.dam.javaproyect.aeropuerto.model.DailyFlight;
import pa.althaus.dam.javaproyect.aeropuerto.controller.SalidasController;


/**
 *
 * @author Imper
 */
public class SalidasPanel extends javax.swing.JPanel {

    private final SalidasController salidasController;
    private final DefaultTableModel tableModel = new DefaultTableModel();

    public SalidasPanel() {
        this.salidasController = new SalidasController();
        initComponents();
        inicializarTabla();
    }

 private void inicializarTabla() {
    tableModel.addColumn("Hora de Salida");
    tableModel.addColumn("Detalles del Vuelo"); 
    tblSalidasDatos.setModel(tableModel);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lblSalidas = new javax.swing.JLabel();
        tblSalidas = new javax.swing.JScrollPane();
        tblSalidasDatos = new javax.swing.JTable();
        btnEnviar = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        airportSelector = new javax.swing.JComboBox<>();

        lblSalidas.setText("Salidas del Aeropuerto");

        tblSalidas.setViewportView(tblSalidasDatos);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        airportSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(lblSalidas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(airportSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnEnviar)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblSalidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEnviar)
                        .addComponent(airportSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        try {
            LocalDate selectedDate = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            String selectedAirport = (String) airportSelector.getSelectedItem();

            // Obtener salidas para la fecha y aeropuerto seleccionados, ordenadas por hora de salida ascendente
            HashMap<Integer, DailyFlight> salidas = salidasController.obtenerSalidas(selectedDate);

            // Mostrar salidas en la tabla
            actualizarTablaSalidas(salidas);
        } catch (DateTimeException e) {
            // Manejar la excepción de conversión de fecha
            e.printStackTrace();
            // Mostrar un mensaje de error al usuario
            JOptionPane.showMessageDialog(this, "Error al procesar la fecha.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void actualizarTablaSalidas(HashMap<Integer, DailyFlight> salidas) {
        // Limpiar el modelo de la tabla antes de agregar nuevas filas
        tableModel.setRowCount(0);

        for (DailyFlight salida : salidas.values()) {
            // Agregar filas al modelo de la tabla
            Object[] rowData = {salida.getHoraSalida(), salida.getFlight()};  // Aquí usamos getFlight() en lugar de DailyFlight.toString()
            tableModel.addRow(rowData);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> airportSelector;
    private javax.swing.JButton btnEnviar;
    private com.toedter.calendar.JDateChooser dateChooser;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel lblSalidas;
    private javax.swing.JScrollPane tblSalidas;
    private javax.swing.JTable tblSalidasDatos;
    // End of variables declaration//GEN-END:variables
}
