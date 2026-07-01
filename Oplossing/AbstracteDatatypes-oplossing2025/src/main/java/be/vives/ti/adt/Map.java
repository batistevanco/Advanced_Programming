package be.vives.ti.adt;

public interface Map<K, V>{

    int size();

    boolean isEmpty();

    /**
     * Retourneert de value v die hoort bij de key k. Als de entry niet bestaat wordt null geretourneerd.
     * @param key
     */
    V get(K key);

    /**
     * Wanneer de map nog geen entry met key k bevat dan wordt een entry (k,v) toegevoegd aan de map en wordt null geretourneerd
     * Wanneer de map wel al een entry met key k bevat dan wordt de bestaande value van de entry met key k overschreven met v,
     * waarna de vorige value wordt geretourneerd
     * @param key
     * @param value
     */
    V put(K key, V value);

    /**
     * Verwijdert de entry met de key gelijk aan k en retourneert de bijhorende value. Null wordt geretourneerd als er geen entry bestaat met key k.
     * @param key
     * @return de verwijderde waarde
     */
    V remove(K key);


}
