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
        System.out.println("Added: 'Kalaspuffar', 654321");
        HashMapInheritance<Integer, Object> hashMapInheritNotNull = new HashMapInheritance<>(intValidator, notNullValidator);
        hashMapInheritNotNull.put(123, new Object());


        try 
        {
            hashMapInherit.put(11120, "Stockholms centralstation");
        } 
        catch (IllegalArgumentException exc) 
        {
            ErrorMessageHandler.getErrorMessageHandler().showErrorMessage("Could not put key-value pair");
        }
        
        try 
        {
            hashMapInherit.put(983745873, "Ostbågar");
        } 
        catch (IllegalArgumentException exc) 
        {
            ErrorMessageHandler.getErrorMessageHandler().showErrorMessage("Could not put key-value pair.");
        }

        try
        {
            hashMapInheritNotNull.put(456, null);
        }
        catch(IllegalArgumentException exc)
        {
            ErrorMessageHandler.getErrorMessageHandler().showErrorMessage("Could not put key-value pair");
        }


        System.out.println("---- Using composition ----");
        HashMapComposition hashMapComposition = new HashMapComposition<>(intValidator, stringValidator);
        hashMapComposition.put(978348, "Hallonsaft");
        System.out.println("Added: 978348" + hashMapComposition.get(978348));

        HashMapComposition hashMapCompositionNotNull = new HashMapComposition<>(intValidator, notNullValidator);
        hashMapCompositionNotNull.put(987, new Object());

        try
        {
            hashMapComposition.put(11120, "Stockholms centralstation");
        }
        catch(IllegalArgumentException exc)
        {
            ErrorMessageHandler.getErrorMessageHandler().showErrorMessage("Could not put key-value pair.");
        }

        try 
        {
            hashMapInherit.put(983745873, "Ostbågar");
        } 
        catch (IllegalArgumentException exc) 
        {
            ErrorMessageHandler.getErrorMessageHandler().showErrorMessage("Could not put key-value pair.");
        }

        try 
        {
            hashMapCompositionNotNull.put(987, null);
        } 
        catch (IllegalArgumentException exc) 
        {
            ErrorMessageHandler.getErrorMessageHandler().showErrorMessage("Could not put key-value pair.");
        }

    }
    
}
