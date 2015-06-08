
# $автор : Ю. Николай

# $дата: 2004/11/31 15:39 $
# БД для  matrix.dev.juga.ru

# drop table if exists postHistory;


create table if not exists postHistory
(
   PostID                       INT                            not null AUTO_INCREMENT,
   PostBody                     TEXT                           not null,
   CreationDate                 DATETIME              	       not null,
   UserIP			varchar(20),
   UserHOST	     		varchar(40),
   primary key (PostID)
);

