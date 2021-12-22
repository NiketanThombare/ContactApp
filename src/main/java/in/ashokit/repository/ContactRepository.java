package in.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
