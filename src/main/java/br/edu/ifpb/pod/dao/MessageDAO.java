/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.dao;

import br.edu.ifpb.pod.Message;
import br.edu.ifpb.pod.connection.ConnectionDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.resource.cci.ConnectionFactory;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author magdiel-bruno
 */
public class MessageDAO {
    public void persist(Message message) throws SQLException {
        String sql = "insert into message(id, messageContent, m_from, m_to) "
                + "values(?,?,?,?)";
        Connection connection = ConnectionDataBase.getInstance().getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, message.getId());
            stmt.setString(2, message.getMessageContent());
            stmt.setString(3, message.getFrom());
            stmt.setString(4, message.getTo());
            stmt.execute();
            stmt.close();
        } finally {
            connection.close();
        }
    }
}
