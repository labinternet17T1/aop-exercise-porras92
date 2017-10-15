package cat.tecnocampus;

import cat.tecnocampus.domain.Classroom;
import cat.tecnocampus.controller.ControllerClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JdbcexerciseApplication implements CommandLineRunner{

	@Autowired
	ControllerClassRoom controllerDAO;

	public static void main(String[] args) {
		SpringApplication.run(JdbcexerciseApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		System.out.println("Find all:");
		controllerDAO.findAll().forEach(System.out::println);

		System.out.println("\n\nFind capacity larger than");
		controllerDAO.findCapacityLargerThan(50).forEach(System.out::println);

		System.out.println("\n\nFind capacity lower than");
		controllerDAO.findCapacityLowerThan(60).forEach(System.out::println);

		System.out.println("\n\nFind no plugs");
		controllerDAO.findWithNoPlugs().forEach(System.out::println);

		System.out.println("\n\nFind with plugs");
		controllerDAO.findWithPlugs().forEach(System.out::println);


		List<Classroom> classroomList = new ArrayList<>();
		classroomList.add(new Classroom.ClassroomBuilder()
				.name("Class1").capacity(10).orientation("sud").plugs(false).build());
		classroomList.add(new Classroom.ClassroomBuilder()
				.name("Class2").capacity(10).orientation("sud").plugs(false).build());
		controllerDAO.insertBatch(classroomList);

		controllerDAO.insert(new Classroom.ClassroomBuilder()
				.name("Class3").capacity(10).orientation("sud").plugs(false).build());

		System.out.println("Find all:");
		controllerDAO.findAll().forEach(System.out::println);

	}
}
