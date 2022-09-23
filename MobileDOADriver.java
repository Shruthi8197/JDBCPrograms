package jdbc_maven;

import java.util.Scanner;

public class MobileDOADriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MobileDAO dao = new MobileDAO();
		Mobile m=new Mobile();
		boolean data = true;
		while (data) {
			System.out.println("Enter your choice");
			System.out.println("1.Save Mobile");
			System.out.println("2.Update Mobile");
			System.out.println("3.Delete Mobile");
			System.out.println("4.Get Mobile");

			int x = sc.nextInt();
			switch (x) {

			case 1:
				System.out.println("Enter the id");
				int id = sc.nextInt();
				System.out.println("Enter the name");
				String name = sc.next();
				System.out.println("Enter the brand");
				String brand= sc.next();
				System.out.println("Enter the colour");
				String colour = sc.next();
				System.out.println("Enter the price");
				double price = sc.nextDouble();
				System.out.println("Enter the ram");
				int ram=sc.nextInt();
				System.out.println("Enter the manufacture");
				String manufacture=sc.next();
				
				m.setId(id);
				m.setName(name);
				m.setBrand(brand);
				m.setColour(colour);
				m.setPrice(price);
				m.setRam(ram);
				m.setManufacture(manufacture);
				String p = dao.saveMobile(m);
				System.out.println(p);
				break;
			case 2:
				System.out.println("Enter the id");
				int id1 = sc.nextInt();
				System.out.println("Enter the name");
				String name1 = sc.next();
				System.out.println("Enter the brand");
				String brand1= sc.next();
				System.out.println("Enter the colour");
				String colour1 = sc.next();
				System.out.println("Enter the price");
				double price1 = sc.nextDouble();
				System.out.println("Enter the ram");
				int ram1=sc.nextInt();
				System.out.println("Enter the manufacture");
				String manufacture1=sc.next();
				
				m.setId(id1);
				m.setName(name1);
				m.setBrand(brand1);
				m.setColour(colour1);
				m.setPrice(price1);
				m.setRam(ram1);
				m.setManufacture(manufacture1);
				
				String a = dao.updateMobile(m);
				System.out.println(a);
				break;
			case 3:
				System.out.println("Enter the id");
				int id2 = sc.nextInt();
				String n = dao.deleteMobile(id2);
				System.out.println(n);
				break;
			case 4:
				System.out.println("Enter the id");
				int id4 = sc.nextInt();
			
				Mobile b = dao.getMobile(id4);
				System.out.println(b.getId());
				System.out.println(b.getName());
				System.out.println(b.getBrand());
				System.out.println(b.getColour());
				System.out.println(b.getPrice());
				System.out.println(b.getRam());
				System.out.println(b.getManufacture());
				break;

			default:
				System.out.println("Thank you");

			}

		}


	}

}
