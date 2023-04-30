 
package CapaDeNegocio;


public class Bitwise {
    int x;
    
    public Bitwise(){
        this.x=0;
    }
    public void encender (int pos){ //enciende una posicion determinada  "set1"
        
        int mask =1;
        mask=mask<<(pos-1);
        x=x|mask;
                
    }
    public void apagar (int pos){ //apaga una posicion "set0" 
       
        int mask=1;
        mask=mask<<(pos-1);
        mask=~mask;
        x=x&mask;
            
    }
    public int getbit(int pos){
        int mask=1;
        mask=mask<<(pos-1);
        mask=mask&x;
        mask=mask>>>(pos-1);
        return (mask);
    } 
    
    
    @Override
    public String toString() {
        String S="B=[ ";
        for (int i =32;i>=1;i--){
            S = S + " " + getbit(i);
             }
             S = S + "]";
        return (S);
    }
    public static void main(String[] args) {
        Bitwise bitwisePrueba=new Bitwise();
        bitwisePrueba.encender(12);
        bitwisePrueba.encender(23);
        bitwisePrueba.encender(3);
        System.out.println(bitwisePrueba.toString());
    }
    
}
