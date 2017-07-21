package org.cyberpwn.fusion;

import org.cyberpwn.fusion.material.MaterialRegisterGroup;

public class RegistrarServer
{
	private MaterialRegisterGroup materialRegistry;
	
	public RegistrarServer()
	{
		Fusion.l(this, "Creating Registrar Groups");
		materialRegistry = new MaterialRegisterGroup();
	}
	
	public MaterialRegisterGroup getMaterialRegistry()
	{
		return materialRegistry;
	}
}
