
package recursion;
import java.util.Scanner;
//Clase para la suma de los elementos en un vector
class vector {
    private int[] vector;
    private int tamaño;

    public vector(int tamaño) {
        this.tamaño = tamaño;
        this.vector = new int[tamaño];
    }

    // Método recursivo para cargar el vector
    public void cargarVector(int indice) {
        if (indice < tamaño) {
            vector[indice] = indice + 5; // Puedes cambiar esto para cargar valores específicos
            cargarVector(indice + 1);
        }
    }
    public int sumarVector(int indice) {
        if (indice < 0) {
            return 0;
        } else {
            return vector[indice] + sumarVector(indice - 1);
        }
    }
    // Método para imprimir el vector
    public void imprimirVector() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print(vector[i] + " ");
        }
    }
 }
//Calse de una lista circular
class Nodo {
    String valor;
    Nodo siguiente;

    public Nodo(String valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

// Clase ListaCircular
class ListaCircular {
    private Nodo cabeza;
    private Nodo cola;

    public ListaCircular() {
        this.cabeza = null;
        this.cola = null;
    }

    // Método recursivo para agregar un nodo
    public void agregar(String valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cola.siguiente = cabeza; // Hacer la lista circular
        } else {
            agregarRecursivo(cabeza, nuevoNodo);
        }
    }

    // Método auxiliar recursivo
    private void agregarRecursivo(Nodo actual, Nodo nuevoNodo) {
        if (actual.siguiente == cabeza) {
            actual.siguiente = nuevoNodo;
            cola = nuevoNodo;
            cola.siguiente = cabeza; // Mantener la lista circular
        } else {
            agregarRecursivo(actual.siguiente, nuevoNodo);
        }
    }

    // Método para imprimir la lista
    public void imprimir() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo actual = cabeza;
        do {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println();
    }
}

class Nodo1 {
    int valor;
    Nodo1 siguiente;

    public Nodo1(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

// Clase Pila
class Pila {
    Nodo1 top;

    public Pila() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Método recursivo para apilar un elemento
    public void push(int val) {
        pushRecursivo(new Nodo1(val), top);
    }

    private void pushRecursivo(Nodo1 nuevoNodo, Nodo1 actual) {
        if (actual == null) {
            top = nuevoNodo;
        } else if (actual.siguiente == null) {
            actual.siguiente = nuevoNodo;
        } else {
            pushRecursivo(nuevoNodo, actual.siguiente);
        }
    }

    // Método recursivo para desapilar un elemento
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return popRecursivo(top, null);
    }

    private int popRecursivo(Nodo1 actual, Nodo1 anterior) {
        if (actual.siguiente == null) {
            int valor = actual.valor;
            if (anterior == null) {
                top = null;
            } else {
                anterior.siguiente = null;
            }
            return valor;
        } else {
            return popRecursivo(actual.siguiente, actual);
        }
    }

    // Método recursivo para imprimir la pila
    public void imprimir() {
        imprimirRecursivo(top);
        System.out.println();
    }

    private void imprimirRecursivo(Nodo1 nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            imprimirRecursivo(nodo.siguiente);
        }
    }
}

//Ejercicio 4. Calcular la multiplicacion de dos numero donde A es fatoria A! y B es la potencia de B^n
class Resultados {
    int factorial;
    int potencia;

    public Resultados(int factorial, int potencia) {
        this.factorial = factorial;
        this.potencia = potencia;
    }
    public int multiplicarRecursivo(int a, int b)
    {
        if (b == 0) {
            return 0;
        } else {
            return a + multiplicarRecursivo(a, b - 1);
        }
    }
    public int multiplicar() {
        return multiplicarRecursivo(factorial, potencia);
    }
}

class Calcular{
    
    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    public int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
         return base * potencia(base, exponente - 1);
        }
    }
     public Resultados calcular(int a, int bBase, int bExponente) {
        int factorial = factorial(a);
        int potencia = potencia(bBase, bExponente);
        return new Resultados(factorial, potencia);
    }
    
}


public class Recursion{ 
    public static void main(String[] args) {
        System.out.println("Ejercicio 1");
        int tamaño = 5; // Tamaño del vector
        vector vectorRecursivo = new vector(tamaño);

        vectorRecursivo.cargarVector(0); // Cargar el vector recursivamente
        System.out.println("Vector cargado:");
        vectorRecursivo.imprimirVector(); // Imprimir el vector
        
        System.out.println("\nEjercicio 2");
        ListaCircular lista = new ListaCircular();
        lista.agregar("Hola");
        lista.agregar("mundo");
        lista.agregar("desde");
        lista.agregar("Java");
        System.out.println("Lista circular:");
        lista.imprimir();
        
        System.out.println("Ejercicio 3");
        Pila pila = new Pila();
        Scanner scanner = new Scanner(System.in);
        int i=0; int numero;
        for(i=0; i<=5;i++)
        {
            System.out.print("Ingrese un número: ");
            numero = scanner.nextInt();
            pila.push(numero);
        }

        System.out.println("Apilando los valores:");
        pila.imprimir();

        System.out.println("Desapilando elementos:");
        while (!pila.isEmpty()) {
            System.out.println("Elemento desapilado: " + pila.pop());
        }

        System.out.println("Impresion de la pila inversa:");
        pila.imprimir();
        
        System.out.println("Ejercicio 4");
        Calcular mult= new Calcular();
        int a; int b; int c;
        System.out.print("Ingrese A: ");
        a = scanner.nextInt();
        System.out.print("Ingrese B: ");
        b = scanner.nextInt();
        System.out.print("Ingrese exponente de B: ");
        c = scanner.nextInt();
        Resultados resultados = mult.calcular(a, b, c);
        System.out.println("Factorial de " + a + " es: " + resultados.factorial);
        System.out.println("Potencia de " + b + "^" + c + " es: " + resultados.potencia);

        int multiplicacion = resultados.multiplicar();
        System.out.println("Multiplicación de factorial y potencia es: " + multiplicacion);
    }
    
}
