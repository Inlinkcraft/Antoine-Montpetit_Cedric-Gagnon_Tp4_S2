package exception;

/**
 * 
 * @author Cedric Gagnon
 * @version printemps 2021
 *
 */
public class PiocheException extends RuntimeException
{
	/**
	 * Construit une exeption de base
	 */
	public PiocheException()
	{
		super();
	}

	/**
	 * Construit un exeption avec un message
	 * @param message - le message
	 */
	public PiocheException(String message)
	{
		super(message);
	}
}