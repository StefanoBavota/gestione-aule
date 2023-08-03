package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.AssetsRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRoomRepository extends JpaRepository<AssetsRoom, Long> {
}