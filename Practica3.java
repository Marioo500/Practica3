

package practica3;


public class Practica3 {


    public static void main(String[] args) {
        Mexicano[] personas = new Mexicano[3];
        
        for(int i=0;i<3;i++)
        {
            System.out.println("Capturando mexicano " + (i+1));
            personas[i] = new Mexicano();
        }
        System.out.println("CURP Persona 1: " + personas[0].getCURP());
        System.out.println("RFC Persona 2: " + personas[1].getRFC());
        System.out.println("CURP Persona 3: "+ personas[2].getCURP() + "\nRFC: "+ personas[2].getRFC());
}   

    }

    
