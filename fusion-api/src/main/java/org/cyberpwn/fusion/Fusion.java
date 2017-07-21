package org.cyberpwn.fusion;

import java.util.ArrayList;
import java.util.List;
import org.cyberpwn.fusion.material.MaterialRegistrar;
import org.cyberpwn.fusion.registry.FusionRegistrationException;

public class Fusion
{
	private static Fusion instance;
	private RegistrarServer registry;
	private List<Fuse> fuses;
	
	public Fusion()
	{
		instance = this;
		fuses = new ArrayList<Fuse>();
		registry = new RegistrarServer();
		beginRegistration();
	}
	
	public static Fusion instance()
	{
		return instance;
	}
	
	public static void l(Object c, String s)
	{
		System.out.println("[FUSION]: " + c.getClass().getName() + ": " + s);
	}
	
	private void beginRegistration()
	{
		Fusion.l(this, "BEGIN REGISTRATION");
		
		for(Fuse i : fuses)
		{
			try
			{
				handleRegistrationFor(i);
			}
			
			catch(FusionRegistrationException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void handleRegistrationFor(Fuse f) throws FusionRegistrationException
	{
		Fusion.l(this, "REGISTER " + f.getClass().getSimpleName());
		getRegistry().getMaterialRegistry().addRegistrar(new MaterialRegistrar(f.getSourceName()));
		// Initialize other registries
		Fusion.l(this, "Calling onBeginRegistration to fuses");
		f.onBeginRegistration();
		// Compact and handle
		Fusion.l(this, "Calling onRegistrationComplete to fuses");
		f.onRegistrationComplete();
		Fusion.l(this, "Registration Complete");
	}
	
	public void registerFuse(Fuse f) throws FusionRegistrationException
	{
		Fusion.l(this, "Registering Fuse: " + f.getClass().getName());
		
		for(Fuse i : fuses)
		{
			if(i.getSourceName().equals(f.getSourceName()))
			{
				throw new FusionRegistrationException("Fuse " + f.getSourceName() + " already registered");
			}
		}
		
		Fusion.l(this, "Registered Fuse: " + f.getClass().getName());
		fuses.add(f);
	}
	
	public RegistrarServer getRegistry()
	{
		return registry;
	}
}
