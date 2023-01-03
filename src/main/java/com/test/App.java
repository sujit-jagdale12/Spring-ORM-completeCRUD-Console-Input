package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDao;
import com.entities.Student;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		StudentDao bean = (StudentDao) context.getBean("sdao", StudentDao.class);

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean isOpen = true;
		while (isOpen) {
			System.out.println("PRESS 1.Add Student");
			System.out.println("PRESS 2.Get Student");
			System.out.println("PRESS 3.Update Student");
			System.out.println("PRESS 4.Delete Student");
			System.out.println("PRESS 5.Get all Students");
			System.out.println("PRESS 6.exit");

			try {
				int choice = Integer.parseInt(reader.readLine());

				switch (choice) {
				case 1: {
					Student student = new Student();
					System.out.print("Enter your name: ");
					String name = reader.readLine();
					System.out.print("Enter your Email: ");
					String email = reader.readLine();
					System.out.print("Enter your Branch: ");
					String branch = reader.readLine();
					System.out.print("Enter your College: ");
					String college = reader.readLine();

					student = new Student(name, email, branch, college);
					int r = bean.addStudent(student);

					if (r > 0) {
						System.out.println(student.getStudentName() + "'s data added.\n");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~");
					} else {
						System.out.println("error!");
					}
					break;
				}
				case 2: {
					System.out.print("Select Id to get data: ");
					int id = Integer.parseInt(reader.readLine());
					Student student = bean.getStudent(id);
					if(student==null) {
						System.out.println("entered id is not present\n");
						break;
					}
					System.out.println("~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("Id: " + student.getStudentId());
					System.out.println("Name: " + student.getStudentName());
					System.out.println("Email: " + student.getStudentEmail());
					System.out.println("Branch: " + student.getBranch());
					System.out.println("College: " + student.getCollege());
					System.out.println("~~~~~~~~~~~~~~~~~~~~~");
					break;
				}
				case 3: {
					System.out.print("Enter Id to update: ");
					int id = Integer.parseInt(reader.readLine());
					Student student = bean.getStudent(id);
					if(student==null) {
						System.out.println("entered id is not present\n");
						break;
					}

					boolean c = true;
					while (c) {
						System.out.println("choice to update 1.name 2.email 3.branch 4.college 5.done update");
						int ch = Integer.parseInt(reader.readLine());
						if (ch == 1) {
							System.out.print("Enter your name: ");
							String name = reader.readLine();
							student.setStudentName(name);
						} else if (ch == 2) {
							System.out.print("Enter your Email: ");
							String email = reader.readLine();
							student.setStudentEmail(email);
						} else if (ch == 3) {
							System.out.print("Enter your Branch: ");
							String branch = reader.readLine();
							student.setBranch(branch);
						} else if (ch == 4) {
							System.out.print("Enter your College: ");
							String college = reader.readLine();
							student.setCollege(college);
						} else if (ch == 5) {
							c = false;
						} else {
							System.out.println("Enter correct following choice\n");
						}
					}
					bean.updateStudent(student);
					System.out.println("Updated....\n");

					break;
				}
				case 4: {
					System.out.print("Enter Id to delete: ");
					int id = Integer.parseInt(reader.readLine());
					bean.deleteStudent(id);
					System.out.println(id + " id deleted\n");
					break;
				}
				case 5: {
					List<Student> list = bean.getStudents();
					for (Student student : list) {
						System.out.println("~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("Id: " + student.getStudentId());
						System.out.println("Name: " + student.getStudentName());
						System.out.println("Email: " + student.getStudentEmail());
						System.out.println("Branch: " + student.getBranch());
						System.out.println("College: " + student.getCollege());
						System.out.println("~~~~~~~~~~~~~~~~~~~~~");
					}
					System.out.println();

					break;
				}
				case 6: {
					isOpen = false;
					break;
				}
				default:
					System.out.println("select following choice\n");
				}
			} catch (Exception e) {
				System.out.println("Invalid Input. try again..."+e.getMessage()+"\n");

			}

		}
		System.out.println("Thank you......visit again!");
	}

}
