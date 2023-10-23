package swagger.demo.controller;

import org.springframework.web.bind.annotation.*;
import swagger.demo.dto.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController

public class contactController {

    ConcurrentHashMap<String, Contact> contacts=new ConcurrentHashMap<String, Contact>();

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable String id){
        return contacts.get(id);
    }

    @GetMapping("/")
    public List<Contact> getAllContacts(){
        return new ArrayList<Contact>(contacts.values());

    }

    @PostMapping("/")
    public  Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(),contact);
        return contact;

    }
}
