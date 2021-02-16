package pl.anril.sfgpetclinic.services.map;

import pl.anril.sfgpetclinic.model.Visit;
import pl.anril.sfgpetclinic.services.VisitService;

import java.util.Objects;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Visit save(Visit visit) {
        if (Objects.isNull(visit.getPet()) || Objects.isNull(visit.getPet().getOwner())
            ||Objects.isNull(visit.getPet().getId()) || Objects.isNull(visit.getPet().getOwner().getId())) {
            throw new RuntimeException("Invalid visit");
        }

        return super.save(visit);
    }
}
