package testtest.conparatorconparable;

public class People implements Comparable<People>{
	String name;  
    int age;  
    public People(String name, int age){  
        this.name = name;  
        this.age = age;  
    }      
    public String toString() {  
        return "ĞÕÃû£º"+name + " ÄêÁä£º" + age;  
    }
	@Override
	public int compareTo(People o) {
		if (o.age>this.age) {
			return -1;
		}
		if (o.age<this.age) {
			return 1;
		}
		return 0;
	}  

}
