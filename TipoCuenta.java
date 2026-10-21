public abstract class TipoCuenta {
    private String clave;
    private int idCuenta;
    public TipoCuenta(String clave, int idCuenta){
        setClave(clave);
        setIdCuenta(idCuenta);
    }

    public String getClave() {
        return clave;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setClave(String clave) {
        for(int i = 0; i < clave.length(); ++i){
            if(!Character.isLetterOrDigit(clave.charAt(i))){
                throw new IllegalArgumentException("Error: No debe contener caracteres Especiales");
            }else if(Character.isLetter(clave.charAt(i))){
                throw new IllegalArgumentException("No debe contener letras");
            }
        }

        if(clave.length() <= 3 || clave.length() > 4){
            throw new IllegalArgumentException("Error: Debe contener 4 digitos su clave ! ");
        }

        


    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
    
    

}
