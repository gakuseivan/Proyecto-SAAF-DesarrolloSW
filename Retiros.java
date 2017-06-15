/**********************************************************************************************************************
 *Archivo: Retiros.java																						          *
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
import java.awt.print.*;

public class Retiros extends JPanel implements ActionListener
{
	JLabel titulo          = new JLabel("ORDEN DE RETIRO DE ARTICULOS Nro");
    JLabel digite          = new JLabel("ESTA AUTORIZADO PARA RETIRAR DE");
    JLabel de              = new JLabel("LOS SIGUIENTES ARTICULOS");
    JLabel facultadL       = new JLabel("FACULTAD");
	JLabel deptoL      	   = new JLabel("DEPARTAMENTO");
	JLabel seccionL        = new JLabel("SECCION/OFICINA");
	JLabel nombreL     	   = new JLabel("NOMBRE DEL PORTADOR");
	JLabel cedulaL         = new JLabel("Nro DE CEDULA");
	JLabel dependenciaL    = new JLabel("DEPENDENCIA");
	JTextField facultad    = new JTextField();
	JTextField depto       = new JTextField();
	JTextField seccion     = new JTextField();
	JTextField nombre      = new JTextField();
	JTextField cedula      = new JTextField();
	JTextField dependencia = new JTextField();
	JTextField send        = new JTextField();
	JTextField destino     = new JTextField();

	JLabel inventarioL     = new JLabel("Nro INVENTARIO");
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
	JLabel sendL           = new JLabel("RETIRO CON EL PROPOSITO DE");
	JLabel destinoL        = new JLabel("LUGAR DE DESTINO");
	JLabel itemL           = new JLabel("ITEM");
	JButton clear          = new JButton("LIMPIAR");
	JButton enviar         = new JButton("ENVIAR");
	JButton close          = new JButton("SALIR");
	JButton print          = new JButton("IMPRIMIR");
		
	JLabel item1      		= new JLabel("1");
	JLabel item2     		= new JLabel("2");
	JLabel item3      		= new JLabel("3");
	JLabel item4      		= new JLabel("4");
	JLabel item5      		= new JLabel("5");
	JLabel item6      		= new JLabel("6");
	JLabel item7      		= new JLabel("7");
	JLabel item8     		= new JLabel("8");
	JLabel item9      		= new JLabel("9");
	JLabel item10    	    = new JLabel("10");
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
	int state = 03;
	
	public Retiros ()
   { 
   	setLayout(null);
   
    add(panel1);
    add(panel2);
    add(panel3);
    add(titulo);
    add(print);
    add(clear);
    add(enviar);
    add(close);
       
    panel1.setBounds(20,40,800,160);
    panel1.setBorder (BorderFactory.createTitledBorder (""));
	panel1.setLayout (null);
    panel1.add(digite);
    panel1.add(de);
    panel1.add(facultad);
    panel1.add(depto);
    panel1.add(seccion);
    panel1.add(nombre);
    panel1.add(cedula);
    panel1.add(dependencia);
    panel1.add(send);
    panel1.add(destino);
    
    panel1.add(facultadL);
    panel1.add(deptoL);
    panel1.add(seccionL);
    panel1.add(nombreL);
    panel1.add(cedulaL);
    panel1.add(dependenciaL);
    panel1.add(sendL);
    panel1.add(destinoL);
    
    titulo.setBounds   	  (200,10,500,20);
    titulo.setFont     	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 15));
    nombreL.setBounds  	  (20,10,170,20);
    nombreL.setFont    	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    nombre.setBounds      (10,40,300,20);
    dependenciaL.setBounds(360,10,200,20);
    dependenciaL.setFont  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    dependencia.setBounds (320,40,300,20);
    cedulaL.setBounds  	  (650,10,170,20);
    cedulaL.setFont    	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    cedula.setBounds   	  (630,40,150,20);
    digite.setBounds   	  (270,65,300,20);
    digite.setFont	   	  (new Font( "Serif", Font.ITALIC, 12));
    facultadL.setBounds	  (100,90,200,20);
    facultadL.setFont  	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    facultad.setBounds 	  (60,115,200,20);
    deptoL.setBounds   	  (300,90,170,20);
    deptoL.setFont	   	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    depto.setBounds    	  (280,115,200,20);
    seccionL.setBounds 	  (500,90,170,20);
    seccionL.setFont   	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14)); 
    seccion.setBounds  	  (500,115,200,20);
    de.setBounds   	      (280,140,250,20);
    de.setFont     	   	  (new Font( "Serif", Font.ITALIC, 12));
    
    panel2.setBounds(20,210,800,300);
    panel2.setBorder (BorderFactory.createTitledBorder (""));
	panel2.setLayout (null);
	//panel1.setBackground(Color.white);
    panel2.add(item1);
    panel2.add(item2);
    panel2.add(item3);
    panel2.add(item4);
    panel2.add(item5);
    panel2.add(item6);
    panel2.add(item7);
    panel2.add(item8);
    panel2.add(item9);
    panel2.add(item10);
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
    panel2.add(itemL);
    
    
    itemL.setBounds  (10,15,120,20);
    itemL.setFont	 (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    item1.setBounds  (10,50,40,20);
    item2.setBounds  (10,75,40,20);
    item3.setBounds  (10,100,40,20);
    item4.setBounds  (10,125,40,20);
    item5.setBounds  (10,150,40,20);
    item6.setBounds  (10,175,40,20);
    item7.setBounds  (10,200,40,20);
    item8.setBounds  (10,225,40,20);
    item9.setBounds  (10,250,40,20);
    item10.setBounds (10,275,40,20);
    
    inventarioL.setBounds  (60,15,120,20);
    inventarioL.setFont	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    inventario1.setBounds  (60,50,100,20);
    inventario2.setBounds  (60,75,100,20);
    inventario3.setBounds  (60,100,100,20);
    inventario4.setBounds  (60,125,100,20);
    inventario5.setBounds  (60,150,100,20);
    inventario6.setBounds  (60,175,100,20);
    inventario7.setBounds  (60,200,100,20);
    inventario8.setBounds  (60,225,100,20);
    inventario9.setBounds  (60,250,100,20);
    inventario10.setBounds (60,275,100,20);
    articuloL.setBounds  (190,15,200,20);
    articuloL.setFont	 (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    articulo1.setBounds  (170,50,300,20);
    articulo2.setBounds  (170,75,300,20);
    articulo3.setBounds  (170,100,300,20);
    articulo4.setBounds  (170,125,300,20);
    articulo5.setBounds  (170,150,300,20);
    articulo6.setBounds  (170,175,300,20);
    articulo7.setBounds  (170,200,300,20);
    articulo8.setBounds  (170,225,300,20);
    articulo9.setBounds  (170,250,300,20);
    articulo10.setBounds (170,275,300,20);
    marcaL.setBounds  (480,15,200,20);
    marcaL.setFont	 (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    marca1.setBounds  (480,50,130,20);
    marca2.setBounds  (480,75,130,20);
    marca3.setBounds  (480,100,130,20);
    marca4.setBounds  (480,125,130,20);
    marca5.setBounds  (480,150,130,20);
    marca6.setBounds  (480,175,130,20);
    marca7.setBounds  (480,200,130,20);
    marca8.setBounds  (480,225,130,20);
    marca9.setBounds  (480,250,130,20);
    marca10.setBounds (480,275,130,20);   
    serieL.setBounds  (620,15,200,20);
    serieL.setFont	 (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    serie1.setBounds  (620,50,120,20);
    serie2.setBounds  (620,75,120,20);
    serie3.setBounds  (620,100,120,20);
    serie4.setBounds  (620,125,120,20);
    serie5.setBounds  (620,150,120,20);
    serie6.setBounds  (620,175,120,20);
    serie7.setBounds  (620,200,120,20);
    serie8.setBounds  (620,225,120,20);
    serie9.setBounds  (620,250,120,20);
    serie10.setBounds (620,275,120,20);
    cantidadL.setBounds  (720,15,100,20);
    cantidadL.setFont	 (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    cantidad1.setBounds  (750,50,40,20);
    cantidad2.setBounds  (750,75,40,20);
    cantidad3.setBounds  (750,100,40,20);
    cantidad4.setBounds  (750,125,40,20);
    cantidad5.setBounds  (750,150,40,20);
    cantidad6.setBounds  (750,175,40,20);
    cantidad7.setBounds  (750,200,40,20);
    cantidad8.setBounds  (750,225,40,20);
    cantidad9.setBounds  (750,250,40,20);
    cantidad10.setBounds (750,275,40,20);
    
    panel3.setBounds(20,525,800,130);
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
    panel3.add(send);
    panel3.add(sendL);
    panel3.add(destino);
    panel3.add(destinoL);
    
    sendL.setBounds 	  (10,5,300,20);
    sendL.setFont	      (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    send.setBounds        (10,30,300,20);
    destinoL.setBounds 	  (360,5,300,20);
    destinoL.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    destino.setBounds     (330,30,300,20);
    
    autorizadoL.setBounds (10,55,150,20);
    autorizadoL.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    autorizado.setBounds  (10,80,180,40);
    retiradoL.setBounds   (200,55,150,20);
    retiradoL.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    retirado.setBounds    (200,80,180,40);
    vistoBL.setBounds     (390,55,150,20);
    vistoBL.setFont	      (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    vistoB.setBounds      (390,80,180,40);
    recibeCL.setBounds    (580,55,150,20);
    recibeCL.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    recibeC.setBounds     (580,80,180,40);
    
    clear.setBounds   (835,540,150,20);
    clear.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    
    enviar.setBounds   (835,570,150,20);
    enviar.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    
    close.setBounds   (835,600,150,20);
    close.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));
    
    print.setBounds   (835,630,150,20);
    print.setFont	  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14));

    clear.addActionListener(this);
    close.addActionListener(this);
    enviar.addActionListener(this);
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
  		    
  		    	
			if(evento.getSource() == enviar )
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
    	}}
       		 	
	}
	