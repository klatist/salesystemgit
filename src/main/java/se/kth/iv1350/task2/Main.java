package se.kth.iv1350.task2;

import se.kth.iv1350.salesystem.view.ErrorMessageHandler;

public class Main 
{
    public static void main(String[] args)
    {
        Validator<String> stringValidator = ValidatorFactory.getValidator(String.class, 15);
        Validator<Integer> intValidator = ValidatorFactory.getValidator(Integer.class, 6);
        Validator<Object> notNullValidator = ValidatorFactory.getValidator(Object.class, null);

        System.out.println("---- Using inheritance ----");
        HashMapInheritance<Integer,String> hashMapInherit = new HashMapInheritance<>(intValidator, stringValidator);
        hashMapInherit.put(654321,  "Kalaspuffar");
        System.out.println("Added: 654321 " + hashMapInherit.get(654321));
        HashMapInheritance<Integer, Object> hashMapInheritNotNull = new HashMapInheritance<>(intValidator, notNullValidator);
        hashMapInheritNotNull.put(123, new Object());
        System.out.println("Added: 123, object");


        try 
        {
            hashMapInherit.put(11120, "Stockholms centralstation");
        } 
        catch (IllegalArgumentException exc) 
        {
            ErrorMessageHandler.getErrorMessageHandler().showErrorMessage(exc.getMessage());
        }
        
        try 
        {
            hashMapInherit.put(983745873, "Ostbågar");
        } 
        catch (IllegalArgumentException exc) 
        {
            
            ErrorMessageHandler.getErrorMessageHandler().showErrorMessage(exc.getMessage());
        }

        try
        {
            hashMapInheritNotNull.put(456, null);
        }
        catch(IllegalArgumentException exc)
        {
            ErrorMessageHandler.getErrorMessageHandler().showErrorMessage(exc.getMessage());
        }

        System.out.println();

        System.out.println("---- Using composition ----");
        HashMapComposition hashMapComposition = new HashMapComposition<>(intValidator, stringValidator);
        hashMapComposition.put(978348, "Hallonsaft");
        System.out.println("Added: 978348 " + hashMapComposition.get(978348));

        HashMapComposition hashMapCompositionNotNull = new HashMapComposition<>(intValidator, notNullValidator);
        hashMapCompositionNotNull.put(987, new Object());
        System.out.println("Added: 987, object");

        try
        {
            hashMapComposition.put(11120, "Stockholms centralstation");
        }
        catch(IllegalArgumentException exc)
        {
            ErrorMessageHandler.getErrorMessageHandler().showErrorMessage(exc.getMessage());
        }

        try 
        {
            hashMapInherit.put(983745873, "Ostbågar");
        } 
        catch (IllegalArgumentException exc) 
        {
            ErrorMessageHandler.getErrorMessageHandler().showErrorMessage(exc.getMessage());
        }

        try 
        {
            hashMapCompositionNotNull.put(987, null);
        } 
        catch (IllegalArgumentException exc) 
        {
            ErrorMessageHandler.getErrorMessageHandler().showErrorMessage(exc.getMessage());
        }

    }
    
}
