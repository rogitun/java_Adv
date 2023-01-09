# 병렬 스트림

병렬 스트림은 항상 빠르고 좋은가? 그렇진 않다.

1. 병렬을 사용할지 말지 고민이 된다면 성능을 직접 측정하라. 
2. 박싱을 주의하라. 자동 방식과 언박싱은 성능을 크게 저하시킬 수 있다. 기본형 특화 스트림(IntStream)등을 사용하여 회피하라.
3. 순차 스트림보다 병렬 스트림에서 오히려 성능이 떨어질 수 있다. limit, findFirst를 병렬 스트림에서 사용하려면 큰 비용을 치러야한다. 순서가 크게 중요하지 않다면 unordered 스트림에 limit을 호출하는게 더 효율적이다.
4. 스트림에서 수행하는 전체 파이프라인 연산 비용을 고려하라. 
5. 소량의 데이터에선 병렬 스트림으로 이득을 보기 어렵다. 
6. 스트림을 구성하는 자료구조를 적절히 확인하라. ArrayList는 LinkedList보다 효율적으로 분할이 가능하다.
7. 스트림의 특성과 파이프라인의 중간 연산이 스트림의 특성을 어떻게 바꾸는지에 따라 분해 과정의 성능이 달라질 수 있다. SIZED 스트림은 정확히 같은 크기의 두 스트림으로 분할할 수 있어 병렬로 처리하기 좋다.
8. 최종 연산의 병합 과정 (Collector의 combiner 메서드) 비용을 살펴보라. 병합 과정의 비용이 비싸다면 병렬 스트림으로 얻은 성능의 이익이 서브스트림의 부분 결과를 합치는 과정에서 상쇄될 수 있다.

ArrayList와 IntStream(기본형 특화 스트림)은 분해성이 좋지만,\
LinkedList, Stream.iterate는 분해성이 좋지 않다.

> 포크 조인 프레임워크

병렬화 할 수 있는 작업을 재귀적으로 작은 작업으로 분할하여 서브태스크 각각의 결과를 합쳐 전체 결과를 만들도록 설계되었다.
