import java.util.*;
public class Principal {
    private Map<String, List<Animal>> clasificacion = new TreeMap<>();
    private List<Animal> animales = new ArrayList<>();

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
        clasificacion.computeIfAbsent(animal.getTipo(), k -> new ArrayList<>()).add(animal);
    }

    public void mostrarAnimales() {
        for (Map.Entry<String, List<Animal>> entry : clasificacion.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Animal animal : entry.getValue()) {
                System.out.println("          " + animal.getNombre());
            }
        }

    }
}
