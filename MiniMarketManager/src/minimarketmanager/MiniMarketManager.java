/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minimarketmanager;


import java.util.Scanner;


/**
 *
 * @author HP_USER
 */
public class MiniMarketManager {


    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // VARIABLES
        int opcion = 0;
        int cantidadProductos = 0;

        // ARREGLOS
        String[] nombres = new String[100];
        double[] precios = new double[100];
        int[] stock = new int[100];

        // VARIABLES DE VENTAS
        double totalVentas = 0;

        do {

            System.out.println("\n====================================");
            System.out.println("        MINI MARKET MANAGER");
            System.out.println("====================================");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Realizar venta");
            System.out.println("5. Mostrar total ventas");
            System.out.println("6. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:

                    if (cantidadProductos < nombres.length) {

                        entrada.nextLine();

                        System.out.println("\n--- REGISTRAR PRODUCTO ---");

                        System.out.print("Nombre del producto: ");
                        nombres[cantidadProductos] = entrada.nextLine();

                        System.out.print("Precio del producto: ");
                        precios[cantidadProductos] = entrada.nextDouble();

                        System.out.print("Cantidad en stock: ");
                        stock[cantidadProductos] = entrada.nextInt();

                        cantidadProductos++;

                        System.out.println("\nProducto registrado correctamente.");

                    } else {

                        System.out.println("\nNo hay espacio para mas productos.");
                    }

                    break;

                case 2:

                    System.out.println("\n--- LISTA DE PRODUCTOS ---");

                    if (cantidadProductos == 0) {

                        System.out.println("No hay productos registrados.");

                    } else {

                        for (int i = 0; i < cantidadProductos; i++) {

                            System.out.println("\nProducto #" + (i + 1));
                            System.out.println("Nombre: " + nombres[i]);
                            System.out.println("Precio: $" + precios[i]);
                            System.out.println("Stock: " + stock[i]);
                        }
                    }

                    break;

                case 3:

                    entrada.nextLine();

                    System.out.println("\n--- BUSCAR PRODUCTO ---");

                    System.out.print("Ingrese el nombre del producto: ");
                    String buscar = entrada.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < cantidadProductos; i++) {

                        if (nombres[i].equalsIgnoreCase(buscar)) {

                            System.out.println("\nProducto encontrado");
                            System.out.println("Nombre: " + nombres[i]);
                            System.out.println("Precio: $" + precios[i]);
                            System.out.println("Stock: " + stock[i]);

                            encontrado = true;
                        }
                    }

                    if (!encontrado) {

                        System.out.println("\nProducto no encontrado.");
                    }

                    break;

                case 4:

                    entrada.nextLine();

                    System.out.println("\n--- REALIZAR VENTA ---");

                    System.out.print("Ingrese el nombre del producto: ");
                    String ventaProducto = entrada.nextLine();

                    boolean ventaRealizada = false;

                    for (int i = 0; i < cantidadProductos; i++) {

                        if (nombres[i].equalsIgnoreCase(ventaProducto)) {

                            System.out.print("Cantidad a vender: ");
                            int cantidadVenta = entrada.nextInt();

                            if (cantidadVenta <= stock[i]) {

                                double subtotal = cantidadVenta * precios[i];

                                stock[i] = stock[i] - cantidadVenta;

                                totalVentas = totalVentas + subtotal;

                                System.out.println("\nVenta realizada correctamente.");
                                System.out.println("Total venta: $" + subtotal);

                            } else {

                                System.out.println("\nStock insuficiente.");
                            }

                            ventaRealizada = true;
                        }
                    }

                    if (!ventaRealizada) {

                        System.out.println("\nProducto no encontrado.");
                    }

                    break;

                case 5:

                    System.out.println("\n--- TOTAL DE VENTAS ---");
                    System.out.println("Total acumulado: $" + totalVentas);

                    break;

                case 6:

                    System.out.println("\nGracias por usar Mini Market Manager.");

                    break;

                default:

                    System.out.println("\nOpcion invalida.");

            }

        } while (opcion != 6);

    }

}    

