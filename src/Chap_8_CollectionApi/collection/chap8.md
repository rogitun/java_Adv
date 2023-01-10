# 컬렉션 팩토리

컬렉션 팩토리 메서드는 코드를 간단하게 줄일 수 있도록 돕는다. 

```aidl
 //적은 요소를 포함하는 리스트 생성.

        List<String> strings = Arrays.asList("ab", "bc", "cd"); //고정 크기의 리스트가 생성된다.
        strings.add("abc"); -> Exception
```

고정 크기의 리스트이기 때문에 요소를 추가하려하면 예외가 발생한다.

> 집합 팩토리

List.of, Arrays.of와 비슷한 방법으로 불변 집합 또한 생성할 수 있다.

```aidl
        Set<String> abcd = Set.of("Abcd", "DSD", "DSD");

Exception in thread "main" java.lang.IllegalArgumentException: duplicate element: DSD

```

중복된 요소를 포함해 집합을 만들려고 하면 중복된 요소로 인해 예외가 발생한다.

> 맵 팩토리 

맵 또한 팩토리 메서드가 존재한다.
하지만 맵은 key-value 쌍으로 주어지기 때문에 초기값을 설정할 때 key-value 쌍이 필요하다.

아래와 같이 순차적으로 키와 밸류를 번갈아 제공하는 방식으로 맵을 생성할 수 있다.
작은 크기의 map을 생성할 때 유용하다.
```aidl
 Map<String, String> k1 = Map.of("k1", "v1", "k2", "v2");

        k1.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " " + e.getValue());
        });
```

> List와 집합처

자바8부터 List, Set 인터페이스에 아래와 같은 메서드가 추가되었다.

1. removeIf : 프레디케이트를 만족시키는 요소를 제거. List나 Set을 구현 및 상속받은 모든 클래스에서 이용 가능
2. replaceAll : 리스트에서 사용할 수 있는 기능으로 UnaryOperator 함수를 이용해 요소를 바꾼다.
3. sort : List 인터페이스에서 제공하는 기능으로 리스트를 정렬한다.

이 메서드들은 컬렉션 자체를 바꾼다. 컬렉션을 바꾸는 동작은 에러를 유발하며 복잡함이 더해진다. 근데 왜 추가되었을까?

```aidl
    for (Dish dish : dishes) {
            if(dish.getCalory()>500){
                dishes.remove(dish);
            }
    }
```

위 코드는 그냥 보기엔 별 문제가 없어보인다.
하지만 동시성과 관련된 예외가 발생한다.

내부적으로 for-each 루프는 Iterator 객체를 사용한다. 
반복자의 상태와 컬렉션의 상태는 서로 동기화되지 않기 때문에 컬렉션에서 삭제했을 때 그것이 반복자(Iterator)로 전달되지 않아 문제가 발생하게 된다.

```aidl
        dishes.removeIf(d -> d.getCalory() > 300);
```

removeIf를 사용해 위와 같이 간단히 람다식과 프레디케이트를 이용해 컬렉션 요소를 삭제할 수 있다.

> Map - ForEach

맵을 루프 돌리는건 정말 귀찮은 일이다.
key, value를 가져다 돌려야하기 때문에 entrySet을 가져와 루프를 돌리곤 한다.

자바8부터 BiConsumer(키와 값을 인수로 받음)를 인수로 받는 forEach 메서드를 지원하기 때문에 좀 더 간단히 루프를 돌릴 수 있다.

```aidl
        k1.forEach((k,v)->{
            System.out.println("key = " + k + " val = " + v);
        });
```

람다식 인자로 key와 value를 지정해주면 해당 키-밸류 쌍을 사용할 수 있다.

> 맵 정렬 

- comparingByValue
- comparingByKey

위 두 메서드를 통해 항목을 키 또는 값을 기준으로 정렬할 수 있다.

```aidl
            k1.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(System.out::println); //병렬 스트림인 경우에도 순서가 보장됨.
```

> 맵 합치기 

```aidl
        Map<String, String> map1 = Map.ofEntries(Map.entry("hansel", "CS"), Map.entry("Kim", "english"));
        Map<String, String> map2 = Map.ofEntries(Map.entry("albert", "Tech"), Map.entry("Kim", "Korean"));

        HashMap<String, String> totalMap = new HashMap<>(map1);

        map2.forEach((k, v) -> {
            totalMap.merge(k, v, (v1, v2) -> v1 + " & " + v2);
        });

        System.out.println(totalMap);
```

두 맵을 합칠 때 중복되는 key가 있다면 merge 메서드를 이용해 유연하게 합칠 수 있다.

