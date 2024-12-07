package example.bean;

public class Person {
		private String name;
		private int age;
		private float weight;
		
		public Person() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getName() {
			System.out.println("Getting name");
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			System.out.println("Getting age");
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public float getWeight() {
			System.out.println("Getting weight");
			return weight;
		}
		public void setWeight(float weight) {
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
		}
		
		
}
