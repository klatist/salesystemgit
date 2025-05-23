package se.kth.iv1350.task2;

public class NotNullValidator<T> implements Validator<T>{

    @Override
    public boolean isValid(T obj){
        return obj != null;
    }

    @Override
    public String getErrorMessage(){
        return "Object cannot be null";
    }
    
}
