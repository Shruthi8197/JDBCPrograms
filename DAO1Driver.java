package jdbc_maven;

import java.util.Scanner;

public class DAO1Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO1 dao1 = new DAO1();
		Person p=new Person();
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
				//Person p=new Person();
				p.setId(id);
				p.setName(name);
				p.setAddress(address);
				p.setPhone(phone);
				p.setPincode(pincode);
				String m = dao1.savePerson(p);
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
				
				p.setId(id1);
				p.setName(name1);
				p.setAddress(address1);
				p.setPhone(phone1);
				p.setPincode(pincode1);
				String a = dao1.updatePerson(p);
				System.out.println(a);
				break;
			case 3:
				System.out.println("Enter the id");
				int id2 = sc.nextInt();
				String n = dao1.deletePerson(id2);
				System.out.println(n);
				break;
			case 4:
				System.out.println("Enter the id");
				int id4 = sc.nextInt();
			
				Person b = dao1.getPerson(id4);
				System.out.println(b.getId());
				System.out.println(b.getName());
				System.out.println(b.getAddress());
				System.out.println(b.getPhone());
				System.out.println(b.getPincode());
				break;

			default:
				System.out.println("Thank you");

			}

		}

	}

}
