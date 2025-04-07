package com.app.nanny.infrastructure.repositories;

import com.app.nanny.infrastructure.entities.NannyCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaNannyCarRepository extends JpaRepository<NannyCarEntity,Long > {
}
