package ru.tshadrin.teta.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.tshadrin.teta.domain.CoursesEntity;
import ru.tshadrin.teta.repository.CustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import java.util.List;
@Repository
@Transactional(readOnly = true)
public class CustomRepositoryImpl implements CustomRepository {

    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<CoursesEntity> findCourseWithTitle(String title) {
        var tuples = manager.createNativeQuery(
                "SELECT * FROM courses",
                Tuple.class
        ).getResultList();

        return null;
    }
}
