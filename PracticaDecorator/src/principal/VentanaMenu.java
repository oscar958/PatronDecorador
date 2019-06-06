package principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import componentes.Texto;
import componentes.Parrafo;
import componentes.Encabezado;
import componentes.Titulo;
import decoradores.Subrayar;
import decoradores.TamañoTexto;
import decoradores.Negrita;
import decoradores.ColorTexto;


/**
 * Clase GUI, es la ventana interfaz de 
 * usuario, en la que se permite la seleccion de
 * un combo y el calculo de su valor con o sin adicionales
 * @author Oscar Salamanca
 *
 */
public class VentanaMenu extends JFrame implements ActionListener{
	
	JLabel titulo,adicionales;
	JComboBox combos;
	String arregloCombos[] = { "Seleccione","Parrafo", 
			"Titulo", "Encabezado" };
	JTextArea area;
	private JScrollPane scroll;
	JTextArea area2;
	private JScrollPane scroll2;
	JButton aceptar,cancelar;
	JCheckBox color,tamaño,subrayar,negrita;
	
	public VentanaMenu()
	{
	  color= new JCheckBox();
	  color.setText("Color Rojo");
	  color.setBounds(190, 30, 70, 25);
	  color.setEnabled(false);
	  
	  
	  tamaño= new JCheckBox();
	  tamaño.setText("Tamaño");
	  tamaño.setBounds(280, 30, 70, 25);
	  tamaño.setEnabled(false);
	 
		
	  subrayar= new JCheckBox();
	  subrayar.setText("Subrayado");
	  subrayar.setBounds(190, 50, 70, 25);
	  subrayar.setEnabled(false);
	  
	  negrita= new JCheckBox();
	  negrita.setText("Negrita");
	  negrita.setBounds(280, 50, 70, 25);
	  negrita.setEnabled(false);
	  
	  aceptar=new JButton();
	  aceptar.setText("Enviar");
	  aceptar.setBounds(70, 320, 150, 25);
	  
	  cancelar=new JButton();
	  cancelar.setText("Salir");
	  cancelar.setBounds(230, 320, 90, 25);
		
	  titulo= new JLabel();
	  titulo.setText("Menu");
	  titulo.setBounds(20, 10, 150, 25);
	  
	  adicionales= new JLabel();
	  adicionales.setText("Seleccione los Adicionales");
	  adicionales.setBounds(195, 10, 180, 25);
	  
	  combos= new JComboBox();
	  combos.setBounds(20, 40, 150, 25);
	  combos.setModel(new javax.swing.DefaultComboBoxModel(arregloCombos));
	  combos.addActionListener(this);
	  
	  scroll = new JScrollPane();
	  area = new JTextArea();
		area.setEditable(false);
		area.setFont(new java.awt.Font("Verdana", 0, 12));
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null, null, null,
				new java.awt.Color(0, 0, 0)));
		scroll.setViewportView(area);
		scroll.setBounds(20, 90, 340, 60);
		
		scroll2 = new JScrollPane();
		  area2 = new JTextArea();
			area2.setEditable(false);
			area2.setFont(new java.awt.Font("Verdana", 0, 12));
			area2.setLineWrap(true);
			area2.setWrapStyleWord(true);
			area2.setBorder(javax.swing.BorderFactory.createBevelBorder(
					javax.swing.border.BevelBorder.LOWERED, null, null, null,
					new java.awt.Color(0, 0, 0)));
			scroll2.setViewportView(area2);
			scroll2.setBounds(20, 152, 340, 160);
	 
			
	  combos.addActionListener(this);
	  aceptar.addActionListener(this);
	  cancelar.addActionListener(this);
	  color.addActionListener(this);
	  negrita.addActionListener(this);
	  subrayar.addActionListener(this);
	  tamaño.addActionListener(this);

	  add(negrita);		
	  add(subrayar);
	  add(tamaño);		
	  add(color);
	  add(cancelar);
	  add(aceptar);
	  add(scroll);
	  add(scroll2);
	  add(adicionales);
	  add(titulo);
	  add(combos);
	  
	  setSize(400,390);
	  setTitle("Patron Decorator");
	  setLocationRelativeTo(null);
	  setLayout(null);

	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==aceptar)
		{
			if (combos.getSelectedIndex()==1) 
			{
				Texto parrafoQ=new Parrafo();
				area.setText(parrafoQ.getDescripcion());
				enviarPedido(parrafoQ);
			}
			else if (combos.getSelectedIndex()==2) 
			{
				Texto tituloq=new Titulo();
				area.setText(tituloq.getDescripcion());
				enviarPedido(tituloq);
			}
			else if (combos.getSelectedIndex()==3) 
			{
				Texto encabezadoq=new Encabezado();
				area.setText(encabezadoq.getDescripcion());
				enviarPedido(encabezadoq);
			}
			else{
				JOptionPane.showMessageDialog(null, "No ha realizado " +
						"ninguna Solicitud","Advertencia!!!",JOptionPane.WARNING_MESSAGE);
			}
		}
		if (e.getSource()==cancelar)
		{
			System.exit(0);
		}
		if (e.getSource()==combos)
		{
			verificaSeleccion();
			
		}
	}

	
	private void enviarPedido(Texto texto)
	{
			if (negrita.isSelected())
			{
				texto=new Negrita(texto);
							}
			if (subrayar.isSelected())
			{
				texto=new Subrayar(texto);
			}
			if (tamaño.isSelected())
			{
				texto=new TamañoTexto(texto);
			}
			if (color.isSelected())
			{
				texto=new ColorTexto(texto);
			}
		area2.setText( "Su Solicitud"+ ""+texto.getDescripcion()+"\n\n" +
				"Se han Agregado:\n $"+texto.valor() +"Estilos");	
	}

	
	
	private void verificaSeleccion() {
		if (combos.getSelectedIndex()!=0)
		{
			habilitar(true);
			if (combos.getSelectedIndex()==1) 
			{
				area.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
				area2.setText("");
			}
			else if (combos.getSelectedIndex()==2) 
			{
				area.setText("Este es El Titulo");
				area2.setText("");
			}
			else if (combos.getSelectedIndex()==3) 
			{
				area.setText("Este es El Encabezado");
				area2.setText("");
			}
			
		}
		else{
			area.setText("");
			area2.setText("");
			habilitar(false);
		}
			
	}



	private void habilitar(boolean b) 
	{
		color.setEnabled(b);
		negrita.setEnabled(b);
		subrayar.setEnabled(b);
		tamaño.setEnabled(b);
		color.setSelected(false);
		negrita.setSelected(false);
		subrayar.setSelected(false);
		tamaño.setSelected(false);
	}


}
