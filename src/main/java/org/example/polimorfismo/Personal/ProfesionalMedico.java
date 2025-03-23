package org.example.polimorfismo.Personal;

public class ProfesionalMedico extends Profesional{

    public ProfesionalMedico(String name, int edad, String genero, String nacionalidad, Integer salario, String empresa, String puesto, String profesion, String moneda) {
        super(name, edad, genero, nacionalidad, salario, empresa, puesto, profesion, moneda);
    }

    @Override
    public void trabajar(){
        System.out.println(this.name + " ha agarrado su equipo médico");
        super.trabajar();
    }

    public void ofrecerConsultas(){
        System.out.println(this.name + " ha orfecido consultas a varios pacientes");
    }
}
