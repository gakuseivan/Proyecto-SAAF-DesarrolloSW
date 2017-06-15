/**********************************************************************************************************************
 *Archivo: UserAdmin.java																						          *
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

public class UserAdmin extends JFrame implements ActionListener
{	
	JMenuBar barraMenu = new JMenuBar();
	JMenu menuCambiarPanel = new JMenu("Cambiar Panel");
	JMenuItem opcionPanel1 = new JMenuItem("Insertar Activo");
	JMenuItem opcionPanel2 = new JMenuItem("Eliminar Activo");
	JMenuItem opcionPanel4 = new JMenuItem("Modificar Activo");
	JMenuItem opcionPanel5 = new JMenuItem("Consultar activos");
	JMenuItem opcionPanel6 = new JMenuItem("Buscar activo");
	JMenuItem opcionPanel7 = new JMenuItem("Dar de Baja Activo");
	JMenuItem salir        = new JMenuItem("salir");	
	JTextArea areaTexto= new JTextArea();
	JScrollPane barra = new JScrollPane(areaTexto);
	JTabbedPane panelesPestaas = new JTabbedPane();
				
		
	public UserAdmin(/*String texto*/)
		{
		setTitle("Aplicacion de calculo");
		setBackground(Color.WHITE);
		setSize(820,800);
		panelesPestaas.addTab("Insertar Activo", new InsertarActivo());
		panelesPestaas.addTab("eliminar Activo", new EliminarActivo());
		panelesPestaas.addTab("Modificar Activo", new ModificarActivo());
		panelesPestaas.addTab("Consultar Activos", new ConsultarActivo());
		panelesPestaas.addTab("Buscar Activo", new BuscarActivo());
		panelesPestaas.addTab("Dar de Baja Activo", new DarBaja());
		panelesPestaas.setSelectedIndex(0);
		validate();
		show();

		opcionPanel1.addActionListener(this);
		opcionPanel2.addActionListener(this);
		opcionPanel4.addActionListener(this);
		opcionPanel5.addActionListener(this);
		opcionPanel6.addActionListener(this);
		opcionPanel7.addActionListener(this);
		salir.addActionListener(this);
	
		//organizar componentes dentro de la barra de menu
		menuCambiarPanel.add(opcionPanel1);
		menuCambiarPanel.add(opcionPanel2);
		menuCambiarPanel.add(opcionPanel4);
		menuCambiarPanel.add(opcionPanel5);
		menuCambiarPanel.add(opcionPanel6);
		menuCambiarPanel.add(opcionPanel7);
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
		
		if(fuenteEvento==opcionPanel1)
			panelesPestaas.setSelectedIndex(0);
	
		if(fuenteEvento==opcionPanel2)		
			panelesPestaas.setSelectedIndex(1);	
			
		if(fuenteEvento==opcionPanel4)
			panelesPestaas.setSelectedIndex(4);
		
		if(fuenteEvento==opcionPanel5)
			panelesPestaas.setSelectedIndex(5);
			
			if(fuenteEvento==opcionPanel6)
			panelesPestaas.setSelectedIndex(6);
			
		if(fuenteEvento==salir)
			System.exit(0);
		
	}
	
	public static void main(String a[]){
		UserAdmin ventana = new UserAdmin();
		ventana.setSize(new Dimension(800,700));
		ventana.show();	
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}	
}