package se.kth.iv1350.task2;

public class StringValidator implements Validator<String>{
    private int maxLength;

    public StringValidator(int maxLength){
        this.maxLength = maxLength;
    }

    @Override
    public boolean isValid(String value){
        if(value == null)
            return false;

        return value.length() <= maxLength;
    }

    @Override
    public String getErrorMessage(){
        return "String cannot be null and string length must be at most" + maxLength + " characters.";
    }
    
}
