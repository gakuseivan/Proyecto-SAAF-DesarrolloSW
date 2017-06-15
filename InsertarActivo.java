/**********************************************************************************************************************
 *Archivo: InsertarActivo.java																						  *
 *Autores: 																											  *
 *		 Jorge Ivan Estrada R.																						  *
 *       cod: 0761868																								  *
 *       Diana Marcela Lopez Q. 																					  *
 *       cod: 0761833																								  *
 *		 Melisa Calero Ramirez.																					      *
 *       cod: 0761858 																								  *
 *Fecha de ultima modificacion: 19/12/08																			  *
 *Version: 0.1																										  *
 *Responsabilidad: La clase Permite capturar los datos del formulario de entrada e insertarlos en la base de datos    *
 **********************************************************************************************************************/


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class InsertarActivo extends JPanel implements ActionListener
{	
	JButton	radio1 = new JButton("Insertar Activo");
	JButton	radio2 = new JButton("Limpiar campos");
	JButton	radio3 = new JButton("Salir");

    JLabel code         = new JLabel("CODIGO EJEMPLAR:");
	JTextField codebox  = new JTextField();
	JLabel name         = new JLabel("DESCRIPCION:");
	JTextField namebox  = new JTextField();
	JLabel date         = new JLabel("FECHA DE COMPRA:");
	JTextField datebox  = new JTextField();
	JLabel marca        = new JLabel("MARCA:");
	JTextField marcabox = new JTextField();
	JLabel name2        = new JLabel("NOMBRE:");
	JTextField  name2box= new JTextField();
	JLabel modelo         = new JLabel("MODELO:");
	JTextField  modelobox = new JTextField();
	JLabel dateF          = new JLabel("FECHA DE FABRICACION:");
	JTextField  dateFbox  = new JTextField();
	JLabel codeF          = new JLabel("CODIGO DE FABRICACION:");
	JTextField  codeFbox  = new JTextField();
	JLabel codeS          = new JLabel("CODIGO DE ESTADO:");
	JLabel codeA          = new JLabel("CODIGO DE ACTIVO:");
	JTextField  codeAbox  = new JTextField();
	JTextArea  areaTexto  = new JTextArea();
	JLabel     welcome    = new JLabel("Bienvenido Usuario Administrador!");
    JPanel button = new JPanel();
    private JLabel dukeLabel;
    private JComboBox state;
	private String estados[] =
      { "01  Inactivo", "02  Prestado", "03  Retirado", "04  Trasladado", "05  Dado de Baja"};
	
	//Variables para guardar las tablas
	String codigoEjm;
	String nombre;
	String fecha;
	String marcas;
	String nombre2;
	String modelos;
	String fechaFab;
	String codigoFab;
	int codigoEstado;
	String codigoActivo;
		
	//Variables para guardar las capturas de las areas de texto
	String codeEjm;
	String names;
	String dates;
	String marc;
	String names2;
	String model;
	String dateMade;
	String codeMade;
	int codeState;
	String codeActiv;
	
	public InsertarActivo()
		{
			
		state = new JComboBox( estados );
        state.setMaximumRowCount( 5 );	
        	
		radio1.addActionListener(this);
		radio2.addActionListener(this);
		radio3.addActionListener(this);
	
	code.setBounds     (30, 50, 200, 20);
	code.setFont	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
	codebox.setBounds  (230, 50, 200,20);
	name.setBounds     (30, 80, 200, 20);
	name.setFont	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
	namebox.setBounds  (230,80, 200, 20);
	date.setBounds     (30, 110, 200, 20);
	date.setFont	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
	datebox.setBounds  (230,110, 200, 20);
	marca.setBounds    (30, 140, 200, 20);
	marca.setFont	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
	marcabox.setBounds (230, 140, 200,20);
	name2.setBounds    (30, 170, 200, 20);
	name2.setFont	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
	name2box.setBounds (230, 170, 200,20);
	modelo.setBounds   (30, 200, 200, 20);
	modelo.setFont 	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
	modelobox.setBounds(230, 200, 200,20);
	
	dateF.setBounds   (30, 230, 200, 20);
	dateF.setFont 	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
	dateFbox.setBounds(230, 230, 200,20);
	codeF.setBounds   (30, 260, 200, 20);
	codeF.setFont 	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
	codeFbox.setBounds(230, 260, 200,20);
	codeS.setBounds   (30, 290, 200, 20);
	codeS.setFont 	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
	state.setBounds   (230, 290, 200,20);
	codeA.setBounds   (30, 320, 200, 20);
	codeA.setFont 	   (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
	codeAbox.setBounds(230, 320, 200,20);
	
		radio1.setBounds(240,380,200,20);
		radio2.setBounds(240,410,200,20);
		radio3.setBounds(240,440,200,20);
		areaTexto.setBounds(465,70,350,540);
		welcome.setBounds(470,10,350,30);
		welcome.setFont(new Font( "Serif", Font.BOLD + Font.ITALIC, 20) );
	
		setLayout(null);
		button.setLayout(null);
		button.setBounds(10,10,450,580);
    	button.setBorder (BorderFactory.createTitledBorder ("DATOS DEL ACTIVO"));
		//button.setBackground(Color.GRAY);
	
		add(radio1);
		add(radio2);
		add(radio3);
		add(areaTexto);
		add(welcome);
	
    button.add(state);
	button.add(code);
	button.add(codebox);
	button.add(name);
	button.add(namebox);
	button.add(date);
	button.add(datebox);
	button.add(marca);
	button.add(marcabox);
	button.add(name2);
	button.add(name2box);
	button.add(modelo);
	button.add(modelobox);	
	button.add(dateF);
	button.add(dateFbox);
	button.add(codeF);
	button.add(codeFbox);
	button.add(codeS);
	button.add(codeA);
	button.add(codeAbox);
	add(button);
	
	final ImageIcon icon = new ImageIcon("jpg\\up.png");
			//final ImageIcon icon2 = new ImageIcon("jpg\\Panel1.jpg");
            dukeLabel = new JLabel(icon);
            //fondo = new JLabel(icon2);
        if ((icon != null)/*||(icon2 != null)*/) 
        	{
            dukeLabel.setBounds(30,330,200,240);                 
            //fondo.setBounds(0,-80,1000,300);
        } 
        else {}
        button.add(dukeLabel);
        //getContentPane().add(fondo); 
	
	}
	
	public void actionPerformed(ActionEvent evento)
		{
		Object fuenteEvento = evento.getSource();
		
		if (fuenteEvento == radio2)		  
  			{  
  			   codebox.setText("");
               namebox.setText("");
               datebox.setText("");
               marcabox.setText("");
               name2box.setText("");
               modelobox.setText("");
               dateFbox.setText("");
               codeFbox.setText("");
               codeAbox.setText("");
  			}
  			
  			if (fuenteEvento == radio3)  
  			{  	
  				JOptionPane.showMessageDialog(this, "Gracias por su visita, que tenga buen dia");			
  				System.exit (0);
  			}

	    if (fuenteEvento == radio1)		  
  			{ 
		//capturas
	codeEjm  = codebox.getText();
	names     = namebox.getText();
	dates	 = datebox.getText();
	marc	 = marcabox.getText();
	names2	 = name2box.getText();
	model	 = modelobox.getText();
	dateMade = dateFbox.getText();
	codeMade = codeFbox.getText();
					
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
            s.executeUpdate("insert into ejemplar values ('"+codeEjm+"','"+names+"','"+ dates+"','"+marc+"','"+names2+"','"+model+
            	"','"+dateMade+"','"+codeMade+"',"+codeState+",'"+codeActiv+"')");

            // Se realiza la consulta. Los resultados se guardan en el 
            // ResultSet rs
            ResultSet rs = s.executeQuery ("select * from Ejemplar");
            
            // Se recorre el ResultSet.
            while (rs.next())
            {
            }
            JOptionPane.showMessageDialog(this, "La operacion de insercion fue realizada con exito!");
            // Se cierra la conexin con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "No se pudo realizar la insercion!");
        }
    	}}	
		}
			
