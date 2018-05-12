package ar.edu.untref.aydoo;

import java.util.Calendar;
import java.util.Date;

public class Utils {

    public final static Double DESCUENTO_CLIENTE = 1.05;
    public final static Double SUSCRIPCION = 1.2;

    public static Integer obtenerMes(Date fecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal.get(Calendar.MONTH) + 1;
    }

    public static Integer obtenerAnio(Date fecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal.get(Calendar.YEAR);
    }
}
