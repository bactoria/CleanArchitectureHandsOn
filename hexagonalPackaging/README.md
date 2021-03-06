### 3. 헥사고날 패키지 구성하기 - 아키텍처적으로 표현력 있는 패키지 구조!

<img width="45%" alt="CleanShot 2022-01-15 at 01 32 57@2x" src="https://user-images.githubusercontent.com/25674959/149550990-adba78c8-9fe0-442f-ae8f-300b320d6846.png">

코드에서 아키텍처의 특정 요소를 찾으려면 이제 아키텍처 다이어그램의 박스 이름을 따라 패키지 구조를 탐색하면 된다.
eg. 수정할 기능은 어디에 있는가? 계좌 저장하는 클라이언트 코드는 어디에있는가? account/adapter/out/~Adapter !

아키텍처가 패키지 구조에 잘 반영되어 있다.

Q) 여기는 패키지가 굉장히 많은데, 이러면 다 public으로 만들어야하는거 아닌가요?    
-> `Adapter 패키지`: 모두 package-private 가능. 내부는 모두 application 패키지의 port interface 를 통하지 않고서는 바깥에서 호출되지 않는다.  
-> `Application 패키지`: 서비스는 package-private 가능. (어댑터에서 접근 가능해야 하는 port는 public)
-> `Domain 패키지`: public

장점: 어댑터 코드 구현(세부사항)을 쉽게 바꿀 수 있다.
eg. Redis 에서 MYSQL로 변경하는 경우. -> 아웃고잉 포트들만 새로운 어댑터 패키지에 구현하고 기존 패키지를 지우면 끝.

한계: 위와 같은 패키지 구조가 적합하지 않아서, 아키텍처를 반영하지 않는 패키지가 생길 수도 있다.  
이 때는 어쩔 수 없이 패키지를 만들어야겠지만, 위와 같은 패키지 구조는 코드와 아키텍처 간의 갭을 줄인다는 건 명백함.  

<br>

- [계층으로 패키지 구성하기 (Layered)](../layeredPackaging)
- [기능으로 패키지 구성하기 (Featured)](../featuredPackaging)
