package eu.virtusdevelops.virtuscore.managers;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public abstract class Manager<K, V> {
    final JavaPlugin plugin;
    private final Map<K, V> map;

    /**
       * Initialize
       * @param plugin - Java plugin.
     **/
    public Manager(JavaPlugin plugin){
        this.plugin = plugin;
        this.map = new HashMap<>();
    }

    public Optional<V> getValue(K key) {
        for (Object k : map.keySet()) {
            if (k.toString().equalsIgnoreCase(key.toString()))
                return Optional.ofNullable(map.get(k));
        }
        return Optional.empty();
    }

    public void add(K key, V value) {
        map.put(key, value);
    }

    public V getValueUnsafe(K key) {
        return getValue(key).orElse(null);
    }

    public Collection<V> getValues() {
        return Collections.unmodifiableCollection(map.values());
    }

    public Collection<K> getKeys() {
        return Collections.unmodifiableCollection(map.keySet());
    }

    public void clear() {
        map.clear();
    }
}
