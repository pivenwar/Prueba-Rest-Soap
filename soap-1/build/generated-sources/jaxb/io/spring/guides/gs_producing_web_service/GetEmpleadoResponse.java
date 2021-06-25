//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.4 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.06.25 a las 04:56:03 PM COT 
//


package io.spring.guides.gs_producing_web_service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="empleado" type="{http://spring.io/guides/gs-producing-web-service}empleado"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "empleado"
})
@XmlRootElement(name = "getEmpleadoResponse")
public class GetEmpleadoResponse {

    @XmlElement(required = true)
    protected Empleado empleado;

    /**
     * Obtiene el valor de la propiedad empleado.
     * 
     * @return
     *     possible object is
     *     {@link Empleado }
     *     
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Define el valor de la propiedad empleado.
     * 
     * @param value
     *     allowed object is
     *     {@link Empleado }
     *     
     */
    public void setEmpleado(Empleado value) {
        this.empleado = value;
    }

}
