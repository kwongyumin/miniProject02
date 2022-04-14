# miniProject02
# **혼자같이(*aloneighbor*)**

### Team
- Frontend : 임세영,김다운 (REACT)
- Backend : 김일권,권규민,심현웅 (SPRING)

# 프로젝트 소개

### 키워드

- SNS 형식
- 당근마켓 동네생활 컨셉
- 자취에 대한 소셜내용
- 혼자(개인의 게시글 등이 중심)/ 같이(동네 행사, 이슈 등의 내용)

### 프로젝트 개요

- 닉네임
- 좋아요 Top 5 게시글 상위 노출(시간이 된다면)
- 정렬 - 최신순
- 좋아요 기능
- 댓글 기능 구현
- 게시글 상세페이지 - 모달 or html
- 게시글 작성페이지(s3 사진 업로드)
- 게시글 수정, 삭제

### 와이어프레임 및 기능 설계
<img width="650" alt="스크린샷 2022-04-08 오후 3 11 07" src="https://user-images.githubusercontent.com/93507721/163360095-c4ef363b-9065-4041-8340-dbcdfeed6aef.png">

### ERD 설계

![ERD PNG](https://user-images.githubusercontent.com/93507721/163360020-61f95868-3685-4778-b444-bed6ae59cf75.png)


<details>
<summary> API 설계</summary>
<div markdown="1">


![api1](https://user-images.githubusercontent.com/93507721/163361049-9fddba89-c013-4a11-9477-70dc14a298b9.PNG)

![api2](https://user-images.githubusercontent.com/93507721/163361063-91e77461-4fbd-4d01-bfa5-cf36581b97c0.PNG)

![api3](https://user-images.githubusercontent.com/93507721/163361090-c7d4c1b3-7875-4224-b1b1-477ed2abfb0a.PNG)
  

</div>
</details>



### 트러블슈팅
1. 로그인 후 페이지 이동 및 HTTP메서드 요청마다 헤더에 토큰값을 받아와 유효토큰인지 BE단에서 확인 및 검증.
2. 글 작성 시 이미지 파일과 글내용을 전달받올 때 ,  JSON타입 객체와  MultipartFile 타입 객체를 
@ReqeustBody 가 아닌 @RequestPart 어노테이션을 사용하여 파라미터값으로 받아온다.
3. 댓글 작성 시 게시글과의 순환참조 해결 - @JsonIgnoreProperties({"참조외래키값"}) 어노테이션 처리를 통해 해결.
4. CORS 이슈 해결.




