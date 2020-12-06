/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Pelicula;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class AccesoDatosSQL implements AccesoDatos{
    
    public Connection getConnection() throws SQLException {
      String url = "jdbc:sqlite:./base de datos/Peliculas.sqlite";  
      Connection con = DriverManager.getConnection(url);
      return con;
      
    }
    

    @Override
    public boolean existe (String nombreTabla) throws AccesoDatosEx { 
        boolean hola = false;
        Connection con = null;
        Statement st = null;
        ResultSet ex = null;
        String tabla = " ";
        List<String> tablas = new ArrayList();
        String tableExists = "SELECT name FROM sqlite_master WHERE type IN ('table','view') AND name NOT LIKE 'sqlite_%' ORDER BY 1";   
      
        try {
           con = getConnection();      
           st = con.createStatement();
           ex = st.executeQuery(tableExists);
           while (ex.next()) {
                tabla = ex.getString("name");
                tablas.add(tabla);
           }
           
           for (String elem : tablas) {
              if (elem.equalsIgnoreCase(nombreTabla)) {
              hola = true;
              break;
            } 
              else hola = false;
          }
     
        } catch (SQLException sql) {
            System.out.println("Error de SQL en método EXISTE." + sql);
        }    
 
        finally { 
            try {
               if (con != null) con.close();
               if (st != null) st.close();
               if (ex != null) ex.close();
  
            } catch (SQLException sql) {
                System.out.println("Error en SQL en CLOSE." + sql);
            }    
        }
      return hola;      
    }

    @Override
    public List<Pelicula> listar(String nombreTabla) throws LecturaDatosEx {
     
        List<Pelicula> coucou = new ArrayList<>();
        String listaFinal = " ";
        
        String query = "SELECT * FROM " + "'" + nombreTabla + "'";
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;
        
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String peli = rs.getString("titulo");
                Pelicula objetoPeli = new Pelicula();
                objetoPeli.setNombre(peli);
                coucou.add(objetoPeli);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en método LISTAR." + ex);
        }
        
        for (Pelicula elem : coucou) {
            listaFinal = listaFinal.concat("\n" + " --> " + elem.getNombre());
        }
        
        if (listaFinal != " ") {
        System.out.println("Las películas en la tabla == " + nombreTabla + " == son: " + listaFinal);
        }
        else System.out.println("La tabla seleccionada no tiene películas cargadas aún.");
        
        return coucou;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreTabla, boolean anexar) throws EscrituraDatosEx {
        
        
        String query = "INSERT INTO " + "'" + nombreTabla + "'" + " VALUES " + "('" + pelicula.getNombre() + "');";
        Connection con = null;
        PreparedStatement pst = null;
        int rs = 0;
        
       
        try {
            con = getConnection();
            pst = con.prepareStatement(query);
            rs = pst.executeUpdate();
            System.out.println("Se agregó película --> " + pelicula.getNombre() + " <-- a la tabla --> " + nombreTabla +  " <--");
            
            
        } catch (SQLException sql) {
          System.out.println("Error de SQL en método escribir." + sql);
        }
    
    finally { 
        try {
           if (con != null) con.close();
           if (pst != null) pst.close();   
          
            
        } catch (SQLException sql) {
            System.out.println("Error en SQL en close." + sql);;
        }
      } 
   }
    

    @Override
    public String buscar(String nombreTabla, String buscar) throws LecturaDatosEx {
      
        String listaFinal = " ";
        
        String query = "SELECT * FROM " + "'" + nombreTabla + "'" + " WHERE titulo LIKE " + "'%" + buscar + "%' COLLATE NOCASE";
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;
        
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String peli = rs.getString("titulo");
                listaFinal += ("\n" + peli);
            }
                  
            
        } catch (SQLException ex) {
            System.out.println("Error en método BUSCAR." + ex);
        }
            
     finally { 
        try {
           if (con != null) con.close();
           if (st != null)  st.close();  
            
            
        } catch (SQLException sql) {
            System.out.println("Error en SQL en close." + sql);
        }
     }
      if (listaFinal != " ") {  
      System.out.println("Las películas que coinciden con su búsqueda en la tabla == " + nombreTabla + " == son: " + listaFinal);
      }
      else System.out.println("No hay películas que coincidan con su búsqueda en la tabla == " + nombreTabla + " ==");
      
      return listaFinal; 
    }

    @Override
    public void crear(String nombreTabla) throws AccesoDatosEx {
         String url = "jdbc:sqlite:./base de datos/Peliculas.sqlite";  
         Connection con = null;
         Statement st = null;
         
         
        try {
            con = DriverManager.getConnection(url);
            st = con.createStatement();
            String crearTabla = ("CREATE TABLE " + "'" + nombreTabla + "'" + "\n(titulo VARCHAR(200)" + "\n);"); 
            st.executeUpdate(crearTabla);
            
            System.out.println("Se ha creado la tabla --> " + nombreTabla + " <--");
       
            
        } catch (SQLException sql) {
            System.out.println("Error de SQL en método CREAR." +  sql);
            sql.printStackTrace();
        }
        
    finally { 
            try {
               if (con != null) con.close();
               if (st != null) st.close();
      

            } catch (SQLException sql) {
                System.out.println("Error en SQL en close" + sql);;
            }
        }    
        
       
    }

    @Override
    public void borrar(String nombreTabla) throws AccesoDatosEx {
       
    }
    
}
