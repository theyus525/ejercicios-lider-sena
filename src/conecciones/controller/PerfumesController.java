package controller;

import model.Perfumes;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PerfumesController
{
    private connection.conexion conexion = new connection.conexion();

    //metodo agregar
    public void agregar(Perfumes perfumes)
    {
        Connection con = conexion.getConexion();

        String query = "INSERT INTO perfumes (nombre, marca, categoria, precio, stock) VALUES (?,?,?,?,?)";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, perfumes.getNombre());
            pst.setString(2, perfumes.getMarca());
            pst.setString(3, perfumes.getCategoria());
            pst.setDouble(4, perfumes.getPrecio());
            pst.setInt(5, perfumes.getStock());

            int resultado = pst.executeUpdate();

            if(resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Perfume agregado correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al agregar perfume");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void eliminar(int id)
    {
        Connection con = conexion.getConexion();

        String query = "DELETE FROM perfumes WHERE id_perfume = ?";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);

            int resultado = pst.executeUpdate();

            if(resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Perfume eliminado correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al eliminar perfume");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void editar(Perfumes perfumes)
    {
        Connection con = conexion.getConexion();

        String query = "UPDATE perfumes SET nombre = ?, marca = ?, categoria = ?, precio = ?, stock = ? WHERE id_perfume = ?";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, perfumes.getNombre());
            pst.setString(2, perfumes.getMarca());
            pst.setString(3, perfumes.getCategoria());
            pst.setDouble(4, perfumes.getPrecio());
            pst.setInt(5, perfumes.getStock());
            pst.setInt(6, perfumes.getId_perfume());

            int resultado = pst.executeUpdate();

            if(resultado > 0)
            {
                JOptionPane.showMessageDialog(null, "Perfume actualizado correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error al actualizar perfume");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Perfumes> mostrar()
    {
        ArrayList<Perfumes> listaPerfumes = new ArrayList<>();

        Connection con = conexion.getConexion();

        String query = "SELECT * FROM perfumes";

        try
        {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while(rs.next())
            {
                Perfumes perfumes = new Perfumes(
                        rs.getString("categoria"),
                        rs.getInt("id_perfume"),
                        rs.getString("marca"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );

                listaPerfumes.add(perfumes);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return listaPerfumes;
    }
}