package se.kth.iv1350.task2;

import java.util.HashMap;
/**
 * This class is meant to adapt the <code>HashMap</code> class through composition by implementing
 * functionality that validates 
 */
public class HashMapComposition<K, V> {
    private HashMap <K, V> internalMap = new HashMap<>();
    private Validator<K> keyValidator;
    private Validator<V> valueValidator;

    public HashMapComposition(Validator<K> keyValidator, Validator<V> valueValidator){
        this.keyValidator = keyValidator;
        this.valueValidator = valueValidator;
    }

    public V put(K key, V value) throws IllegalArgumentException{
        if(!keyValidator.isValid(key))
        {
            throw new IllegalArgumentException("Invalid key: " + key + keyValidator.getErrorMessage());
        }

        if(!valueValidator.isValid(value))
        {
            throw new IllegalArgumentException("Invalid value " + valueValidator.getErrorMessage());
        }

        return internalMap.put(key, value);

    }

    public V get(K key){
        return internalMap.get(key);
    }

    
}
