package team.java.auction.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.CategoryProducerEntity;
import team.java.auction.house.repository.CategoryProducerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryProducerService {
    @Autowired
    private CategoryProducerRepository categoryProducerRepository;

    public Optional<CategoryProducerEntity> findById(Long id) {
        return categoryProducerRepository.findById(id);
    }

    public List<CategoryProducerEntity> findAll() {
        return categoryProducerRepository.findAll();
    }

    public void save(CategoryProducerEntity categoryProducer) {
        categoryProducerRepository.save(categoryProducer);
    }

}
