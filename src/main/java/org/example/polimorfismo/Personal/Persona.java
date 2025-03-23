package org.example.polimorfismo.Personal;

public class Persona {
    protected String name;
    protected int edad;
    protected String genero;
    protected String nacionalidad;

    public Persona(String name, int edad, String genero, String nacionalidad) {
        this.name = name;
        this.edad = edad;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
    }

    public String getName() {
        return name;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void despertar(){
        System.out.println(this.name + " ha despertado");
    }
    public void desayunar(){
        System.out.println(this.name + " ha desayunado");
    }
    public void caminar(){
        System.out.println(this.name + " empezó a caminar");
    }
    public void caminar(boolean conPrisa){
        System.out.println(this.name + " empezó a caminar con prisa");
    }
    public void correr(){
        System.out.println(this.name + " empezó a correr");
    }
    public void correr(boolean cansado){
        System.out.println(this.name + " empezó a correr cansado");
    }
    public void comer(){
        System.out.println(this.name + " ha almorzado");
    }
    public void cenar(){
        System.out.println(this.name + " ha cenado");
    }
    public void descansar(){
        System.out.println(this.name + " esta descansado");
    }
    public void banarse(){
        System.out.println(this.name + " se ha bañado");
    }
    public void dormir(){
        System.out.println(this.name + " se ha dormido");
    }
}
