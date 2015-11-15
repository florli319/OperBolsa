import java.util.ArrayList;
import java.util.List;

import com.stock.dto.OrdenDTO;
import com.stock.dto.TransaccionDTO;


public class BolsaEJB {

	

	/**
	 * Método que valida si la orden de compra que acaba de llegar puede
	 * ser efectiva, si es así se retorna la orden de Venta
	 */
	public OrdenDTO validarOrdenCompra(OrdenDTO ordenCompra){
		List<OrdenDTO> ordenesVenta = new ArrayList<OrdenDTO>();//TODO: consultar ordenes de venta
		
		for (OrdenDTO ordenVentaDTO : ordenesVenta) {
			if(ordenCompra.getEmpresa().equalsIgnoreCase(ordenVentaDTO.getEmpresa())
					&& ordenCompra.getValor() >= ordenVentaDTO.getValor()){
				return ordenVentaDTO;
			}
		}
		return null;
	}
	
	/**
	 * Método que valida si la orden de venta que acaba de llegar puede
	 * ser efectiva, si es así se retorna la orden de compra
	 */
	public OrdenDTO validarOrdenVenta(OrdenDTO ordenVenta){
		List<OrdenDTO> ordenesCompra = new ArrayList<OrdenDTO>();//TODO: consultar ordenes de compra
		
		for (OrdenDTO ordenCompraDTO : ordenesCompra) {
			if(ordenVenta.getEmpresa().equalsIgnoreCase(ordenCompraDTO.getEmpresa())
					&& ordenVenta.getValor() <= ordenCompraDTO.getValor()){
				return ordenCompraDTO;
			}
		}
		return null;
	}
	/**
	 * Método que recibe una orden de compra y realiza las operaciones correspondientes
	 * en caso de existir una transación de compra
	 * @param ordenCompra
	 */
	public void recibirOrdenCompra(OrdenDTO ordenCompra){
		OrdenDTO ordenVenta = this.validarOrdenCompra(ordenCompra);
		//Si existe una orden de venta se procede a hacer la actualización en base de datos
		if(ordenVenta != null){
			//Si la cantidad es la misma, la orden de venta debe eliminarse de bd
			if(ordenCompra.getCantidad() == ordenVenta.getCantidad()){
				//TODO: delete orden venta - Registrar transaccion
				TransaccionDTO transaccionDTO = new TransaccionDTO();
				transaccionDTO.setAccion(ordenCompra.getEmpresa());
//				transaccionDTO.setOrdenCompra(ordenCompra);
				//La transacción se registra con el valor de la orden de venta ya que es la que se encuentra
				//registrada con anterioridad
				transaccionDTO.setOrdenVenta(ordenVenta);
			}else{
				//Si no es así se actualizan los datos de la orden para que posteriormente
				//otra persona pueda comprar las acciones restantes
				ordenVenta.setCantidad(ordenVenta.getCantidad()-ordenCompra.getCantidad());
				//TODO: Actualizar orden venta
				TransaccionDTO transaccionDTO = new TransaccionDTO();
				transaccionDTO.setAccion(ordenCompra.getEmpresa());
//				transaccionDTO.setOrdenCompra(ordenCompra);
				//La transacción se registra con el valor de la orden de venta ya que es la que se encuentra
				//registrada con anterioridad
				transaccionDTO.setOrdenVenta(ordenVenta);
				transaccionDTO.setRemanente(ordenVenta.getCantidad());
			}
			
		}else{
			//Persistir orden de compra
		}
	}
	
	/**
	 * Método que recibe una orden de venta y realiza las operaciones correspondientes
	 * en caso de existir una transación de venta
	 * @param ordenVenta
	 */
	public void recibirOrdenVenta(OrdenDTO ordenVenta){
		OrdenDTO ordenCompra = this.validarOrdenVenta(ordenVenta);
		//Si existe una orden de compra se procede a hacer la actualización en base de datos
		if(ordenCompra != null){
			//Si la cantidad es la misma, la orden de venta debe eliminarse de bd
			if(ordenVenta.getCantidad() == ordenCompra.getCantidad()){
				//TODO: delete orden compra - Registrar transaccion
				TransaccionDTO transaccionDTO = new TransaccionDTO();
				transaccionDTO.setAccion(ordenCompra.getEmpresa());
				//La transacción se registra con el valor de la orden de compra ya que es la que se encuentra
				//registrada con anterioridad
				transaccionDTO.setOrdenCompra(ordenCompra);
			}else{
				//Si no es así se actualizan los datos de la orden para que posteriormente
				//otra persona pueda comprar las acciones restantes
				ordenCompra.setCantidad(ordenCompra.getCantidad()-ordenVenta.getCantidad());
				//TODO: Actualizar orden venta
				TransaccionDTO transaccionDTO = new TransaccionDTO();
				transaccionDTO.setAccion(ordenCompra.getEmpresa());
				//La transacción se registra con el valor de la orden de compra ya que es la que se encuentra
				//registrada con anterioridad
				transaccionDTO.setOrdenCompra(ordenCompra);
				transaccionDTO.setRemanente(ordenCompra.getCantidad());
			}
			
		}else{
			//Persistir orden de venta
		}
	}
}
