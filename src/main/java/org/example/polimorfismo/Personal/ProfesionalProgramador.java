package org.example.polimorfismo.Personal;

public class ProfesionalProgramador extends Profesional{
    public ProfesionalProgramador(String name, int edad, String genero, String nacionalidad, Integer salario, String empresa, String puesto, String profesion, String moneda) {
        super(name, edad, genero, nacionalidad, salario, empresa, puesto, profesion, moneda);
    }

    @Override
    public void trabajar(){
        System.out.println(this.name + " ha encendido su computadora");
        super.trabajar();
    }

    public void entrarALlamadas(){
        System.out.println(this.name + " ha entrado a varias llamadas");
    }
}
