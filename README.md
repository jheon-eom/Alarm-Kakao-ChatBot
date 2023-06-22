# 날씨 알리미

## 프로젝트 진행 이유
매일 출퇴근 시간대에 사는 지역(오산)과 회사(강남 또는 판교)의 날씨 상황을 빠르게 확인하고 싶은데 마켓 플레이스에 올라와 있는 앱들은 앱을 키면 광고가 뜨기 때문에 지체되는 시간이 답답하게 느껴졌고, 사는 지역과 회사 지역의 위치를 따로 검색해가며 확인하는 것이 번거로웠기 때문에 기상청에서 제공하는 Open API를 이용하여 빠르게 날씨를 확인하고자 프로젝트를 진행하였다.

## 개발 환경
- Spring Boot 3.0.7
- Java 17
- Gradle 7.6.1
- HttpClient 4.5.13

## API
GET /api/v1/weather/{time}

- 요청 예시 (URI)

/api/v1/weather/morning,
/api/v1/weather/afternoon,
/api/v1/weather/night

- 응답 예시 (JSON)

{"requestTime":"0700","osanREH":"습도79","osanRN1":"1시간 강수량0","osanT1H":"기온22.6","gangnamREH":"습도69","gangnamRN1":"1시간 강수량0","gangnamT1H":"기온21.9","pangyoREH":"습도60","pangyoRN1":"1시간 강수량0","pangyoT1H":"기온22.4"}

## API 흐름

<img width="649" alt="스크린샷 2023-06-22 오전 10 27 19" src="https://github.com/jheon-eom/Weather-Api-Bot/assets/79975547/7d1c4798-2e1b-4205-987c-0781295de248">
