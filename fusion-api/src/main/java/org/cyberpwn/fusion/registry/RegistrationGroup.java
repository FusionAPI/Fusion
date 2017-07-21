package org.cyberpwn.fusion.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.cyberpwn.fusion.Fusion;

public class RegistrationGroup<OBJECT, ID> implements RegistryGroup<OBJECT, ID>
{
	private Map<String, Registrar<OBJECT, ID>> registrars;
	
	public RegistrationGroup()
	{
		Fusion.l(this, "Creating " + getClass().getSimpleName() + " Registrar group");
		registrars = new HashMap<String, Registrar<OBJECT, ID>>();
	}
	
	public Registrar<OBJECT, ID> getRegistrar(String source)
	{
		return registrars.get(source);
	}
	
	public List<String> getRegistrarSources()
	{
		return new ArrayList<String>(registrars.keySet());
	}
	
	public List<Registrar<OBJECT, ID>> getRegistrars()
	{
		List<Registrar<OBJECT, ID>> reg = new ArrayList<Registrar<OBJECT, ID>>();
		
		for(String i : getRegistrarSources())
		{
			reg.add(getRegistrar(i));
		}
		
		return reg;
	}
	
	public void addRegistrar(Registrar<OBJECT, ID> registrar) throws FusionRegistrationException
	{
		Fusion.l(this, "Adding Registrar " + registrar.getSource() + " to group");
		if(getRegistrarSources().contains(registrar.getSource()))
		{
			throw new FusionRegistrationException("Registrar " + registrar.getSource() + " already exists");
		}
		
		registrars.put(registrar.getSource(), registrar);
	}
	
	public void beginRegistration() throws FusionRegistrationException
	{
		for(String i : getRegistrarSources())
		{
			getRegistrar(i).beginRegistration();
		}
	}
	
	public void completeRegistration() throws FusionRegistrationException
	{
		for(String i : getRegistrarSources())
		{
			getRegistrar(i).completeRegistration();
		}
	}
}
