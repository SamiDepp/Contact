package org.sid.service;

import org.sid.repository.ContactRepository;
import org.sid.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public Contact getContact(@PathVariable Long id){
        return contactRepository.findOne(id);
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public Contact addContact(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
    public Contact update(@PathVariable Long id, @RequestBody Contact contact){
        contact.setId(id);
        return contactRepository.save(contact);
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable Long id){
        contactRepository.delete(id);
        return true;
    }


    @RequestMapping(value = "/chercherContact", method = RequestMethod.GET)
    public Page<Contact> chercher(
            @RequestParam(name="mc",defaultValue="") String mc,
            @RequestParam(name="page",defaultValue="0")int page,
            @RequestParam(name="size",defaultValue="5")int size) {
        return contactRepository.chercher('%'+mc+'%', new PageRequest(page,size));


    }
}
