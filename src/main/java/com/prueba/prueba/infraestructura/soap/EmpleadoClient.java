package com.prueba.prueba.infraestructura.soap;

import com.prueba.prueba.wsdl.GetEmpleadoRequest;
import com.prueba.prueba.wsdl.GetEmpleadoResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;

public class EmpleadoClient extends WebServiceGatewaySupport {


    public GetEmpleadoResponse getEmpleado(String nombres, String apellidos, String tipoDocumento,
                                           String numeroDocumento, Date fechaNacimiento,
                                           Date fechaVinculacionCompania, String cargo, Double salario) {

        XMLGregorianCalendar fechaNacimientoXML = formatearFecha(fechaNacimiento);
        XMLGregorianCalendar fechaVinculacionXML = formatearFecha(fechaVinculacionCompania);

        GetEmpleadoRequest request = new GetEmpleadoRequest();
        request.setNombres(nombres);
        request.setApellidos(apellidos);
        request.setTipoDocumento(tipoDocumento);
        request.setNumeroDocumento(numeroDocumento);
        request.setFechaNacimiento(fechaNacimientoXML);
        request.setFechaVinculacionCompania(fechaVinculacionXML);
        request.setCargo(cargo);
        request.setSalario(salario);

        GetEmpleadoResponse response = (GetEmpleadoResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:9020/ws/empleado", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetEmpleadoRequest"));
        return response;
    }

    public XMLGregorianCalendar formatearFecha(Date fecha) {

        java.util.GregorianCalendar fechaConvertir = new java.util.GregorianCalendar();
        fechaConvertir.setTime(fecha);
        javax.xml.datatype.XMLGregorianCalendar fechaXML = null;
        try {
            fechaXML = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaConvertir);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        return fechaXML;
    }

}