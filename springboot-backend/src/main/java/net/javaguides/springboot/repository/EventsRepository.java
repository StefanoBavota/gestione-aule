package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {
    List<Events> findAllByRoomsId(Long roomId);
}