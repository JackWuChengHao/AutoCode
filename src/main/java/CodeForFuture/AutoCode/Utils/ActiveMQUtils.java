package CodeForFuture.AutoCode.Utils;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import CodeForFuture.AutoCode.entity.IMessageProducerService;

@Service
public class ActiveMQUtils extends ActiveMQQueue implements IMessageProducerService{
	
	
//	@Autowired
//	private ActiveMQConnectionFactory connectionFactory;
	
	public ActiveMQUtils(String mqname){
		super(mqname);
	}
	
	@Override
	public void sendMessage(final String msg) {
		
//		System.out.println(connectionFactory);
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(); 
		connectionFactory.setBrokerURL("tcp://140.143.234.38:61616");
		connectionFactory.setUserName("admin");
		connectionFactory.setPassword("admin");
		System.out.println(connectionFactory);
		JmsMessagingTemplate jmsMessagingTemplate = new JmsMessagingTemplate(connectionFactory);
		
		System.out.println(jmsMessagingTemplate);
		jmsMessagingTemplate.convertAndSend(this, msg);
	}


}
