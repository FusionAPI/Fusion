package org.cyberpwn.fusion.registry;

import java.util.List;

public interface RegistryGroup<OBJECT, ID>
{
	public Registrar<OBJECT, ID> getRegistrar(String source);
	
	public List<String> getRegistrarSources();
	
	public List<Registrar<OBJECT, ID>> getRegistrars();
	
	public void addRegistrar(Registrar<OBJECT, ID> registrar) throws FusionRegistrationException;
	
	public void beginRegistration() throws FusionRegistrationException;
	
	public void completeRegistration() throws FusionRegistrationException;
}
