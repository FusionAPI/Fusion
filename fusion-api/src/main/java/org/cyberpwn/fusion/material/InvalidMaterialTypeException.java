package org.cyberpwn.fusion.material;

import org.cyberpwn.fusion.FusionException;

public class InvalidMaterialTypeException extends FusionException
{
	private static final long serialVersionUID = -7354119315384737103L;
	
	public InvalidMaterialTypeException(String material)
	{
		super("Invalid Block Type: " + material + ". Fusion was unable to look up the material type.");
	}
	
}
