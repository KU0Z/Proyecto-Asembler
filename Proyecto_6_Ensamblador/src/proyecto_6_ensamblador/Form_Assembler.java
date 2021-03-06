/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_6_ensamblador;

import java.awt.Component;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author keviu
 */
public class Form_Assembler extends javax.swing.JFrame {

    /**
     * Creates new form Form_Assembler
     */
    LinkedList<String> lista= new LinkedList<String>();
    LinkedList<String> resultado= new LinkedList<String>();
    Symbol_table tabla=new Symbol_table();
    public Form_Assembler() {
        initComponents();
        Btnrun.setEnabled(false);
        BTnGuardar.setEnabled(false);
        JMCorrer.setEnabled(false);
        JMGuardar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TALeido = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        Btnrun = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TAresultado = new javax.swing.JTextArea();
        BTnGuardar = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        MenuLeerArchivo = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        JMCorrer = new javax.swing.JMenu();
        JMGuardar = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TALeido.setColumns(20);
        TALeido.setRows(5);
        jScrollPane2.setViewportView(TALeido);

        jButton1.setText("Leer Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Btnrun.setText("Correr");
        Btnrun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnrunActionPerformed(evt);
            }
        });

        TAresultado.setColumns(20);
        TAresultado.setRows(5);
        jScrollPane3.setViewportView(TAresultado);

        BTnGuardar.setText("Guardar Archivo");
        BTnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTnGuardarActionPerformed(evt);
            }
        });

        MenuLeerArchivo.setText("File");

        jMenu5.setText("Leer Archivo");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        MenuLeerArchivo.add(jMenu5);

        JMCorrer.setText("Correr");
        JMCorrer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JMCorrerMouseClicked(evt);
            }
        });
        MenuLeerArchivo.add(JMCorrer);

        JMGuardar.setText("Guardar archivo");
        JMGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JMGuardarMouseClicked(evt);
            }
        });
        MenuLeerArchivo.add(JMGuardar);

        jMenuBar2.add(MenuLeerArchivo);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(Btnrun)
                        .addGap(18, 18, 18)
                        .addComponent(BTnGuardar)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Btnrun)
                    .addComponent(BTnGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String ObtenerRuta(Component a)
    {
     String nuevaRuta = "";
     JFileChooser dialog = new JFileChooser();
     FileNameExtensionFilter filtro = new FileNameExtensionFilter("Adembler", "asm");
     File archivo;
     dialog.setFileFilter(filtro);
     if(dialog.showOpenDialog(a) == JFileChooser.APPROVE_OPTION)
     {
        Btnrun.setEnabled(true);
        JMGuardar.setEnabled(false);
        JMCorrer.setEnabled(true);
        JMGuardar.setEnabled(false);
        archivo = dialog.getSelectedFile();
        nuevaRuta = archivo.getPath();
     }
     return nuevaRuta;
    }
    public void GuardarRuta(Component a) throws IOException
    {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(a) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            FileWriter fw = new FileWriter(file.getPath());
            fw.write(TAresultado.getText());
            fw.close();
            
  // save to file
        }
    }
    public void LeerArchivo()
    {
        String ruta=ObtenerRuta(this);
        String Linea ="";
        lista= new LinkedList<String>();
        resultado=new LinkedList<String>();
        TALeido.setText(null);
        TAresultado.setText(null);
        tabla=new Symbol_table();
        try
        {
            //Si el archivo existe, lo leerá una linea a la vez
            File Archivo = new File(ruta);
            if(Archivo.exists())
            {
            int númLinea = 0;
            RandomAccessFile LeerArchivo = new RandomAccessFile(Archivo,"rw");
            Linea = LeerArchivo.readLine();
            String[] values;
            while(Linea != null)  //Leemos linea por linea hasta el final.
            {            
                if(!"".equals(Linea)){
                    if(!Linea.substring(0,2).equals("//")){
                        if(Linea.contains("//")){
                            values=Linea.split("//");
                            lista.add(values[0].trim());
                            TALeido.append(values[0].trim()+"\n");
                        }
                        else{
                            lista.add(Linea.trim());                 
                            TALeido.append(Linea.trim()+"\n");   
                        }
                    }                                        
                }
                númLinea=(int)LeerArchivo.getFilePointer();
                Linea=LeerArchivo.readLine();
            }
            
            //Cerrar el lector utilizado
            LeerArchivo.close();
            }
        }
        catch(Exception ex){}
    }
    public void PrimeraPasada()
    {
        int i = 0;
        while(i < lista.size())
        {
            if( lista.get(i).contains("(")){
                String etiqueta=lista.get(i);
                etiqueta=etiqueta.substring(1,etiqueta.length()-1);
                tabla.rom.put(etiqueta, i);
                lista.remove(i);
            }
            else
            {
                i++;
            }
        }
        
    }
    public String IntruccionC(String comp,String dest,String jump)
    { 
        String binario="111";
                switch (comp) {
            case "0":  binario = binario+"0101010";
                     break;
            case "1":  binario = binario+"0111111";
                     break;
            case "-1":  binario = binario+"0111010";
                     break;
            case "D":  binario = binario+"0001100";
                     break;
            case "A":  binario = binario+"0110000";
                     break;
            case "!D":  binario = binario+"0001101";
                     break;
            case "!A":  binario = binario+"0110001";
                     break;
            case "-D":  binario = binario+"0001111";
                     break;
            case "-A":  binario = binario+"0110011";
                     break;
            case "D+1":  binario = binario+"0011111";
                     break;
            case "A+1":  binario = binario+"0110111";
                     break;
            case "D-1":  binario = binario+"0001110";
                     break;
            case "A-1":  binario = binario+"0110010";
                     break;
            case "D+A":  binario = binario+"0000010";
                     break;
            case "D-A":  binario = binario+"0010011";
                     break;
            case "A-D":  binario = binario+"0000111";
                     break;
            case "D&A":  binario = binario+"0000000";
                     break;
            case "D|A":  binario = binario+"0010101";
                     break;
            case "M":  binario = binario+"1110000";
                     break;
            case "!M":  binario = binario+"1110001";
                     break;
            case "-M":  binario = binario+"1110011";
                     break;
            case "M+1":  binario = binario+"1110111";
                     break;
            case "M-1":  binario = binario+"1110010";
                     break;
            case "D+M":  binario = binario+"1000010";
                     break;
            case "D-M":  binario = binario+"1010011";
                     break;
            case "M-D":  binario = binario+"1000111";
                     break;
            case "D&M":  binario = binario+"1000000";
                     break;
            case "D|M":  binario = binario+"1010101";
                     break;
            default: binario = binario+"0000000";
                     break;
        }
                switch(dest){
                    case "M":  binario = binario+"001";
                     break;
                    case "D":  binario = binario+"010";
                     break; 
                    case "MD":  binario = binario+"011";
                     break;
                    case "A":  binario = binario+"100";
                     break;
                    case "AM":  binario = binario+"101";
                     break; 
                    case "AD":  binario = binario+"110";
                     break;
                    case "AMD":  binario = binario+"111";
                     break;
                    default: binario = binario+"000";
                     break;
                }
                switch(jump){
                    case "JGT":  binario = binario+"001";
                     break;
                    case "JEQ":  binario = binario+"010";
                     break; 
                    case "JGE":  binario = binario+"011";
                     break;
                    case "JLT":  binario = binario+"100";
                     break;
                    case "JNE":  binario = binario+"101";
                     break; 
                    case "JLE":  binario = binario+"110";
                     break;
                    case "JMP":  binario = binario+"111";
                     break;
                    default: binario = binario+"000";
                     break;
                }
                return binario;
    }
    public String IntruccionA(int numero)
    { 
        String binario=Integer.toBinaryString(numero);
        String ceros="";
        for (int i = binario.length(); i < 16; i++) {
            ceros=ceros+"0";
        }
        return ceros+binario;
        
    }
    
    public void SegundaPasada()
    {
        String[] values;
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).contains(";")){
                values=lista.get(i).split(";");
                resultado.add(IntruccionC(values[0],"null",values[1]));
            }
            else if(lista.get(i).contains("=")){
                values=lista.get(i).split("=");
                resultado.add(IntruccionC(values[1],values[0],"null"));
            }
            else if(lista.get(i).contains("@")){
                values=lista.get(i).split("@");
                try{
                    int num=Integer.parseInt(values[1]);
                    resultado.add(IntruccionA(num));
                }
                catch(Exception e){
                    if(tabla.rom.containsKey(values[1])){
                       resultado.add(IntruccionA(tabla.rom.get(values[1])));
                    }
                    else if(tabla.ram.containsKey(values[1])){
                       resultado.add(IntruccionA(tabla.ram.get(values[1]))); 
                    }
                    else{
                        tabla.rom.put(values[1], tabla.counterRam);
                        resultado.add(IntruccionA(tabla.counterRam));
                        tabla.counterRam++;
                    
                    }
                    
                }
            }
            TAresultado.append(resultado.getLast()+"\n");
        }
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LeerArchivo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnrunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnrunActionPerformed
        // TODO add your handling code here:
        PrimeraPasada();
        SegundaPasada();
        BTnGuardar.setEnabled(true);
        JMGuardar.setEnabled(true);
    }//GEN-LAST:event_BtnrunActionPerformed

    private void BTnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTnGuardarActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Hack", "hack");
        fileChooser.setFileFilter(filtro);
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();          
            try {
                FileWriter fw = new FileWriter(file.getPath()+".hack");
                for (int i = 0; i < resultado.size(); i++) {
                fw.write(resultado.get(i)+"\r\n");    
                }                
            fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Form_Assembler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_BTnGuardarActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        LeerArchivo();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void JMCorrerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMCorrerMouseClicked
        // TODO add your handling code here:
        PrimeraPasada();
        SegundaPasada();
        BTnGuardar.setEnabled(true);
        JMGuardar.setEnabled(true);
    }//GEN-LAST:event_JMCorrerMouseClicked

    private void JMGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMGuardarMouseClicked
        // TODO add your handling code here:
            JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Hack", "hack");
        fileChooser.setFileFilter(filtro);
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();          
            try {
                FileWriter fw = new FileWriter(file.getPath()+".hack");
                for (int i = 0; i < resultado.size(); i++) {
                fw.write(resultado.get(i)+"\r\n");    
                }                
            fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Form_Assembler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_JMGuardarMouseClicked

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Assembler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Assembler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Assembler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Assembler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Assembler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTnGuardar;
    private javax.swing.JButton Btnrun;
    private javax.swing.JMenu JMCorrer;
    private javax.swing.JMenu JMGuardar;
    private javax.swing.JMenu MenuLeerArchivo;
    private javax.swing.JTextArea TALeido;
    private javax.swing.JTextArea TAresultado;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
