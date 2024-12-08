/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfazactividades;

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class InterfazActividades {

    private int espaciosYoga = 30;
    private int espaciosBaile = 30;  // Se crean los 30  espacios para la clase de Baile
    private HashMap<String, String> pedidosBebidas = new HashMap<>();
    private Cine cine = new Cine("Pelicula 1", "Pelicula 2"); // creamos el cine 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazActividades().crearInterfaz());
    } //creacion de la interfaz

    public void crearInterfaz() {
        JFrame ventana = new JFrame("Gestión de Clases, Bebidas y Cine");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 500);
        ventana.setLayout(new FlowLayout());   // Damos forma t tamaño  a la interfaz 

        // Construimos  el panel de botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10)); // 4 filas, 2 columnas de botones   , 10 de espacio vertical e horizontal entre los componentes 

        // Botones para cada opción del menú   se le da un color caracteristico a cada uno para facilitar su memorización 
        JButton botonMenu1 = crearBotonColor("Elegir una bebida", Color.CYAN);
        JButton botonMenu2 = crearBotonColor("Reservar espacio en Yoga", Color.GREEN);
        JButton botonMenu3 = crearBotonColor("Reservar espacio en Baile", Color.pink); 
        JButton botonMenu4 = crearBotonColor("Liberar espacio en Yoga", Color.RED);
        JButton botonMenu5 = crearBotonColor("Liberar espacio en Baile", Color.ORANGE); 
        JButton botonMenu6 = crearBotonColor("Listar pedidos de bebidas", Color.MAGENTA);
        JButton botonMenu7 = crearBotonColor("Gestionar Cine", Color.GRAY);
        JButton botonMenu8 = crearBotonColor("Salir", Color.DARK_GRAY);

        // Acción para abrir el menú de cada opción
        botonMenu1.addActionListener(e -> elegirBebida(ventana));
        botonMenu2.addActionListener(e -> reservarEspacioYoga(ventana));
        botonMenu3.addActionListener(e -> reservarEspacioBaile(ventana));  
        botonMenu4.addActionListener(e -> liberarEspacioYoga(ventana));
        botonMenu5.addActionListener(e -> liberarEspacioBaile(ventana));  
        botonMenu6.addActionListener(e -> listarPedidos(ventana));
        botonMenu7.addActionListener(e -> gestionarCine(ventana));
        botonMenu8.addActionListener(e -> {
            JOptionPane.showMessageDialog(ventana, "Menú interactivo cerrado con éxito");
            System.exit(0);
        });

        // Añadir botones al panel
        panel.add(botonMenu1);
        panel.add(botonMenu2);
        panel.add(botonMenu3);
        panel.add(botonMenu4);
        panel.add(botonMenu5);
        panel.add(botonMenu6);
        panel.add(botonMenu7);
        panel.add(botonMenu8);

        // Añadir el panel a la ventana
        ventana.add(panel);
        ventana.setVisible(true);
    }

    private JButton crearBotonColor(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente del botón
        boton.setBackground(color); // Color de fondo del botón
        boton.setForeground(Color.WHITE); // Color del texto
        boton.setPreferredSize(new Dimension(250, 50)); // Tamaño del botón
        return boton;
    }

    private void gestionarCine(JFrame ventana) {
        String[] opcionesCine = {"Ver estado de salas", "Reservar asiento", "Cambiar película", "Regresar"};   //Opciones relacionadas al cine 
        boolean continuar = true;

        while (continuar) {
            String seleccion = (String) JOptionPane.showInputDialog(
                    ventana, "¿Qué deseas hacer en el Cine?", "Gestión de Cine", JOptionPane.PLAIN_MESSAGE, null, opcionesCine, opcionesCine[0]);

            if (seleccion == null || seleccion.equals("Regresar")) {
                continuar = false;
                break;
            }

            switch (seleccion) {
                case "Ver estado de salas":
                    cine.mostrarSalas();
                    JOptionPane.showMessageDialog(ventana, "El estado de las salas se ha mostrado en la consola.");  //muestra en consola los espacios y pelicula segun el formato requerido 
                    break;
                case "Reservar asiento":
                    reservarAsientoCine(ventana);
                    break;
                case "Cambiar película":
                    cambiarPelicula(ventana);
                    break;
                default:
                    JOptionPane.showMessageDialog(ventana, "Opción no válida.");
            }
        }
    }

    private void reservarAsientoCine(JFrame ventana) {
        String[] opcionesSala = {"Sala 1", "Sala 2"};
        String salaSeleccionada = (String) JOptionPane.showInputDialog(
                ventana, "Selecciona una sala:", "Reservar Asiento", JOptionPane.PLAIN_MESSAGE, null, opcionesSala, opcionesSala[0]);

        if (salaSeleccionada != null) {
            int salaNum = salaSeleccionada.equals("Sala 1") ? 1 : 2;
            String fila = JOptionPane.showInputDialog(ventana, "Ingresa la fila (A-E):").toUpperCase();
            String columna = JOptionPane.showInputDialog(ventana, "Ingresa la columna (1-6):");

            if (fila != null && columna != null) {
                int filaNum = fila.charAt(0) - 'A';
                int columnaNum = Integer.parseInt(columna) - 1;

                String nombreEmpleado = JOptionPane.showInputDialog(ventana, "Ingresa el nombre del empleado:");
                cine.asignarAsiento(salaNum, filaNum, columnaNum, nombreEmpleado);
            }
        }
    }

    private void cambiarPelicula(JFrame ventana) {
        String[] opcionesSala = {"Sala 1", "Sala 2"};
        String salaSeleccionada = (String) JOptionPane.showInputDialog(
                ventana, "Selecciona una sala:", "Cambiar Película", JOptionPane.PLAIN_MESSAGE, null, opcionesSala, opcionesSala[0]);

        if (salaSeleccionada != null) {
            int salaNum = salaSeleccionada.equals("Sala 1") ? 1 : 2;
            String nuevaPelicula = JOptionPane.showInputDialog(ventana, "Ingresa el nombre de la nueva película:");
            cine.setPelicula(salaNum, nuevaPelicula);
            JOptionPane.showMessageDialog(ventana, "Película cambiada exitosamente.");
        }
    }

    private void elegirBebida(JFrame ventana) {
        // Opciones de bebida n_n/
        String[] opcionesBebidas = {
            "Café Americano",
            "Capuchino",
            "Capuchino con Vainilla",
            "Chocolate",
            "Moka",
            "Té Chai",
            "Café Frío"
        };

        // Mostrar menú para elegir que bebida reservar 
        String seleccion = (String) JOptionPane.showInputDialog(
                ventana,
                "Selecciona una bebida:",
                "Elegir Bebida",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcionesBebidas,
                opcionesBebidas[0]
        );

        if (seleccion != null) {
            // Guardar el pedido en la lista 
            pedidosBebidas.put(seleccion, "Pedido realizado");
            JOptionPane.showMessageDialog(ventana, "Has elegido: " + seleccion);
        }
    }

    private void reservarEspacioYoga(JFrame ventana) {
        if (espaciosYoga > 0) {
            espaciosYoga--;
            JOptionPane.showMessageDialog(ventana, "Espacio reservado para Yoga. Espacios restantes: " + espaciosYoga);
        } else {
            JOptionPane.showMessageDialog(ventana, "No hay más espacios disponibles para Yoga.");
        }
    }

    private void liberarEspacioYoga(JFrame ventana) {
        if (espaciosYoga < 30) {
            espaciosYoga++;
            JOptionPane.showMessageDialog(ventana, "Espacio liberado para Yoga. Espacios restantes: " + espaciosYoga);
        } else {
            JOptionPane.showMessageDialog(ventana, "No se pueden liberar más espacios para Yoga.");
        }
    }

    private void reservarEspacioBaile(JFrame ventana) {  
        if (espaciosBaile > 0) {
            espaciosBaile--;
            JOptionPane.showMessageDialog(ventana, "Espacio reservado para Baile. Espacios restantes: " + espaciosBaile);
        } else {
            JOptionPane.showMessageDialog(ventana, "No hay más espacios disponibles para Baile.");
        }
    }

    private void liberarEspacioBaile(JFrame ventana) {  
        if (espaciosBaile < 30) {
            espaciosBaile++;
            JOptionPane.showMessageDialog(ventana, "Espacio liberado para Baile. Espacios restantes: " + espaciosBaile);
        } else {
            JOptionPane.showMessageDialog(ventana, "No se pueden liberar más espacios para Baile.");
        }
    }

    private void listarPedidos(JFrame ventana) {
        if (pedidosBebidas.isEmpty()) {
            JOptionPane.showMessageDialog(ventana, "No se han realizado pedidos.");
        } else {
            StringBuilder listaPedidos = new StringBuilder("Pedidos realizados de bebidas:\n");
            for (String bebida : pedidosBebidas.keySet()) {
                listaPedidos.append(bebida).append(": ").append(pedidosBebidas.get(bebida)).append("\n");
            }
            JOptionPane.showMessageDialog(ventana, listaPedidos.toString());
        }
    }
}
