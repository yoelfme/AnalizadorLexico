package proyectoautomatas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

/**
 *
 * @author YOEL, BESLY Y BALLARDO
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    
    private String direccionArchivo;
    private static int contadorArchivos;
    private ManejarArchivos manejador;
    
    
    public PantallaPrincipal() {
        contadorArchivos=0;
        manejador = new ManejarArchivos();
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.opAbri.setActionCommand("cmd_open");
        this.opGuardar.setActionCommand("cmd_save");
        this.opNuevo.setActionCommand("cmd_new");
        this.btnNuevo.setActionCommand("cmd_new2");
        this.btnAbrir.setActionCommand("cmd_open2");
        this.btnGuardar.setActionCommand("cmd_save2");
        this.btnGuardarComo.setActionCommand("cmd_saveas2");
        
        
        //Añadimos el Icono al Frame
        this.setIconImage(new ImageIcon(getClass().getResource("/iconos/logo.png")).getImage());

        //Agregamos los Numeros de Linea para el cuadro de lado izquierdo
        //panelCodigo.setBorder(BorderFactory.createEmptyBorder(50,50,20,20));
	this.panelEditor.setLayout(new BorderLayout());
        this.txtAreaTexto.setFont( new Font("levenim mt", Font.PLAIN, 14) );
	JScrollPane scrollPane = new JScrollPane(txtAreaTexto);
	this.panelEditor.add(scrollPane);
	scrollPane.setPreferredSize(new Dimension(300, 250));
	NumeroLineas columnaLineas = new NumeroLineas( this.txtAreaTexto );
	scrollPane.setRowHeaderView( columnaLineas );
        this.txtAreaTexto.setSelectionStart(100);
        
        //Agregamos los Numeros de Linea para el cuadro de lado derecho
	this.panelEditor2.setLayout(new BorderLayout());
        this.txtAreaTexto2.setFont( new Font("levenim mt", Font.PLAIN, 14) );
	JScrollPane scrollPane2 = new JScrollPane(txtAreaTexto2);
	this.panelEditor2.add(scrollPane2);
	scrollPane2.setPreferredSize(new Dimension(300, 250));
	NumeroLineas columnaLineas2 = new NumeroLineas( this.txtAreaTexto2 );
	scrollPane2.setRowHeaderView(columnaLineas2);
        this.txtAreaTexto2.setSelectionStart(100);
        
        // Desactivar el area de texto dos
        this.txtAreaTexto2.setEditable(false);
        
        //Nombramos al primer documento
        this.setTitle("Programa " + ++contadorArchivos + " | Compilador");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarComo = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnTokens = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        panelErrores = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblErrores = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultados = new javax.swing.JTextArea();
        panelEditor2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaTexto2 = new javax.swing.JTextArea();
        lblFila = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        lblColumna = new javax.swing.JLabel();
        panelEditor = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAreaTexto = new javax.swing.JTextArea();
        menuPrincipal = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        opNuevo = new javax.swing.JMenuItem();
        opAbri = new javax.swing.JMenuItem();
        opGuardar = new javax.swing.JMenuItem();
        opSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuAyuda = new javax.swing.JMenu();
        opAyuda = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador 3M");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setMaximumSize(new java.awt.Dimension(85, 60));
        btnNuevo.setMinimumSize(new java.awt.Dimension(85, 60));
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/abrir.png"))); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.setFocusable(false);
        btnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbrir.setMaximumSize(new java.awt.Dimension(85, 60));
        btnAbrir.setMinimumSize(new java.awt.Dimension(85, 60));
        btnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAbrir);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setMaximumSize(new java.awt.Dimension(85, 60));
        btnGuardar.setMinimumSize(new java.awt.Dimension(85, 60));
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        btnGuardarComo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardarComo.png"))); // NOI18N
        btnGuardarComo.setText("Guardar Como");
        btnGuardarComo.setFocusable(false);
        btnGuardarComo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarComo.setMaximumSize(new java.awt.Dimension(85, 60));
        btnGuardarComo.setMinimumSize(new java.awt.Dimension(85, 60));
        btnGuardarComo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardarComo);

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimir2.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setFocusable(false);
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setMaximumSize(new java.awt.Dimension(85, 60));
        btnImprimir.setMinimumSize(new java.awt.Dimension(85, 60));
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnImprimir);
        jToolBar1.add(jSeparator1);

        btnTokens.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnTokens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/token.png"))); // NOI18N
        btnTokens.setText("Tabla Tokens (A.Lexico)");
        btnTokens.setFocusable(false);
        btnTokens.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTokens.setMaximumSize(new java.awt.Dimension(85, 60));
        btnTokens.setMinimumSize(new java.awt.Dimension(85, 60));
        btnTokens.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTokens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTokensActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTokens);

        btnEjecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ejecutar.png"))); // NOI18N
        btnEjecutar.setText("Convertir");
        btnEjecutar.setEnabled(false);
        btnEjecutar.setFocusable(false);
        btnEjecutar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEjecutar.setMaximumSize(new java.awt.Dimension(85, 60));
        btnEjecutar.setMinimumSize(new java.awt.Dimension(85, 60));
        btnEjecutar.setPreferredSize(new java.awt.Dimension(69, 57));
        btnEjecutar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEjecutar);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblTokens);

        panelErrores.addTab("Tabla de Tokens", jScrollPane2);

        tblErrores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblErrores);

        panelErrores.addTab("Tabla de Errores", jScrollPane3);

        txtResultados.setColumns(20);
        txtResultados.setRows(5);
        jScrollPane1.setViewportView(txtResultados);

        panelErrores.addTab("Resultados Analisis Sintactico", jScrollPane1);

        panelEditor2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelEditor2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                panelEditor2KeyReleased(evt);
            }
        });

        jScrollPane4.setFont(new java.awt.Font("Levenim MT", 0, 11)); // NOI18N

        txtAreaTexto2.setBackground(new java.awt.Color(227, 227, 227));
        txtAreaTexto2.setColumns(20);
        txtAreaTexto2.setRows(5);
        txtAreaTexto2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAreaTexto2KeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(txtAreaTexto2);

        javax.swing.GroupLayout panelEditor2Layout = new javax.swing.GroupLayout(panelEditor2);
        panelEditor2.setLayout(panelEditor2Layout);
        panelEditor2Layout.setHorizontalGroup(
            panelEditor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditor2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelEditor2Layout.setVerticalGroup(
            panelEditor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditor2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.setEditable(false);
        jTextField1.setText("Fila:");

        jTextField2.setEditable(false);
        jTextField2.setText("Columna:");

        panelEditor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelEditor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                panelEditorKeyReleased(evt);
            }
        });

        jScrollPane5.setFont(new java.awt.Font("Levenim MT", 0, 11)); // NOI18N

        txtAreaTexto.setBackground(new java.awt.Color(227, 227, 227));
        txtAreaTexto.setColumns(20);
        txtAreaTexto.setRows(5);
        txtAreaTexto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtAreaTextoCaretUpdate(evt);
            }
        });
        txtAreaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAreaTextoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAreaTextoKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(txtAreaTexto);

        javax.swing.GroupLayout panelEditorLayout = new javax.swing.GroupLayout(panelEditor);
        panelEditor.setLayout(panelEditorLayout);
        panelEditorLayout.setHorizontalGroup(
            panelEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelEditorLayout.setVerticalGroup(
            panelEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        menuArchivo.setText("Archivo");

        opNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        opNuevo.setText("Nuevo");
        opNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opNuevoActionPerformed(evt);
            }
        });
        menuArchivo.add(opNuevo);

        opAbri.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        opAbri.setText("Abrir");
        opAbri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opAbriActionPerformed(evt);
            }
        });
        menuArchivo.add(opAbri);

        opGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        opGuardar.setText("Guardar");
        opGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opGuardarActionPerformed(evt);
            }
        });
        menuArchivo.add(opGuardar);

        opSalir.setText("Salir");
        menuArchivo.add(opSalir);

        menuPrincipal.add(menuArchivo);

        jMenu2.setText("Edicion");
        menuPrincipal.add(jMenu2);

        menuAyuda.setText("Ayuda");

        opAyuda.setText("Ayuda");
        menuAyuda.add(opAyuda);

        jMenuItem2.setText("Acerca de...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuAyuda.add(jMenuItem2);

        menuPrincipal.add(menuAyuda);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelErrores, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFila, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(panelEditor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelEditor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(lblFila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblColumna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        try 
        {
            manejador.AbrirArchivo(this.txtAreaTexto);
            if (manejador.obtenerNombreArchivo() == null){
                this.setTitle("Programa " + (++contadorArchivos) + "| Compilador");
            }
            else{
                this.setTitle(manejador.obtenerNombreArchivo() + " | Compilador");
            }
            
            this.direccionArchivo=manejador.obtenerDireccionArchivo();
        } catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(this, ex);
        }
        
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try 
        {
            manejador.Guardar(this.txtAreaTexto);
        } catch (FileNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComoActionPerformed
        try 
        {
            manejador.GuardarComo(this.txtAreaTexto);
            this.setTitle(manejador.obtenerNombreArchivo() + " | Compilador");
        } catch (FileNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnGuardarComoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        try 
        {
            manejador.Nuevo(this.txtAreaTexto);
            contadorArchivos++;
            this.setTitle("Programa " + contadorArchivos + " | Compilador");
        } catch (FileNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtAreaTexto2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaTexto2KeyPressed
       
    }//GEN-LAST:event_txtAreaTexto2KeyPressed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        //
        PDF imprimir = new PDF(this.getTitle(),"prueba",this.txtAreaTexto);
        
         //Preguntar al usuario si desea abrir el documento PDF

            int respuesta = JOptionPane.showConfirmDialog(null,"Se ha generado el documento "+ "prueba"+", ¿Desea abrirlo?","Pregunta",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            //Si la respuesta es SI, abrirlo
                if(respuesta == JOptionPane.YES_OPTION)
                    imprimir.abrirPDF ();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnTokensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTokensActionPerformed
        AnalizadorLexico analizar = new AnalizadorLexico(this.txtAreaTexto);
        this.tblTokens.setModel(analizar.miTabla);
        this.tblErrores.setModel(analizar.miTablaErrores);
        if (analizar.obtenerResultadoAnalisis() == 0){
            JOptionPane.showMessageDialog(this,"Analisis ejecutado exitosamente","Informe",JOptionPane.INFORMATION_MESSAGE);
            this.btnEjecutar.setEnabled(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Se encontraron " + analizar.obtenerResultadoAnalisis() + " errores,\nVer tabla de errores","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTokensActionPerformed

    private void panelEditor2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelEditor2KeyReleased
        this.btnEjecutar.setEnabled(false);
    }//GEN-LAST:event_panelEditor2KeyReleased

    private void txtAreaTextoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtAreaTextoCaretUpdate
        int pos = evt.getDot();
        try {
           int fila = txtAreaTexto.getLineOfOffset( pos ) + 1;
           int columna = pos - txtAreaTexto.getLineStartOffset( fila - 1 ) + 1;
           lblFila.setText(fila + "");
           lblColumna.setText(columna + "");
       }
       catch( BadLocationException exc ){ 
           System.out.println(exc); 
       }
    }//GEN-LAST:event_txtAreaTextoCaretUpdate

    private void txtAreaTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaTextoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaTextoKeyPressed

    private void txtAreaTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaTextoKeyReleased
        this.btnEjecutar.setEnabled(false);
    }//GEN-LAST:event_txtAreaTextoKeyReleased

    private void panelEditorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelEditorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_panelEditorKeyReleased

    private void opNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opNuevoActionPerformed
        try 
        {
            manejador.Nuevo(this.txtAreaTexto);
            contadorArchivos++;
            this.setTitle("Programa " + contadorArchivos + " | Compilador");
        } catch (FileNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_opNuevoActionPerformed

    private void opAbriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opAbriActionPerformed
        try 
        {
            manejador.AbrirArchivo(this.txtAreaTexto);
            if (manejador.obtenerNombreArchivo() == null){
                this.setTitle("Programa " + (++contadorArchivos) + "| Compilador");
            }
            else{
                this.setTitle(manejador.obtenerNombreArchivo() + " | Compilador");
            }
            
            this.direccionArchivo=manejador.obtenerDireccionArchivo();
        } catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_opAbriActionPerformed

    private void opGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opGuardarActionPerformed
        try 
        {
            manejador.Guardar(this.txtAreaTexto);
        } catch (FileNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_opGuardarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        Convertidor convertidor = new Convertidor((DefaultTableModel) this.tblTokens.getModel());
        
        String codigoFinal = convertidor.convertir();
        System.out.println(codigoFinal);
        this.txtAreaTexto2.setText(codigoFinal);
    }//GEN-LAST:event_btnEjecutarActionPerformed

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarComo;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnTokens;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblColumna;
    private javax.swing.JLabel lblFila;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenuItem opAbri;
    private javax.swing.JMenuItem opAyuda;
    private javax.swing.JMenuItem opGuardar;
    private javax.swing.JMenuItem opNuevo;
    private javax.swing.JMenuItem opSalir;
    private javax.swing.JPanel panelEditor;
    private javax.swing.JPanel panelEditor2;
    private javax.swing.JTabbedPane panelErrores;
    private javax.swing.JTable tblErrores;
    private javax.swing.JTable tblTokens;
    private javax.swing.JTextArea txtAreaTexto;
    private javax.swing.JTextArea txtAreaTexto2;
    private javax.swing.JTextArea txtResultados;
    // End of variables declaration//GEN-END:variables
}
