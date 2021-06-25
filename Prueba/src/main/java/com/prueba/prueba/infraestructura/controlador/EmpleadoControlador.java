package com.prueba.prueba.infraestructura.controlador;

import com.prueba.prueba.dominio.model.Empleado;
import com.prueba.prueba.dominio.service.ServicioEmpleado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("empleado")
public class EmpleadoControlador{

    private final ServicioEmpleado servicioEmpleado;

    public EmpleadoControlador(final ServicioEmpleado servicioEmpleado) {
        this.servicioEmpleado = servicioEmpleado;

    }

    @GetMapping
    private Empleado obtener(@RequestParam String nombres,
                             @RequestParam String apellidos,
                             @RequestParam String tipoDocumento,
                             @RequestParam String numeroDocumento,
                             @RequestParam String fechaNacimiento,
                             @RequestParam String fechaVinculacionCompania,
                             @RequestParam String cargo,
                             @RequestParam Double salario) {


        return this.servicioEmpleado.validarEmpleado(nombres, apellidos,
                tipoDocumento, numeroDocumento, fechaNacimiento, fechaVinculacionCompania, cargo, salario);
    }

}
