/**********************************************************************************************************************
 *Archivo: ValidarUsuario.java																						  *
 *Autores: 																											  *
 *		 Jorge Ivan Estrada R.																						  *
 *       cod: 0761868																								  *
 *       Diana Marcela Lopez Q. 																					  *
 *       cod: 0761833																								  *
 *		 Melisa Calero Ramirez.																					      *
 *       cod: 0761858 																								  *
 *Fecha de ultima modificacion: 19/12/08																			  *
 *Version: 0.1																										  *
 *Responsabilidad: La clase Permite capturar los datos del formulario de entrada y validarlos comparandolos con los de*
 *la tabla pass de la base de datos																					  *
 **********************************************************************************************************************/


import javax.swing.*; 
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.text.JTextComponent.*;
import java.sql.*;

public class ValidarUsuario extends JFrame implements ActionListener 
{
	
    Icon print          = new ImageIcon("jpg\\Padlock1.png" );	
	JButton Liquidar    = new JButton  ("Ingresar", print);
    Icon exit           = new ImageIcon("jpg\\Delete.png" );
    JButton cerrar      = new JButton  ("Salir",exit);
    Icon delete         = new ImageIcon("jpg\\fullbin.png" );
    JButton erase       = new JButton ("Limpiar", delete );
    JPanel button       = new JPanel();
    JPanel button2      = new JPanel();
    JLabel digit        = new JLabel("digite login y password");
    JLabel login        = new JLabel("LOGIN");
    JLabel pass         = new JLabel("PASSWORD");
    JTextField passbox  = new JTextField();
    JPasswordField loginbox = new JPasswordField();
    JRadioButton radio1 = new JRadioButton("USUARIO ADMINISTRADOR");
	JRadioButton radio2 = new JRadioButton("USUARIO SUPERVISOR");
	JRadioButton radio3 = new JRadioButton("USUARIO EXTERNO");
	JPanel panelRadio   = new JPanel();
    ButtonGroup grupoBotones = new ButtonGroup();

    MiJMenuBar menubar 		   = new MiJMenuBar();
	JMenu menuArchivo 		   = new JMenu("Archivo");
	JMenu menuAyuda            = new JMenu("Ayuda");
	JMenuItem acercaMenuItem   = new JMenuItem("Acerca de ...");
	JMenuItem conectarMenuItem = new JMenuItem("Conectar");
	JMenuItem abrirMenuItem    = new JMenuItem("Abrir");
	JMenuItem salirMenuItem    = new JMenuItem("Salir");
	
    private JLabel dukeLabel;
    private JLabel fondo;
    
    /*Variables para almacenar el retorno de las tablas de la base de datos con el resultSet y las capturas 
    de los JTextFields*/
    String contras;
    String logout;
    String con;
    String logi;
    int nite;
    int type = 0;
    int ad;
    
    /*instancia de objetos para utilizar sus metodos y hacerlos visibles en varias ocasiones*/
    UserAdmin admin;
    UserExtern externo;
    UserView superv;
    
