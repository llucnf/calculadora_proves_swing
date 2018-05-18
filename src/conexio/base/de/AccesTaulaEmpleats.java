package conexio.base.de;

import java.sql.*;
import java.util.*;

public class AccesTaulaEmpleats{
  class Empleat{
      public int id;
      public String name;
  }

  public static void main(String[] args){
    new AccesTaulaEmpleats();
  }

  public AccesTaulaEmpleats() {
    Connection conn = null;
    List llistaEmpleats = new ArrayList();

    // connect to the database
    conn = connectToDatabaseOrDie();

    // get the data
    populateListaEmpleats(conn, llistaEmpleats);
    
    // print the results
    printEmpleats(llistaEmpleats);
    printEmpleatAtzar(llistaEmpleats);
  }
  private void printEmpleatAtzar(List llistaEmpleats) {
      int id_empleat = (int) (Math.random() * llistaEmpleats.size());
      Empleat empleat_escollit=(Empleat) llistaEmpleats.get(id_empleat);
      System.out.println("L'empleat amb id escollit a l'atzar:"+id_empleat+" és: "+empleat_escollit.name);
  }
  private void printEmpleats(List llistadEmpleats)
  {
    Iterator it = llistadEmpleats.iterator();
    while (it.hasNext())
    {
      Empleat empleat = (Empleat)it.next();
      System.out.println("id: " + empleat.id + ", nom: " + empleat.name);
    }
  }

  private void populateListaEmpleats(Connection conn, List llistadEmpleats)
  {
    try 
    {
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT id, name as nom FROM hr_employee ORDER BY id");
      while ( rs.next() )
      {
        Empleat empleat = new Empleat();
        empleat.id        = rs.getInt    ("id");
        empleat.name   = rs.getString ("nom");
        llistadEmpleats.add(empleat);
      }
      rs.close();
      st.close();
    }
    catch (SQLException se) {
      System.err.println("S'ha produït un SQLException creant la llista d'empleats.");
      System.err.println(se.getMessage());
    }
  }

  private Connection connectToDatabaseOrDie()
  {
    Connection conn = null;
    try
    {
      Class.forName("org.postgresql.Driver");
      String url = "jdbc:postgresql://desenvolupament2.xaviersastre.cat:5432/practica_cide";
      conn = DriverManager.getConnection(url,"admin", "fritdematances");
     System.out.println("conectat a la base de dades");
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
      System.exit(1);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      System.exit(2);
    }
    return conn;
  }

}