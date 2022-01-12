### 기능으로 패키지 구성하기 (Featured)

<img width="35%" alt="CleanShot 2022-01-13 at 04 10 55@2x" src="https://user-images.githubusercontent.com/25674959/149206150-b79715c2-b146-4210-aa21-9cc16d7e86da.png">


**계층 패키지보다 장점**
1. 패키지 외부에서 접근되면 안되는 클래스들에 대해 package-private 접근 수준을 이용해 패키지 간의 경계를 강화할 수 있다.
   -> 어느정도 경계를 무너트리는 것을 막아준다. 다른 기능의 패키지에서는 접근이 안되기 때문에.

2. AccountService -> SendMoneyService  
   -> 기능으로 패키지가 구성되었다보니 Account를 생략할 수 있다.  
   -> SendMoneyService 보자. '송금하기' 유스케이스를 구현한 코드는 클래스명만으로도 찾을 수 있게 됬다.  
   -> 클린아키텍처 - 소리치는 아키텍처 (코드가 그 의도를 우리에게 소리치고 있다.)

**단점**
1. 아키텍처의 가시성을 떨어트린다.
- 어댑터를 나타내는 패키지명이 없다.
- 인커밍 포트, 아웃고잉 포트를 확인할 수 없다.
- 도메인 코드와 영속성 코드 간의 의존성을 역전시켜서 SendMoneyService가 AccountRepository 인터페이스만 알고 있고 구현체는 알 수 없도록 했음에도 불구하고, 도메인 코드가 실수로 영속성 코드에 의존하는 것을 막을 수 없다.
    - package-private 접근 수준을 이용할 수 없기 때문이다.  



<br>

- [계층으로 패키지 구성하기 (Layered)](../layeredPackaging)
- [헥사고날 패키지 구성하기 - 아키텍처적으로 표현력 있는 패키지 구조!](../featuredPackaging)
