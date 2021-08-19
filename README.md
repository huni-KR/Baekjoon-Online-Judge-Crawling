# [Baekjoon Online Judge](https://www.acmicpc.net/) Crawling

## **설명**
[Baekjoon Online Judge](https://www.acmicpc.net/) 사이트의 내 계정으로 제출한 코드를 크롤링합니다.</br>
Selenium을 사용하여 직접 코드를 가지고 오기 때문에 실행 속도가 굉장히 느립니다.

크롤링 우선순위 1 : 제출한 코드중 가장 최근에 제출한 정답인 코드</br>
크롤링 우선순위 2 : 제출한 코드중 가장 최근에 제출한 오답인 코드</br>

지원하는 언어 : C/C++, Java, Python</br>
지원하는 언어 이외의 언어는 txt 확장자로 저장됩니다.

문의사항 및 수정 요청 : <babodevloper@gmail.com>

---

## **설정**
[Step 1] pip install -r requirements.txt</br>
[Step 2] [ready 함수] 크롬 드라이버 경로 설정하기 -> [경로 설정 팁](https://pythondocs.net/selenium/%EC%85%80%EB%A0%88%EB%8B%88%EC%9B%80-%EC%9B%B9-%ED%81%AC%EB%A1%A4%EB%A7%81-%EB%B4%87-%ED%83%90%EC%A7%80-%EC%9A%B0%ED%9A%8C/)
    

---

## **사용법**
[Step 1] Crawling.py 실행</br>
[Step 2] 로그인 하기( Robot Check 통과하기 )</br>
[Step 3] 크롤링 종료까지 기다리기

---

## **참고한 사이트**
1. [열려있는 Chrome에서 크롤링하기](https://jakpentest.tistory.com/39)
2. [셀레니움 웹 크롤링 봇 탐지 우회](https://pythondocs.net/selenium/%EC%85%80%EB%A0%88%EB%8B%88%EC%9B%80-%EC%9B%B9-%ED%81%AC%EB%A1%A4%EB%A7%81-%EB%B4%87-%ED%83%90%EC%A7%80-%EC%9A%B0%ED%9A%8C/)

---