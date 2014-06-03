
package br.edu.ifpb.pod.dao;

import br.edu.ifpb.pod.Message;
import br.edu.ifpb.pod.connection.ConnectionDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author magdiel-bruno
 */

public class MessageDAO {

    public void persist(Message message) throws SQLException {
        String sql = "insert into message(id, messageContent, m_from, m_to) values(?,?,?,?)";
        Connection connection = ConnectionDataBase.getInstance().getConnection();

        List<String> msgs = new ArrayList<>();
        boolean equalsMessage = false;
        msgs = findMessages();

        for (String msg : msgs) {
            if (msg.equalsIgnoreCase(message.getMessageContent())) {
                equalsMessage = true;
                break;
            }
        }

        if (!equalsMessage) {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, MessageIdGenerator.generate());
                stmt.setString(2, message.getMessageContent());
                stmt.setString(3, message.getFrom());
                stmt.setString(4, message.getTo());
                stmt.execute();
            } finally {
                connection.close();
            }
        }
    }

    public List<String> findMessages() throws SQLException {
        List<String> messages = new ArrayList<>();
        String sql = "select messageContent from message";

        try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                messages.add(result.getString("messageContent"));
            }
        }
        return messages;
    }

    public List<Message> findMessagesFId() throws SQLException {
        List<Message> messages = new ArrayList<>();
        String sql = "select id, messageContent, m_from, m_to from message where fid is null";

        try (Connection connection = ConnectionDataBase.getInstance().getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Message m = new Message();
                m.setId(result.getString("id"));
                m.setMessageContent(result.getString("messageContent"));
                m.setFrom(result.getString("m_from"));
                m.setTo(result.getString("m_to"));
                messages.add(m);
            }
        }
        return messages;
    }

    public void updateFId(ArrayList<Message> messages) throws SQLException {
        String sql = "update message set fid=? where id=?";
        Connection connection = ConnectionDataBase.getInstance().getConnection();

        for (Message message : messages) {
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(2, message.getId());
                stmt.setString(1, message.getfId());
                stmt.execute();
            } finally {
                connection.close();
            }
        }
    }

}