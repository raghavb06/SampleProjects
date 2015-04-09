package com.threetier.cluster;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.contrib.pattern.DistributedPubSubExtension;
import akka.contrib.pattern.DistributedPubSubMediator;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ClusterLauncher {
	
	public  static String SAMPLE_SESSION_USER_NAME = "password";
	public final static String APPLICATION ="DEMO";
	static String DEFAULT_PROVIDER_NAME="DEMO_SERVICE";

	static String requestFile = null;
    static  String [] policyFiles = null;
    private static ActorSystem system;
    private static ActorRef actorRef;
    private static ActorRef mediator=null;
	private static String systemName;
	@SuppressWarnings("unused")
	private static String configFile=null;
	@SuppressWarnings("unused")
	private static String port=null;
	private static Config config=null;
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws UnknownIdentifierException 
	 * @throws ParsingException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
			configFile="application";
			config = ConfigFactory.load();
			System.out.println(""+config);
			systemName=config.getString("akka.systemName");    	
			system=ActorSystem.create(systemName,config);
			actorRef=system.actorOf(Props.create(ClusterActor.class), "cluster");
			mediator =DistributedPubSubExtension.get(system).mediator();
			mediator.tell(new DistributedPubSubMediator.Put(actorRef),actorRef);
	}
	

}
