package rs.ac.uns.ftn.isa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.isa.model.Address;
import rs.ac.uns.ftn.isa.model.Student;
import rs.ac.uns.ftn.isa.repository.AddressRepository;
import rs.ac.uns.ftn.isa.repository.StudentRepository;

@Service
@Transactional
public class AddressService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public void save() {

		Student student = studentRepository.findById(1).get();
		
		Address address = new Address();
		address.setStreet("Pera's street");
		address.setNumber("33A");

		// ovim ce se za id adrese postaviti isti id kao za studenta
        address.setStudent(student);

        addressRepository.save(address);
    }


    public Address getAddressByStudentId() {

        Student student = studentRepository.findById(1).get();

        return addressRepository.findById(student.getId()).get();
    }

}
