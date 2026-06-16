import javax.swing.*;

//Clase Calculadora
public class Calculadora
{
   //Metodo Sumar
   public int sumar(int num1, int num2)
   {
       return num1 + num2;
   }

   //metodo restar
   public int restar(int num1, int num2)
   {
     return num1 - num2;
   }

   //metodo multiplicar
   public int multiplicar(int num1, int num2)
   {
       return num1 * num2;
   }

   //metodo dividir
   public double dividir(double num1, double num2)
   {
       return num1 / num2;
   }

   //metodo mayor
    public void esMayor(int num1, int num2)
    {
        if(num1 > num2)
        {
            JOptionPane.showMessageDialog(null, num1 + " es MAYOR que " + num2);
        }
        else if(num1 < num2)
        {
            JOptionPane.showMessageDialog(null, num1 + " es MENOR que " + num2);
        }
        else
        {
            JOptionPane.showMessageDialog(null, num1 + " es IGUAL a " + num2);
        }
    }

    //metodo numero primo
    public void primo(int num1)
    {
        if (esPrimo(num1)) {
            JOptionPane.showMessageDialog(null, num1 + " es un número PRIMO.");
        } else {
            JOptionPane.showMessageDialog(null, num1 + " NO es un número primo.");
        }
    }

    private boolean esPrimo(int n)
    {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

   //psvm
   public static void main(String[] args)
   {
     //NombreClase nombreObjeto = new NombreClase();
       Calculadora calculadora = new Calculadora();
       int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del numero 1"));
       int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del numero 2"));
       //se muestra el resultado por consola
       System.out.println("El resultado de la suma es: "+calculadora.sumar(num1,num2));
       //Se muestra el resultado por pantalla
       JOptionPane.showMessageDialog(null,"El resultado de la suma es: "+calculadora.sumar(num1,num2));
       JOptionPane.showMessageDialog(null,"El resultado de la resta es: "+calculadora.restar(num1,num2));
       JOptionPane.showMessageDialog(null,"El resultado de la multiplicacion es: "+calculadora.multiplicar(num1,num2));
       JOptionPane.showMessageDialog(null,"El resultado de la division es: "+calculadora.dividir(num1,num2));
       //Comparación de números
       calculadora.esMayor(num1, num2);
       //Verificar número primo
       calculadora.primo(num1);
       calculadora.primo(num2);
   }
}
