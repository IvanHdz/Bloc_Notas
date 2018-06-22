/**
 *
 * @author ViRuZ
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class BlocNotas extends Frame {
    private MenuItem Abrir;
    private MenuItem Guardar;
    private MenuItem Salir;
    private TextArea texto;
  
    public BlocNotas(){
        super("Viruz Blog: Bloc de Notas");
        setSize(600,600);
        setBackground(Color.white);
        setLocationRelativeTo(null);
        addMenu();
        addEventos();
        addComponentes();
        setVisible(true);
      }
    
    public void addMenu (){
        MenuBar barra = new MenuBar();
        Menu m1 = new Menu("Archivo");
        Menu m2 = new Menu("Editar");
        barra.add(m1);
        barra.add(m2);
        Abrir = new MenuItem("Abrir");
        Guardar = new MenuItem("Guardar");       
        Salir = new MenuItem("Salir");
        m1.add(Abrir);
        m1.add(Guardar);
        m1.add(Salir);
        setMenuBar(barra);
    }
    
    public void addEventos(){
       addWindowListener (new WindowAdapter(){
            @Override
         public void windowClosing(WindowEvent e){
                 confirmarSalida();
         }
      });
      Salir.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
                confirmarSalida();
        }
      });
      Abrir.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              abrirArchivo();
          }
      });
      Guardar.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              guardarArchivo();
          }
      });
    }
    
    public void confirmarSalida(){
        VentanaDialogo v = new VentanaDialogo(this);
        v.setVisible(true);
    }
    
    public void abrirArchivo(){
        String nombre;
        FileDialog d = new FileDialog(this,"Abrir archivo"
                ,FileDialog.LOAD);
        d.setLocation(50, 50);
        d.setFile("* .* ");
        d.setVisible(true);
        // getFile obtengo el nombre del archivo seleccionado
        nombre =d.getDirectory()+ d.getFile();
        if(nombre!=null){
            try{
                BufferedReader archivo = new BufferedReader(
                        new FileReader(nombre));
                String linea;
                //setText Asigna caracteres al area de texto
                texto.setText("");
                while((linea=archivo.readLine())!=null){
                    //"\n" Salto de linea
                    texto.setText(texto.getText()+linea+"\n");
                }
                archivo.close();  
                }catch(IOException e){
                System.out.println("Error de Archivo");
                }
        }
     }
    
    public void guardarArchivo(){
        String nombre;
        FileDialog d = new FileDialog(this,"Guardar archivo"
                ,FileDialog.SAVE);
        d.setLocation(100, 100);
        d.setVisible(true);
        //getDirectory te permite guardar en la ubicacion que se desea
        nombre = d.getDirectory()+ d.getFile();
        if(nombre!=null){
            try{
                BufferedWriter archivo = new BufferedWriter(
                        new FileWriter(nombre));
                //getText agarra el string 
                archivo.write(texto.getText());
                //Cierra el flujo
                archivo.close();
            }catch(IOException e){
                System.out.println("Error de archivo");
            }
        }   
    }
    
    public void addComponentes(){
        texto = new TextArea(300,300);
        add(texto,"Center");
    }
}