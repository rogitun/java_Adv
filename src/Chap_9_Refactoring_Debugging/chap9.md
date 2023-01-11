# Refactoring & Testing & Debugging

기존의 프로젝트를 람다식과 스트림을 이용해 어떻게 리팩토링 할 것인가?

1. 익명 클래스를 람다 표현식으로 리팩토링하기.

```aidl
    public static void main(String[] args) {
        // 1. 익명클래스를 람다 표현식으로 리팩토링

        doSth(new Task() {
            @Override
            public void execute() {
                System.out.println("Task Executed");
            }
        });

    }

    interface Task {
        public void execute();
    }

    public static void doSth(Runnable r) {
        r.run();
    }

    public static void doSth(Task t) {
        t.execute();
    }
```

위 코드에서 doSth 메서드 호출은 익명 클래스 사용시 명시적이다.\
하지만 이를 람다식으로 변환하면 어떤 메서드를 호출하는지 명확하지 않을 수 있다.

```aidl
        doSth((Runnable) ()->{
            System.out.println("?? Executed");
        });
        
        doSth((Task) ()->{
            System.out.println("?? Executed");
        });
```

따라서 task인지 Runnable인지 명시적으로 형변환을 해야한다. 다행히 인텔리제이에서 바로 잡아주긴 한다.

2. 람다 표현식을 메서드 참조로 리팩토링하기.

```aidl
        List<Dish> dishes = SampleDishes.getDishes();
        Map<String, List<Dish>> collect = dishes.stream()
                .collect(Collectors.groupingBy(dish -> {
                    if (dish.getCalory() > 500) return "heavy";
                    else return "light";
                }));
```

프레디케이트에 따라 grouping하는 스트림 및 람다식이다.
위의 코드는 람다식의 부분을 메서드로 뽑아내어 메서드 참조로 변환할 수 있다.

```aidl
    public String groupByCalory() {
        if (this.calory > 500) return "heavy";
        else return "light";
    }
```

이 메서드를 Dish 내부에 메서드로 추가한 뒤, 아래와 같이 메서드 참조로 호출하는 방법이 있다.

```aidl
        Map<String, List<Dish>> collect1 = dishes.stream()
                .collect(Collectors.groupingBy(Dish::groupByCalory));
```

프레디케이트절은 캡슐화되었고 코드는 더 간략해졌다.

3. 명령형 처리를 스트림으로 리팩토링하기.

```aidl
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalory() > 300) {
                dishNames.add(dish.getName());
            }
        }
```

위 코드를 stream으로 리팩토링한다면 어떻게 할 수 있을까?

```aidl
//1. dishNames에 add를 할 필요 없이 300이상 filter처리하고 collections으로 담는다.
        
        dishes.stream()
                .filter(d -> d.getCalory()>300)
                .map(Dish::getName)
                .collect(Collectors.toList());
```

더 직접적인 코드를 만들었고, 원한다면 병렬처리도 가능하다.

# 람다로 디자인패턴 리팩토링

1. 전략패턴

전략패턴 : 런타임에 적절한 알고리즘을 선택하는 기법.

다양한 기준을 갖는 입력값을 검증하거나,\
다양한 파싱 방법을 사용하거나,\
입력 형식을 설정하는 등 다양한 시나리오에 전략 패턴을 활용할 수 있다.

```aidl
    public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}

```

```
    public class Validator {
    private final ValidationStrategy validationStrategy;

    public Validator(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public boolean validate(String s) {
        return validationStrategy.execute(s);
    }
}
```

```aidl
        Validator validatorNumeric = new Validator(new IsNumeric());
        Validator validatorLowerCase = new Validator(new IsAllLowerCase());

        String allLower = "abcd";
        String notLower = "AdVD";
        String numeric = "123321";
        String notNumeric = "ads123";

        System.out.println("is numeric ? " + validatorNumeric.validate(numeric)); // true
        System.out.println("is numeric ? " + validatorNumeric.validate(notNumeric)); // false
        System.out.println("is allLower ? " + validatorLowerCase.validate(allLower)); // yes
        System.out.println("is allLower ? " + validatorLowerCase.validate(notLower)); // false
```

위 처럼 각 상황에 맞는 전략을 만들어 검증에 사용할 수 있다.

하지만 각 전략이 간단하고 따로 클래스로 추출해 관리하기 복잡한 상황이라면 람다식으로 전환할 수 있다.

```aidl
        Validator lowerCaseValidator = new Validator((String s) -> s.matches("[a-z]+"));
        Validator numericValidator = new Validator((String s) -> s.matches("\\d+"));
```

2. 템플릿메서드

