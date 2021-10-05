package team.java.auction.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.ProducerEntity;
import team.java.auction.house.repository.CopyRepository;
import team.java.auction.house.repository.ProducerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProducerService {
    @Autowired
    private ProducerRepository producerRepository;

    public Optional<ProducerEntity> findById(Long id) {
        return producerRepository.findById(id);
    }

    public List<ProducerEntity> findAll(){ return producerRepository.findAll(); }

    public Optional<ProducerEntity> findByName(String name) { return producerRepository.findByName(name); }

    public void save(ProducerEntity producer) {
        producerRepository.save(producer);
    }

    public void delete(ProducerEntity producer) {
        producerRepository.delete(producer);
    }
}
