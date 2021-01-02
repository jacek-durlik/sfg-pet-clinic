package pl.anril.sfgpetclinic.services.map;

import pl.anril.sfgpetclinic.model.BaseEntity;
import pl.anril.sfgpetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService <T extends BaseEntity,ID extends Long> implements CrudService<T,ID>{
    protected Map<Long, T> map = new HashMap<>();
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save (T object) {
        if (Objects.nonNull(object) && Objects.isNull(object.getId())) {
            object.setId(getNextId());
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    public void delete(T object) {
        map.entrySet().removeIf(el->Objects.equals(el, object));
    }

    private Long getNextId() {
        return map.keySet().stream().max((e1,e2)->Long.compare(e1, e2)).orElse(0L) + 1;
    }
}
