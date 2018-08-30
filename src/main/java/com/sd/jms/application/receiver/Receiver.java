/**
 * 
 */
package com.sd.jms.application.receiver;

import java.util.logging.Level;
import java.util.logging.Logger;

/*import org.springframework.jms.annotation.JmsListener;*/
import org.springframework.stereotype.Component;

import com.sd.jms.application.domain.Email;

/**
 * @author Sapan.Desai
 *
 */
@Component
public class Receiver {
	
	Logger logger = Logger.getLogger(Receiver.class.getName());
	
	/*@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void receiveMessage(Email email) {
		logger.log(Level.INFO, "Received email which is intended to {0} .",email.getTo());
		
	}*/

}
