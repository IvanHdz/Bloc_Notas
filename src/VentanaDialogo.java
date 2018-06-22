/**
 *
 * @author ViRuZ
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDialogo extends Dialog {
    private Button boton;
    private Button boton2;
    
    public VentanaDialogo(Frame padre){
        super(padre,"Salir de la ventana",true);
        setBounds(200,200,200,100);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        addComponentes();
        addEventos();
      }
    
    public void addComponentes(){
    Panel p = new Panel();
    boton = new Button("Aceptar");
    boton2 = new Button("Cancelar");
    add(new Label("Desea Salir Realmente"),
            BorderLayout.NORTH);
    add(p,BorderLayout.SOUTH);
    p.add(boton);
    p.add(boton2);
    }
    
    public void addEventos(){
        boton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        boton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
         });
    } 
}     