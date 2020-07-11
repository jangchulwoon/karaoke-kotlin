# karaoke-kotlin

![travis](https://travis-ci.org/jangchulwoon/karaoke-kotlin.svg?branch=master)


코틀린 공부겸 / 스프링 부트 공부겸 예전에 만들어둔  karaokeParser 를 다시 만들어봅니다.
지극히 개인 필요로 만들어진 프로젝트입니다. 

- 태진 / 금영 웹사이트로 부터, 데이터를 파싱하여 내려줍니다.
- 요청때마다 파싱을 진행하므로, 처리 속도가 늦습니다. (태진 / 금영 사이트가 느립니다..)

#### todo 

- redis cache 를 발라둘 예정입니다.
- 가능하면 batch 를 만들어, 인기검색어만 파싱 -> txt 로 내려볼 예정입니다.
- 그 외는 떠오르는거 부터 .. 
