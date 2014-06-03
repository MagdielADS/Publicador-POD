package br.edu.ifpb.pod.timer;

import br.edu.ifpb.pod.FacadeService;
import br.edu.ifpb.pod.Message;
import br.edu.ifpb.pod.dao.MessageDAO;
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
 * @author marciel
 */

public class Agendamento extends TimerTask {

    @Override
    public void run() {
        MessageDAO m = new MessageDAO();

        try {
            System.out.println("Verificando por mensagens...");
            List<Message> messages = new ArrayList<>();
            messages = m.findMessagesFId();
            Registry registry = LocateRegistry.getRegistry("192.168.10.7", 10888);
            FacadeService service = (FacadeService) registry.lookup("FacadeService");

            if (messages.size() >= 1) {
                List<Message> result = service.publish((ArrayList<Message>) messages);

                if (result != null) {
                    m.updateFId((ArrayList<Message>) result);
                }

            }

        } catch (SQLException | RemoteException | NotBoundException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}