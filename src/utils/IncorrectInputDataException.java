package utils;

public class IncorrectInputDataException extends RuntimeException{

    public IncorrectInputDataException(int l, int h)
    {
        super("Неверное число вагонов. Правильный диапазон: от " + l +" до " + h);
    }
}
