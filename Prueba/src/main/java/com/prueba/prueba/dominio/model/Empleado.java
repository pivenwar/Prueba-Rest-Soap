package com.prueba.prueba.dominio.model;

import org.springframework.lang.NonNull;

public class Empleado {

    private Long id;

    private String nombres;

    private String apellidos;

    private String tipoDocumento;

    private String numeroDocumento;

    private String fechaNacimiento;

    private String fechaVinculacionCompania;

    private String Cargo;

    private Double salario;

    private String tiempoVinculacionCompania;

    private String edadActualEmpleado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(@NonNull String nombres) {
        this.nombres = nombres;
    }


    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@NonNull String apellidos) {
        this.apellidos = apellidos;
    }


    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(@NonNull String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(@NonNull String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaVinculacionCompania() {
        return fechaVinculacionCompania;
    }

    public void setFechaVinculacionCompania(String fechaVinculacionCompania) {
        this.fechaVinculacionCompania = fechaVinculacionCompania;
    }

    @NonNull
    public String getCargo() {
        return Cargo;
    }

    public void setCargo(@NonNull String cargo) {
        Cargo = cargo;
    }

    @NonNull
    public Double getSalario() {
        return salario;
    }

    public void setSalario(@NonNull Double salario) {
        this.salario = salario;
    }

    public String getTiempoVinculacionCompania() {
        return tiempoVinculacionCompania;
    }

    public void setTiempoVinculacionCompania(String tiempoVinculacionCompania) {
        this.tiempoVinculacionCompania = tiempoVinculacionCompania;
    }

    public String getEdadActualEmpleado() {
        return edadActualEmpleado;
    }

    public void setEdadActualEmpleado(String edadActualEmpleado) {
        this.edadActualEmpleado = edadActualEmpleado;
    }
}
