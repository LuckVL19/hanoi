/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojuego;

/**
 *
 * @author eliel
 */
public class hanoi {
    
    class disco{
        public int size;
        
        public disco(int size) {
            this.size = size;
        }
        
        public int size() {
            return size;
        }

        @Override
        public String toString() {
            return "Disco[" + size + "]";
        }
    }
    
    class Nodo {
        disco disco;
        Nodo sig;

        public Nodo(disco disco) {
            this.disco = disco;
            this.sig = null;
        }
    }
    
    class torre {
        private Nodo L;
        
        public torre () {
            L = null;
        }
        
        
        public void agregar(disco disco) {
            Nodo nuevo = new Nodo(disco);
            if (L == null) {
                L = nuevo;
                L.sig = L;
            } else {
                Nodo aux = L;
                while (aux.sig != L) {
                    aux = aux.sig;
                }
                aux.sig = nuevo;
                nuevo.sig = L;
            }
        }
        
        public disco quitar() {
            if (L == null) {
                return null; // Torre vacía
            } else if (L.sig == L) { // Un solo elemento
                disco disco = L.disco;
                L = null;
                return disco;
            } else {
                Nodo aux = L;
                while (aux.sig != L) {
                    aux = aux.sig;
                }
                disco disco = L.disco;
                aux.sig = L.sig;
                L = L.sig;
                return disco;
            }
        }
        
        
        public void mostrar() {
            if (L == null) {
                System.out.println("Torre vacía");
                return;
            }
            Nodo temp = L;
            do {
                System.out.print(temp.disco + " - ");
                temp = temp.sig;
            } while (temp != L);
                System.out.println();
        }
        
        public disco verPrimerDisco() {
            return (L != null) ? L.disco : null;
        }
        
        public boolean torreEstaOrdenada(torre torre) {
            if (torre.L == null) {
                return false;
            }
    
            Nodo actual = torre.L;
            do {
                if (actual.sig != torre.L && actual.disco.size() > actual.sig.disco.size()) {
                    return false;
                }
                actual = actual.sig;
            } while (actual != torre.L);
    
            return true;
        }
    }
}
