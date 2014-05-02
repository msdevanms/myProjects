package edu.am.bigdata.controller.resources;

import java.util.Date;

import org.apache.log4j.Logger;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
/**
 * @author devan
 * @date 02-May-2014
 * @mail devanms@am.amrita.edu
 * 
 */

public class LoadChecker extends ServerResource{

	static Logger log = Logger.getLogger(LoadChecker.class.getName());

	@Get 
	public Representation getData() {  
	Date date = new Date();		
	return new StringRepresentation(date.toString());
	}
	
	
	@Post
	public void postData() {  
		/*
		 * 
		 */
		
		}
		
	}  	