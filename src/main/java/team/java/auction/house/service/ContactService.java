package team.java.auction.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.ContactEntity;
import team.java.auction.house.repository.ContactRepository;

import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Optional<ContactEntity> findContactById(Long id) {
        return contactRepository.findById(id);
    }

    public void save(ContactEntity contact) {
        contactRepository.save(contact);
    }
}