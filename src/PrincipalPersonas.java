import java.util.*;
public class PrincipalPersonas {
    private List<Persona> personas = new ArrayList<>();

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public void ejecutarOperaciones() {
        // a.
        long cantidadPersonas = personas.stream().count();
        System.out.println("Cantidad de personas: " + cantidadPersonas);

        // b.
        double promedioEdad = personas.stream().mapToInt(Persona::getEdad).average().orElse(0);
        System.out.println("Promedio de edad: " + promedioEdad);

        // c.
        long mayoresDeEdad = personas.stream().filter(p -> p.getEdad() >= 18).count();
        System.out.println("Mayores de edad: " + mayoresDeEdad);

        // d.
        personas.stream().filter(p -> p.getNombre().startsWith("A")).forEach(p -> System.out.println(p.getNombre()));

        // e.
        personas.stream().filter(p -> p.getApellido().contains("M")).forEach(p -> System.out.println(p.getApellido()));
    }

    public void operacionesLambdaExtra() {
        // a.
        personas.stream()
                .filter(p -> p.getCargo().equals("Director") && p.getGenero().equals("M"))
                .map(p -> p.getNombre() + " Sueldo por 8 horas: $" + (p.getSueldoHora() * 8))
                .forEach(System.out::println);

        // b.
        personas.stream()
                .filter(p -> p.getCargo().equals("Desarrollador") && p.getGenero().equals("F"))
                .findFirst()
                .ifPresent(p -> System.out.println(p.getNombre()));

        // c.
        Optional<Persona> masGana = personas.stream()
                .filter(p -> p.getCargo().equals("Desarrollador"))
                .max(Comparator.comparingDouble(Persona::getSueldoHora));
        if (masGana.isPresent()) {
            Persona persona = masGana.get();
            System.out.println(persona.getNombre() + " gana más por hora.");
        }

        // d.
        personas.stream()
                .filter(p -> p.getGenero().equals("F"))
                .sorted(Comparator.comparing(Persona::getNombre))
                .forEach(p -> System.out.println(p.getNombre()));
    }
}
