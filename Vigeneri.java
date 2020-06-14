public class Vigeneri{
	
  private final char []LETRAS = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
  private final char [][]MATRIZ = new char[][]{
  	{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
	{'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A'},
	{'C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B'},
	{'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C'},
	{'E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D'},
	{'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E'},
	{'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F'},
	{'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G'},
	{'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H'},
	{'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I'},
	{'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J'},
	{'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K'},
	{'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L'},
	{'N','O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M'},
	{'O','P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N'},
	{'P','Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O'},
	{'Q','R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'},
	{'R','S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'},
	{'S','T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R'},
	{'T','U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S'},
	{'U','V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T'},
	{'V','W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U'},
	{'W','X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V'},
	{'X','Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W'},
	{'Y','Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'},
	{'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'}
  };

  private String llave;
  private String mensaje;

  public Vigeneri(String llave, String mensaje){
	this.llave = llave.toUpperCase();
	this.mensaje = mensaje.toUpperCase();
  }

  public String codificar(){
  	char arregloLlave[] = this.llave.toCharArray();
  	char arregloMensaje[] = this.mensaje.toCharArray();
	char auxiliar[] = new char[ arregloMensaje.length ];
	int contador = 0;
	for (int indice = 0;indice < auxiliar.length; indice++) {
	  if(contador == arregloLlave.length) {
	  	contador = 0;
	  }
	  auxiliar[ indice ] = arregloLlave[ contador ];
	  contador++;
	}	
	int posicionMensaje = 0;
	int posicionAuxiliar = 0;
	String resultado = "";
	for (int i = 0; i < arregloMensaje.length; i++) {
	  posicionMensaje = posicionLetra(arregloMensaje[i]);
	  posicionAuxiliar = posicionLetra(auxiliar[i]);
	  resultado+= letra(posicionMensaje, posicionAuxiliar);
	}
	return resultado;
  }

  private int posicionLetra(char letra) {
     int indice = 0;
     while(letra != this.LETRAS[indice] && (indice < this.LETRAS.length)){
     	indice++;
     }
     return indice;
  }

  public String decodificar(){
    char arregloLlave[] = this.llave.toCharArray();
    char arregloMensaje[] = this.mensaje.toCharArray();
    char auxiliar[] = new char[ arregloMensaje.length ];
    int posicionAuxiliar = 0;
    String resultado = "";
    int columna = 0;
    int contador = 0;
    for (int indice = 0;indice < auxiliar.length; indice++) {
	if(contador == arregloLlave.length) {
	  contador = 0;
	}
	 auxiliar[ indice ] = arregloLlave[ contador ];
	 contador++;
    }

    int [] posiciones = posiciones(auxiliar);
    for(int i =0; i < posiciones.length; i++){
    	resultado+= buscar(posiciones[i], arregloMensaje[i]);
    }
    return resultado;
  }

  public int[] posiciones(char[] auxiliarLLave) {
    int []resultado = new int[auxiliarLLave.length];
    for(int i = 0; i< auxiliarLLave.length; i++) {
	resultado[i] = posicionLetra(auxiliarLLave[i]);
    }
    return resultado;
  }

  private char buscar(int fila, char letra){
  	char letra1 =' ';
	int contador = 0;
	while(letra != letra(fila, contador) && (contador < this.LETRAS.length)) {
	  contador++;
	}
	letra1 = this.LETRAS[contador];
	return letra1;
  }
  private char letra(int posicionMensaje, int posicionAuxiliar) {
  	return this.MATRIZ[ posicionMensaje ][ posicionAuxiliar ];
  }

  public static void main(String arg[]){
	String llave = "thisisalilkey"; // ingrese llave de encriptacion
	String mensaje = "llkjmlmpadkkc"; // ingrese mensaje a encriptar
	System.out.println("Mensaje: "+mensaje);
	System.out.println("Llave:   " +llave);
	Vigeneri vigeneri = new Vigeneri(llave, mensaje);
	String decodificar = vigeneri.decodificar();
	System.out.println("Decodificar: " + decodificar.toLowerCase());
	
  }


}
