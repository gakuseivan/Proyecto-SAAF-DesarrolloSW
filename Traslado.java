/**********************************************************************************************************************
 *Archivo: Traslado.java																						          *
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
 *estos datos en la base de datos.																	                  *
 **********************************************************************************************************************/

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.awt.print.*;

public class Traslado extends JPanel implements ActionListener
{
	JLabel titulo          = new JLabel("ORDEN DE TRASLADO DEFINITIVO DE ARTICULOS");
    JLabel digite          = new JLabel("ENTREGA");
    JLabel de              = new JLabel("DE");
    JLabel facultadL       = new JLabel("FACULTAD");
	JLabel deptoL      	   = new JLabel("DEPARTAMENTO");
	JLabel seccionL        = new JLabel("SECCION/OFICINA");
	JLabel nombreL     	   = new JLabel("NOMBRE");
	JLabel cedulaL         = new JLabel("CEDULA");
	JTextField facultad    = new JTextField();
	JTextField depto       = new JTextField();
	JTextField seccion     = new JTextField();
	JTextField nombre      = new JTextField();
	JTextField cedula      = new JTextField();
	JLabel recibe          = new JLabel("RECIBE");
	JLabel a               = new JLabel("A");
	JLabel facultad2L      = new JLabel("FACULTAD");
	JLabel depto2L         = new JLabel("DEPARTAMENTO");
	JLabel seccion2L       = new JLabel("SECCION/OFICINA");
	JLabel nombre2L        = new JLabel("NOMBRE");
	JLabel cedula2L        = new JLabel("CEDULA");
	JTextField facultad2   = new JTextField();
	JTextField depto2      = new JTextField();
	JTextField seccion2    = new JTextField();
	JTextField nombre2     = new JTextField();
	JTextField cedula2     = new JTextField();
	JLabel inventarioL     = new JLabel("N INVENTARIO");
	JLabel articuloL       = new JLabel("DESCRIPCION DEL ARTICULO");
	JLabel marcaL          = new JLabel("MARCA");
	JLabel serieL          = new JLabel("SERIE");
	JLabel cantidadL       = new JLabel("CANTIDAD");
	JLabel autorizadoL     = new JLabel("AUTORIZADO POR");
	JLabel firma           = new JLabel("Firma y cedula");
	JLabel retiradoL       = new JLabel("RETIRADO POR");
	JLabel firma2          = new JLabel("Firma y cedula");
	JLabel vistoBL         = new JLabel("VB INVENTARIOS");
	JLabel recibeCL        = new JLabel("RECIBI");
	JButton clear          = new JButton("LIMPIAR");
	JButton send           = new JButton("ENVIAR");
	JButton close          = new JButton("SALIR");
	JButton print          = new JButton("IMPRIMIR");
		
	JTextField inventario1      = new JTextField();
	JTextField inventario2      = new JTextField();
	JTextField inventario3      = new JTextField();
	JTextField inventario4      = new JTextField();
	JTextField inventario5      = new JTextField();
	JTextField inventario6      = new JTextField();
	JTextField inventario7      = new JTextField();
	JTextField inventario8      = new JTextField();
	JTextField inventario9      = new JTextField();
	JTextField inventario10     = new JTextField();
	JTextField articulo1        = new JTextField();
	JTextField articulo2        = new JTextField();
	JTextField articulo3        = new JTextField();
	JTextField articulo4        = new JTextField();
	JTextField articulo5        = new JTextField();
	JTextField articulo6        = new JTextField();
	JTextField articulo7        = new JTextField();
	JTextField articulo8        = new JTextField();
	JTextField articulo9        = new JTextField();
	JTextField articulo10       = new JTextField();	
	JTextField marca1           = new JTextField();
	JTextField marca2           = new JTextField();
	JTextField marca3           = new JTextField();
	JTextField marca4           = new JTextField();
	JTextField marca5           = new JTextField();
	JTextField marca6           = new JTextField();
	JTextField marca7           = new JTextField();
	JTextField marca8           = new JTextField();
	JTextField marca9           = new JTextField();
	JTextField marca10          = new JTextField();
	JTextField serie1           = new JTextField();
	JTextField serie2           = new JTextField();
	JTextField serie3           = new JTextField();
	JTextField serie4           = new JTextField();
	JTextField serie5           = new JTextField();
	JTextField serie6           = new JTextField();
	JTextField serie7           = new JTextField();
	JTextField serie8           = new JTextField();
	JTextField serie9           = new JTextField();
	JTextField serie10          = new JTextField();
	JTextField cantidad1        = new JTextField();
	JTextField cantidad2        = new JTextField();
	JTextField cantidad3        = new JTextField();
	JTextField cantidad4        = new JTextField();
	JTextField cantidad5        = new JTextField();
	JTextField cantidad6        = new JTextField();
	JTextField cantidad7        = new JTextField();
	JTextField cantidad8        = new JTextField();
	JTextField cantidad9        = new JTextField();
	JTextField cantidad10       = new JTextField();
	
