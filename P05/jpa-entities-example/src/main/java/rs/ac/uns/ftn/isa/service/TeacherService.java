package rs.ac.uns.ftn.isa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.isa.model.CourseList;
import rs.ac.uns.ftn.isa.model.CourseSet;
import rs.ac.uns.ftn.isa.model.TeacherList;
import rs.ac.uns.ftn.isa.model.TeacherSet;
import rs.ac.uns.ftn.isa.repository.TeacherListRepository;
import rs.ac.uns.ftn.isa.repository.TeacherSetRepository;

@Service
@Transactional
public class TeacherService {

	@Autowired
	private TeacherSetRepository teacherSetRepository;

	@Autowired
	private TeacherListRepository teacherListRepository;

	public void saveTeacherWithCoursesSet() throws InterruptedException {

		TeacherSet ts1 = new TeacherSet();
		ts1.setFirstName("Pera");
		ts1.setLastName("Peric");
		
		TeacherSet ts2 = new TeacherSet();
		ts2.setFirstName("Mika");
		ts2.setLastName("Mikic");
		
		CourseSet cs1 = new CourseSet();
		cs1.setName("Matematika");
		
		CourseSet cs2 = new CourseSet();
		cs2.setName("Fizika");
		
		ts1.addCourse(cs1);
		ts2.addCourse(cs1);
		ts1.addCourse(cs2);
		ts2.addCourse(cs2);
		
		teacherSetRepository.save(ts1);
		teacherSetRepository.saveAndFlush(ts2);
		//Brisanje kursa iz Seta
		System.out.println("-----------Brisanje kursa iz seta-----------");
		Thread.sleep(4000);
		ts1.removeCourse(cs2);
	}

	public void saveTeacherWithCoursesList() throws InterruptedException {

		TeacherList tl1 = new TeacherList();
		tl1.setFirstName("Pera");
		tl1.setLastName("Peric");
		
		TeacherList tl2 = new TeacherList();
		tl2.setFirstName("Mika");
		tl2.setLastName("Mikic");
		
		CourseList cl1 = new CourseList();
		cl1.setName("Matematika");
		
		CourseList cl2 = new CourseList();
		cl2.setName("Fizika");
		
		tl1.addCourse(cl1);
		tl2.addCourse(cl1);
		tl1.addCourse(cl2);
		tl2.addCourse(cl2);
		
		teacherListRepository.save(tl1);
		teacherListRepository.saveAndFlush(tl2);
		//Brisanje kursa iz Liste
		System.out.println("-----------Brisanje kursa iz liste-----------");
		Thread.sleep(4000);
		tl1.removeCourse(cl2);
	}

}
