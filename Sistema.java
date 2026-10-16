import java.util.Scanner;
public class Sistema {
    public static void main(String[] args) {
        Scanner sistemaBanco = new Scanner(System.in);
        Scanner contrania = new Scanner(System.in);
        Scanner nombre = new Scanner(System.in);
        boolean simbolo = true;
        boolean espacii = false; // este boolean lo hice para identificar cuando contra tendra un espacio por eso empieza como false
        int intentos = 3;
        System.out.println("Cual es su nombre ?");
        String hola = nombre.nextLine();
        System.out.println("Hola " + hola + " Buen dia");
        while(intentos != 0){
            System.out.println("la contraseña debe tener almenos una de estas Caracteristicas !");
            System.out.println("Tienes solamente " +intentos + " intentos ");
            System.out.println("1.Debe de contener almenos 1 simbolo especial");
            System.out.println("2.No debe de contener espacios");
            System.out.println("3.debe de tener almenos 4 caracteres");
            String contra = contrania.nextLine();

            for(int i = 0; i < contra.length(); i++){
                char espacio = contra.charAt(i);
                if (espacio == ' '){
                    espacii = true;
                }
            }

            for (int i = 0; i < contra.length(); i++){
                char simbo = contra.charAt(i);
                if(simbo == '@' || simbo == '#' || simbo == '!'|| simbo == '&' || simbo == '/' || simbo == '(' || simbo == ')' || simbo == '=' || simbo == '?' || simbo == '¿' || simbo == '¡'){
                    simbolo = false;
                }
            }
            
            if(contra == null || contra.length() < 4){
                System.out.println("Error : no puede valor nulo o tener menos de 4 caracteres");
                intentos --;
            }else if(espacii == true){
                System.out.println("Error : no debe de contener espacios !!");
                intentos --;

            }else if (simbolo == true){
                System.out.println("Error :  debe de contener almenos 1 Caracteres Especial");
                intentos --;
            }else if( intentos == 0) {
                System.out.println("Se acabaron los intentos Acceso Cerrado");
                
            }else{
                System.out.println("Contraseña Creada correctamente !");
                intentos = 0;
            }
              
        }
        int op = 0;
        while (op == 5){
            System.out.println("Bienvenid@ e banco estado");
            System.out.println("Porfavor escriba su contraseña");
        }

    }

}