	JTextField autorizado      = new JTextField();
	JTextField retirado        = new JTextField();
	JTextField vistoB          = new JTextField();
	JTextField recibeC         = new JTextField();
	
	JPanel panel1          = new JPanel();
	JPanel panel2          = new JPanel();
	JPanel panel3          = new JPanel();

	Image imagen  = new ImageIcon("jpg\\logo_univalle.jpg").getImage();
	
	String codeA;
	int state = 04;
	
	public Traslado()
   { 
    setLayout(null);	
    add(panel1);
    add(panel2);
    add(panel3);
    add(titulo);
    add(print);
    add(clear);
    add(send);
    add(close);
    add(print);
       
    panel1.setBounds(20,40,800,200);
    panel1.setBorder (BorderFactory.createTitledBorder ("SERVICIOS"));
	panel1.setLayout (null);
    panel1.add(digite);
    panel1.add(de);
    panel1.add(a);
    panel1.add(facultad);
    panel1.add(depto);
    panel1.add(seccion);
    panel1.add(nombre);
    panel1.add(cedula);
    
    panel1.add(facultadL);
    panel1.add(deptoL);
    panel1.add(seccionL);
    panel1.add(nombreL);
    panel1.add(cedulaL);
    
    panel1.add(recibe);
    panel1.add(facultad2);
    panel1.add(depto2);
    panel1.add(seccion2);
    panel1.add(nombre2);
    panel1.add(cedula2);
    
    panel1.add(facultad2L);
    panel1.add(depto2L);
    panel1.add(seccion2L);
    panel1.add(nombre2L);
    panel1.add(cedula2L);
    
    titulo.setBounds   (200,15,500,20);
    titulo.setFont     (new Font( "Serif", Font.BOLD + Font.ITALIC, 15));
    digite.setBounds   (230,20,170,20);
    digite.setFont	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    de.setBounds   	   (15,70,50,50);
    de.setFont     	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 15));
    facultadL.setBounds(50,50,170,20);
    facultadL.setFont  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    facultad.setBounds (180,50,170,20);
    deptoL.setBounds   (50,80,170,20);
    deptoL.setFont	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    depto.setBounds    (180,80,170,20);
    seccionL.setBounds (50,110,170,20);
    seccionL.setFont   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    seccion.setBounds  (180,110,170,20);
    nombreL.setBounds  (50,140,170,20);
    nombreL.setFont    (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    nombre.setBounds   (180,140,170,20);
    cedulaL.setBounds  (50,170,170,20);
    cedulaL.setFont    (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    cedula.setBounds   (180,170,170,20);
    a.setBounds   	   (380,70,50,50);
    a.setFont     	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 15));
    recibe.setBounds   (600,20,170,20);
    recibe.setFont     (new Font( "Serif", Font.BOLD + Font.ITALIC, 15));
    facultad2L.setBounds(415,50,170,20);
    facultad2L.setFont (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    facultad2.setBounds(545,50,170,20);
    depto2L.setBounds  (415,80,170,20);
    depto2L.setFont	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    depto2.setBounds   (545,80,170,20);
    seccion2L.setBounds(415,110,170,20);
    seccion2L.setFont  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    seccion2.setBounds (545,110,170,20);
    nombre2L.setBounds (415,140,170,20);
    nombre2L.setFont   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    nombre2.setBounds  (545,140,170,20);
    cedula2L.setBounds (415,170,170,20);
    cedula2L.setFont   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    cedula2.setBounds  (545,170,170,20);
    
    panel2.setBounds(20,250,800,300);
    panel2.setBorder (BorderFactory.createTitledBorder (""));
	panel2.setLayout (null);
	//panel1.setBackground(Color.white);
    panel2.add(inventario1);
    panel2.add(inventario2);
    panel2.add(inventario3);
    panel2.add(inventario4);
    panel2.add(inventario5);
    panel2.add(inventario6);
    panel2.add(inventario7);
    panel2.add(inventario8);
    panel2.add(inventario9);
    panel2.add(inventario10);
    panel2.add(articulo1);
    panel2.add(articulo2);
    panel2.add(articulo3);
    panel2.add(articulo4);
    panel2.add(articulo5);
    panel2.add(articulo6);
    panel2.add(articulo7);
    panel2.add(articulo8);
    panel2.add(articulo9);
    panel2.add(articulo10);
    
    panel2.add(marca1);
    panel2.add(marca2);
    panel2.add(marca3);
    panel2.add(marca4);
    panel2.add(marca5);
    panel2.add(marca6);
    panel2.add(marca7);
    panel2.add(marca8);
    panel2.add(marca9);
    panel2.add(marca10);
    panel2.add(serie1);
    panel2.add(serie2);
    panel2.add(serie3);
    panel2.add(serie4);
    panel2.add(serie5);
    panel2.add(serie6);
    panel2.add(serie7);
    panel2.add(serie8);
    panel2.add(serie9);
    panel2.add(serie10);
    panel2.add(cantidad1);
    panel2.add(cantidad2);
    panel2.add(cantidad3);
    panel2.add(cantidad4);
    panel2.add(cantidad5);
    panel2.add(cantidad6);
    panel2.add(cantidad7);
    panel2.add(cantidad8);
    panel2.add(cantidad9);
    panel2.add(cantidad10);
  
    panel2.add(inventarioL);
    panel2.add(articuloL);
    panel2.add(marcaL);
    panel2.add(serieL);
    panel2.add(cantidadL);
    
    inventarioL.setBounds  (10,15,120,20);
    inventarioL.setFont	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    inventario1.setBounds  (10,50,100,20);
    inventario2.setBounds  (10,75,100,20);
    inventario3.setBounds  (10,100,100,20);
    inventario4.setBounds  (10,125,100,20);
    inventario5.setBounds  (10,150,100,20);
    inventario6.setBounds  (10,175,100,20);
    inventario7.setBounds  (10,200,100,20);
    inventario8.setBounds  (10,225,100,20);
    inventario9.setBounds  (10,250,100,20);
    inventario10.setBounds (10,275,100,20);
    articuloL.setBounds  (160,15,200,20);
    articuloL.setFont	 (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    articulo1.setBounds  (120,50,300,20);
    articulo2.setBounds  (120,75,300,20);
    articulo3.setBounds  (120,100,300,20);
    articulo4.setBounds  (120,125,300,20);
    articulo5.setBounds  (120,150,300,20);
    articulo6.setBounds  (120,175,300,20);
    articulo7.setBounds  (120,200,300,20);
    articulo8.setBounds  (120,225,300,20);
    articulo9.setBounds  (120,250,300,20);
    articulo10.setBounds (120,275,300,20);
    marcaL.setBounds  (450,15,200,20);
    marcaL.setFont	 (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    marca1.setBounds  (430,50,130,20);
    marca2.setBounds  (430,75,130,20);
    marca3.setBounds  (430,100,130,20);
    marca4.setBounds  (430,125,130,20);
    marca5.setBounds  (430,150,130,20);
    marca6.setBounds  (430,175,130,20);
    marca7.setBounds  (430,200,130,20);
    marca8.setBounds  (430,225,130,20);
    marca9.setBounds  (430,250,130,20);
    marca10.setBounds (430,275,130,20);   
    serieL.setBounds  (580,15,200,20);
    serieL.setFont	 (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    serie1.setBounds  (570,50,120,20);
    serie2.setBounds  (570,75,120,20);
    serie3.setBounds  (570,100,120,20);
    serie4.setBounds  (570,125,120,20);
    serie5.setBounds  (570,150,120,20);
    serie6.setBounds  (570,175,120,20);
    serie7.setBounds  (570,200,120,20);
    serie8.setBounds  (570,225,120,20);
    serie9.setBounds  (570,250,120,20);
    serie10.setBounds (570,275,120,20);
    cantidadL.setBounds  (700,15,100,20);
    cantidadL.setFont	 (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    cantidad1.setBounds  (700,50,60,20);
    cantidad2.setBounds  (700,75,60,20);
    cantidad3.setBounds  (700,100,60,20);
    cantidad4.setBounds  (700,125,60,20);
    cantidad5.setBounds  (700,150,60,20);
    cantidad6.setBounds  (700,175,60,20);
    cantidad7.setBounds  (700,200,60,20);
    cantidad8.setBounds  (700,225,60,20);
    cantidad9.setBounds  (700,250,60,20);
    cantidad10.setBounds (700,275,60,20);
    
    panel3.setBounds(20,565,800,80);
    panel3.setBorder (BorderFactory.createTitledBorder (""));
	panel3.setLayout (null);
	//panel1.setBackground(Color.white);
	panel3.add(autorizado);
    panel3.add(retirado);
    panel3.add(vistoB);
    panel3.add(recibeC);
    panel3.add(autorizadoL);
    panel3.add(retiradoL);
    panel3.add(vistoBL);
    panel3.add(recibeCL);
    panel3.add(firma);
    panel3.add(firma2);
    
    autorizadoL.setBounds (10,5,150,20);
    autorizadoL.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    autorizado.setBounds  (10,35,180,40);
    retiradoL.setBounds   (200,5,150,20);
    retiradoL.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    retirado.setBounds    (200,35,180,40);
    vistoBL.setBounds     (390,5,150,20);
    vistoBL.setFont	      (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    vistoB.setBounds      (390,35,180,40);
    recibeCL.setBounds    (580,5,150,20);
    recibeCL.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    recibeC.setBounds     (580,35,180,40);
    
    clear.setBounds   (835,540,150,20);
    clear.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    
    send.setBounds    (835,570,150,20);
    send.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    
    close.setBounds   (835,600,150,20);
    close.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    
    print.setBounds   (835,630,150,20);
    print.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    
    clear.addActionListener(this);
    close.addActionListener(this);
    send.addActionListener(this);
    print.addActionListener(this);
   }
   
   
   public void actionPerformed(ActionEvent evento)		
		{ 
		     if (evento.getSource() == close)  
  			 {  	
  				JOptionPane.showMessageDialog(this, "Gracias por su visita, que tenga buen dia");			
  				System.exit (0);
  		    }
  		    
  		     if (evento.getSource() == print)  
  			 {  	
  				try
		    	{
				facultad.print();
			    }
			
			catch(PrinterException a)
			   {
				System.err.println("Error: " + a.getMessage());
			   }	
  		    }	
  		    
  		    	
			if (evento.getSource() == clear)  
  			 {  	
  	inventario1.setText("");
	inventario2.setText("");
	inventario3.setText("");
	inventario4.setText("");
	articulo1.setText("");
	articulo2.setText("");
	articulo3.setText("");
	articulo4.setText("");
	marca1.setText("");
	marca2.setText("");
	marca3.setText("");
	marca4.setText("");
	serie1.setText("");
	serie2.setText("");
	serie3.setText("");
	serie4.setText("");
	cantidad1.setText("");
	cantidad2.setText("");
	cantidad3.setText("");
	cantidad4.setText("");
	
	autorizado.setText("");
	retirado.setText("");
	vistoB.setText("");
	recibeC.setText("");
  		    }	
  		    
  		    	
			if(evento.getSource() == send)
			{
		 	    codeA = inventario1.getText(); 

            try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexin con la base de datos. Hay que cambiar la url, el usuario y la clave por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/akane","root", "daigaku");
            
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();  
            ResultSet rs = s.executeQuery ("select * from ejemplar WHERE(`CodigoE` = "+codeA+")");
            
            // Se recorre el ResultSet.
            while (rs.next())
            {
            }

            s.executeUpdate("UPDATE ejemplar SET CodEs ="+state+" WHERE(`CodigoE` = "+codeA+")");
            JOptionPane.showMessageDialog(this, "Los datos son correctos!!. Su solicitud ha sido aprobada!!");

            conexion.close();
        }
        catch (Exception e)
        {
           JOptionPane.showMessageDialog(this, "No se encontro el activo, por favor verifique");
        }
    	}
      }		 	
	}
	