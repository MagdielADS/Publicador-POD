/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.tests;

import br.edu.ifpb.pod.Message;
import br.edu.ifpb.pod.dao.MessageDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magdiel-bruno
 */
public class TestPersistence {
    public static void main(String[] args) {
        MessageDAO m = new MessageDAO();
        Message mens = new Message();
        mens.setId("002");
        mens.setMessageContent("Olá Marciel");
        mens.setFrom("Antoin");
        mens.setTo("Filipe");
        try {
            m.persist(mens);
        } catch (SQLException ex) {
            Logger.getLogger(TestPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
