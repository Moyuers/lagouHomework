package Homework401;

/**
 * 自定义ID异常类
 */

public class IDException extends Exception{
    static final long serialVersionUID = -3387516993124229948L;
    public IDException() {
    }

    public IDException(String message) {
        super(message);
    }
}
