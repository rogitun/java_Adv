<h1> 인터페이스의 변화 </h1>

# Default Method

```aidl
public interface Foo {
	void printName();
	
}

public class DefaultFoo implements Foo {

	@Override
	public void printName() {

	}
}
```

특정 인터페이스를 구현해 사용중인 클래스가 있다고 가정해보자.

해당 인터페이스를 여러 클래스에서 구현해 사용중인 경우 인터페이스에 다른 메서드가 추가된다면?
모든 구현체에 오버라이딩하여 전부 구현해줘야 한다.

큰 번거로움이 될 수 있다.

이런 경우에 사용하는 것이 default 메서드이다.

```aidl
public interface Foo {
	void printName();

	default void printAge() {
		System.out.println("Age is ~~");
	}
}
```

메서드가 새로 추가됐지만 구현체에선 컴파일 에러가 발생하지 않는다.
대신 모두 동일한 printAge의 구현부를 사용하게 되는 것이다.
이게 마음에 들지 않는다면 오버라이드하여 구현해 사용하면 된다.

# Static Method

일반적인 static Method와 동일하게 사용하면 된다.
해당 타입 관련 헬퍼 또는 유틸리티 메서드를 제공할 때 인터페이스에 스태텍 메서드를 제공할 수 있다.





