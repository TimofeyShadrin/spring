package ru.tshadrin.teta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tshadrin.teta.domain.PersonsEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonsEntity, Long> {
}
