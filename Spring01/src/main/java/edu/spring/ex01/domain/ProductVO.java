package edu.spring.ex01.domain;

public class ProductVO {
	private String name;
	private int price;
	
	public ProductVO() {
		System.out.println("�⺻ ������ ȣ��");
	}

	public ProductVO(String name, int price) {
		System.out.println("�Ű����� ������ ȣ��");
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + "]";
	}
	
	
}
