-- (MovieReservation.sql)

/* 영화 예매 프로그램 */
-- 회원(memberId, pwd, name, phone, addr)
-- 영화(title, director, actor, genre, time, nation, openDate)
-- 예매(memberId, title, businessName, startTime, sit)

-- moviedb  사용
use moviedb;

-- 테이블 삭제
drop table 예매;
drop table 영화;
drop table 회원;

-- 테이블 생성
-- 회원(memberId, pwd, name, phone, addr)
create table 회원(
	memberId char(5) not null,
    pwd varchar(10) ,
    name varchar(20) ,
    phone varchar(30) ,
    addr varchar(50) ,
    primary key(memberId)
);

-- 영화(title, director, actor, genre, time, nation, openDate)
create table 영화(
    title varchar(20) not null,
    director varchar(20) ,
    actor varchar(20) ,
    genre varchar(20) ,
    time varchar(20) ,
    nation varchar(20) ,
    openDate varchar(30) ,
    primary key(title)
);

-- 예매(memberId, title, businessName, startTime, sit)
create table 예매(
	memberId char(5) not null,
    title varchar(20) not null,
    businessName varchar(20) not null,
    startTime varchar(10) not null,
    sit varchar(10) not null,
    primary key(memberId, title, businessName, startTime, sit) ,
    foreign key(memberId) references 회원(memberId) ,
    foreign key(title) references 영화(title)
);

-- 데이터 입력
-- 회원(memberId, pwd, name, phone, addr)
insert into 회원 values('m0001', '1234', '전채린', '010-0000-0001', '서울시 구로구');
insert into 회원 values('m0002', '2345', '이바다', '010-0000-0002', '서울시 영등포구');
insert into 회원 values('m0003', '3456', '김보아', '010-0000-0003', '서울시 양천구');
insert into 회원 values('m0004', '4567', '유민선', '010-0000-0004', '서울시 강서구');
insert into 회원 values('m0005', '5678', '최나영', '010-0000-0005', '서울시 마포구');

-- 영화(title, director, actor, genre, time, nation, openDate)
insert into 영화 values('컨저링 3', '마이클 차베즈', '베라 파미가', '공포', '111분', '미국', '2021-06-03');
insert into 영화 values('크루엘라', '크레이그 질레스피', '엠마 스톤', '드라마', '133분', '미국', '2021-05-26');
insert into 영화 values('캐시트럭', '가이 리치', '제이슨 스타뎀', '액션', '119분', '미국', '2021-06-09');
insert into 영화 values('분노의 질주', '저스틴 린', '빈 디젤', '액션', '142분', '미국', '2021-05-19');
insert into 영화 values('파이프라인', '유하', '서인국', '범죄', '108분', '한국', '2021-05-26');
insert into 영화 values('실크로드', '틸러 러셀', '닉 로빈슨', '범죄', '116분', '미국', '2021-06-09');
insert into 영화 values('낫아웃', '이정곤', '정재광', '드라마', '107분', '한국', '2021-06-03');

-- 예매(memberId, title, businessName, startTime, sit)
insert into 예매 values('m0001', '컨저링 3', '강남', '09:00', 'A01');
insert into 예매 values('m0001', '크루엘라', '미아', '10:00', 'A02');
insert into 예매 values('m0002', '캐시트럭', '강변', '11:00', 'A03');
insert into 예매 values('m0002', '분노의 질주', '구로', '12:00', 'A04');
insert into 예매 values('m0003', '실크로드', '목동', '13:00', 'A05');
insert into 예매 values('m0003', '컨저링 3', '용산아이파크몰', '14:00', 'B01');
insert into 예매 values('m0003', '낫아웃', '불광', '15:00', 'B02');
insert into 예매 values('m0004', '캐시트럭', '대학로', '16:00', 'B03');
insert into 예매 values('m0004', '분노의 질주', '명동', '17:00', 'B04');
insert into 예매 values('m0004', '낫아웃', '왕십리', '18:00', 'B05');
insert into 예매 values('m0005', '컨저링 3', '성신여대입구', '19:00', 'C01');
insert into 예매 values('m0005', '실크로드', '송파', '20:00', 'C02');
insert into 예매 values('m0005', '캐시트럭', '영등포', '21:00', 'C03');

-- 데이터 검색
select * from 회원;
select * from 영화;
select * from 예매;
