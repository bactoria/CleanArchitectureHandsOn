본 Repository 는 "만들면서 배우는 클린아키텍처" 의 실습인 https://github.com/wikibook/clean-architecture 기반의 코드이다.

위 저장소와의 차이는 다음과 같다.

||위 저장소|이거|
|:--:|:--:|:--|
|구성|hexagonal|layered packaging <br> featured packaging <br>hexagonal packaging|
|lang|java|kotlin|

kotlin 은 `package-private` 를 지원하지 않기에, java로 대체할 수도 있음.

<br>

### 패키지 구성
- [계층으로 패키지 구성하기 (Layered)](./layeredPackaging)
- [기능으로 패키지 구성하기 (Featured)](./featuredPackaging)
- [헥사고날 패키지 구성하기 - 아키텍처적으로 표현력 있는 패키지 구조!](./hexagonalPackaging)
