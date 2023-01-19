create database CollegeExamination2
on
primary (
name = CollegeExaminationPrimary ,
filename = 'D:\FCAIHU\2022-2023\Programming 3\Project\Database/CollegeExamination2.mdf',
size = 10MB ,
filegrowth = 5%
)
log on (
name = CollegeExaminationLog ,
filename = 'D:\FCAIHU\2022-2023\Programming 3\Project\Database/CollegeExamination2.ldf',
size = 9MB ,
filegrowth = 5%
)