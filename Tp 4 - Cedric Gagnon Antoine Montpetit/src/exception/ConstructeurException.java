package exception;

/**
 * 
 * @author Cedric Gagnon
 * @version printemps 2021
 *
 */
public class ConstructeurException extends RuntimeException
{
	/**
	 * Construit une exeption de base
	 */
	public ConstructeurException()
	{
		super();
	}

	/**
	 * Construit un exeption avec un message
	 * @param message - le message
	 */
	public ConstructeurException(String message)
	{
		super(message);
	}
}
