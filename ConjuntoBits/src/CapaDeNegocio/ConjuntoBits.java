/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDeNegocio;

/**
 *
 * @author fernandoo
 */
public class ConjuntoBits {
    //Atributos
    //C[bitwise n ]
    Bitwise C[]; // Arreglo de bitwise 
    int cantidad;  //la Cantidad de datos
    //Constructor
    public ConjuntoBits(){
       C=new Bitwise[3];
        for (int i = 0; i < 3; i++) {
            C[i]=new Bitwise();
        }
    }
                            //90
    public ConjuntoBits(int cantidad){
        this.cantidad=cantidad;
        int cantidadDeEnteros=this.cantidad/32;//2
         if((this.cantidad%32)!=0){
             cantidadDeEnteros++;
         }
         C=new Bitwise[cantidadDeEnteros];
         //C[bitwise1,bitwise2,bitwise3]
         //C[entero1,entero2,entero3]
         for (int i = 0; i < 3; i++) {
            C[i]=new Bitwise();
        }
    }
     
    public boolean Vacia(){
        return cantidad==0;
    }
    public int getCantidad(){
        return cantidad;
    }
                             //50
    public void insertar(int elemento){
        if (elemento>0 && elemento<=cantidad) {
             int numeroDeBitwise=sacarBitwise(elemento);//1
             int numeroDeBits=sacarBits(elemento);//18
             C[numeroDeBitwise].encender(numeroDeBits);
          /*  System.out.println("elemento="+elemento);
             System.out.println("numero De Bitwise="+numeroDeBitwise);
             System.out.println("numero De Bits="+numeroDeBits);
             System.out.println(numeroDeBitwise+"="+C[numeroDeBitwise].toString());
            */ 
        }
    }
                          // 50
    public void Eliminar (int elemento){
        if (elemento>0 && elemento<cantidad) {
            int numeroDeBitwise=sacarBitwise(elemento);//1
            int numeroDeBit=sacarBits(elemento);//18
            
            C[numeroDeBitwise].apagar(numeroDeBit);
             /*System.out.println("elemento="+elemento);
             System.out.println("numero De Bitwise="+numeroDeBitwise);
             System.out.println("numero De Bits="+numeroDeBit);
             System.out.println(numeroDeBitwise+"="+C[numeroDeBitwise].toString());
               */     
        }
    }
    
    
    public int sacarBitwise(int numero){
       return ((numero-1)/32);
    }
    
    public int sacarBits(int numero){
        return (((numero-1)%32)+1);
    } 
                                   //50
    public boolean pertenece(int elemento){
        int numeroDeBitwise=sacarBitwise(elemento);  //1
        int numeroDebit=sacarBits(elemento);  //18
       // System.out.println(C[numeroDeBitwise].getbit(numeroDebit)+"=="+1);
        return (C[numeroDeBitwise].getbit(numeroDebit)==1);
        
    }
    
    public void union(ConjuntoBits A,ConjuntoBits B){
        for (int i = 0; i < (((A.cantidad-1)/32)+1); i++) {//3
            //System.out.println("A="+A.C[i].toString());
            // System.out.println("B="+B.C[i].toString());
              
             
            this.C[i].x=A.C[i].x|B.C[i].x;
           // System.out.println("C="+C[i].toString());
           //  System.out.println("----------------------------------------------------------------------");
        }
    }
    
    public void Interccecion(ConjuntoBits A,ConjuntoBits B){
        for (int i = 0; i < (((A.cantidad-1)/32)+1); i++) {//3
            //System.out.println("A="+A.C[i].toString());
            // System.out.println("B="+B.C[i].toString());
              
             
            this.C[i].x=A.C[i].x&B.C[i].x;
           // System.out.println("C="+C[i].toString());
           //  System.out.println("----------------------------------------------------------------------");
        }
    }
    
    
    public String toString(){
        String salida="C={ ";
        for (int i = 1; i <=cantidad; i++) {
            if (pertenece(i)) {
                salida=salida+i+",";
            }
        }
        
        salida=salida.substring(0, salida.length()-1);
        return salida+"}";
    }
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
       ConjuntoBits conjuntoPruebaA=new ConjuntoBits(90);
        conjuntoPruebaA.insertar(10);
       conjuntoPruebaA.insertar(50);
         conjuntoPruebaA.insertar(80);
          conjuntoPruebaA.insertar(20);
         
         
         //--------------------------------------------------------------------
         ConjuntoBits conjuntoPruebaB=new ConjuntoBits(90);
        conjuntoPruebaB.insertar(20);
       conjuntoPruebaB.insertar(60);
         conjuntoPruebaB.insertar(90);
         //--------------------------------------------------------------------
         ConjuntoBits conjuntoPruebaC=new ConjuntoBits(90);
     
       
        // conjuntoPrueba.Eliminar(50);
        //System.out.println(conjuntoPrueba.pertenece(49));
        System.out.println(conjuntoPruebaA.toString());
         System.out.println(conjuntoPruebaB.toString());
         //conjuntoPruebaC.union(conjuntoPruebaA, conjuntoPruebaB);
         conjuntoPruebaC.Interccecion(conjuntoPruebaA, conjuntoPruebaB);
          System.out.println(conjuntoPruebaC.toString());
       
    }
    
}

