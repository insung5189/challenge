## 1차 요구사항 구현
- [x] 유저가 루트 url로 접속시에 게시글 리스트 페이지가 나온다.
- [x] 리스트 페이지에서는 등록 버튼이 있고 버튼을 누르면 http://주소:포트/article/create 경로로 이동하고 등록 폼이 나온다.
- [x] 등록을 하면 http://주소:포트/article/create로 POST 요청을 보내어 DB에 해당 내용을 저장한다.
- [x] 등록이 되면 해당 게시글 상세 페이지로 리다이렉트 된다. 해당 경로는 http://주소:포트/article/detail/{id} 가 된다.
- [x] 게시글 상세 페이지에는 목록 버튼이 있다. 목록 버튼을 누르면 게시글 리스트 페이지로 이동하게 된다.
- (추가 기능이나 구현기능설명이 필요한 경우 서술)
- [x] 게시글 리스트 페이지와 상세 페이지에는 해당 게시글의 ID값을 표시한다.
- [x] 게시글 리스트 페이지에는 수정 버튼이 있다. 수정 버튼을 누르면 해당 게시글이 세팅된 수정 폼이 나타나고 수정이 가능하다.
- [x] 게시글 리스트 페이지에는 삭제 버튼이 있다. 삭제 버튼을 누르면 해당 게시글의 삭제가 가능하다.


## 미비사항 or 막힌 부분
- ...

## MVC 패턴
- MVC란 Model, View, Controller의 약자로 Model(Service, Repository)에서 받아온 데이터를 가공 및 예외처리를 하여
- Controller를 통해서 View로 보내기 위한 추가 가공처리를 하고 View는 Controller에서 보낸 데이터를 출력한다.
- 여기서 Controller에는 Modle의 로직이 존재할 수 있지만, Model에는 Controller의 로직이 존재할 수 없다.
- 데이터 처리과정을 나눠서 볼 수 있기 때문에 유지보수가 편하다는 장점이 있다.

## 스프링에서 의존성 주입(DI) 방법
- @RequiredArgsConstructor, @Autowired, @Setter를 통해서 객체를 주입할 수 있는데
- 위 주입법들은 스프링 담당 컨테이너인 ApplicationContext나 BeanFactory에서 어노테이션 조건(컨트롤러, 서비스, 레포지토리 등)에 따라 
- 객체를 자동으로 new 키워드를 통해서 생성하고 인스턴스 변수로써 사용 가능하게 해준다.