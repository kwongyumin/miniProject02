# **ํผ์๊ฐ์ด(*aloneighbor*)**

 <div align=center>
  
![01](https://user-images.githubusercontent.com/98807506/172003058-73f2b9c1-7f0f-4f3c-9005-8e831c6c395f.png)
![02](https://user-images.githubusercontent.com/98807506/172003064-057762af-b346-40bc-97bb-fca435fd84a5.png)
![03](https://user-images.githubusercontent.com/98807506/172003067-181e386c-79f1-40aa-acc4-322f17bf1e6c.png)

</div>


## ๐ ํ๋ก์ ํธ ๊ธฐ๊ฐ
- 2022๋ 4์ 8์ผ ~ 2022๋ 4์ 14์ผ


# โญ๏ธ ํ ๊ตฌ์ฑ
| ์ด๋ฆ     | ๊นํ๋ธ ์ฃผ์                                                | ํฌ์ง์     |
|:--------:|:----------------------------------------------------------:|:-----------:|
| ๊ถ๊ท๋ฏผ | [https://github.com/kwongyumin](https://github.com/kwongyumin)                     | Backend     |
| ์ฌํ์   | [https://github.com/hyun-woong](https://github.com/hyun-woong)                     | Backend     |
| ๊น์ผ๊ถ   | [https://github.com/jjems](https://github.com/jjems) | Backend     |
| ๊น๋ค์ด   | [https://github.com/Daun1309](https://github.com/Daun1309)                     | Frontend |
| ์์ธ์   | [https://github.com/insidelamp](https://github.com/insidelamp)                     | Frontend |

<br>

# ๐ ํ๋ก์ ํธ ์๊ฐ
์์ทจ์๋ค์ ์์ทจ ๊ฟํ ๋ฐ ์์ทจ ์ถ์ฒ ์์ดํ ๊ณต์  ํ๋ซํผ

# ๐ ๊ตฌํ๊ธฐ๋ฅ
- Jwt Security
- ์ด๋ฏธ์ง CRUD
- ๊ฒ์๊ธ CRUD
- ๋๊ธ CRUD
- ์ข์์


### ํค์๋

- SNS ํ์
- ๋น๊ทผ๋ง์ผ ๋๋ค์ํ ์ปจ์
- ์์ทจ์ ๋ํ ์์๋ด์ฉ
- ํผ์(๊ฐ์ธ์ ๊ฒ์๊ธ ๋ฑ์ด ์ค์ฌ)/ ๊ฐ์ด(๋๋ค ํ์ฌ, ์ด์ ๋ฑ์ ๋ด์ฉ)


### ์์ด์ดํ๋ ์ ๋ฐ ๊ธฐ๋ฅ ์ค๊ณ
<img width="650" alt="แแณแแณแแตแซแแฃแบ 2022-04-08 แแฉแแฎ 3 11 07" src="https://user-images.githubusercontent.com/93507721/163360095-c4ef363b-9065-4041-8340-dbcdfeed6aef.png">

### ERD ์ค๊ณ

![ERD PNG](https://user-images.githubusercontent.com/93507721/163360020-61f95868-3685-4778-b444-bed6ae59cf75.png)


### ๐ฏ ํธ๋ฌ๋ธ์ํ
1. ๋ก๊ทธ์ธ ํ ํ์ด์ง ์ด๋ ๋ฐ HTTP๋ฉ์๋ ์์ฒญ๋ง๋ค ํค๋์ ํ ํฐ๊ฐ์ ๋ฐ์์ ์ ํจํ ํฐ์ธ์ง BE๋จ์์ ํ์ธ ๋ฐ ๊ฒ์ฆ.
2. ๊ธ ์์ฑ ์ ์ด๋ฏธ์ง ํ์ผ๊ณผ ๊ธ๋ด์ฉ์ ์ ๋ฌ๋ฐ์ฌ ๋ ,  JSONํ์ ๊ฐ์ฒด์  MultipartFile ํ์ ๊ฐ์ฒด๋ฅผ 
@ReqeustBody ๊ฐ ์๋ @RequestPart ์ด๋ธํ์ด์์ ์ฌ์ฉํ์ฌ ํ๋ผ๋ฏธํฐ๊ฐ์ผ๋ก ๋ฐ์์จ๋ค.
3. ๋๊ธ ์์ฑ ์ ๊ฒ์๊ธ๊ณผ์ ์ํ์ฐธ์กฐ ํด๊ฒฐ - @JsonIgnoreProperties({"์ฐธ์กฐ์ธ๋ํค๊ฐ"}) ์ด๋ธํ์ด์ ์ฒ๋ฆฌ๋ฅผ ํตํด ํด๊ฒฐ.
4. CORS ์ด์ ํด๊ฒฐ.
