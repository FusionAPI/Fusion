package org.cyberpwn.fusion;

public class Fusion
{
	private static Fusion instance;
	private RegistrarServer registry;
	
	public Fusion()
	{
		instance = this;
		registry = new RegistrarServer();
	}
	
	public RegistrarServer getRegistry()
	{
		return registry;
	}
}
