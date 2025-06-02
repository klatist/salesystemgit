package se.kth.iv1350.task2;

import java.util.HashMap;
/**
 * This class is meant to adapt the <code>HashMap</code> class through composition by implementing
 * functionality that validates the values of the key and value.
 */
public class HashMapComposition<K, V> {
    private HashMap <K, V> internalMap = new HashMap<>();
    private Validator<K> keyValidator;
    private Validator<V> valueValidator;

    /**
     * This constructor creates an instance of the <code>HashMapComposition</code> class.
     * 
     * @param keyValidator  represents the validator for the keys in the <code>HashMap</code> 
     *                      which determines the conditions of the key values.
     * @param valueValidator  represents the validator for the values in the <code>HashMap</code> 
     *                        which determines the conditions of the values.
     */
    public HashMapComposition(Validator<K> keyValidator, Validator<V> valueValidator){
        this.keyValidator = keyValidator;
        this.valueValidator = valueValidator;
    }


    /**
     * This method adds a new key-value pair to the <code>HashMap</code> by first 
     * checking if the validators are valid.
     * @param key  represents the object that will be the key.
     * @param value  represents the object that will be the value.
     * @return  the old value that was associated with the key, or null if the key did not have any
     *          value associated with it before.
     * @throws IllegalArgumentException if any of the values of the key-value pair is not valid according
     *                                  to the corresponding validators.
     */
    public V put(K key, V value) throws IllegalArgumentException{
        if(!keyValidator.isValid(key))
        {
            throw new IllegalArgumentException("Invalid key " + key + " - " + keyValidator.getErrorMessage());
        }

        if(!valueValidator.isValid(value))
        {
            throw new IllegalArgumentException("Invalid value " + value + " - " + valueValidator.getErrorMessage());
        }

        return internalMap.put(key, value);

    }

    /**
     * Gives access to the value associated with the key.
     * @param key represents the key in the <code>HashMap</code>
     * @return the value object or null if there is no associated value with the key.
     */
    public V get(K key){
        return internalMap.get(key);
    }

    
}
