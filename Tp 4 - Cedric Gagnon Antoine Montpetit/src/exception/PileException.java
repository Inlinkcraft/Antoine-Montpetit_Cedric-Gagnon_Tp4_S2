package exception;

/**
 * 
 * @author Cedric Gagnon
 * @version printemps 2021
 *
 */
public class PileException extends RuntimeException
{
	/**
	 * Construit une exeption de base
	 */
	public PileException()
	{
		super();
	}

	/**
	 * Construit un exeption avec un message
	 * @param message - le message
	 */
	public PileException(String message)
	{
		super(message);
	}
}