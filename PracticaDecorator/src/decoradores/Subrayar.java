package decoradores;
import componentes.Texto;


/**
 * @author Oscar Salamanca
 *
 */

public class Subrayar extends AdicionalesDecorator{

	Texto texto;
	
	public Subrayar(Texto texto)
	{
		this.texto=texto;	
	}
	
	@Override
	public String getDescripcion() {
		return texto.getDescripcion()+" , Texto Subrayado";
	}

	@Override
	public int valor() {
		return 1+texto.valor();
	}
}
