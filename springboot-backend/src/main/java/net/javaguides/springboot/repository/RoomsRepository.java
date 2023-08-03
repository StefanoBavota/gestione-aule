package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Long> {
    List<Rooms> findAllByGroupsId(Long groupId);
}