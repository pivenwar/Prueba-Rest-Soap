package com.prueba.prueba.dominio.service;

import com.prueba.prueba.dominio.excepcion.DatoVacioExcepcion;
import com.prueba.prueba.dominio.model.Empleado;
import com.prueba.prueba.infraestructura.soap.EmpleadoClient;
import com.prueba.prueba.wsdl.GetEmpleadoResponse;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class ServicioEmpleado {

    private final EmpleadoClient empleadoClient;

    public ServicioEmpleado(final EmpleadoClient empleadoClient) {
        this.empleadoClient = empleadoClient;
    }

    public Empleado validarEmpleado(String nombres, String apellidos, String tipoDocumento,
                                    String numeroDocumento, String fechaNacimiento,
                                    String fechaVinculacionCompania, String cargo, Double salario) {

        Date fechaActual = new Date();
        Date fechaNacimientoDate = formatearFechas(fechaNacimiento);
        Date fechaVinculacionCompaniaDate = formatearFechas(fechaVinculacionCompania);
        int edadEmpleado = fechaActual.getYear() - fechaNacimientoDate.getYear();

        String dato = tiempoEmpleado(fechaActual, fechaNacimientoDate);
        String tiempo = tiempoEmpleado(fechaActual, fechaVinculacionCompaniaDate);


        if (!validarVacidos(nombres, apellidos, tipoDocumento,
                numeroDocumento, fechaNacimientoDate, fechaVinculacionCompaniaDate, cargo, salario)) {
            throw new DatoVacioExcepcion("los campos no pueden ir vacios");
        }

        if (edadEmpleado < 18) {
            throw new DatoVacioExcepcion("el empleado no es mayor de edad");
        }

        GetEmpleadoResponse getEmpleadoResponse = empleadoClient.getEmpleado(nombres, apellidos,
                tipoDocumento, numeroDocumento, fechaNacimientoDate, fechaVinculacionCompaniaDate, cargo, salario);

        Empleado empleado = new Empleado();
        empleado.setNombres(getEmpleadoResponse.getEmpleado().getNombres());
        empleado.setApellidos(getEmpleadoResponse.getEmpleado().getApellidos());
        empleado.setTipoDocumento(getEmpleadoResponse.getEmpleado().getTipoDocumento());
        empleado.setNumeroDocumento(getEmpleadoResponse.getEmpleado().getNumeroDocumento());
        String fechaNacimientoXML = String.valueOf(getEmpleadoResponse.getEmpleado().getFechaNacimiento());
        empleado.setFechaNacimiento(fechaNacimientoXML);
        String fechaVinculacionCompaniaXML = String.valueOf(getEmpleadoResponse.getEmpleado().getFechaVinculacionCompania());
        empleado.setFechaVinculacionCompania(fechaVinculacionCompaniaXML);
        empleado.setCargo(getEmpleadoResponse.getEmpleado().getCargo());
        empleado.setSalario(getEmpleadoResponse.getEmpleado().getSalario());
        empleado.setEdadActualEmpleado(dato);
        empleado.setTiempoVinculacionCompania(tiempo);
        return empleado;
    }

    private boolean validarVacidos(String nombres, String apellidos, String tipoDocumento,
                                   String numeroDocumento, Date fechaNacimiento,
                                   Date fechaVinculacionCompania, String cargo, Double salario) {

        if (nombres == null || nombres.equals("")) {
            return false;

        }
        if (apellidos == null || apellidos.equals("")) {
            return false;

        }
        if (tipoDocumento == null || tipoDocumento.equals("")) {
            return false;
        }
        if (numeroDocumento == null || numeroDocumento.equals("")) {
            return false;
        }
        if (cargo == null || cargo.equals("")) {
            return false;
        }
        if (salario == null || salario == 0) {
            return false;
        }
        if (fechaNacimiento == null || fechaNacimiento.equals("")) {
            return false;
        }
        return fechaVinculacionCompania != null && !fechaVinculacionCompania.equals("");
    }

    public Date formatearFechas(String fecha) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = new Date();
        try {
            fechaDate = sdf.parse(fecha);


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return fechaDate;
    }

    private String tiempoEmpleado(Date fecha1, Date fecha2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(fecha1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(fecha2);
        int anio = calendar1.get(Calendar.YEAR) - calendar2.get(Calendar.YEAR);
        int mes = calendar1.get(Calendar.MONTH) - calendar2.get(Calendar.MONTH);
        int dia = calendar2.get(Calendar.DAY_OF_MONTH) - calendar1.get(Calendar.DAY_OF_MONTH);
        String fecha = anio + "-" + mes + "-" + dia ;
        return (fecha);
    }
}
