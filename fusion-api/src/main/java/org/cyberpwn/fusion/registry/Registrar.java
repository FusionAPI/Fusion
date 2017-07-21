package org.cyberpwn.fusion.registry;

public interface Registrar<OBJECT, ID>
{
	public void beginRegistration() throws FusionRegistrationException;
	
	public void completeRegistration() throws FusionRegistrationException;
	
	public boolean isRegistering();
	
	public boolean isRegistered();
	
	public String getSource();
	
	public void registerObject(OBJECT o, ID i) throws FusionRegistrationException;
	
	public OBJECT getObjectByID(ID id) throws FusionRegistrationException;
	
	public ID getIDByObject(OBJECT object) throws FusionRegistrationException;
}
