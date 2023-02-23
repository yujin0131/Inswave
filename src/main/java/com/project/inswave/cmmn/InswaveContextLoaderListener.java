package com.project.inswave.cmmn;

import javax.servlet.ServletContextEvent;

import com.inswave.elfw.core.ElContextLoaderListener;
import com.inswave.elfw.log.AppLog;

public class InswaveContextLoaderListener extends ElContextLoaderListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
	    super.contextInitialized(event);
	    
	    AppLog.debug("InswaveContextLoaderListener - contextInitialized ...");    	   
		
	}
	 
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		
		AppLog.debug("InswaveContextLoaderListener - contextDestroyed ...");    	   
				
	}	
}
