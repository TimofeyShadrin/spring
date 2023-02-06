package ru.tshadrin.teta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tshadrin.teta.domain.RolesEntity;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> {
}
