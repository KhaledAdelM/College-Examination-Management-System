use CollegeExamination2

create table Module (
Id int primary key,
Name varchar (50) ,
)

create table Users (
Id int identity(25000 ,1) primary key,
Name nvarchar (50) ,
Email nvarchar (100) ,
Birthday date,
Username nvarchar (50) ,
Password nvarchar (50) ,
Id_Module int foreign key references Module (Id) on delete cascade on update cascade,
)


create table Subject (
Id int identity(1 ,1) primary key,
Name nvarchar (20) ,
Details nvarchar (120) 
)
create table AssignSubject (
Id_Subject int primary key foreign key references Subject (Id) on delete cascade on update cascade,
Id_Lecturer int foreign key references Users (Id) on delete cascade on update cascade
)
create table SubjectOfStudent (
Id_Subject int foreign key references Subject (Id) on delete cascade on update cascade,
Id_Student int foreign key references Users (Id) on delete cascade on update cascade
)


create table Exam (
Id int identity(1 ,1) primary key,
Id_Subject int foreign key references Subject (Id) on delete cascade on update cascade,
Name nvarchar (20) ,
Details nvarchar (120) 
)

create table Question (
Id int identity( 1 ,1) primary key,
Id_Exam int foreign key references Exam (Id) on delete cascade on update cascade,
Question varchar (100) ,
Degree int
)

create table Choice (
Id int identity( 1 ,1) primary key,
Id_Question int foreign key references Question (Id) on delete cascade on update cascade,
Choice varchar (100),
T_F bit DEFAULT 0
)
create table StudentDegree (
Id int identity( 1 ,1) primary key,
Id_Exam int foreign key references Exam (Id) on delete cascade on update cascade,
Id_Student int foreign key references Users (Id) on delete cascade on update cascade,
Degree int
)

create table StudentReport (
Id int identity( 1 ,1) primary key,
Id_Exam int foreign key references Exam (Id) on delete cascade on update cascade,
Id_Lecturer int foreign key references Users (Id) on delete cascade on update cascade,
Id_Student int foreign key references Users (Id) ,
Report varchar (100),
)
