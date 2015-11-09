package co.com.tigo.activacion.util;

 import org.apache.log4j.Logger;

 public class Constants
{
   public static final String LOGGER_NAME = "LOG_CLIENTE_ACTIVACION_POSYCONTROL";
   public static Logger logger = Logger.getLogger("LOG_CLIENTE_ACTIVACION_POSYCONTROL");
   public static String NOMBRE_METODO_VALIDACION_CONTROL = "procesarActivacionControlValidar";
   public static String NOMBRE_METODO_ACTIVACION_CONTROL = "procesarActivacionControlActivar";
   public static String NOMBRE_METODO_VALIDACION_POST_PAGO = "procesarActivacionPospagoValidar";
   public static String NOMBRE_METODO_ACTIVACION_POST_PAGO = "procesarActivacionPospagoActivar";
   public static String URL_ACTIVACION = "http://10.69.32.37:8080/ActivacionesServiceEAR-ActivacionesServiceEJB/ServiceActivation?wsdl";
   public static String USER_ACTIVACION = "user";
  public static String PASSWORD_ACTIVACION = "password";
 }



/* Location:           C:\Users\lina.florez\Desktop\cierre masivo\jars\ClienteActivacionPosYControl.jar

 * Qualified Name:     co.com.tigo.activacion.util.Constants

 * JD-Core Version:    0.7.0.1

 */