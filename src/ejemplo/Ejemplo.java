/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.util.LinkedList;

/**
 *
 * @author Freddie
 */
public class Ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SQLclass query = new SQLclass();
        String consulta = "select * from countries";
        LinkedList<String> resultado=query.query(consulta);
        for (int i = 0; i < resultado.size(); i++) {
            System.out.println(resultado.get(i));
        }
    }
    
}
