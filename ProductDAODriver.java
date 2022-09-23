package jdbc_maven;

import java.util.List;
import java.util.Scanner;

public class ProductDAODriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductDAO dao = new ProductDAO();
		Product pro=new Product();
		boolean data = true;
		while (data) {
			System.out.println("Enter your choice");
			System.out.println("1.Save Product");
			System.out.println("2.Update Product");
			System.out.println("3.Delete Product");
			System.out.println("4.Get Product");
			System.out.println("5.Get all product");

			int x = sc.nextInt();
			switch (x) {

			case 1:
				System.out.println("Enter the id");
				int id = sc.nextInt();
				System.out.println("Enter the name");
				String name = sc.next();
				System.out.println("Enter the price");
				double price = sc.nextDouble();
				System.out.println("Enter the manufacture");
				String manufacture = sc.next();
				System.out.println("Enter the Discount");
				int discount = sc.nextInt();
				System.out.println("Enter the warranty");
				int warranty=sc.nextInt();
				System.out.println("Enter the manufacture date");
				String date=sc.next();
				System.out.println("Enter the gst");
				int gst=sc.nextInt();
				
				pro.setId(id);
				pro.setName(name);
				pro.setPrice(price);
				pro.setManufacture(manufacture);
				pro.setDiscount(discount);
				pro.setWarranty(warranty);
				pro.setManu_date(date);
				pro.setGst(gst);
				Product p = dao.saveProduct(pro);
				System.out.println(p);
				break;
			case 2:
				System.out.println("Enter the id");
				int id1 = sc.nextInt();
				System.out.println("Enter the name");
				String name1 = sc.next();
				System.out.println("Enter the price");
				double price1 = sc.nextDouble();
				System.out.println("Enter the manufacture");
				String manufacture1 = sc.next();
				System.out.println("Enter the Discount");
				int discount1 = sc.nextInt();
				System.out.println("Enter the warranty");
				int warranty1=sc.nextInt();
				System.out.println("Enter the manufacture date");
				String date1=sc.next();
				System.out.println("Enter the gst");
				int gst1=sc.nextInt();
				
				pro.setId(id1);
				pro.setName(name1);
				pro.setPrice(price1);
				pro.setManufacture(manufacture1);
				pro.setDiscount(discount1);
				pro.setWarranty(warranty1);
				pro.setManu_date(date1);
				pro.setGst(gst1);
				Product m = dao.updateProduct(pro);
				System.out.println(m);
				break;
			case 3:
				System.out.println("Enter the id");
				int id2 = sc.nextInt();
				String n = dao.deleteProduct(id2);
				System.out.println(n);
				break;
			case 4:
				System.out.println("Enter the id");
				int id4 = sc.nextInt();
			
				Product b = dao.getProduct(id4);
				System.out.println(b.getId());
				System.out.println(b.getName());
				System.out.println(b.getPrice());
				System.out.println(b.getManufacture());
				System.out.println(b.getDiscount());
				System.out.println(b.getWarranty());
				System.out.println(b.getManu_date());
				System.out.println(b.getGst());
				break;
			case 5:
				
				List<Product> ls=dao.getAllProduct();
				System.out.println(ls);
				break;

			default:
				System.out.println("Thank you");

			}

		}



	}

}