  public ValidarUsuario()//constructor de la clase
  { 
   	setBounds(5,0,1005,900); 
  	setTitle("SISTEMA DE ADMINISTRACION DE ACTIVOS FIJOS"); 
  	setDefaultCloseOperation(EXIT_ON_CLOSE); 
   	getContentPane().setBackground(Color.WHITE);
    getContentPane().setLayout(null);	
    setResizable(false);
    
    grupoBotones.add(radio1);
	grupoBotones.add(radio2);
	grupoBotones.add(radio3);
	
	panelRadio.setBackground(Color.WHITE);
    panelRadio.setLayout(null);
	panelRadio.add(radio1);
	panelRadio.add(radio2);
	panelRadio.add(radio3);

    button.add(login);
    login.setFont  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
    button.add(pass);
    pass.setFont  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) ); 
    button.add(loginbox);
    loginbox.setFont  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
    button.add(passbox);
    passbox.setFont  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
    button.add(digit);
    digit.setFont  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
    getContentPane().add(button);
    getContentPane().add(button2);
    getContentPane().add(panelRadio);
    
    button.setBounds(400,400,370,120);
    button.setBorder (BorderFactory.createTitledBorder ("SERVICIOS"));
	button.setLayout (null);
	button.setBackground(Color.white);
	panelRadio.setBackground(Color.white);
	
	button2.setBounds(400,540,370,40);
    button2.setBorder (BorderFactory.createTitledBorder (""));
	button2.setLayout (null);
	button2.setBackground(Color.white);
	
	getContentPane().add(erase); 

	digit.setBounds(20,20,200,20);
	passbox.setBounds(120,60,180,20);
	loginbox.setBounds(120,80,180,20);
	pass.setBounds(20,60,200,20);
	login.setBounds(20,80,200,20);
	panelRadio.setBounds(70,400,250,200);
	radio1.setBounds(20,10,200,20);
	radio2.setBounds(20,70,200,20);
	radio3.setBounds(20,130,200,20);

    Liquidar.setBounds(10,10,110,20);				
    button2.add(Liquidar);
    Liquidar.addActionListener(this);
    Liquidar.setFont  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
    
    cerrar.setBounds(130,10,110,20);		
    button2.add(cerrar);   		
    cerrar.addActionListener(this); 
    cerrar.setFont    (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) ); 
    	
    erase.setBounds(250,10,110,20);				
    button2.add(erase);
    erase.addActionListener(this);
    erase.setFont  (new Font( "Serif", Font.BOLD + Font.ITALIC, 14) );
    
    radio3.addActionListener(new ActionListener()//Escuchador del RadioButton3
	    {
	    	public void actionPerformed(ActionEvent ae)
			{
				passbox.setEditable(false);
				loginbox.setEditable(false);
				ad =3;
				
			}
	    });//fin del escuchador
	    
	    radio1.addActionListener(new ActionListener()//Escuchador del RadioButton3
	    {
	    	public void actionPerformed(ActionEvent ae)
			{
				passbox.setEditable(true);
				loginbox.setEditable(true);
				ad = 1;
			}
	    });	//fin del escuchador 
	    	
	    radio2.addActionListener(new ActionListener()//Escuchador del RadioButton3
	    {
	    	public void actionPerformed(ActionEvent ae)
			{
				passbox.setEditable(true);
				loginbox.setEditable(true);
				ad = 2;
			}
	    });//fin del escuchador 	 
    		
    	setJMenuBar(menubar);
		menubar.addAll(menuArchivo,menuAyuda);

		menuArchivo.add(abrirMenuItem);
		menuArchivo.add(conectarMenuItem);
		menuArchivo.add(salirMenuItem);
		menuAyuda.add  (acercaMenuItem);
		
		//Escuchadores de los botones
		abrirMenuItem.addActionListener   (this);
		conectarMenuItem.addActionListener(this);
		salirMenuItem.addActionListener   (this);
		acercaMenuItem.addActionListener  (this);
		radio1.addActionListener(this);
		radio2.addActionListener(this);
		radio3.addActionListener(this);
		erase.addActionListener (this);	
			
			//Ubicacion y pintado de los paneles e imagenes del frame
			final ImageIcon icon = new ImageIcon("jpg\\Padlock.png");
			final ImageIcon icon2 = new ImageIcon("jpg\\Panel1.jpg");
            dukeLabel = new JLabel(icon);
            fondo = new JLabel(icon2);
        if ((icon != null)||(icon2 != null)) 
        	{
            dukeLabel.setBounds(70,200,200,240);                 
            fondo.setBounds(0,-80,1000,300);
        } 
        else {}
        getContentPane().add(dukeLabel);
        getContentPane().add(fondo);  	    				
  }	    				
  		
	public class MiJMenuBar extends JMenuBar
{
	public void addAll(JMenu... menuList)
	{
		for (JMenu j : menuList)
			add(j);
	}	
}
  //Metodo principal donde se realiza la mayor parte de acciones, validaciones y acceso a la base de datos 		
  public void actionPerformed (ActionEvent evento)
  {
  		
  			if (evento.getSource() == cerrar)  
  			{  	
  				JOptionPane.showMessageDialog(this, "Gracias por su visita, que tenga buen dia");			
  				System.exit (0);
  			}
  			if (evento.getSource()==acercaMenuItem)
		{
			JOptionPane.showMessageDialog(this, "Creado por \nDIANA MARCELA LOPEZ \n JORGE IVAN ESTRADA Y MELISSA CALERO");
		}
		
		if (evento.getSource() == erase)		  
  			{  
  			   passbox.setText("");
               loginbox.setText("");
  			}
		
		if (evento.getSource() == Liquidar)			
  			{ 
  				if ( ad == 1 && type ==0)	
  				{
  		            	boolean a=false;
  		            	contras = passbox.getText();
  		            	logout  = loginbox.getText();
  		            	
  				 try
        {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/akane","root", "daigaku");    
            Statement s = conexion.createStatement();

      		ResultSet rs = s.executeQuery ("select * from Pass WHERE(`pass`='"+contras+"' and `Log`='"+logout+"')");
   
            while (rs.next())
            {
             nite = rs.getInt(1);
             con = rs.getString(2);
          	 logi = rs.getString(3);
          	 type = rs.getInt(4);	      
     		 a=true;
            }
        }
        catch (Exception e)
        {	a=false;
            JOptionPane.showMessageDialog(this, "Usuario incorrecto, verifique datos!");
        }
           if(a)
           	admin = new UserAdmin();
           	else 
           		JOptionPane.showMessageDialog(this, "Usuario incorrecto, verifique datos!");
        
  			}
  			else
  				if(ad == 0)
  				JOptionPane.showMessageDialog(this, "Seleccione un tipo de usuario");
  				else
  				{
  					if(ad == 2 && type ==2)
  					{
  						superv = new UserView();
  						}
  						else
  							{
  								if(ad == 3)
  						externo = new UserExtern();
  						}
  				}
  				}//fin del escuchador del boton liquidar
  				}//fin del actionPerformed


  public static void main(String... args)
  {
  	new ValidarUsuario().setVisible(true); 
  }
}