# 스프링 부트와 AWS로 만드는 CRUD 게시판 웹서비스

## 📋 사용기술
### 백엔드
#### Spring boot2
* JAVA 8
* Spring MVC
* Spring Security
* Spring Data JPA

#### Build tool
* Gradle 4.10.2

#### Database
* MariaDB 10.04

#### AWS
* EC2
* RDS
* S3

#### 배포 자동화 & 무중단 배포
* Travis CI
* Nginx

### 프론트엔드
* Javascript / jQuery
* Mustache

## 📋 게시판 Rest API 설계 문서

**간편 로그인 기능**
* 구글 로그인/네이버 로그인
* 로그인한 사용자 글 작성 권한
* 본인 작성 글에 대한 권한 관리

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

**게시글 등록 화면 조회**

* Method: : `GET`
* URL : /board/create
* Success Response: status 200 OK
* View 화면 : board-create.mustache

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

**게시글 수정 화면 조회**

* Method: : `GET`
* URL : /board/update/{boardId}
* Success Response: status 200 OK
* View 화면 : board-update.mustache

**게시글 조회**

* Method: : `GET`
* URL : /api/board/{boardId}
* Success Response: status 200 OK

  | Name | Required | Type | Description |
  |:--------:|:--------:|:--------:|:--------:|
  | boardId | required | Long | 글 번호 |
  | title | required | String | 작성글 제목 |
  | content | required | String | 작성글 내용 |
  | author | required | String | 작성자 |     

* Error Response: "해당 게시글이 없습니다."

**메인 화면 조회(전체 게시글 조회)**

* Method: : `GET`
* URL : /
* Success Response: status 200 OK
* View 화면 : index.mustache

**게시글 삭제**

* Method: : `DELETE`
* URL : /api/board/{boardId}
* Success Response: status 200 OK

  | Name | Required | Type | Description |
  |:--------:|:--------:|:--------:|:--------:|
  | boardId | required | Long | 글 번호 |

* Error Response: "해당 게시글이 없습니다."

