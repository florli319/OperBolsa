/*  1:   */ package co.com.tigo.activacion.util;
/*  2:   */ 
/*  3:   */ import java.io.FileInputStream;
/*  4:   */ import java.io.IOException;
/*  5:   */ import java.io.InputStream;
/*  6:   */ import java.io.PrintStream;
/*  7:   */ import java.util.Enumeration;
/*  8:   */ import java.util.Properties;
/*  9:   */ 
/* 10:   */ public class PropertiesLoader
/* 11:   */ {
/* 12:   */   private static PropertiesLoader instance;
/* 13:   */   
/* 14:   */   public PropertiesLoader()
/* 15:   */   {
/* 16:12 */     load();
/* 17:   */   }
/* 18:   */   
/* 19:   */   public static PropertiesLoader getInstance()
/* 20:   */   {
/* 21:16 */     if (instance == null) {
/* 22:17 */       synchronized (PropertiesLoader.class)
/* 23:   */       {
/* 24:18 */         if (instance == null) {
/* 25:19 */           instance = new PropertiesLoader();
/* 26:   */         }
/* 27:   */       }
/* 28:   */     }
/* 29:21 */     return instance;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public Properties load()
/* 33:   */   {
/* 34:   */     try
/* 35:   */     {
/* 36:28 */       InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("WsClientPropertiesActivacion.properties");
/* 37:29 */       if (in == null) {
/* 38:30 */         properties.load(new FileInputStream("C:/TRABAJO/WorkSpaces/WsImeis/jboss-4.2.3.GA/server/default/conf/props/ImeiService.properties"));
/* 39:   */       } else {
/* 40:32 */         properties.load(in);
/* 41:   */       }
/* 42:   */     }
/* 43:   */     catch (IOException e)
/* 44:   */     {
/* 45:37 */       System.err.println("error cargando archivo de propiedades " + e.getMessage());
/* 46:38 */       e.printStackTrace();
/* 47:   */     }
/* 48:40 */     return properties;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public String getProperty(String prop)
/* 52:   */   {
/* 53:44 */     String value = "";
/* 54:   */     try
/* 55:   */     {
/* 56:46 */       value = properties.getProperty(prop);
/* 57:47 */       if (value == null) {
/* 58:48 */         System.err.println("ERROR propiedad NULA " + prop);
/* 59:   */       }
/* 60:   */     }
/* 61:   */     catch (Exception localException) {}
/* 62:54 */     return value;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public String getProperty(String prop, String vDefalult)
/* 66:   */   {
/* 67:59 */     String value = "";
/* 68:   */     try
/* 69:   */     {
/* 70:61 */       value = properties.getProperty(prop, vDefalult);
/* 71:   */     }
/* 72:   */     catch (Exception localException) {}
/* 73:68 */     return value;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public Enumeration<?> getPropertyNames()
/* 77:   */   {
/* 78:74 */     return properties.propertyNames();
/* 79:   */   }
/* 80:   */   
/* 81:78 */   private static Properties properties = new Properties();
/* 82:   */ }


/* Location:           C:\Users\lina.florez\Desktop\cierre masivo\jars\ClienteActivacionPosYControl.jar
 * Qualified Name:     co.com.tigo.activacion.util.PropertiesLoader
 * JD-Core Version:    0.7.0.1
 */