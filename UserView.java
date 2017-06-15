/**********************************************************************************************************************
 *Archivo: UserView.java																						          *
 *Autores: 																											  *
 *		 Jorge Ivan Estrada R.																						  *
 *       cod: 0761868																								  *
 *       Diana Marcela Lopez Q. 																					  *
 *       cod: 0761833																								  *
 *		 Melisa Calero Ramirez.																					      *
 *       cod: 0761858 																								  *
 *Fecha de ultima modificacion: 19/12/08																			  *
 *Version: 0.1																										  *
 *Responsabilidad: La clase se encarga de crear nuevas instancias de paneles para formularios, y a su vez		      *	 
 *actua como panel principal sobre los cuales se pintan los demas JPanels.								        	  * 																                  *
 **********************************************************************************************************************/
 
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UserView extends JFrame implements ActionListener
{	
	JMenuBar barraMenu = new JMenuBar();
	JMenu menuCambiarPanel = new JMenu("Cambiar Panel");
	JMenuItem opcionPanel5 = new JMenuItem("Consultar activos");
	JMenuItem opcionPanel6 = new JMenuItem("Buscar activo");
	JMenuItem salir        = new JMenuItem("salir");	
	JTextArea areaTexto= new JTextArea();
	JScrollPane barra = new JScrollPane(areaTexto);
	JTabbedPane panelesPestaas = new JTabbedPane();
				
		
	public UserView()
		{
		setTitle("USUARIO SUPERVISOR");
		setBackground(Color.WHITE);
		panelesPestaas.addTab("Modificar Activo", new ModificarActivo());
		panelesPestaas.addTab("Consultar Activos", new ConsultarActivo());
		panelesPestaas.addTab("Buscar Activo", new BuscarActivo());
		panelesPestaas.setSelectedIndex(0);
		setSize(800,800);
		validate();
		show();
		
		opcionPanel5.addActionListener(this);
		opcionPanel6.addActionListener(this);
		salir.addActionListener(this);
	
		//organizar componentes dentro de la barra de menu
		menuCambiarPanel.add(opcionPanel5);
		menuCambiarPanel.add(opcionPanel6);
		menuCambiarPanel.add(salir);
		//asignarle los objetos Menu a la barra 
		barraMenu.add(menuCambiarPanel);
			//asignacin de la barra de menu al JFrame
		setJMenuBar(barraMenu);
		//creacin delos objetos para imprimir las acciones

		//configuracin del panel contenedor
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(barra, BorderLayout.SOUTH);
		getContentPane().add(panelesPestaas, BorderLayout.CENTER);
		
			
	}
	
	public void actionPerformed(ActionEvent evento)
		{
		setVisible(true);
		Object fuenteEvento = evento.getSource();
			
		if(fuenteEvento==opcionPanel5)
			panelesPestaas.setSelectedIndex(5);
			
			if(fuenteEvento==opcionPanel6)
			panelesPestaas.setSelectedIndex(6);
			
		if(fuenteEvento==salir)
			System.exit(0);
		
	}
	
	public static void main(String a[]){
		UserView ventana = new UserView();
		ventana.setSize(new Dimension(800,700));
		ventana.show();	
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}