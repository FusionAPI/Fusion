package org.cyberpwn.fusion.registry;

import java.util.HashMap;
import java.util.Map;

public class Registration<OBJECT, ID> implements Registrar<OBJECT, ID>
{
	private boolean registered;
	private boolean registering;
	private String source;
	private Map<OBJECT, ID> registers;
	private Map<OBJECT, ID> registerSet;
	
	public Registration(String source)
	{
		this.source = source;
		registered = false;
		registering = false;
		registers = null;
		registerSet = new HashMap<OBJECT, ID>();
	}
	
	public void beginRegistration() throws FusionRegistrationException
	{
		if(isRegistered())
		{
			throw new FusionRegistrationException("The registration is already registered");
		}
		
		if(isRegistering())
		{
			throw new FusionRegistrationException("The registration is already being registered");
		}
		
		registering = true;
	}
	
	public void completeRegistration() throws FusionRegistrationException
	{
		if(isRegistered())
		{
			throw new FusionRegistrationException("The registration is already registered");
		}
		
		if(!isRegistering())
		{
			throw new FusionRegistrationException("The registration cannot be completed before started.");
		}
		
		registering = false;
		registered = true;
	}
	
	public boolean isRegistering()
	{
		return registering;
	}
	
	public boolean isRegistered()
	{
		return registered;
	}
	
	public String getSource()
	{
		return source;
	}
	
	public void registerObject(OBJECT o, ID i) throws FusionRegistrationException
	{
		if(isRegistered())
		{
			throw new FusionRegistrationException("Registration is already registered");
		}
		
		if(!isRegistering())
		{
			throw new FusionRegistrationException("Registration is not registering");
		}
		
		if(registerSet.containsKey(o))
		{
			throw new FusionRegistrationException("Object " + o.toString() + " is already registered");
		}
		
		for(OBJECT j : registerSet.keySet())
		{
			if(registerSet.get(j).equals(i))
			{
				throw new FusionRegistrationException("ID " + i.toString() + " is already registered");
			}
		}
		
		registerSet.put(o, i);
	}
	
	public OBJECT getObjectByID(ID id) throws FusionRegistrationException
	{
		if(!isRegistered())
		{
			throw new FusionRegistrationException("Registration is not registered");
		}
		
		if(isRegistering())
		{
			throw new FusionRegistrationException("Registration is registering");
		}
		
		for(OBJECT i : registers.keySet())
		{
			if(registers.get(i).equals(id))
			{
				return i;
			}
		}
		
		return null;
	}
	
	public ID getIDByObject(OBJECT object) throws FusionRegistrationException
	{
		if(!isRegistered())
		{
			throw new FusionRegistrationException("Registration is not registered");
		}
		
		if(isRegistering())
		{
			throw new FusionRegistrationException("Registration is registering");
		}
		
		return registers.get(object);
	}
}
