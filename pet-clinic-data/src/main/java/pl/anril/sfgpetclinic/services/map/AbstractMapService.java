package pl.anril.sfgpetclinic.services.map;

import pl.anril.sfgpetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService <T,ID> implements CrudService<T,ID>{
    protected Map<ID, T> map = new HashMap<>();
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save (ID id,T object) {
        map.put(id, object);
        return object;
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    public void delete(T object) {
        map.entrySet().removeIf(el->Objects.equals(el, object));
    }
}
