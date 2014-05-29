/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifpb.pod.dao;

/**
 *
 * @author magdiel-bruno
 */
public class MessageIdGenerator {
    
    public String generate(){
        return String.valueOf(System.currentTimeMillis()+Math.random());
    }
}
