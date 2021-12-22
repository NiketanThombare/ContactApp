package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.ContactForm;
import in.ashokit.entities.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String saveContact(ContactForm form) {

		Contact contact = new Contact();
		BeanUtils.copyProperties(form, contact);
        contact.setActiveSw("Y");
		contact = contactRepo.save(contact);
		
		if (contact.getContactId() != null) {
			return "SUCCESS";
		}

		return "FAILURE";
	}

	@Override
	public List<ContactForm> viewContacts() {
		List<ContactForm> formList = new ArrayList<>();

		List<Contact> contactList = contactRepo.findAll();

		for (Contact contact : contactList) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(contact, form);
			formList.add(form);
		}

		return formList;
	}

	@Override
	public ContactForm editContact(Integer contacId) 
	{
		Optional<Contact> optional = contactRepo.findById(contacId);
		if(optional.isPresent())
		{
			Contact contact = optional.get();
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(contact, form);
			return form;
			
		}
		
		return null;

	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) 
	{
		contactRepo.deleteById(contactId);
		
		List<Contact> contactList = contactRepo.findAll();
		List<ContactForm> formList= new ArrayList<>();
		
		for(Contact contact:contactList)
		{
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(contact, form);
			formList.add(form);
		}
		return formList;
	}

}
