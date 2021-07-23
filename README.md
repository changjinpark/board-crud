# Requirement

## 1. 게시판 기능 API
* 게시글 등록
* 게시글 등록 화면 조회
* 게시글 수정
* 게시글 수정 화면 조회 
* 게시글 조회
* 메인 화면 조회(전체 게시글 조회)  
* 게시글 삭제
    
## 2. 회원 로그인 기능 
* 구글/네이버 로그인
* 로그인한 사용자 글 작성 권한
* 본인 작성 글에 대한 권한 관리

<br>

**1. 게시판 기능 API**
----
**게시글 등록**

* Method: : `POST`
* URL : /api/board
* Parameters
  
  | Name | Required | Type | Description |
  |:--------:|:--------:|:--------:|:--------:|
  | title | required | String | 작성글 제목 |
  | content | required | String | 작성글 내용 |
  | author | required | String | 작성자 |

* Success Response: status 200 OK 
  
<br>

**게시글 등록 화면 조회**

* Method: : `GET`
* URL : /board/create
* Parameters : X
* Success Response: status 200 OK
* View 화면 : board-create.mustache

<br>

**게시글 수정**

* Method: : `PUT`
* URL : /api/board/{boardId}
* Parameters

  | Name | Required | Type | Description |
  |:--------:|:--------:|:--------:|:--------:|
  | title | required | String | 작성글 제목 |
  | content | required | String | 작성글 내용 |

* Success Response: status 200 OK

  | Name | Required | Type | Description |
  |:--------:|:--------:|:--------:|:--------:|
  | boardId | required | Long | 글 번호 |
  | title | required | String | 작성글 제목 |
  | content | required | String | 작성글 내용 |
  | author | required | String | 작성자 |   

* Error Response: "해당 게시글이 없습니다."
  
<br>

**게시글 수정 화면 조회**

* Method: : `GET`
* URL : /board/update/{boardId}
* Parameters : x
* Success Response: status 200 OK
* View 화면 : board-update.mustache

<br>

**게시글 조회**

* Method: : `GET`
* URL : /api/board/{boardId}
* Parameters : x
* Success Response: status 200 OK

  | Name | Required | Type | Description |
  |:--------:|:--------:|:--------:|:--------:|
  | boardId | required | Long | 글 번호 |
  | title | required | String | 작성글 제목 |
  | content | required | String | 작성글 내용 |
  | author | required | String | 작성자 |     

* Error Response: "해당 게시글이 없습니다."

<br>

**메인 화면 조회(전체 게시글 조회)**

* Method: : `GET`
* URL : /
* Parameters : x
* Success Response: status 200 OK
* View 화면 : index.mustache

<br>

**게시글 삭제**

* Method: : `DELETE`
* URL : /api/board/{boardId}
* Parameters : x
* Success Response: status 200 OK

  | Name | Required | Type | Description |
  |:--------:|:--------:|:--------:|:--------:|
  | boardId | required | Long | 글 번호 |

* Error Response: "해당 게시글이 없습니다."

**2. 회원 로그인 기능 **
----
구글, 네이버 소셜 로그인 기능을 사용해서 로그인 기능을 구현한다.
