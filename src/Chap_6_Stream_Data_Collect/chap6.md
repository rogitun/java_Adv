<h1>GroupingBy</h1>

stream 내부에서 다양한 조건을 통해 그룹핑이 가능하다.
팩토리 메서드 groupingBy를 사용하는데, 그 내부에서 또 다시 그루핑하여 그루핑 또한 깊이를 줄 수 있다.

```aidl
   List<Dish> dishes = SampleDishes.getDishes();

        //dish의 타입으로 1차 그루핑 후 칼로리가 300이 넘는지 넘지 않는지에 대해 2차 그루핑

        Map<Dish.Type, Map<String, List<Dish>>> collect = dishes.stream()
                .collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalory() > 300) {
                                        return "Heavy";
                                    } else {
                                        return "DIET";
                                    }
                                }))
                );

        Set<Map.Entry<Dish.Type, Map<String, List<Dish>>>> entries = collect.entrySet();
        entries.forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
```

```aidl
OTHER {Heavy=[rice, french], DIET=[season, pizza]}
FISH {DIET=[salmon, prawns]}
MEAT {Heavy=[chicken, beef], DIET=[Pork]}
```

> SubGroup에서 Counting

GroupingBy 함수의 파라미터는 (f,toList()) 이다.\
따라서 두번째 파라미터로 오는 코드에 따라 다양하게 grouping 결과를 도출해낼 수 있다.

```aidl
    public static void groupingByCounting(List<Dish> dishes) {
        Map<Dish.Type, Long> collect = dishes.stream().collect(
                groupingBy(Dish::getType, Collectors.counting()));

        collect.entrySet().forEach(
                e -> {
                    System.out.println(e.getKey() + " " + e.getValue());
                }
        );
    }
```

```aidl
FISH 2
MEAT 3
OTHER 4
```

> 컬렉터 결과를 다른 형식에 적용

groupingBy의 결과 값으로 null이 가능한 경우 Optional로 래핑이 된다.
하지만 그럴 경우가 없는 경우 Optional로 래핑되어 나온다면 굉장히 귀찮을 수 있다.

이 경우 CollectingAndThen으로 Optional 객체를 벗겨낼 수 있다.\
- CollectingAndThen은 적용할 컬렉터와 변환 함수를 인수로 받아 다른 컬렉터를 반환한다. 
- 아래 함수에서는 maxBy를 사용해 그룹 별로 최대 값을 뽑아내지만 Optional로 반환되어 언래핑을 추가함. 

```aidl
    public static void collectingAndThen(List<Dish> dishes) {
        Map<Dish.Type, Dish> collect = dishes.stream().collect(
                groupingBy(Dish::getType,
                        Collectors.collectingAndThen(
                                maxBy(comparingInt(Dish::getCalory)), Optional::get)));

        collect.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " " + e.getValue());
        });
    }
```

> 분할

grouping으로 분할이 아닌 partitioningBy에선 프레디케이트를 기준으로 분할이 가능하다.
```aidl
  public static void divideGroup(List<Dish> dishes) {
        Map<Boolean, List<Dish>> collect = dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        collect.entrySet().forEach(e -> {
                    System.out.println(e.getKey() + " " + e.getValue());
                }
        );
    } 
```
```aidl
false [salmon, pizza, Pork, prawns, rice, chicken, beef]
true [season, french]
```

filter로도 구현이 가능하고, grouping으로도 할 수 있는데 partition 만의 장점은 무엇이 있을까?

partitioningBy는 그룹을 프레디케이트 기준으로 2분할 하여 분할하는 경우 groupingBy보다 빠르다는 장점이 있다.\
따라서 GroupingBy는 특정 조건을 기준으로 그룹화하고자 할 때, PartitioningBy는 true,false를 기준으로 분할하고자 할 때 사용된다.

이를 응용하여 아래와 같이 소수를 true,false 기준으로 분리할 수 있다.

```aidl
    public static void main(String[] args) {
        divideByPrime(100);
    }


    public static boolean isPrime(int number) {
//        return IntStream.range(2, number)
//                .noneMatch(n -> number % n == 0);
        int numberSqrt = (int) Math.sqrt((double) number);

        return IntStream.rangeClosed(2, numberSqrt)
                .noneMatch(n -> number % n == 0);
    }

    public static void divideByPrime(int number){

        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(2, number)
                .boxed()
                .collect(partitioningBy(c -> isPrime(c)));

        collect.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " " + e.getValue());
        });
    }
```
```aidl
false [4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50, 51, 52, 54, 55, 56, 57, 58, 60, 62, 63, 64, 65, 66, 68, 69, 70, 72, 74, 75, 76, 77, 78, 80, 81, 82, 84, 85, 86, 87, 88, 90, 91, 92, 93, 94, 95, 96, 98, 99, 100]
true [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
```

> Collector 팩토리 메서드 toList

Collector 인터페이스엔 5개의 메서드가 정의되어 있다.

```aidl
public interface Collector<T, A, R> {
    Supplier<A> supplier();

    BiConsumer<A, T> accumulator();

    BinaryOperator<A> combiner();

    Function<A, R> finisher();

    Set<Characteristics> characteristics();


```

상위 4개의 메서드는 collect 메서드에서 실행하는 함수를 반환한다.\
하지만 마지막 함수는 어떤 최적화를 이용해서 리듀싱 연산을 수행할 것인지 결정하도록 돕는 힌트 특성 집합을 제공한다.

> supplier 메서드 

supplier 메서드는 빈 리스트를 반환한다.

> accumulator 메서드 

이 메서드는 리듀싱 연산을 수행하는 함수를 반환한다. 
예시로, 누적자(스트림의 n-1)와 n 번째 요소에 적용되는 함수이다.

> finisher 메서드

이 메서드는 스트림 탐색을 끝내고 누적자 객체를 최종 결과로 변환하면서 누적 과정을 끝낼 때 호출할 함수를 반환해야 한다.

1. supplier로 빈 리스트를 가져온다.
2. 스트림에 요소가 있다면 accumulator에서 결과 컨테이너에 요소를 추가한다.
3. 없다면 finisher로 종료한다.

여기까지는 단순 Collecting이라 실제 collect와는 차이가 있다. 

> combiner 메서드

이 메서드는 stream의 서로 다른 서브파트를 병렬로 처리할 때 누적자가 이 결과를 어떻게 처리할지 정의한다.

> Characteristics 메서드

이 메서드는 스트림을 병렬로 리듀스할 것인지, 그리고 병렬로 한다면 어떤 최적화를 선택할지 힌트를 제공한다.





