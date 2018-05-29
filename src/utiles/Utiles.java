package utiles;

import java.io.File;

public class Utiles {

	public static final String pathNumerosPedido = "./data/numeroUltimoPedido.data";
	public static final String pathArticulos = "./data/articulos/";
	public static final String pathClientes = "./data/clientes/";
	
	public static boolean comprobarExiste(String ruta){
		File archivo = new File(ruta);
		return archivo.exists();
	}
}
