/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.timer;

import br.edu.ifpb.pod.FacadeService;
import br.edu.ifpb.pod.Message;
import br.edu.ifpb.pod.dao.MessageDAO;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magdiel-bruno
 */
public class Agendamento extends TimerTask{

    @Override
    public void run() {
        MessageDAO m = new MessageDAO();
        try {
            List<Message> messages = new ArrayList<Message>();
            messages = m.findMessagesFId();
            Registry registry = LocateRegistry.getRegistry("10.1.1.104", 10888);
            FacadeService service = (FacadeService)registry.lookup("FacadeServiceImp");
            List<Message> result = service.publish((ArrayList<Message>) messages);
            m.updateFId((ArrayList<Message>) result);
        } catch (SQLException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}