/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.tests;

import br.edu.ifpb.pod.FacadeService;
import br.edu.ifpb.pod.Session;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magdiel-bruno
 */
public class TestConsumo {
    public static void main(String[] args) throws NotBoundException {
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry("10.1.1.102", 10888);
            FacadeService service = (FacadeService) registry.lookup("FacadeService");
            
            Session session  = service.login("fernan", "123456");
            System.out.println("Resultado: "+session.getId());
        } catch (RemoteException ex) {
            Logger.getLogger(TestConsumo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
