/**********************************************************************************************************************
 *Archivo: DarBaja.java																						          *
 *Autores: 																											  *
 *		 Jorge Ivan Estrada R.																						  *
 *       cod: 0761868																								  *
 *       Diana Marcela Lopez Q. 																					  *
 *       cod: 0761833																								  *
 *		 Melisa Calero Ramirez.																					      *
 *       cod: 0761858 																								  *
 *Fecha de ultima modificacion: 19/12/08																			  *
 *Version: 0.1																										  *
 *Responsabilidad: La clase Permite capturar los datos del formulario de entrada y actualiza 						  * 
 *estos datos en la base de datos cambiando el estado de los mismos.								                  *
 **********************************************************************************************************************/

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DarBaja extends JPanel implements ActionListener
{
	
	JButton Limpiar     = new JButton("Borrar");
	JButton Calcular    = new JButton("Modificar");
	JTextArea areaTexto = new JTextArea();
	JScrollPane barra   = new JScrollPane(areaTexto);
	JLabel Series       = new JLabel("DIGITE EL CODIGO DEL ARTICULO QUE DESEA DAR DE BAJA");
	JLabel code         = new JLabel("CODIGO");
	JTextField codebox  = new JTextField();
	String 	codeActiv;
	String 	codigo;
	int 	state = 05;
	
	public DarBaja()
		{
		
		setLayout(null);

		add(Limpiar);
		add(Calcular);

		add(barra);
		add(Series);
		add(code);
		add(codebox);

		
		Limpiar.setBounds(290,170,200,20);
		Calcular.setBounds(290,140,200,20);
		Series.setBounds(200,25,400,20);			
		barra.setBounds(0,200,780,400);
        code.setBounds   (420,60,80,20);
        codebox.setBounds(510,60,200,20); ; 

		Limpiar.addActionListener(this);
		Calcular.addActionListener(this);
			
	}//fin del contructor
		
		public void actionPerformed(ActionEvent evento)
		{
			if (evento.getSource () == Limpiar)
    	      {
                codebox.setText(""); 
              }
              
              if (evento.getSource () == Calcular)
    	      {
    	      	
			codeActiv = codebox.getText();

			try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexin con la base de datos. Hay que cambiar la url, el usuario y la clave por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/akane","root", "daigaku");
            
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();  
            ResultSet rs = s.executeQuery ("select * from ejemplar WHERE(`CodigoE` = "+codeActiv+")");
            
            // Se recorre el ResultSet.
            while (rs.next())
            {
            }

            s.executeUpdate("UPDATE ejemplar SET CodEs ="+state+" WHERE(`CodigoE` = "+codeActiv+")");
            JOptionPane.showMessageDialog(this, "La operacion de actualizacion ha sido exitosa"
            	+"\n EL ACTIVO HA SIDO DADO DE BAJA");

            conexion.close();
        }
        catch (Exception e)
        {
           JOptionPane.showMessageDialog(this, "No se encontro la cuenta, por favor verifique");
        }
		}}}
		
	