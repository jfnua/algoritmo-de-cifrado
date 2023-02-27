
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @descripcion Aplicacion para el cifrado Archivos.
 * 
 * @author Núñez Avila Jose Flaviano
 */
public class CifradoDeArchivos extends javax.swing.JFrame {

    /**
     * Creates new form CifradoDeArchivos
     */
    public CifradoDeArchivos() {
        initComponents();
        this.setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
        //this.setIconImage(new ImageIcon(this.getClass().getResource("./Iconos/icons8_encrypt_30px_1.png")).getImage());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        elegirFichero = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        seleccionarClave = new javax.swing.JLabel();
        labelClaveCifrado = new javax.swing.JLabel();
        generarClave = new javax.swing.JLabel();
        txtArchivoFuente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        seleccionarArchivoFuente = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtArchivoDestino = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        seleccionarArchivoDestino = new javax.swing.JLabel();
        btnCifrar = new javax.swing.JButton();
        btnDescifrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cifrado de Archivos con SDV");
        setBackground(new java.awt.Color(153, 180, 192));
        setIconImage(getIconImage());
        setName("cipherFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(450, 375));

        jPanel1.setBackground(new java.awt.Color(122, 140, 148));

        jPanel2.setBackground(new java.awt.Color(51, 60, 64));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Datos de Archivos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        seleccionarClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_folder_30px_1.png"))); // NOI18N
        seleccionarClave.setToolTipText("Cargar");
        seleccionarClave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seleccionarClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarClaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                seleccionarClaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                seleccionarClaveMouseExited(evt);
            }
        });

        labelClaveCifrado.setBackground(new java.awt.Color(0, 0, 0));
        labelClaveCifrado.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        labelClaveCifrado.setForeground(new java.awt.Color(204, 241, 255));
        labelClaveCifrado.setText("Clave de Cifrado");

        generarClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_key_2_30px_1.png"))); // NOI18N
        generarClave.setToolTipText("Generar, guardar y cargar");
        generarClave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        generarClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generarClaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                generarClaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                generarClaveMouseExited(evt);
            }
        });

        txtArchivoFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArchivoFuenteActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(51, 60, 64));
        jLabel3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 241, 255));
        jLabel3.setText("Archivo fuente");

        seleccionarArchivoFuente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_folder_30px_1.png"))); // NOI18N
        seleccionarArchivoFuente.setToolTipText("Seleccionar");
        seleccionarArchivoFuente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seleccionarArchivoFuente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarArchivoFuenteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                seleccionarArchivoFuenteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                seleccionarArchivoFuenteMouseExited(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 60, 64));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Datos de Cifrado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 241, 255));
        jLabel4.setText("Archivo destino");

        seleccionarArchivoDestino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_folder_30px_1.png"))); // NOI18N
        seleccionarArchivoDestino.setToolTipText("Seleccionar");
        seleccionarArchivoDestino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seleccionarArchivoDestino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarArchivoDestinoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                seleccionarArchivoDestinoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                seleccionarArchivoDestinoMouseExited(evt);
            }
        });

        btnCifrar.setBackground(new java.awt.Color(51, 60, 64));
        btnCifrar.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        btnCifrar.setForeground(new java.awt.Color(250, 250, 250));
        btnCifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_data_encryption_23px.png"))); // NOI18N
        btnCifrar.setText("Cifrar");
        btnCifrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCifrarActionPerformed(evt);
            }
        });

        btnDescifrar.setBackground(new java.awt.Color(51, 60, 64));
        btnDescifrar.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        btnDescifrar.setForeground(new java.awt.Color(250, 250, 250));
        btnDescifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8_Open_Lock_23px.png"))); // NOI18N
        btnDescifrar.setText("Descifrar");
        btnDescifrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescifrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtArchivoFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seleccionarArchivoFuente))
                            .addComponent(labelClaveCifrado)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtArchivoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seleccionarArchivoDestino)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seleccionarClave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(generarClave)
                                .addGap(38, 38, 38))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDescifrar)
                                .addGap(58, 58, 58))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelClaveCifrado)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seleccionarClave)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generarClave))
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtArchivoFuente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seleccionarArchivoFuente))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtArchivoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCifrar)
                            .addComponent(btnDescifrar)))
                    .addComponent(seleccionarArchivoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarClaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarClaveMouseClicked
        elegirFichero.setSelectedFile(new File(""));
        elegirFichero.setDialogTitle("Seleccionar Clave");
        elegirFichero.setApproveButtonText("Seleccionar");
        int resp;
 
        resp=elegirFichero.showOpenDialog(this);

        if (resp==JFileChooser.APPROVE_OPTION) {
            String rutaArchivo = elegirFichero.getSelectedFile().toString();
            int error = this.leerClave(rutaArchivo);
            if(error != 0) {
                JOptionPane.showMessageDialog(this, "[-] No se pudo cargar la clave.", "ERROR", 0);
            } else {
                JOptionPane.showMessageDialog(this, "[+] Se cargo la clave correctamente.", "Success", 1);
                txtClave.setText(rutaArchivo);
            }
        }
        
    }//GEN-LAST:event_seleccionarClaveMouseClicked

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void generarClaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generarClaveMouseClicked
        elegirFichero.setSelectedFile(new File(""));
        elegirFichero.setDialogTitle("Guardar Clave");
        elegirFichero.setApproveButtonText("Guardar");
        int resp;
 
        resp=elegirFichero.showOpenDialog(this);

        if (resp==JFileChooser.APPROVE_OPTION) {
            elegirFichero.setSelectedFile(new File(elegirFichero.getSelectedFile().toString()+".key"));
            String rutaArchivo = elegirFichero.getSelectedFile().toString();
            int error = this.generarYguardarClaves(rutaArchivo);
            if(error != 0) {
                JOptionPane.showMessageDialog(this,"[-] No se puedo guardar la clave correctamente.","Error",0);
            } else{
                JOptionPane.showMessageDialog(this,"[+] Se completo el guardado y carga de la clave correctamente.","Success",1); 
                txtClave.setText(rutaArchivo);
            }
        }
        
    }//GEN-LAST:event_generarClaveMouseClicked

    private void txtArchivoFuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArchivoFuenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArchivoFuenteActionPerformed

    private void seleccionarArchivoFuenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarArchivoFuenteMouseClicked
        elegirFichero.setSelectedFile(new File(""));
        elegirFichero.setDialogTitle("Seleccionar Archivo");
        elegirFichero.setApproveButtonText("Seleccionar");
        int resp;
 
        resp=elegirFichero.showOpenDialog(this);

        if (resp==JFileChooser.APPROVE_OPTION) {
            this.archivoFuente = elegirFichero.getSelectedFile().toString();
            txtArchivoFuente.setText(this.archivoFuente);
        }
    }//GEN-LAST:event_seleccionarArchivoFuenteMouseClicked

    private void seleccionarArchivoDestinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarArchivoDestinoMouseClicked
        elegirFichero.setSelectedFile(new File(""));
        elegirFichero.setDialogTitle("Guardar Archivo | No añadir extension");
        elegirFichero.setApproveButtonText("Guardar");
        int resp;
 
        resp=elegirFichero.showOpenDialog(this);

        if (resp==JFileChooser.APPROVE_OPTION) {
            this.archivoDestino = elegirFichero.getSelectedFile().toString();
            txtArchivoDestino.setText(this.archivoDestino);
        }
    }//GEN-LAST:event_seleccionarArchivoDestinoMouseClicked

    private void btnCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCifrarActionPerformed
        try {
            this.setCursor(WAIT_CURSOR);
            if(!this.clave.equals("") && !this.archivoFuente.equals("") && !this.archivoDestino.equals("")){
                AlgoritmoSDV sdv = new AlgoritmoSDV(this.clave, this.constante);
                int error = sdv.cifrarArchivo(this.archivoFuente, this.archivoDestino);
                if(error != 0) {
                    JOptionPane.showMessageDialog(this,"[-] No se puedo cifrar correctamente el archivo.","Error",0);
                } else {
                    JOptionPane.showMessageDialog(this,"[+] Se ha cifrado correctamente el archivo. Guardado en " + this.archivoDestino,"Success",1);
                    txtArchivoFuente.setText("");
                    txtArchivoDestino.setText("");
                }
            }
            this.setCursor(DEFAULT_CURSOR);
        } catch (ExcepcionLongitudClave ex) {
            this.setCursor(DEFAULT_CURSOR);
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnCifrarActionPerformed

    private void btnDescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescifrarActionPerformed
        try {
            this.setCursor(WAIT_CURSOR);
            if(!this.clave.equals("") && !this.archivoFuente.equals("") && !this.archivoDestino.equals("")){
                AlgoritmoSDV sdv = new AlgoritmoSDV(this.clave, this.constante);
                int error = sdv.descifrarArchivo(this.archivoFuente, this.archivoDestino);
                if(error != 0) {
                    JOptionPane.showMessageDialog(this,"[-] No se puedo descifrar correctamente el archivo.","Error",0);
                } else {
                    JOptionPane.showMessageDialog(this,"[+] Se ha descifrado correctamente el archivo. Guardado en " + this.archivoDestino,"Success",1);
                    txtArchivoFuente.setText("");
                    txtArchivoDestino.setText("");
                }
            }
            this.setCursor(DEFAULT_CURSOR);
        } catch (ExcepcionLongitudClave ex) {
            this.setCursor(DEFAULT_CURSOR);
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnDescifrarActionPerformed

    private void seleccionarArchivoFuenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarArchivoFuenteMouseEntered
        seleccionarArchivoFuente.setIcon(new ImageIcon(this.getClass().getResource("./Iconos/icons8_folder_30px.png")));
    }//GEN-LAST:event_seleccionarArchivoFuenteMouseEntered

    private void seleccionarArchivoFuenteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarArchivoFuenteMouseExited
        seleccionarArchivoFuente.setIcon(new ImageIcon(this.getClass().getResource("./Iconos/icons8_folder_30px_1.png")));
    }//GEN-LAST:event_seleccionarArchivoFuenteMouseExited

    private void seleccionarClaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarClaveMouseEntered
        seleccionarClave.setIcon(new ImageIcon(this.getClass().getResource("./Iconos/icons8_folder_30px.png")));
    }//GEN-LAST:event_seleccionarClaveMouseEntered

    private void seleccionarClaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarClaveMouseExited
        seleccionarClave.setIcon(new ImageIcon(this.getClass().getResource("./Iconos/icons8_folder_30px_1.png")));

    }//GEN-LAST:event_seleccionarClaveMouseExited

    private void seleccionarArchivoDestinoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarArchivoDestinoMouseEntered
        seleccionarArchivoDestino.setIcon(new ImageIcon(this.getClass().getResource("./Iconos/icons8_folder_30px.png")));
    }//GEN-LAST:event_seleccionarArchivoDestinoMouseEntered

    private void seleccionarArchivoDestinoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarArchivoDestinoMouseExited
        seleccionarArchivoDestino.setIcon(new ImageIcon(this.getClass().getResource("./Iconos/icons8_folder_30px_1.png")));
    }//GEN-LAST:event_seleccionarArchivoDestinoMouseExited

    private void generarClaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generarClaveMouseEntered
        generarClave.setIcon(new ImageIcon(this.getClass().getResource("./Iconos/icons8_key_2_30px.png")));
    }//GEN-LAST:event_generarClaveMouseEntered

    private void generarClaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generarClaveMouseExited
        generarClave.setIcon(new ImageIcon(this.getClass().getResource("./Iconos/icons8_key_2_30px_1.png")));
    }//GEN-LAST:event_generarClaveMouseExited

    private int leerClave(String ruta) {
        try {
            byte[] bytesClave = new byte[256];
            DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(ruta)));
            int finDeArchivo = 0;

            // Se leen bytes del archivo, se cifran y se escriben en el archivo nuevo cifrado
            input.read(bytesClave,0,256);
            int[] intsClave = AlgoritmoSDV.convertirByteArrayToArrayInt(bytesClave);
            this.clave = AlgoritmoSDV.arrayIntToString(intsClave);
            this.constante = input.readLong();
            input.close();            
            
        } catch (FileNotFoundException fex) {
            return 1;
        } catch(IOException iex){
            return 2;
        }
        return 0;
    }
    
    private int generarYguardarClaves(String rutaGuardar) {
        
        //Genera la claves de cifrado
        String clave = AlgoritmoSDV.generarClave();
        long constante = AlgoritmoSDV.generarConstante();
        
        try {
            //Guarda la clave en la ruta de archivo
            DataOutputStream archivoCifrado = new DataOutputStream(new FileOutputStream(rutaGuardar));
            archivoCifrado.writeBytes(clave);
            archivoCifrado.writeLong(constante);
            archivoCifrado.close();
            this.leerClave(rutaGuardar);
        } catch(IOException iex) {
            return 1;
        }
        return 0;
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
            java.util.logging.Logger.getLogger(CifradoDeArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CifradoDeArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CifradoDeArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CifradoDeArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CifradoDeArchivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCifrar;
    private javax.swing.JButton btnDescifrar;
    private javax.swing.JFileChooser elegirFichero;
    private javax.swing.JLabel generarClave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelClaveCifrado;
    private javax.swing.JLabel seleccionarArchivoDestino;
    private javax.swing.JLabel seleccionarArchivoFuente;
    private javax.swing.JLabel seleccionarClave;
    private javax.swing.JTextField txtArchivoDestino;
    private javax.swing.JTextField txtArchivoFuente;
    private javax.swing.JTextField txtClave;
    // End of variables declaration//GEN-END:variables
    private String clave = "";
    private long constante;
    private String archivoFuente = "";
    private String archivoDestino = "";
    //private FileNameExtensionFilter tipoArchivo1 = new FileNameExtensionFilter("ENC FILES", "enc");
    //private FileNameExtensionFilter tipoArchivo2 = new FileNameExtensionFilter("KEY FILES", "key");
}
