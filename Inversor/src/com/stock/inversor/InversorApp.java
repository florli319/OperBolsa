package com.stock.inversor;

import java.util.*;
import com.stock.dto.*;
import com.stock.util.*;
public class InversorApp {
    private Inversor inversor;
    final Map<String, List<String>> params = new HashMap<>();
    
	public static void main(String[] args) {
	   if (args.length != 8){
		   System.out.println("Número de argumentos no válido");
		   System.exit(0);
	   }
	   InversorApp inversorApp = new InversorApp();
	   try{
		inversorApp.leerLineaComandos(args);
		inversorApp.iniciarInversor();
        String comando = null;
        inversorApp.imprimirMenu();
        
        do{
          comando = inversorApp.leerComando();
          inversorApp.ejecutarComando(comando);
          
        }while (!"Q".equalsIgnoreCase(comando));
		
	   }catch(Exception ex){
		   System.err.println(ex.getMessage());
	   }

	}
	
	
	public void leerLineaComandos(String[] args){
      List<String> options = null;
	  for (int i= 0; i < args.length; i++){
	    if(args[i].charAt(0)== '-'){
 	      options = new ArrayList<>();
		  params.put(args[i].substring(1), options);
	    }
		else if (options != null) {
		  options.add(args[i]);
	    }
		else {
		  return;
		}
	  }
	}
	
	private void iniciarInversor(){
		
      this.inversor = new Inversor(params.get("n").get(0),params.get("p").get(0),params.get("h").get(0),params.get("a").get(0));
      String sinversor = this.inversor.toString();
      System.out.println(sinversor);
    
	}
	
	 public void imprimirMenu(){
	   //System.out.println("Ingrese el comando a enviar a la bolsa ");
	   System.out.println("Para salir, presione \'Q\'");
	 }
	 
	 public String leerComando(){
	   String input = System.console().readLine();
	   return input;
	 }
 
	 public void ejecutarComando(String comando){
       String[] infoComando = comando.split(" ");
	   if ("compra".equalsIgnoreCase(infoComando[0]) || "venta".equalsIgnoreCase(infoComando[0]) || "nocompra".equalsIgnoreCase(infoComando[0]) || "noventa".equalsIgnoreCase(infoComando[0])){
		  if (infoComando.length != 4){
			   System.out.println("Comando no válido");
		  }
		  OrdenDTO orden = new OrdenDTO();
		  String operacion = infoComando[0];
		  String accion = infoComando[1];
		  int cantidad = Integer.parseInt(infoComando[2]);
		  int precio = Integer.parseInt(infoComando[3]);
		  orden.setOperacion(operacion);
		  orden.setAccion(accion);
		  orden.setCantidad(cantidad);
		  orden.setPrecio(precio);
		  orden.setInversor(inversor.getNombre());
		  orden.setHostCorredor(inversor.getHostCorredor());
		  orden.setPuertoCorredor(Integer.parseInt(inversor.getPuertoCorredor()));
		  XmlUtil.marshallObtjectToXml(orden, "C:\\OperBolsa\\logs\\file.xml");
	   }else if ("consulta".equalsIgnoreCase(infoComando[0])){
		  if (infoComando.length != 2){
			   System.out.println("Comando no válido");
		  }
		  ConsultaAccionDTO consulta = new ConsultaAccionDTO();
		  String operacion = infoComando[0];
		  String accion = infoComando[1];
		  consulta.setOperacion(operacion);
		  consulta.setAccion(accion);
		  consulta.setInversor(inversor.getNombre());
		  consulta.setHostCorredor(inversor.getHostCorredor());
		  consulta.setPuertoCorredor(Integer.parseInt(inversor.getPuertoCorredor()));
		  XmlUtil.marshallObtjectToXml(consulta, "C:\\OperBolsa\\logs\\file.xml");
	   } else if ("portafolio".equalsIgnoreCase(infoComando[0])){
		   if (infoComando.length != 1){
			   System.out.println("Comando no válido");

		  }
	   } else {
		   System.out.println("Comando no válido");
	   }
	   
	 }
}
