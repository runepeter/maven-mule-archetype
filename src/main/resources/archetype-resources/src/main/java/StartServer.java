package org.brylex.sandbox;

import org.mule.api.config.ConfigurationException;
import org.mule.api.config.ConfigurationBuilder;
import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.context.MuleContextFactory;
import org.mule.api.context.MuleContextBuilder;
import org.mule.context.DefaultMuleContextFactory;
import org.mule.config.spring.SpringXmlConfigurationBuilder;

public class StartServer {
	
	/**
	 * This class starts the Mule server using the mule-config.xml
	 * configuration file.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

        org.apache.log4j.BasicConfigurator.configure();

        MuleContext context = null;

        String [] resources = {"mule-config-spring.xml"};

        try {
            MuleContextFactory factory = new DefaultMuleContextFactory();
            ConfigurationBuilder builder = new SpringXmlConfigurationBuilder(resources);

            context = factory.createMuleContext(builder);
		} catch (ConfigurationException ce) {
			ce.printStackTrace();
		}
        catch (InitialisationException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try
        {
            context.start();
            System.out.println("Starting Mule instance.");
        }
        catch (MuleException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
