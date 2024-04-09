package co.edu.uniquindio.empresaEmpleados;

import co.edu.uniquindio.empresaEmpleados.model.Empleado;
import co.edu.uniquindio.empresaEmpleados.model.Empresa;
import co.edu.uniquindio.empresaEmpleados.model.TipoCargo;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        var empleado1 = new Empleado("Jorge", "1097032932", LocalDate.of(2005, 01, 13), "Quimbaya", 15, TipoCargo.EMPLEADO_NORMAL);

        var empleado2 = new Empleado("Luisa", "1097032532", LocalDate.of(2001, 04, 21), "Quimbaya", 20, TipoCargo.ADMINISTRADOR);

        var empleado3 = new Empleado("Alejandro Montoya", "1097038509", LocalDate.of(1994, 11, 17), "Quimbaya", 15, TipoCargo.ADMINISTRADOR);

        empresa.agregarEmpleado(empleado1);
        empresa.agregarEmpleado(empleado2);
        empresa.agregarEmpleado(empleado3);

        System.out.println(empresa.getListaEmpleados());

        empresa.calcularEdadEmpleado();
        empresa.calcularMayoresEdad();
        empresa.calcularPago();
        empresa.calcularDiaCumpleanios();


    }
}