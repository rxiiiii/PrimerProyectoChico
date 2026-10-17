import java.util.InputMismatchException;
import java.util.Scanner;
public class Sistema {
    public static void main(String[] args) {
        Scanner sistemaBanco = new Scanner(System.in);
        Scanner contrania = new Scanner(System.in);
        Scanner nombre = new Scanner(System.in);
        Scanner ponContrania = new Scanner(System.in);
        Scanner agregarDinero = new Scanner(System.in);
        Scanner transferencia2 = new Scanner(System.in);
        Scanner transferenciaBanco = new Scanner(System.in);
        Scanner nombreTransferencia = new Scanner(System.in);
        boolean simbolo = true;
        boolean espacii = false; // este boolean lo hice para identificar cuando contra tendra un espacio por eso empieza como false
        boolean dineroActivo = false;
        boolean letrasAbc = false; //esta variable para tener control que si tiene alguna letra el rut !
        boolean espacio2 = false;
        boolean guion = true; //esta variable es para ver si el rut contiene un  ( - )
        boolean punto = false;
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
                int op = 1;
                while (op !=5){
                    System.out.println("Bienvenid@ e banco estado");
                    System.out.println("Porfavor escriba su contraseña");
                    
                    String contr = ponContrania.nextLine();
                    if (contr.equals(contra)){
                        System.out.println("Se accedio correctamente");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Opciones Banco Ricardo ");
                        System.out.println("1.Deposito Dinero");
                        System.out.println("2.Transferencia");
                        System.out.println("3.Sacar Dinero");
                        System.out.println("4.Ver saldo");
                        System.out.println("5.salir");
                        int opBanco = sistemaBanco.nextInt();
                        try{
                            if (opBanco <= 0 && opBanco > 5){
                                System.out.println("Error: Opcion No valida tiene que ser 1 2 o 3");
                            }else if (opBanco == 1){
                            double saldo = 0;
                            System.out.println("Hola " +hola + " cuanto dinero depositara hacia su cuenta?");
                            double agregarDinero1 = agregarDinero.nextDouble();
                            try{
                                if(agregarDinero1 < 1){
                                    System.out.println("Error: No puede agregar el Valor " +agregarDinero1);
                            }else if(agregarDinero1 > 4000000.0){
                                System.out.println("Error : Acaba de superar el limite Puesto de dinero ");
                            }else{
                                double dineroAgregado = agregarDinero1 + saldo;
                                System.out.println("El monto fue Agregado Correctamente : " + dineroAgregado + "$");
                                dineroActivo = true;
                            }
                            }catch(InputMismatchException e){
                                System.out.println("Error: Tipo de dato no valido");
                            }
                            }else if (opBanco == 2){
                                System.out.println("Hola " +hola + "ponga el rut de la persona que quiere depositarle : ");
                                System.out.println("El rut debe de tener obligatoriamente estos requisitos ! ");
                                System.out.println("1. tener si o si el -");
                                System.out.println("2. no contener espacios");
                                System.out.println("3. no debe contener ( . ) ");
                                while(true){
                                    String rut = transferencia2.nextLine();

                                    for (int i = 0; i < rut.length(); i++){
                                        if(Character.isLetter(rut.charAt(i))){
                                            letrasAbc = true;
                                        }
                                    }

                                    for (int i = 0; i < rut.length(); i++){
                                        char guion1 = rut.charAt(i);
                                        if(guion1 == '-'){
                                            guion = false;
                                        }
                                    }

                                    for (int i = 0; i < rut.length(); i++){
                                        char espacio3 = rut.charAt(i);
                                        if (espacio3 == ' '){
                                            espacio2 = true;
                                        }

                                    }

                                    for (int i = 0; i < rut.length(); i++){
                                        char punto2 = rut.charAt(i);
                                        if(punto2 == '.'){
                                            punto = false;
                                        }
                                    }
                                    
                                    if (letrasAbc == true){
                                        System.out.println("Error : No puede contener letras ! ");
                                    }else if (guion != true){
                                        System.out.println("Error : Debe de contener algun ( - ) ");
                                    }else if (espacio2 == true){
                                        System.out.println("Error : No puede contener espacios ! ");
                                    }else if (rut.length() <= 0 || rut.length() >10 ){
                                        System.out.println("Error: Debe de tener 10 digitos el rut ! ");
                                    }else if(punto == true){
                                        System.out.println("Error : No debe contener espacios ! ");
                                    }else if(rut.length() == 10 && punto == false && espacio2 == false && guion != true && letrasAbc == false){
                                        System.out.println("hola");
                                    }

                                    

                                    }

                                    


                                    
                                    
                                }

                            }catch(InputMismatchException e){
                                System.out.println("Error : Dato no valido");         
                            }
                        }
                }
            }
            }
        }
        
    }

