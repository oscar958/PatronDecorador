package decoradores;
import componentes.Texto;

/**
 * @author Oscar Salamanca
 *
 */

public class Negrita extends AdicionalesDecorator{

	Texto texto;
	
	public Negrita(Texto texto)
	{
		this.texto=texto;	
	}
	
	@Override
	public String getDescripcion() {
		return texto.getDescripcion()+" , Texto en Negrita";
	}

	@Override
	public int valor() {
		return 1+texto.valor();
	}

}