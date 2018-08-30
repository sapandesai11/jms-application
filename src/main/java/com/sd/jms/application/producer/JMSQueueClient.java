/**
 * 
 */
package com.sd.jms.application.producer;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;


/**
 * @author Sapan.Desai
 * @since 1.0.0
 *
 */
public class JMSQueueClient {
	static Logger logger = Logger.getLogger(JMSQueueClient.class.getName());
	public static void main(String[] args) throws JMSException {
		logger.log(Level.INFO, "Started creating connection.");
		Connection connection =null;
		try {
			ConnectionFactory conFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			connection = conFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue("customerQueue");
			MessageProducer producer = session.createProducer(queue);
			String task = "Task";
			for(int i=0; i<10; i++) {
				String payload = task + i;
				Message msg = session.createTextMessage(payload);
				logger.log(Level.INFO, "Payload {0}", payload);
				producer.send(msg);
			}
			producer.send(session.createTextMessage("END"));
            session.close();
		}finally{
			if(connection != null) {
				connection.close();
			}
		}
	}
}
