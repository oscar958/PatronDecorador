package decoradores;
import componentes.Texto;

/**
 * @author Oscar Salamanca
 *
 */

public class TamañoTexto extends AdicionalesDecorator{

	Texto texto;
	
	public TamañoTexto(Texto texto)
	{
		this.texto=texto;	
	}
	
	@Override
	public String getDescripcion() {
		return texto.getDescripcion()+" , Tamaño del Texto";
	}

	@Override
	public int valor() {
		return 1+texto.valor();
	}

}