create table user (
userID varchar(20),
userPassword varchar(20),
userName varchar(20),
userAge int,
userGender varchar(20),
userEmail varchar(50),
userProfile varchar(50)
);

create table chat (
chatID int primary key auto_increment,
fromID varchar(20),
toID varchar(20),
chatContent varchar(100),
chatTime datetime
);