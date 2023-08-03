package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.model.Typologies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TypologiesService {

    public List<Typologies> getAllTypologies();

    Optional<Typologies> getTypologyById(Long idTypology);
}
