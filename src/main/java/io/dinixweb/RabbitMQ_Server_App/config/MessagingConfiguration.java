package io.dinixweb.RabbitMQ_Server_App.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {

    public static  final String QUEUE = "dinix_queue";
    public static final String EXCHANGE = "dinix_exchange";
    public static final String ROUTINGKEY = "dinix_routingKey";


    public Queue queue(){
        return new Queue(QUEUE);
    }

    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY);
    }
}
