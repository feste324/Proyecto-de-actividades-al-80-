/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfazactividades;

/**
 *
 * @author Usuario
 */
public class Bebidas {
     private Empleado empleado;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Bebidas() {

    }

    public Bebidas(Empleado empleado) {
        this.empleado = empleado;

    }

    @Override
    public String toString() {
        return "Bebidas{" + "empleado=" + empleado + '}';
    }
 public void selectBebida(Empleado empleado, Empleado empleado1, Empleado empleado2, Empleado empleado3) {
     System.out.println("Nombre del empleado 2: " + empleado2.getNombre());
     System.out.println("ID del empleado 1: " + empleado1.getId());
 }
    
    
    
    
    
    
}
