package chandresh.practice.programs.designPatterns;

import java.util.Date;

class BuilderPattern {

	private String name;
	private int age;
	private String address;
	private Date dob;

	private BuilderPattern(InnerBuilder inner) {
		this.name = inner.name;
		this.age = inner.age;
		this.address = inner.address;
		this.dob = inner.dob;
	}

	static class InnerBuilder {
		private String name;
		private int age;
		private String address;
		private Date dob;

		public InnerBuilder(String name,int age,Date dob) {
			this.name=name;
			this.age=age;
			this.dob=dob;
		}
		
		public InnerBuilder name(String name){
			this.name=name;
			return this;
		}
		public InnerBuilder age(int age){
			this.age=age;
			return this;
		}
		public InnerBuilder address(String address){
			this.address=address;
			return this;
		}
		public InnerBuilder dob(Date dob){
			this.dob=dob;
			return this;
		}
		
		public BuilderPattern build(){
			return new BuilderPattern(this);
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public Date getDob() {
		return dob;
	}
}

public class BuilderPatternTest {

	public static void main(String args[]) {
		BuilderPattern bp = new BuilderPattern.InnerBuilder("Bob", 21, new Date()).address("India").build();
		System.out.println(bp.getName());
	}

}
