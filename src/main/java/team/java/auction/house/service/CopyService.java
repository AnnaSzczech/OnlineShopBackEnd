package team.java.auction.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.CopyEntity;
import team.java.auction.house.repository.CopyRepository;

import java.util.Optional;

@Service
public class CopyService {
    @Autowired
    private CopyRepository copyRepository;

    public Optional<CopyEntity> findCopyById(Long id) {
        return copyRepository.findById(id);
    }

    public void save(CopyEntity copy) {
        copyRepository.save(copy);
    }

    public void delete(CopyEntity copy) {
        copyRepository.delete(copy);
    }
}
