
package br.edu.ifpb.pod.dao;

/**
 *
 * @author marciel
 */

public class MessageIdGenerator {
    
    public static String generate(){
        return String.valueOf(System.currentTimeMillis()+Math.random());
    }
}
