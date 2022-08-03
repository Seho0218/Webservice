use lib_book;
show databases;

show tables;
select * from book;

create table book(
	ISBN integer primary key, -- 자료가 있다.
    BookName varchar(30) not null, -- 자료가 무조건 있어야된다.
    Author varchar(30) null,-- 없어도 된다.
    Publisher varchar(20), -- 자릿수가 20
    Pages int(20),
    writedate datetime default now()
    );
    -- alter table book add primary key (ISBN);
    alter table book add statement varchar(20);
    alter table book modify writedate varchar(20);
    select * from information_schema.table_constraints where table_schema='lib_book';
