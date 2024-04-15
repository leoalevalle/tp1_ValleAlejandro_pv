package ar.edu.unju.fi.ejercicio11;

public class Main {

	public static void main(String[] args) {
		int i, j, numero=80;
		i=2;
		
		for(j=40; j>=0; j--) {
			
			if (numero>0)
				System.out.print(numero+" ");		
			i++;
			numero=numero+(j-i);
        }
    }
}