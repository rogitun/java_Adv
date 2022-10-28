<h1>Stream 활용</h1>

<h2>Filter</h2>

> predicate 필터링

프레디케이트 필터링은 불리언을 반환하는 함수를 인수로 받아서\
프레디케이트와 일치하는 모든 요소를 포함하는 스트림을 반환한다.

```aidl
        menu.stream()
                .filter(Dish::isVegetarian)
                .map(veget::add);
```
<hr>

> 고유 요소 필터링

스트림은 고유 요소로 이루어진 스트림을 반환하는 distinct 메서드도 지원한다.

고유의 여부는 equals, hashcode로 결정된다.

```aidl
        List<Integer> integers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        List<Integer> collect = integers.stream()
                .filter(num -> num % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
```

위 코드는 2, 4 만 반환하게 된다.

<hr>

> 스트림 슬라이싱

프레디케이트를 이용하여 처음 몇개 요소를 무시하는 방법, 특정 크기로 스트림을 줄이는 방법 등 다양한 
작업을 수행할 수 있다.

1. 프레디케이트를 이용한 슬라이싱 

takeWhile, dropWhile

<h3>takeWhile</h3>

```aidl
            dishes.add(new Dish("season",true,120, Dish.Type.OTHER));
            dishes.add(new Dish("salmon",false,190, Dish.Type.FISH));
            dishes.add(new Dish("pizza",false,220, Dish.Type.OTHER));
            dishes.add(new Dish("Pork",false,230, Dish.Type.MEAT));
            dishes.add(new Dish("prawns",false,300, Dish.Type.FISH));
            dishes.add(new Dish("rice",false,350, Dish.Type.OTHER));
            dishes.add(new Dish("chicken",false,400, Dish.Type.MEAT));
            dishes.add(new Dish("french",true,530, Dish.Type.OTHER));
            dishes.add(new Dish("beef",false,700, Dish.Type.MEAT));
```

만약 위와 같이 정렬된 데이터 중 칼로리가 300 이하인 dish만 반환하고 싶다면?\
간단히 filter를 사용해 처리할 수 있다. 하지만 filter만 사용하면 모든 데이터에 대해서 filter를 해야한다.\
데이터는 이미 정렬되어 있다는 것이 중요하다.

이는 굉장히 비효율적으로 보인다. 
takeWhile을 사용하면 이 문제를 해결할 수 있다.

```aidl
        dishes.stream()
                .takeWhile(dish -> dish.getCalory() < 300)
                .forEach(System.out::println);
```
필터 없이 더 효율적으로 정렬된 데이터를 처리했다.
이처럼 슬라이싱 할 수 있다.

2. DropWhile 

dropWhile은 나머지 요소를 처리할 때 사용한다.
이름 그대로 takeWhile은 조건에 해당하는 데이터를 **Take** 했고\
dropWhile은 프레디케이트가 거짓이 되는 지점까지 발견된 요소를 버린다.
거짓이 되면 그 지점에서 작업을 중단하고 남은 모든 요소를 버린다.

```aidl
        dishes.stream()
                .dropWhile(dish -> dish.getCalory() < 300)
                .forEach(System.out::println);
```

3. Limit

limit은 sql 쿼리와 비슷하다.
반환되는 요소들 중 최대 n개의 요소만 반환하도록 하는 것이 limit이다.

```aidl
        dishes.stream()
                .filter(dish -> dish.getCalory() > 300)
                .limit(2)
                .forEach(System.out::println);
```

4. Skip

skip은 처음 n개의 요소를 제외한 함수이다.
어떤 조건을 수행하는 요소들 중 n개를 건너뛴 결과를 반환할 수 있다.

<h2>매핑</h2>

특정 객체에서 특정 데이터를 선택하는 작업은 자주 수행되는 연산이다.
스트림의 Map & FlatMap 메서드는 특정 데이터를 선택하는 기능을 제공한다.

map에서는 적용한 결과가 새로운 요소로 매핑된다.

```aidl
        List<String> collect = dishes.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

```
<hr>

> 스트림 평면화

```
    strings = ["abc","de"]
    
        List<String[]> splitsStrings = strings
                .stream()
                .map(s -> s.split(""))
                .distinct()
                .collect(Collectors.toList());
                
   result => [['a','b','c'],['d','e']]
```

위 코드를 사용하면 하나의 문자열은 하나의 알파벳으로 변환되어 반환된다.
하지만 결과 타입은 List<String[]>이 된다.

split으로 쪼개지니 String[] 타입이 반환될 수 밖에 없고\
그걸 toList 헀으니 어찌 보면 당연하다. 

이 문제는 flatMap을 사용해 해결할 수 있다.

> FlatMap 

```aidl
        List<String> collect1 = strings.stream()
                .map(w -> w.split("")) -> 각 단어를 개별 문자를 포함하는 배열로 변환
                .flatMap(Arrays::stream) -> 생성된 스트림을 하나의 스트림으로 평면화
                .distinct()
                .collect(Collectors.toList());
```

중복이 제거된 완벽한 개별 string으로 반환된다.

flatMap은 Array, Object 등의 모든 원소를 단일 원소 스트림으로 반환한다.

map은 입력한 원소를 그대로 스트림으로 반환했지만, flatMap은 입력한 원소를 가장 작은 단위의 단일 스트림으로
반환했다.
조금 쉽게 말하면 여러 개의 스트림을 한개의 스트림으로 합쳐준다고 할 수 있다.


