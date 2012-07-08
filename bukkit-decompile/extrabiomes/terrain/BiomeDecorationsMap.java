package extrabiomes.terrain;

import java.lang.instrument.UnmodifiableClassException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.ModLoader;

public class BiomeDecorationsMap implements Map
{
    private Map map = new HashMap();

    public static BiomeDecorationsMap newInstance()
    {
        return new BiomeDecorationsMap();
    }

    public void clear()
    {
        this.map.clear();
    }

    public boolean containsKey(Object var1)
    {
        return this.map.containsKey(var1);
    }

    public boolean containsValue(Object var1)
    {
        return this.map.containsValue(var1);
    }

    public Set entrySet()
    {
        return Collections.unmodifiableSet(this.map.entrySet());
    }

    public Collection get(Object var1)
    {
        if (var1 == null)
        {
            return Collections.emptySet();
        }
        else
        {
            Object var2 = (Collection)this.map.get(var1);

            if (var2 == null)
            {
                if (!(var1 instanceof BiomeBase))
                {
                    return Collections.emptySet();
                }

                var2 = new ArrayList();
                this.map.put((BiomeBase)var1, var2);
            }

            return (Collection)var2;
        }
    }

    public boolean isEmpty()
    {
        return this.map.isEmpty();
    }

    public Set keySet()
    {
        return Collections.unmodifiableSet(this.map.keySet());
    }

    public Collection put(BiomeBase var1, Collection var2)
    {
        ModLoader.throwException("BiomeDecorationsMap is not modifiable.", new UnmodifiableClassException());
        return Collections.emptySet();
    }

    public void putAll(Map var1)
    {
        ModLoader.throwException("BiomeDecorationsMap is not modifiable.", new UnmodifiableClassException());
    }

    public Collection remove(Object var1)
    {
        ModLoader.throwException("BiomeDecorationsMap is not modifiable.", new UnmodifiableClassException());
        return Collections.emptySet();
    }

    public int size()
    {
        return this.map.size();
    }

    public Collection values()
    {
        return Collections.unmodifiableCollection(this.map.values());
    }

    public Object remove(Object var1)
    {
        return this.remove(var1);
    }

    public Object put(Object var1, Object var2)
    {
        return this.put((BiomeBase)var1, (Collection)var2);
    }

    public Object get(Object var1)
    {
        return this.get(var1);
    }
}
