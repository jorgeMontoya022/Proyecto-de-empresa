package co.edu.uniquindio.empresaEmpleados.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Empleado> listaEmpleados = new ArrayList<>();
    private List<Empleado> listaEmpleadosMayoresEdad = new ArrayList<>();

    public Empresa(List<Empleado> listaEmpleados, List<Coordinador> listaCoordinadores, List<Empleado> listaEmpleadosMayoresEdad) {
        this.listaEmpleados = listaEmpleados;
        this.listaEmpleadosMayoresEdad = listaEmpleadosMayoresEdad;

    }

    public Empresa() {

    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }


    public List<Empleado> getListaEmpleadosMayoresEdad() {
        return listaEmpleadosMayoresEdad;
    }

    public void setListaEmpleadosMayoresEdad(List<Empleado> listaEmpleadosMayoresEdad) {
        this.listaEmpleadosMayoresEdad = listaEmpleadosMayoresEdad;
    }

    public void agregarEmpleado(Empleado empleado) {
        if (validarEmpleado(empleado.getId())) {
            throw new IllegalArgumentException("ya hay un empleado con es ID");
        }
        listaEmpleados.add(empleado);
    }

    private boolean validarEmpleado(String id) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void eliminarEmpleado(Empleado empleado) {
        listaEmpleados.remove(empleado);
    }


    public void calcularEdadEmpleado() {
        for (Empleado empleado : listaEmpleados) {
            int edad = calcularEdad(empleado.getFechaNacimiento(), LocalDate.now());
            System.out.println("El empledado " + empleado.getNombre() + " " + "tiene" + " " + edad + " " + "años");
        }

    }

    private int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
        Period period = Period.between(fechaNacimiento, fechaActual);
        int edad = period.getYears();
        return edad;
    }

    public void calcularMayoresEdad() {
        for (Empleado empleado : listaEmpleados) {
            int edad = calcularEdad(empleado.getFechaNacimiento(), LocalDate.now());

            if (edad >= 18) {
                listaEmpleadosMayoresEdad.add(empleado);
            }
        }
        System.out.println("------------------------------------");
        System.out.println("empleados mayores de edad");
        for (Empleado empleado : listaEmpleadosMayoresEdad) {
            System.out.println(empleado);
        }
    }


    public void calcularPago() {
        boolean empleadoNormalImpreso = false;
        boolean administradorImpreso = false;

        System.out.println("-------------------------------------------");
        System.out.println("NÓMINA");
        System.out.println("*********************************************");

        for (Empleado empleado : listaEmpleados) {
            if (empleado.getTipoCargo().equals(TipoCargo.EMPLEADO_NORMAL)) {
                if (!empleadoNormalImpreso) {
                    System.out.println("Nómina empleados normales:");
                    empleadoNormalImpreso = true;
                }
                double pago = calcularPagoEmpleadoNormal(empleado.getCantidadDiasTrabajados());
                System.out.println("El total a pagar para el/la empleado " + empleado.getNombre() + ", identificado con el número de documento " + empleado.getId() + ", es: " + pago);

            } else if (empleado.getTipoCargo().equals(TipoCargo.ADMINISTRADOR)) {
                if (!administradorImpreso) {
                    System.out.println("-------------------------------------");
                    System.out.println("Nómina Administrador:");
                    administradorImpreso = true;
                }
                double pago = calcularPagoAdministrador(empleado.getCantidadDiasTrabajados());
                System.out.println("El total a pagar para el/la administrador " + empleado.getNombre() + ", identificado con el número de documento " + empleado.getId() + ", es: " + pago);

            }
        }
    }


    private double calcularPagoAdministrador(int cantidadDiasTrabajados) {
        double valorDia = 65000;
        return valorDia * cantidadDiasTrabajados;
    }


    private double calcularPagoEmpleadoNormal(int cantidadDiasTrabajados) {
        double valorDia = 50000;
        return valorDia * cantidadDiasTrabajados;
    }


    public void calcularDiaCumpleanios() {
        boolean fechasCumpleaños = false;
        for (Empleado empleado : listaEmpleados) {
            LocalDate fechaCumpleaniosEsteAño = LocalDate.of(LocalDate.now().getYear(), empleado.getFechaNacimiento().getMonth(), empleado.getFechaNacimiento().getDayOfMonth());
            DayOfWeek diaCumpleanios = fechaCumpleaniosEsteAño.getDayOfWeek();
            if (!fechasCumpleaños) {
                System.out.println("---------------------------------------");
                System.out.println("Fechas de Cumpleaños:");
                fechasCumpleaños = true;
            }
            System.out.println("El empleado " + empleado.getNombre()+" identidicado con el número de documento"+" "+empleado.getId() + " cumple años el día " + diaCumpleanios);
        }
        if (!fechasCumpleaños) {
            System.out.println("No se encontraron fechas de cumpleaños.");
        }
    }







    @Override
    public String toString() {
        return "Empresa{" +
                "listaEmpleados=" + listaEmpleados +
                ", listaEmpleadosMayoresEdad=" + listaEmpleadosMayoresEdad +
                '}';
    }
}






