package co.edu.uniquindio.empresaEmpleados.model;

import java.time.LocalDate;

public class Empleado {
    private String nombre;
    private String id;
    private LocalDate fechaNacimiento;
    private String ciudadVivienda;
    private int cantidadDiasTrabajados;
    private TipoCargo tipoCargo;

    public Empleado() {

    }

    public Empleado(String nombre, String id, LocalDate fechaNacimiento, String ciudadVivienda, int cantidadDiasTrabajados, TipoCargo tipoCargo) {
        this.nombre = nombre;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudadVivienda = ciudadVivienda;
        this.cantidadDiasTrabajados = cantidadDiasTrabajados;
        this.tipoCargo = tipoCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudadVivienda() {
        return ciudadVivienda;
    }

    public void setCiudadVivienda(String ciudadVivienda) {
        this.ciudadVivienda = ciudadVivienda;
    }

    public int getCantidadDiasTrabajados() {
        return cantidadDiasTrabajados;
    }

    public void setCantidadDiasTrabajados(int cantidadDiasTrabajados) {
        this.cantidadDiasTrabajados = cantidadDiasTrabajados;
    }

    public TipoCargo getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(TipoCargo tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", ciudadVivienda='" + ciudadVivienda + '\'' +
                ", cantidadDiasTrabajados=" + cantidadDiasTrabajados +
                ", tipoCargo=" + tipoCargo +
                '}';
    }
}
