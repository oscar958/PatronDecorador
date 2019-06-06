package decoradores;
import componentes.Texto;

/**
 * @author Oscar Salamanca
 *
 */

public class Tama�oTexto extends AdicionalesDecorator{

	Texto texto;
	
	public Tama�oTexto(Texto texto)
	{
		this.texto=texto;	
	}
	
	@Override
	public String getDescripcion() {
		return texto.getDescripcion()+" , Tama�o del Texto";
	}

	@Override
	public int valor() {
		return 1+texto.valor();
	}

}