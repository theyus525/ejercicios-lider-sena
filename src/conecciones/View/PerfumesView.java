package view;

import controller.PerfumesController;
import model.Perfumes;

import javax.swing.*;
import java.util.ArrayList;

public class PerfumesView
{
    PerfumesController perfumesController = new PerfumesController();
    connection.conexion conexion = new connection.conexion();

    public void mostrar()
    {
        ArrayList<Perfumes> listaPerfumes = new ArrayList<>();

        listaPerfumes = perfumesController.mostrar();

        for (Perfumes perfumes : listaPerfumes)
        {
            System.out.println("ID: " + perfumes.getId_perfume());
            System.out.println("Nombre: " + perfumes.getNombre());
            System.out.println("Marca: " + perfumes.getMarca());
            System.out.println("Categoria: " + perfumes.getCategoria());
            System.out.println("Precio: " + perfumes.getPrecio());
            System.out.println("Stock: " + perfumes.getStock());
            System.out.println("----------------------------------------");
        }
    }

    public void agregar()
    {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del perfume");
        String marca = JOptionPane.showInputDialog("Ingrese la marca del perfume");
        String categoria = JOptionPane.showInputDialog("Ingrese la categoria del perfume");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del perfume"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del perfume"));

        Perfumes perfumes = new Perfumes(categoria, 0, marca, nombre, precio, stock);
        perfumesController.agregar(perfumes);
    }

    public void eliminar()
    {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del perfume"));
        perfumesController.eliminar(id);
    }

    public void actualizar()
    {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del perfume");
        String marca = JOptionPane.showInputDialog("Ingrese la marca del perfume");
        String categoria = JOptionPane.showInputDialog("Ingrese la categoria del perfume");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del perfume"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del perfume"));
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del perfume"));

        Perfumes perfumes = new Perfumes(categoria, id, marca, nombre, precio, stock);
        perfumesController.editar(perfumes);
    }

    public void menu()
    {
        int op = Integer.parseInt(JOptionPane.showInputDialog(
                "1.Mostrar\n2.Agregar\n3.Actualizar\n4.Eliminar\n5.Salir"));

        switch (op)
        {
            case 1:
                mostrar();
                break;
            case 2:
                agregar();
                break;
            case 3:
                actualizar();
                break;
            case 4:
                eliminar();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
        }

        menu();
    }

    public static void main(String[] args)
    {
        PerfumesView perfumesView = new PerfumesView();
        perfumesView.menu();
    }
}