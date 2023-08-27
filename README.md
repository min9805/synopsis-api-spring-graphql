# 개발 내용

EUXP, SCS, MeTV 에 호출한 데이터를 GraphQL 로 전달하는 BFF

# 개발 내용의 의의

- 각 API 에서 전달되는 방대한 양의 데이터
- GraphQL 을 통해 클라이언트에서 선택적으로 데이터 추출
  - 클라이언트 입장에서 HTTP 요청 횟수를 줄일 수 있다
  - 클라이언트 입장에서 HTTP 응답 사이즈를 줄일 수 있다

## GraphQL
- API 를 위한 쿼리 언어
- 클라이언트에게 많은 제어권
- 단일 엔드 포인트
- 타입 시스템, 자동화된 데이터 유형 검사
- 오버 페칭, 언더 페칭 적음
  - 클라이언트가 원하는 것보다 많은 데이터가 내려오는 상황
  - 데이터를 요청하고나서 추가 데이터 요청을 하는 상황
- 상대적 빠름

- 단점
  - 스키마의 유지보수
  - 캐싱 전략의 어려움
  - 학습 곡선 존재

# 선택한 개발 방법 및 이유

## 패키지 구조

간단한 서비스 구조이기에 기존 Spring MVC 패턴 사용
Controller → Resolver

## 프레임워크

### DGS 

- Schema First
- Schema를 생성하고 그에 따른 코드를 Generate하는 과정으로 개발
  - code-gen plugin
    - plugin 으로 Schema 작성으로 code 자동화



# 결과

## Synopsis1	

Synopsis 에서 SMD, SCS, EUXP 각각의 3개 Input 을 가지고 있으며 각각의 IF 를 Key 값으로 응답

## Synopsis2

Common Input 을 추가하고 각각의 추가적 Input 과 각각의 응답

- 각 API 별로 동작, fault tolerance
- 중복되는 Input 값을 한 번의 Input 으로 처리
- 4개의 input variable
- API 이름을 Key 값으로 분리된 응답

## ViewPage

	
Common input 과 전체 데이터를 하나의 스키마로 응답

- 하나의 Input, 하나의 Key 값 응답
- 직관적인 네이밍으로 매핑
- Fault Toerance, 하나의 API 가 fault 시 data = null
- 스키마 설계

