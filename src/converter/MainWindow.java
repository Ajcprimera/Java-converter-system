package converter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Arrays;
import java.util.HashMap;
import java.math.BigDecimal;
import java.util.Locale;

/**
 *
 * @author Albert Carruido and Santiago Pinto
 */
public class MainWindow extends JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        
        strToConverterMap.put("Tasa de transmisión de datos", DataTransferRateConverter.class);
        strToConverterMap.put("Energía", EnergyConverter.class);
        
        comboMeasureType.setModel(new DefaultComboBoxModel<String>( strToConverterMap.keySet().toArray(new String[strToConverterMap.size()]) ));
        comboMeasureType.setSelectedIndex(0);
        
        Runnable convertLeft = () -> convert(fieldFrom, comboFrom, fieldTo, comboTo);
        fromDocListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Insert left");
                changedUpdate(e);
            }

            public void removeUpdate(DocumentEvent e) {
                System.out.println("Remove left");
                changedUpdate(e);
            }

            public void changedUpdate(DocumentEvent e) {
                /*
                Auxiliary.ifelse(conversionMutex > 0,
                    () -> {--conversionMutex; return null;},
                    () -> {conversionMutex = 2; EventQueue.invokeLater(convertLeft); return null;}
                );
                */
                EventQueue.invokeLater(convertLeft);
            }
        };
        fieldFrom.getDocument().addDocumentListener(fromDocListener);
        comboFrom.addActionListener(e -> {/*conversionMutex = 2; */convert(fieldFrom, comboFrom, fieldTo, comboTo);});
        
        Runnable convertRight = () -> convert(fieldTo, comboTo, fieldFrom, comboFrom);
        toDocListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Insert right");
                changedUpdate(e);
            }

            public void removeUpdate(DocumentEvent e) {
                System.out.println("Remove right");
                changedUpdate(e);
            }

            public void changedUpdate(DocumentEvent e) {
                /*
                Auxiliary.ifelse(conversionMutex > 0,
                    () -> {--conversionMutex; return null;},
                    () -> {conversionMutex = 2; EventQueue.invokeLater(convertRight); return null;}
                );
                */
                EventQueue.invokeLater(convertRight);
            }
        };
        fieldTo.getDocument().addDocumentListener(toDocListener);
        comboTo.addActionListener(e -> {/*conversionMutex = 2; */convert(fieldFrom, comboFrom, fieldTo, comboTo);});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        GridBagConstraints gridBagConstraints;

        panelMain = new JPanel();
        comboMeasureType = new JComboBox<>();
        fieldFrom = new JTextField();
        comboFrom = new JComboBox<>();
        labelEqual = new JLabel();
        fieldTo = new JTextField();
        comboTo = new JComboBox<>();
        labelFormula = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversor de unidades");
        setLocationByPlatform(true);

        panelMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelMain.setLayout(new GridBagLayout());

        comboMeasureType.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboMeasureType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboMeasureTypeActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 1.0;
        panelMain.add(comboMeasureType, gridBagConstraints);

        fieldFrom.setColumns(10);
        fieldFrom.setFont(new Font("sansserif", 0, 18)); // NOI18N
        fieldFrom.setText("1");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.5;
        gridBagConstraints.insets = new Insets(20, 0, 0, 0);
        panelMain.add(fieldFrom, gridBagConstraints);

        comboFrom.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(2, 0, 0, 0);
        panelMain.add(comboFrom, gridBagConstraints);

        labelEqual.setFont(new Font("sansserif", 0, 24)); // NOI18N
        labelEqual.setText("=");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(20, 5, 0, 5);
        panelMain.add(labelEqual, gridBagConstraints);

        fieldTo.setColumns(10);
        fieldTo.setFont(new Font("sansserif", 0, 18)); // NOI18N
        fieldTo.setText("1");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.5;
        gridBagConstraints.insets = new Insets(20, 0, 0, 0);
        panelMain.add(fieldTo, gridBagConstraints);

        comboTo.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(2, 0, 0, 0);
        panelMain.add(comboTo, gridBagConstraints);

        labelFormula.setFont(new Font("sansserif", 0, 14)); // NOI18N
        labelFormula.setText("Fórmula: multiplica el valor por 1");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        panelMain.add(labelFormula, gridBagConstraints);

        getContentPane().add(panelMain, BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboMeasureTypeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_comboMeasureTypeActionPerformed
        try {
            converter = (Converter) strToConverterMap.get((String) comboMeasureType.getSelectedItem()).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Error al crear conversor: " + e.getLocalizedMessage());
            return;
        }
        String[] unitNames = converter.getUnitNames().clone();
        //comboFrom.setEnabled(false); comboTo.setEnabled(false);
        comboFrom.setModel(new DefaultComboBoxModel<String>(unitNames));
        comboTo.setModel(new DefaultComboBoxModel<String>(unitNames));
        //comboFrom.setEnabled(true); comboTo.setEnabled(true);
    }//GEN-LAST:event_comboMeasureTypeActionPerformed

    private BigDecimal parseNumber(String input) {
        input = input.replace(',', '.');
        String[] fraction = input.split("/");
        try {
            return Auxiliary.ifelse(fraction.length > 2 || fraction.length == 0, () -> null, () -> 
                Auxiliary.ifelse(fraction.length == 2,
                    () -> parseNumber(fraction[0]).divide(parseNumber(fraction[1])),
                    () -> new BigDecimal(fraction[0])
                )
            );
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    private void convert(JTextField fromText, JComboBox fromUnit, JTextField toText, JComboBox toUnit) {
        BigDecimal number = parseNumber(fromText.getText());
        String from = (String) fromUnit.getSelectedItem();
        String to = (String) toUnit.getSelectedItem();
        Auxiliary.ifelse(number == null, () -> null, () -> {
            DocumentListener listener = toText == fieldTo ? toDocListener : fromDocListener;
            toText.getDocument().removeDocumentListener(listener);
            Auxiliary.ifelse(from.equals(to),
                () -> {toText.setText(number.toString()); return null;},
                () -> {toText.setText(String.format(Locale.US, "%g", converter.convert(from, to, number))); return null;}
            );
            toText.getDocument().addDocumentListener(listener);
            labelFormula.setText(converter.getFormula(from, to));
            return null;
        });
    }
    
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
            Arrays.stream(UIManager.getInstalledLookAndFeels()).anyMatch(info -> 
                (boolean) Auxiliary.ifelse("Nimbus".equals(info.getName()),
                    (Auxiliary.ThrowingSupplier<Boolean>) () -> {
                        UIManager.setLookAndFeel(info.getClassName()); return true;
                    },
                    () -> false
                )
            );
        } catch (RuntimeException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainWindow().setVisible(true));
    }

    private HashMap<String, Class> strToConverterMap = new HashMap<String, Class>(3, 1);
    private Converter converter;
    private int conversionMutex;
    private DocumentListener fromDocListener, toDocListener;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> comboFrom;
    private JComboBox<String> comboMeasureType;
    private JComboBox<String> comboTo;
    private JTextField fieldFrom;
    private JTextField fieldTo;
    private JLabel labelEqual;
    private JLabel labelFormula;
    private JPanel panelMain;
    // End of variables declaration//GEN-END:variables
}
