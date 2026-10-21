public class Cliente {

    private String nombreTitular;
    private double saldo;
    private String rut;

    public Cliente (String nombreTitular, double saldo, String rut){
        setNombreTitular(nombreTitular);
        setRut(rut);
        setSaldo(saldo);
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public String getRut() {
        return rut;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNombreTitular(String nombreTitular) {


        if (nombreTitular == null  || nombreTitular.isBlank()){
            throw new IllegalArgumentException("Error: no debe estar vacio");
        }
        if (nombreTitular.length() > 21){
            throw new IllegalArgumentException("Error: No debe de contener mas de 21 caracteres");
        }


        for (int i = 0; i <= nombreTitular.length(); ++i){
            if(Character.isDigit(nombreTitular.charAt(i))){
                throw new IllegalArgumentException("Error: No debe contener Numeros");
            }
        }

        this.nombreTitular = nombreTitular;
    }

    public void setRut(String rut) {


        if(!rut.contains("-")){
            throw new IllegalArgumentException("Error: Debe de contener algun (-)");
        }
        
        if(rut.indexOf("-") != rut.lastIndexOf("-")){
            throw new IllegalArgumentException("Error: Debe contener solamente 1 (-) ");
        }

        
        int posicionGuion = rut.indexOf('-');

        String cuerpo = rut.substring(0, posicionGuion);
        String dv = rut.substring(posicionGuion + 1).toUpperCase();

        if (posicionGuion <= 0 || posicionGuion != rut.lastIndexOf('-') || posicionGuion == rut.length() - 1) {
            throw new IllegalArgumentException("El guion está mal ubicado");
        }

        if(cuerpo.length() > 8){
            throw new IllegalArgumentException("Error : El cuerpo del rut no puede tener mas de 8 digitos ! ");
        }

        
        for (int i = 0; i < rut.length(); ++i){
            if (Character.isLetter(rut.charAt(i))){
                throw new IllegalArgumentException("Error: No debe contener letras");
            }
        }

        for (int i = 0; i < rut.length(); ++i){
            char tienePunto = rut.charAt(i);
            if(tienePunto == '.'){
                throw new IllegalArgumentException("Error: No debe de contener puntos ! ");
            }
        }
        
        this.rut = rut;

        /*Esta parte del set falta por terminar para hacerlo bien, por mientras investigare como hacer para que el ultimo digito solamente acepte un ( k )
         */

    }

    public void setSaldo(double saldo) {
        if (saldo < 0 ){
            throw new IllegalArgumentException("Error: No puede tener un saldo menor a 0");
        }
        
        if (Double.isNaN(saldo)){
            throw new IllegalArgumentException("Error: Debe ser un dato tipo numero ! ");
        }
        if(Double.isFinite(saldo)){
            throw new IllegalArgumentException("Error: No puede ser un valor infinito");
        }

        if (saldo >= 4000000.0  || saldo <= 5000000.0){
            throw new IllegalArgumentException("Error: No puede tener esa cantidad de sueldo ! ");
        }

        this.saldo = saldo;
    }
    

}
