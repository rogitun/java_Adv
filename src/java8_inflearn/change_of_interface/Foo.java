package java8_inflearn.change_of_interface;

public interface Foo {
	void printName();

	default void printAge() {
		System.out.println("Age is ~~");
	}
}
