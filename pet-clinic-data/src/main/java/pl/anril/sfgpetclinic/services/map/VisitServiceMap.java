package pl.anril.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.anril.sfgpetclinic.model.Visit;
import pl.anril.sfgpetclinic.services.VisitService;

import java.util.Objects;

@Service
@Profile({"default", "map"})
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
