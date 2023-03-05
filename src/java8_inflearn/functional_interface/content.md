자바8

자바8?
2014년 출시

함수형 인터페이스??

인터페이스에 추상메서드가 하나만 있으면
함수형 인터페이스이다.

자바 8 부터는
static, default
메서드 등을 인터페이스에 추가할 수 있다.

함수형 프로그래밍?

1. 함수를 first class object로 만들어서 사용할 수 있다.
2. 순수 함수의 성질

- 사이드 이펙트를 만들 수 없다.(동일 인풋 - 동일 아웃풋)
- 상태가 없다.

3. 고차 함수 : 함수가 함수를 매개변수로 받고 함수를 리턴할 수 있다.

```
@FunctionalInterface -> 어노테이션을 붙여서 관리할 수 있다.
public interface RunSomething {

	void doIt();
}

```

```aidl
RunSomething runSomething = () -> {
	System.out.println("HIHI");
	System.out.println("HELLO~~");
};
runSomething.doIt();
```

- 함수영 인터페이스 RunSomething에는 doit 메서드가 정의되어있다.
- doIt의 정의를 람다식으로 만들어 사용한다.

# 자바에서 제공하는 기본 함수형 인터페이스

- java.lang.function 패키지에 존재한다.

1. Function 인터페이스

제너릭으로 <T,R>을 받는다.
T타입의 객체를 받아 R타입의 객체를 반환하는 것이다.

```aidl
		Function<Integer, String> function = (num) -> num.toString();

		System.out.println(function.apply(55).getClass().equals(String.class));
```

함수를 조합할 수 있는 Compose, andThen이 존재한다.

- Compose

compose의 파라미터로 받은 함수를 먼저 실행한 뒤 그 값을 기존 함수에서 다시 실행한다.

```aidl
Function<Integer, Integer> plus = (i) -> i + 1;
Function<Integer, Integer> multi = (i) -> i * 2
Integer val = plus.compose(multi).apply(5);
```

apply에서 받은 파라미터 5를 multi에서 사용하고 그 결과를 plus에서 사용한다.

- andThen

위의 함수를 andThen에서 그대로 사용해보았다.

```aidl
    Integer apply1 = plus.andThen(multi).apply(5);
    System.out.println(apply1.compareTo(12));
```

알아보기가 굉장히 직관적이다.
plus 하고 난 뒤(AndThen) multi를 하는 것이다.

2. Bifunction<T,U,R>

두개의 t,u 타입 인자를 받아 R 타입으로 반환한다.

3. Predicate<T>

인자를 받아 true, false를 반환하는 인터페이스이다.

# 람다 Function

람다는 (인자) -> {Body} 부분으로 구성된다.
return 혹은 body 부분 코드가 한 줄이라면 중괄호는 생략이 가능하다.

인자에서 타입은 적을 수도 있고, 타입이 제네릭 부분에 정의되어 있기 때문에 타입 추론도 가능하다.

# 메서드 레퍼런스






