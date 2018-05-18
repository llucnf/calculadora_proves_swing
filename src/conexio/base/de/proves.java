/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexio.base.de;

/**
 *
 * @author alumne-DAM
 */
import java.util.*;
public class proves {
  

    
    static void ImprimirLG(List l){
        for(int a=0;a<l.size();a++)
        {
            System.out.println(l.get(a));
        }
        System.out.println("_______________");
    }
    
    public static void main(String[] args) {
      
        List llista1=new ArrayList();
        llista1.add("Hola");
        llista1.add(2);
        llista1.add(3);
        llista1.add("Tofol");
        llista1.add(false);
        ImprimirLG(llista1);
        llista1.remove(llista1.size()-1);
        ImprimirLG(llista1);
        llista1.remove(0);
        ImprimirLG(llista1);
        llista1.remove((Object) 2);
        ImprimirLG(llista1);
        llista1.add("Bunyol");
        llista1.add(3.1416);
        llista1.add("Java");
        ImprimirLG(llista1);
        System.out.println(llista1.get(3));
        System.out.println("_________________");
        System.out.println(llista1.indexOf("Java"));
        System.out.println("_________________");
        if(llista1.contains("Java")) System.out.println("La llista conté 'Java'");
        else System.out.println("No conté Java");
        System.out.println("_________________");
        llista1.remove("Java");
        if(llista1.contains("Java")) System.out.println("La llista conté 'Java'");
        else System.out.println("No conté Java");
        System.out.println("_________________");
        if(llista1.isEmpty()) System.out.println("La llista no conté dades");
        else System.out.println("La llista te dades");
        System.out.println("_________________");
        llista1.clear();
        if(llista1.isEmpty()) System.out.println("La llista no conté dades");
        else System.out.println("La llista te dades");
        System.out.println("_________________"); 
        llista1.add("Miquelet");
        llista1.add("Pauet beneitet");
        llista1.add("Pauet");
        llista1.add("Cheis");
        llista1.add("Predo predito");
        ImprimirLG(llista1);
        llista1.add(5,"Bacalla amb tomàtiga");
        Iterator it=llista1.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
    
}

  

