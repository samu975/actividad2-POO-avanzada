import java.util.*;

public class Main {
    public static void main(String[] args) {
        Principal principalAnimal = new Principal();
        PrincipalPersonas principalPersona = new PrincipalPersonas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción: \n1. Gestionar animales \n2. Gestionar personas \n3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    while (true) {
                        System.out.println("Gestión de Animales");
                        System.out.println("1. Agregar animal \n2. Mostrar animales \n3. Volver al menú principal");
                        int opcionAnimal = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer

                        switch (opcionAnimal) {
                            case 1:
                                System.out.println("Ingrese nombre del animal:");
                                String nombreAnimal = scanner.nextLine();

                                System.out.println("Ingrese tipo de animal (terrestre, aéreo, acuático):");
                                String tipo = scanner.nextLine();

                                System.out.println("Ingrese género del animal (masculino, femenino):");
                                String generoAnimal = scanner.nextLine();

                                principalAnimal.agregarAnimal(new Animal(nombreAnimal, tipo, generoAnimal));
                                break;

                            case 2:
                                principalAnimal.mostrarAnimales();
                                break;

                            case 3:
                                System.out.println("Volviendo al menú principal...");
                                break;

                            default:
                                System.out.println("Opción no válida. Intente nuevamente.");
                                break;
                        }

                        if (opcionAnimal == 3) {
                            break;  // Salir del bucle de gestión de animales
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("Gestión de Personas");
                        System.out.println("1. Agregar persona \n2. Ejecutar operaciones con personas \n3. Volver al menú principal");
                        int opcionPersona = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer

                        switch (opcionPersona) {
                            case 1:
                                System.out.println("Ingrese nombre de la persona:");
                                String nombrePersona = scanner.nextLine();

                                System.out.println("Ingrese apellido de la persona:");
                                String apellido = scanner.nextLine();

                                System.out.println("Ingrese edad de la persona:");
                                int edad = scanner.nextInt();
                                scanner.nextLine();  // Limpiar el buffer

                                System.out.println("Ingrese género de la persona (M/F):");
                                String generoPersona = scanner.nextLine();

                                System.out.println("Ingrese sueldo por hora de la persona:");
                                double sueldoHora = scanner.nextDouble();
                                scanner.nextLine();  // Limpiar el buffer

                                System.out.println("Ingrese cargo de la persona:");
                                String cargo = scanner.nextLine();

                                principalPersona.agregarPersona(new Persona(nombrePersona, apellido, edad, generoPersona, sueldoHora, cargo));
                                break;

                            case 2:
                                principalPersona.ejecutarOperaciones();
                                principalPersona.operacionesLambdaExtra();
                                break;

                            case 3:
                                System.out.println("Volviendo al menú principal...");
                                break;

                            default:
                                System.out.println("Opción no válida. Intente nuevamente.");
                                break;
                        }

                        if (opcionPersona == 3) {
                            break;  // Salir del bucle de gestión de personas
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
}