package decoradores;
import componentes.Texto;

/**
 * @author Oscar Salamanca
 *
 */

public class ColorTexto extends AdicionalesDecorator{

	Texto texto;
	
	public ColorTexto(Texto texto)
	{
		this.texto=texto;
	}

	
	@Override
	public String getDescripcion() {
		
		return  texto.getDescripcion() + " Color del texto"; 
	}

	@Override
	public int valor() {
		return 1+texto.valor();
	}

}
