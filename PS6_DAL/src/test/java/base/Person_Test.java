package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person_Test {
	private static PersonDAL personTest;	
	private static PersonDomainModel person1;
	private static PersonDomainModel person2;
	private static PersonDomainModel person3;
	private static PersonDomainModel person4;
	private static PersonDomainModel person5;
	private static UUID person1UUID = UUID.randomUUID();			
	private static UUID person2UUID = UUID.randomUUID();
	private static UUID person3UUID = UUID.randomUUID();
	private static UUID person4UUID = UUID.randomUUID();
	private static UUID person5UUID = UUID.randomUUID();
	
	@BeforeClass
	public static void personInstance() throws Exception{
		Date person1Birth = null;
		Date person2Birth = null;
		Date person3Birth = null;
		Date person4Birth = null;
		Date person5Birth = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		 person1 = new PersonDomainModel();
		 person2 = new PersonDomainModel();
		 person3 = new PersonDomainModel();
		 person4 = new PersonDomainModel();
		 person5 = new PersonDomainModel();
		 
		try {
			person1Birth = dateFormat.parse("1994-11-27");
			person2Birth = dateFormat.parse("1994-06-20");
			person3Birth = dateFormat.parse("1993-09-11");
			person4Birth = dateFormat.parse("1994-01-12");
			person5Birth = dateFormat.parse("1995-05-28");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		person1.setPersonID(person1UUID);
		person1.setFirstName("Mingkun");
		person1.setLastName("Chen");
		person1.setBirthday(person1Birth);
		person1.setCity("Elkton");
		person1.setStreet("702 Stone Gate Blvd");
		person1.setPostalCode(21921);
		
		person2.setPersonID(person2UUID);
		person2.setFirstName("Yuefei");
		person2.setLastName("Liu");
		person2.setBirthday(person2Birth);
		person2.setCity("New York");
		person2.setStreet("300 West 20th Street");
		person2.setPostalCode(10011);
		
		person3.setPersonID(person3UUID);
		person3.setFirstName("Longzhao");
		person3.setLastName("Hong");
		person3.setBirthday(person3Birth);
		person3.setCity("Elkton");
		person3.setStreet("2201 Stone Gate Blvd");
		person3.setPostalCode(21921);
		
		person4.setPersonID(person4UUID);
		person4.setFirstName("Jianbo");
		person4.setLastName("Pei");
		person4.setBirthday(person4Birth);
		person4.setCity("Newark");
		person4.setStreet("999 South College AVE");
		person4.setPostalCode(19711);
		
		person5.setPersonID(person5UUID);
		person5.setFirstName("Mengxi");
		person5.setLastName("Jiang");
		person5.setBirthday(person5Birth);
		person5.setCity("Elkton");
		person5.setStreet("702 Stone Gate Blvd");
		person5.setPostalCode(21921);
	}
	
	
	@Test
	public void personTest() {	
		personTest.addPerson(person1);
		personTest.addPerson(person2);
		personTest.addPerson(person3);
		personTest.addPerson(person4);
		personTest.addPerson(person5);
		personTest.deletePerson(person1UUID);
		
		person2.setFirstName("Huihui");
		personTest.updatePerson(person2);
		
		person3.setCity("Beijing");
		personTest.updatePerson(person3);
		
		person4.setFirstName("Bobo");
		person4.setCity("Yan Tai");
		personTest.updatePerson(person4);
		
		person5.setLastName("Mai");
		person5.setPostalCode(19712);
		personTest.updatePerson(person5);
	}

}
