package org.example.polimorfismo.Personal;

public abstract class Profesional extends Persona{

    protected Integer salario;
    protected String moneda;
    protected String profesion;
    protected String puesto;
    protected String empresa;

    public Profesional(String name, int edad, String genero, String nacionalidad, Integer salario, String empresa, String puesto, String profesion, String moneda) {
        super(name, edad, genero, nacionalidad);
        this.salario = salario;
        this.empresa = empresa;
        this.puesto = puesto;
        this.profesion = profesion;
        this.moneda = moneda;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getProfesion() {
        return profesion;
    }

    public String getMoneda() {
        return moneda;
    }

    public Integer getSalario() {
        return salario;
    }

    public void irAlTrabajo(){
        System.out.println(this.name + " se dirige al trabajo");
    };
    public void trabajar(){
        System.out.println(this.name + " ha empezado a trabajar");
    }
}
