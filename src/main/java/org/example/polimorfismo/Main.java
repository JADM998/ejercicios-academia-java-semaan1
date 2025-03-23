package org.example.polimorfismo;

import org.example.polimorfismo.Personal.*;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new ProfesionalDesempleado(
                "Juanito", 22, "Masculino", "Mexico",
                null, null, null, "Ingeniero", "MXN Peso"
        );
        Persona persona2 = new ProfesionalMedico(
                "Karla", 35, "Femenino", "Reino unido",
                80000, "Super hospital", "Médico general", "Médico", "Euro"
        );
        Persona persona3 = new ProfesionalProgramador(
                "Beatriz", 28, "Femenino", "Colombia",
                45000, "La gran consultora", "Software Engineer Jr", "Software Engineer", "USD"
        );
        Persona persona4 = new Persona(
                "George", 71, "Masculino", "Alemania"
        );

        Persona[] personas = {persona3, persona2, persona1, persona4};

        for(Persona persona: personas){
            System.out.println("La vida normal de " + persona.getName() + " en " + persona.getNacionalidad());
            persona.despertar();
            persona.desayunar();
            persona.caminar();

            if(persona instanceof Profesional){
                Profesional profesional = (Profesional) persona;
                profesional.irAlTrabajo();
                profesional.caminar(true);
                profesional.trabajar();

                if(profesional instanceof ProfesionalProgramador){
                    ProfesionalProgramador programador = (ProfesionalProgramador) profesional;
                    programador.entrarALlamadas();
                }else if(profesional instanceof ProfesionalMedico){
                    ProfesionalMedico medico = (ProfesionalMedico) profesional;
                    medico.ofrecerConsultas();
                }

                profesional.comer();
                profesional.trabajar();
                profesional.caminar();
            }

            persona.correr();
            persona.correr(true);
            persona.descansar();
            persona.banarse();
            persona.cenar();
            persona.dormir();
            System.out.println("\n\n");
        }
    }
}