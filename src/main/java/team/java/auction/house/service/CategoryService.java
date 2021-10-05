package team.java.auction.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.CategoryEntity;
import team.java.auction.house.domain.ProducerEntity;
import team.java.auction.house.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<CategoryEntity> findAll(){ return categoryRepository.findAll(); }

    public Optional<CategoryEntity> findByName(String name) { return categoryRepository.findByName(name); }

    public void save(CategoryEntity category) {
        categoryRepository.save(category);
    }

    public void delete(CategoryEntity category) {
        categoryRepository.delete(category);
    }
}
