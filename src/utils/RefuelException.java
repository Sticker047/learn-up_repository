package utils;

public class RefuelException extends RuntimeException
{
    public RefuelException(float litres)
    {
        super("Неверное число литров: " + litres);
    }
}
