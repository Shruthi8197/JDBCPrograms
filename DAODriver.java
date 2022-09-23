package jdbc_maven;

import java.sql.ResultSet;
import java.util.Scanner;

public class DAODriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		boolean data = true;
		while (data) {
			System.out.println("Enter your choice");
			System.out.println("1.Save person");
			System.out.println("2.Update person");
			System.out.println("3.Delete person");
			System.out.println("4.Get person");

			int x = sc.nextInt();
			switch (x) {

			case 1:
				System.out.println("Enter the id");
				int id = sc.nextInt();
				System.out.println("Enter the name");
				String name = sc.next();
				System.out.println("Enter the address");
				String address = sc.next();
				System.out.println("Enter the phone number");
				long phone = sc.nextLong();
				System.out.println("Enter the pincode");
				int pincode = sc.nextInt();
				String m = dao.savePerson(id, name, address, phone, pincode);
				System.out.println(m);
				break;
			case 2:
				System.out.println("Enter the id");
				int id1 = sc.nextInt();
				System.out.println("Enter the name");
				String name1 = sc.next();
				System.out.println("Enter the address");
				String address1 = sc.next();
				System.out.println("Enter the phone number");
				long phone1 = sc.nextLong();
				System.out.println("Enter the pincode");
				int pincode1 = sc.nextInt();
				String a = dao.updatePerson(id1, name1, address1, phone1, pincode1);
				System.out.println(a);
				break;
			case 3:
				System.out.println("Enter the id");
				int id2 = sc.nextInt();
				String n = dao.deletePerson(id2);
				System.out.println(n);
				break;
			case 4:
				System.out.println("Enter the id");
				int id4 = sc.nextInt();
				ResultSet b = dao.getPerson(id4);
				System.out.println(b);
				break;

			default:
				System.out.println("Thank you");

			}

		}
	}
}
