package libreria;

import java.util.ArrayList;
import java.util.Scanner;


public class Libreria {

    static Scanner leer = new Scanner(System.in);
    
    static ArrayList<Libro> libros = new ArrayList();
    
    public static void Solicitar(){
        int codigo;
        double precio;
        int cantidad;
        Libro aux;
        int i, numero;
        
        do {
            System.out.print("ingrese el numero de libros que desea guardar ");
            numero = leer.nextInt();
        } while (numero <= 0);
        leer.nextLine();
        
        for (i = 1; i <= numero; i++) {
            System.out.println("Libro " + i);
            System.out.print("Codigo: ");
            codigo = leer.nextInt();          
            System.out.print("Precio: ");
            precio = leer.nextDouble();
            System.out.print("Cantidad: ");
            cantidad = leer.nextInt();
            leer.nextLine();
            
            aux = new Libro();
            
            aux.setCodigo(codigo);
            aux.setPrecio(precio);
            aux.setCantidad(cantidad);
            
            libros.add(aux);
        }
    }
    
    public static void Consultar(){
        int codigo;
        System.out.println("\nintrodusca el codigo del libro que desea consultar");
        codigo = leer.nextInt();
        System.out.println("los datos del libro son " + codigo);
        for(int i = 0; i < libros.size(); i++){
            if(libros.get(i).getCodigo()== codigo){
                System.out.println(libros.get(i));
                } 
            }           
    }
    
    public static void ActualizarVenta(){
        int codigo; 
        Libro aux;
        int venta=0;
        double pre=0;
        System.out.println("\nConsulte un libro que desee comprar");
        System.out.print("Introduzca el codigo: ");
        codigo = leer.nextInt();
        for(int i = 0; i < libros.size(); i++){
            if(libros.get(i).getCodigo()== codigo){
                pre=libros.get(i).getPrecio();
                aux = new Libro();
                
                if(libros.get(i).getCantidad()>0){
                    venta = libros.get(i).getCantidad();
                    venta--;
                } else if(libros.get(i).getCantidad()==0){
                    venta = libros.get(i).getCantidad();
                    System.out.println("el libro esta agotado");
                }

                aux.setCodigo(codigo);
                aux.setPrecio(pre);
                aux.setCantidad(venta);
              
                libros.set(i,aux);
                }
            
            System.out.println(libros.get(i));
    }
        System.out.println("\nse actualizo el inventario");
    }
    
    public static void MayoresCosto(){
        Libro m1 = libros.get(0);
        Libro m2 = libros.get(0);
        Libro m3 = libros.get(0);
        for(int i = 0; i < libros.size(); i++){
            if(libros.get(i).getPrecio()> m1.getPrecio()){
                m1 = libros.get(i);
            }
        }
        for(int i = 0; i < libros.size(); i++){
            if(libros.get(i).getPrecio()< m1.getPrecio() && libros.get(i).getPrecio()> m2.getPrecio()){
                m2 = libros.get(i);
            }
        }
        for(int i = 0; i < libros.size(); i++){
            if(libros.get(i).getPrecio()< m1.getPrecio() && libros.get(i).getPrecio()< m2.getPrecio() && libros.get(i).getPrecio()> m3.getPrecio()){
                m3 = libros.get(i);
            }
        }
        System.out.println("\nLos 3 libros mas costosos");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
    
    
    public static void main(String[] args) {
       Solicitar();
       Consultar();
       ActualizarVenta();
       MayoresCosto();
    }
    
}