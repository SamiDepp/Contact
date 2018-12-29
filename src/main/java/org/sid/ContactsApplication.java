package org.sid;

import org.sid.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner {

    @Autowired
    private ContactRepository   contactRepository;

    public static void main(String[] args) {
        SpringApplication.run(ContactsApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
       /* contactRepository.save(new Contact("dd","ds",dateFormat.parse("11/11/2000"),"dd@gmail.com",99));
        contactRepository.save(new Contact("ff","ds",dateFormat.parse("11/01/2000"),"ff@gmail.com",99));
*/        contactRepository.findAll().forEach(c-> {

            System.out.println(c.getNom());
                }


        );

    }
}
