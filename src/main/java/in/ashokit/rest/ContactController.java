package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.ContactForm;
import in.ashokit.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService contactService;
	
	@PostMapping(value = "/savecontact")
	public String saveContact(@RequestBody ContactForm form)
	{
		return contactService.saveContact(form);
	}
	
	@GetMapping(value = "/viewcontacts")
	public List<ContactForm> viewContacts()
	{
		return contactService.viewContacts();
	}
	
	@GetMapping(value = "/editcontact/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId)
	{
		return contactService.editContact(contactId);
	}
	
	@DeleteMapping(value = "/deletecontact/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId)
	{
		return contactService.deleteContact(contactId);
	}
	
    public void m1()
    {
    	
    }
}
