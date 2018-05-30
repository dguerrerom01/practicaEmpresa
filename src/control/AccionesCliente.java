package control;

import java.io.File;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JComboBox;

import modelo.Cliente;
import utiles.Utiles;

public class AccionesCliente<K> {

	public void insertarPedidosEnCombo(JComboBox combo, String cadena) {
		cadena=cadena.substring(cadena.lastIndexOf(" ")+1);
		if(Utiles.comprobarExiste("./data/pedidos/"+cadena)){
			File[] pedidos = new File("./data/pedidos/"+cadena).listFiles();
			for (int i = 0; i < pedidos.length; i++) {
				combo.addItem("Pedido " + pedidos[i].getName().replace(".ped", ""));
			}
		}else{
			//TODO mostrar en el panel de mensaje
			System.out.println("no tiene pedidos");
		}
	}
	
	public void insertarClientesEnCombo(JComboBox combo) {
		TreeMap indiceMap = new AlmacenIndice<>(Utiles.pathClientes).obtenerMap();
		if (!(indiceMap==null)) {
			Set keySet = indiceMap.keySet();
			for (Object object : keySet) {
				Cliente cliente=(Cliente) new AlmacenIndice<>(Utiles.pathClientes).leer((K)object);
				combo.addItem(cliente.getRazonSocial()+" "+cliente.getDniCif());
			}
		}

		
	}
}
