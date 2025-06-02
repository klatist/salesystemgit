package se.kth.iv1350.task2;

import java.util.HashMap;

/**
 * This class is meant to adapt the <code>HashMap</code> class through inheritance by implementing
 * functionality that validates the values of the key and value.
 */
public class HashMapInheritance<K, V> extends HashMap<K, V>
{
    private Validator<K> keyValidator;
    private Validator<V> valueValidator;

    /**
     * This constructor creates an instance of the <code>HashMapInheritance</code> class.
     * 
     * @param keyValidator  represents the validator for the keys in the <code>HashMap</code> which
     *                      determines the conditions of the key values.
     * @param valueValidator  represents the validator for the values in the <code>HashMap</code> which
     *                        determines the conditions of the values.
     */
    public HashMapInheritance(Validator<K> keyValidator, Validator<V> valueValidator)
    {
        this.keyValidator = keyValidator;
        this.valueValidator = valueValidator;
    }
    
    /**
     * This method adds a new key-value pair to the <code>HashMap</code> by first checking if the 
     * validators are valid.
     * 
     * @param key  represents the object that will be the key.
     * @param value  represents the object that will be the value.
     * @return  the old value that was associated with the key, or null if the key did not
     *          have any value associated with it before.
     * @throws IllegalArgumentException  if any of the values of the key-value pair is not valid according
     *                                   to the corresponding validators.
     */
    @Override
    public V put(K key, V value) throws IllegalArgumentException
    {
        if(!keyValidator.isValid(key))
        {
            throw new IllegalArgumentException("Invalid key " + key + " - " + keyValidator.getErrorMessage());

        }

        if(!valueValidator.isValid(value))
        {
            throw new IllegalArgumentException("Invalid value " + value + " - " + valueValidator.getErrorMessage());
        }

        return super.put(key, value);

    }
}
