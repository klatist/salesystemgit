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

    public HashMapInheritance(Validator<K> keyValidator, Validator<V> valueValidator)
    {
        this.keyValidator = keyValidator;
        this.valueValidator = valueValidator;
    }
    
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
