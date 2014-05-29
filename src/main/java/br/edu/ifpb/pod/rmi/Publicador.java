/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.rmi;

import br.edu.ifpb.pod.FacadeService;
import br.edu.ifpb.pod.Message;
import br.edu.ifpb.pod.Session;
import br.edu.ifpb.pod.dao.MessageDAO;
import br.edu.ifpb.pod.timer.Agendamento;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magdiel-bruno
 */
public class Publicador extends UnicastRemoteObject implements FacadeService{

    public Publicador() throws RemoteException{
        super();
    }
    
    @Override
    public Session login(String login, String password) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logout(Session sesion) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message sendMessage(Session session, Message message) throws RemoteException {
        MessageDAO m =  new MessageDAO();
        try {
            System.out.println("Tentando persistir");
            if(message != null){
                m.persist(message);
            }else{
                System.out.println("Messagem nula");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Publicador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
    @Override
    public ArrayList<Message> publish(ArrayList<Message> messages) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) throws AlreadyBoundException {
        Registry registry;
        Timer timer = new Timer();
        try {
            registry = LocateRegistry.createRegistry(10888);
            registry.bind("FacadeService", new Publicador());
        } catch (RemoteException ex) {
            Logger.getLogger(Publicador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Executando...");
        //timer.schedule(new Agendamento(), 0, 1000*60);
    }
}
