# **혼자같이(*aloneighbor*)**

 <div align=center>
  
![01](https://user-images.githubusercontent.com/98807506/172003058-73f2b9c1-7f0f-4f3c-9005-8e831c6c395f.png)
![02](https://user-images.githubusercontent.com/98807506/172003064-057762af-b346-40bc-97bb-fca435fd84a5.png)
![03](https://user-images.githubusercontent.com/98807506/172003067-181e386c-79f1-40aa-acc4-322f17bf1e6c.png)

</div>


## 🗓 프로젝트 기간
- 2022년 4월 8일 ~ 2022년 4월 14일


# ⭐️ 팀 구성
| 이름     | 깃허브 주소                                                | 포지션     |
|:--------:|:----------------------------------------------------------:|:-----------:|
| 권규민 | [https://github.com/kwongyumin](https://github.com/kwongyumin)                     | Backend     |
| 심현웅   | [https://github.com/hyun-woong](https://github.com/hyun-woong)                     | Backend     |
| 김일권   | [https://github.com/jjems](https://github.com/jjems) | Backend     |
| 김다운   | [https://github.com/Daun1309](https://github.com/Daun1309)                     | Frontend |
| 임세영   | [https://github.com/insidelamp](https://github.com/insidelamp)                     | Frontend |

<br>

# 🍀 프로젝트 소개
자취생들의 자취 꿀팁 및 자취 추천 아이템 공유 플랫폼

# 📎 구현기능
- Jwt Security
- 이미지 CRUD
- 게시글 CRUD
- 댓글 CRUD
- 좋아요


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


### 🎯 트러블슈팅
1. 로그인 후 페이지 이동 및 HTTP메서드 요청마다 헤더에 토큰값을 받아와 유효토큰인지 BE단에서 확인 및 검증.
2. 글 작성 시 이미지 파일과 글내용을 전달받올 때 ,  JSON타입 객체와  MultipartFile 타입 객체를 
@ReqeustBody 가 아닌 @RequestPart 어노테이션을 사용하여 파라미터값으로 받아온다.
3. 댓글 작성 시 게시글과의 순환참조 해결 - @JsonIgnoreProperties({"참조외래키값"}) 어노테이션 처리를 통해 해결.
4. CORS 이슈 해결.




