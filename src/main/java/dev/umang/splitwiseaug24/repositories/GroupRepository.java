package dev.umang.splitwiseaug24.repositories;

import dev.umang.splitwiseaug24.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    @Override
    Optional<Group> findById(Long groupId);
}
