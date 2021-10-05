package team.java.auction.house.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.java.auction.house.domain.AddressEntity;
import team.java.auction.house.domain.ContactEntity;
import team.java.auction.house.domain.CustomerEntity;
import team.java.auction.house.dto.CustomerDTO;
import team.java.auction.house.dto.Response;
import team.java.auction.house.dto.TestDTO;
import team.java.auction.house.service.AddressService;
import team.java.auction.house.service.ContactService;
import team.java.auction.house.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/customer")
public class CustomerController extends BasicResponse {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ContactService contactService;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping
    public Response<CustomerDTO> createProduct(@RequestBody TestDTO test) {
        AddressEntity address = new AddressEntity();
        address.setCounty("Poland");
        address.setStreet("Sportowa");
        address.setTown(test.getCity());
        address.setZipcode("18-500");
        address.setStreetNumber("16");
//        addressService.save(address);


        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setEmail("email");
        contactEntity.setPhoneNumber1("777 777 777");
//        contactService.save(contactEntity);


        CustomerEntity customer = new CustomerEntity();
        customer.setAddressId(address);
        customer.setContactId(contactEntity);

        customer.setLogin(test.getLogin());
        customer.setMd5Password(test.getPassword());
        customer.setName(test.getName());
        customer.setSurname(test.getSurname());
        customer.setCustomerType("type");

        customerService.save(customer);

        return createOkResponse(modelMapper.map(customer, CustomerDTO.class));
    }

}