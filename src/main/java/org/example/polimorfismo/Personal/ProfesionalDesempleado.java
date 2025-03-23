package org.example.polimorfismo.Personal;

public class ProfesionalDesempleado extends Profesional{
    public ProfesionalDesempleado(String name, int edad, String genero, String nacionalidad, Integer salario, String empresa, String puesto, String profesion, String moneda) {
        super(name, edad, genero, nacionalidad, salario, empresa, puesto, profesion, moneda);
    }

    @Override
    public void irAlTrabajo(){
        System.out.println(this.name + " no tiene trabajo, no puede ir a trabajar");
    };
    @Override
    public void trabajar(){
        System.out.println(this.name + " no tiene trabajo, pero empieza a aplicar a distintos puestos");
    }
}
