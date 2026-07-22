package model;

public class Perfumes
{
    //Atributos
    private int id_perfume;
    private String nombre;
    private String marca;
    private String categoria;
    private double precio;
    private int stock;

    //Constructor
    public Perfumes(String categoria, int id_perfume, String marca, String nombre, double precio, int stock)
    {
        this.categoria = categoria;
        this.id_perfume = id_perfume;
        this.marca = marca;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    //Getters y Setters
    public int getId_perfume()
    {
        return id_perfume;
    }

    public void setId_perfume(int id_perfume)
    {
        this.id_perfume = id_perfume;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }
}