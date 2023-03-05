<h1>Stream</h1>

# Stream?

Collection 내부 데이터를 소스로 사용하여 처리하는 방식이다.
데이터가 Stream으로 흘러들어가 처리해 반환하는 방식이다.

**Stream은 데이터를 담는 저장소가 절대 아니다.**

1. 중개 Opt, 종료 Opt
stream에는 중개 opt, terminal opt가 있다.

중개 opt는 lazy하다는 특징이 있다.
이들은 모두 stream을 return한다.

lazy하기 때문에 stream을 돌면서(stream 메서드들을 수행하면서) 내부 코드들은 terminal opt를 만나야
수행이 된다.

2. 병렬 처리

Stream은 병렬처리가 가능하다.
ParallelStream을 사용하면 JVM이 알아서 병렬처리를 하게 된다.
이후 오는 opreator들은 병렬처리가 된다.

병렬처리 한다고 항상 빠른가?
**그렇진 않다.**

데이터가 정말 방대하게 큰 경우에만 효율적이다.
쓰레드를 생성하는 비용, 각 쓰레드에서 결과를 받아오는 비용, 쓰레드간의 컨텍스트 스위칭 비용 등..


# Stream API 

