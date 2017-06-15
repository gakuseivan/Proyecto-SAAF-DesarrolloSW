/**********************************************************************************************************************
 *Archivo: BuscarActivo.java																						  *
 *Autores: 																											  *
 *		 Jorge Ivan Estrada R.																						  *
 *       cod: 0761868																								  *
 *       Diana Marcela Lopez Q. 																					  *
 *       cod: 0761833																								  *
 *		 Melisa Calero Ramirez.																					      *
 *       cod: 0761858 																								  *
 *Fecha de ultima modificacion: 19/12/08																			  *
 *Version: 0.1																										  *
 *Responsabilidad: La clase Permite consultar los datos de un determinado registro en la base de datos.               *
 **********************************************************************************************************************/


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BuscarActivo extends JPanel implements ActionListener
{
	
	JRadioButton radio1 = new JRadioButton("Buscar por nombre");
	JRadioButton radio2 = new JRadioButton("Buscar por Codigo");

	JButton Limpiar     = new JButton("Borrar");
	JButton Calcular    = new JButton("Buscar");
	ButtonGroup grupoBotones = new ButtonGroup();
	JTextArea areaTexto = new JTextArea();
	JScrollPane barra   = new JScrollPane(areaTexto);
	JPanel panelRadio   = new JPanel();
	JLabel Series       = new JLabel("PARA BUSCAR UN ARTICULO DIGITE EL NOMBRE O CODIGO");
	JLabel code         = new JLabel("CODIGO");
	JLabel name         = new JLabel("NOMBRE");
	JLabel dep          = new JLabel("DEPENDENCIAS");
	JTextField codebox  = new JTextField();
	JTextField namebox  = new JTextField();
	String 	codeActiv;
	String 	codigo;
	String  nameActiv;
	
	public BuscarActivo()
		{
		
		setLayout(null);
		panelRadio.setLayout(null);

		grupoBotones.add(radio1);
		grupoBotones.add(radio2);
	
		panelRadio.add(radio1);
		panelRadio.add(radio2);
		//add(opcion);
	
		add(Limpiar);
		add(Calcular);
		add(panelRadio);
		add(barra);
		add(Series);
		add(name);
		add(code);
		add(namebox);
		add(codebox);
		add(dep);
		
		Limpiar.setBounds(290,170,200,20);
		Calcular.setBounds(290,140,200,20);
		Series.setBounds(200,25,400,20);			
		barra.setBounds(0,200,780,400);
        panelRadio.setBounds(150,45,250,100);
        radio1.setBounds (45,25,200,20);
        radio2.setBounds (45,45,200,20);
        dep.setBounds    (20,40,200,20); 
        name.setBounds   (420,60,80,20);
        namebox.setBounds(510,60,200,20);
        code.setBounds   (420,90,80,20);
        codebox.setBounds(510,90,200,20); 
        
		radio1.addActionListener(this);
		radio2.addActionListener(this);
		Limpiar.addActionListener(this);
		Calcular.addActionListener(this);
		
	radio1.addMouseListener( new MouseAdapter()//Radio1

      { public void mouseClicked(MouseEvent e)
      	{
        if(radio1.isSelected()== true )  
           {
		  	codebox.setEnabled   (false);
		  	namebox.setEnabled   (true);	  				
			}	
		  }//end de la ejecucion
      });
      
      
      	radio2.addMouseListener( new MouseAdapter()//Radio2

      { public void mouseClicked(MouseEvent e)
      	{
        if(radio2.isSelected()== true )  
           {
		  	namebox.setEnabled   (false);
		  	codebox.setEnabled   (true);
			}
		  }   //end de la ejecucion
      });
	
	}//fin del contructor
	
		public void actionPerformed(ActionEvent evento)
		{
			codeActiv = codebox.getText();
			nameActiv = namebox.getText();
			Object fuenteEvento = evento.getSource();
			if(fuenteEvento==Limpiar)
      	     {  
      	     	areaTexto.setText(""); 
      	     	codebox.setText("");
      	     	namebox.setText("");
      	     }
      	     
			if(fuenteEvento==Calcular)
      	     {   
      	   	 try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexin con la base de datos. Hay que
            // cambiar la url, el usuario y la clave por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/akane","root", "daigaku");
            
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            
            
            // Se insertan registros
           // s.executeUpdate("select * from ejemplar");

            // Se realiza la consulta. Los resultados se guardan en el 
            // ResultSet rs
      ResultSet rs = s.executeQuery ("select * from ejemplar WHERE(`CodigoE`="+codeActiv+")");
      //or `NombreE`="+nameActiv +"
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next())
            {	
        areaTexto.append("\n"+rs.getString (1) + " " + rs.getString (2)+ " " + rs.getString(3)+ " " + rs.getString(4)+ " " 
   	+ rs.getString (5)+ " " + rs.getString (6)+ " " + rs.getString (7)+ " " + rs.getString (8)+ " " + rs.getInt (9)
   		+ " " + rs.getString(10)+"\n");
            }
            JOptionPane.showMessageDialog(this, "La operacion de consulta fue realizada con exito!");
            // Se cierra la conexin con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "El activo no existe o no se encuentra. Por favor verifique!");
        }
       }
		}}