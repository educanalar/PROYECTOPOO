public class ReciboEmpleado extends Empleado{
    private String ruc;


    public ReciboEmpleado(){

    }
    public ReciboEmpleado( String nombre, String apellido, String dni, String direccion, int edad, String formacionAcademica, int añosExperiencia, int horas_trabajadas, int pago_horas,
                            String strRuc) {
        super(nombre, apellido, dni, direccion, edad, formacionAcademica, añosExperiencia, horas_trabajadas, pago_horas);
        this.ruc = ruc;

    }

    public String getruc() {
        return ruc;
    }

    public void setruc(String ruc) {
        this.ruc = ruc;
    }
    @Override
    public int cant_horas_extras()
    {    int horasExtras = getHoras_trabajadas() - 40;
        if (getHoras_trabajadas() > 40)
            return  horasExtras;
        else
            return 0;
    }

    @Override
    public int  horasExtras()
    {
        int horaExtras = getHoras_trabajadas() -  40;
        if (getHoras_trabajadas() > 40 )
            return getPagoPorHora() * 2 * horaExtras;
        else
            return 0;
    }
    @Override
    public double sueldoBruto(){
        return getHoras_trabajadas() * getPagoPorHora();
    }
    @Override
    public double sueldoNeto(){
        return sueldoBruto() + horasExtras();
    }

    @Override
    public String imprimirBoletaPago() {
        return      "INFORME DEL TRABAJADOR" + "\n" +
                "----------------------" + "\n" +
                "                       "+ "\n" +
                "Datos del Empleado" + "\n" +
                "Nombres: " + super.getNombre()+"\n" +
                "Apellidos: " + super.getApellido()+"\n" +
                "DNI: "  + super.getCurp()+ "\n" +
                "Edad: " + super.getEdad()+"\n" +
                "Dirección: " + super.getDireccion()+"\n" +
                "Formación Academica: " + super.getFormacionAcademica()+ "\n" +
                "Años de experiencia: " + super.getAñosExperiencia()+ "\n" +
                "                        " + "\n" +
                "Resumen de Pago" + "\n" +
                "Sueldo Bruto: S/ " + sueldoBruto()+ "\n" +
                "Horas Extras: " + cant_horas_extras()+ "\n" +
                "Pago por horas Extras: S/ " + horasExtras() + "\n" +
                "Sueldo Neto: S/ " + sueldoNeto();
    }

}
