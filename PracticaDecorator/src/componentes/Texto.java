package componentes;

/**
 * @author Oscar Salamanca
 *
 */

public abstract class Texto {
	
	String descripcion = "";
	
	public String getDescripcion() 
	{
		return descripcion;
	}

	public abstract int valor();

}
