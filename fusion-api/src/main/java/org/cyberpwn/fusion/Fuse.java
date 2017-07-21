package org.cyberpwn.fusion;

public interface Fuse
{
	public Fusion getFusion();
	
	public RegistrarServer getFusionRegistry();
	
	public void onBeginRegistration();
	
	public void onRegistrationComplete();
	
	public String getSourceName();
}
