# Задания для кандидатов

## Описание задания

**1 Задание**

<p>&nbsp;</p>

Напишите на своём любимом языке функцию преобразования целого числа в строку прописью. 

Функция должна поддерживать вывод в любом падеже и в любом роде.

**Прототип функции**

string sumProp(int nSum, string sGender, string sCase);

**Параметры:**

nSum - целое число менее триллиона (максимум 999 999 999 999).

sGender - род:

"М" - мужской

"Ж" - женский

"С" - средний

sCase - падеж:

"И" - именительный

"Р" - родительный

"Д" - дательный

"В" - винительный

"Т" - творительный

"П" - предложный



**Примеры вызова функции и ожидаемые результаты**


sumProp(31, "М", "Р")	"тридцати одного"

sumProp(22, "С", "Т")	"двадцатью двумя"

sumProp(154323, "М", "И")	"сто пятьдесят четыре тысячи триста двадцать три"

sumProp(154323, "М", "Т")	"ста пятьюдесятью четырьмя тысячами тремястами двадцатью тремя"


<p>&nbsp;</p>

**2 Задание**

<p>&nbsp;</p>
**Проектирование схемы базы данных**

**Описание задания**

Спроектируйте схему базы данных, предназначенной для составления расписания занятий в ВУЗе. 

Вам не нужно тщательно продумывать детали, например, длину строковых полей или способ представления адреса.

**Требования**

1. Изобразите таблицы в виде прямоугольников.
   
2. Связи между таблицами обозначьте стрелками.
   
3. Укажите минимально необходимый набор полей для каждой таблицы.
   
4. При необходимости добавьте жизненно важные индексы.
   
5. Обеспечьте комментарии для неочевидных фрагментов схемы, чтобы пояснить, что и с какой целью создано.

**Формат**

Ожидается, что итоговая схема будет содержать от 15 до 25 таблиц и будет размещаться на 1-2 листах формата A4.



**Проектирование**

База данных: 

MySQL

P.S – Также без проблем выполню задание в PostgreSQL

**Название:**

UniversitySchedule (Университетское расписание)

**Состав:** 

22 таблицы (сущности) связанные между собой внешними и первичными ключами и включающие создание индексов там где требуется.

**Краткое описание сущностей:**

Faculties: Хранит информацию о факультетах университета.

AcademicDepartments: Хранит информацию о департаментах (кафед-рах), которые Students: Хранит информацию о студентах.

Professors: Хранит информацию о преподавателях.

Courses: Хранит информацию о курсах, предлагаемых университетом.

StudentGroups: Хранит информацию о группах студентов, обучаю-щихся на определенных курсах.

Rooms: Хранит информацию об аудиториях, доступных для занятий.

Schedule: Хранит расписание занятий, включая курсы, преподавателей и аудитории.

Curricula: Хранит учебные планы, связывая курсы и группы студен-тов.

Enrollments: Хранит информацию о том, какие студенты записаны на какие курсы.

CourseEvaluations: Хранит оценки преподавателей курсов.

Attendance: Хранит информацию о посещаемости студентов на заняти-ях.

ExamSchedules: Хранит расписание экзаменов, включая курсы, препо-давателей и аудитории.

CourseMaterials: Хранит материалы для курсов, такие как лекционные заметки, задания и экзамены.

CourseRequests: Хранит заявки студентов на курсы.

ProfessorAssignments: Хранит информацию о назначении преподавате-лей на курсы.

StudentProjects: Хранит информацию о проектах студентов.

Mentors: Хранит информацию о наставниках студентов.

CourseGroups: Хранит информацию о группах курсов, связывая кур-сы с группами.

TimeSlots: Хранит информацию о временных слотах для расписаний.

CourseResources: Хранит информацию о ресурсах для курсов, таких как учебники и оборудование.

StudentGrades: Хранит информацию о результатах студентов по кур-сам.

SemesterPlans: Хранит планы на семестр для курсов.


**Информация:**

Создание базы и таблиц спроектировано в файле create_tables.sql

Чтобы выполнить проектирование базы и таблиц напишите в терминале команду: mysql -u your_username -p < create_tables.sql

**Проектирование:**

CREATE DATABASE UniversitySchedule;

USE UniversitySchedule;


**-- Таблица для хранения информации о факультетах**

CREATE TABLE Faculties (

    faculty_id INT AUTO_INCREMENT PRIMARY KEY,
    
    faculty_name VARCHAR (100) NOT NULL,
    
    INDEX (faculty_name) -- Индекс на поле faculty_name для быстрого поиска факультетов по имени
    
);



**-- Таблица для хранения информации о департаментах (кафедрах)**

CREATE TABLE AcademicDepartments (

    department_id INT AUTO_INCREMENT PRIMARY KEY,
    
    department_name VARCHAR (100) NOT NULL,
    
    faculty_id INT,
    
    INDEX (department_name), -- Индекс на поле department_name для быстрого поиска департаментов по имени
    
    FOREIGN KEY (faculty_id) REFERENCES Faculties(faculty_id) -- Связь с таблицей Faculties
    
);


**-- Таблица для хранения информации о студентах**

CREATE TABLE Students (

    student_id INT AUTO_INCREMENT PRIMARY KEY,
    
    first_name VARCHAR (50) NOT NULL,
    
    last_name VARCHAR (50) NOT NULL,
    
    email VARCHAR (100) UNIQUE NOT NULL,
    
    phone VARCHAR (20),
    
    INDEX (email) -- Индекс на поле email для быстрого поиска студентов по электронной почте
    
);


**-- Таблица для хранения информации о преподавателях**

CREATE TABLE Professors (

    professor_id INT AUTO_INCREMENT PRIMARY KEY,
    
    first_name VARCHAR (50) NOT NULL,
    
    last_name VARCHAR (50) NOT NULL,
    
    email VARCHAR (100) UNIQUE NOT NULL,
    
    phone VARCHAR (20),
    
    department_id INT,
    
    INDEX (email), -- Индекс на поле email для быстрого поиска преподавателей по электронной почте
    
    FOREIGN KEY (department_id) REFERENCES AcademicDepartments(department_id) -- Связь с таблицей AcademicDepartments
    
);


**-- Таблица для хранения информации о курсах**

CREATE TABLE Courses (

    course_id INT AUTO_INCREMENT PRIMARY KEY,
    
    course_name VARCHAR (100) NOT NULL,
    
    course_code VARCHAR (20) UNIQUE NOT NULL,
    
    credits INT NOT NULL,
    
    department_id INT,
    
    INDEX (course_code), -- Индекс на поле course_code для быстрого поиска курсов по коду
    
    FOREIGN KEY (department_id) REFERENCES AcademicDepartments(department_id) -- Связь с таблицей AcademicDepartments
    
);


**-- Таблица для хранения информации о группах студентов**

CREATE TABLE StudentGroups (

    group_id INT AUTO_INCREMENT PRIMARY KEY,
    
    group_name VARCHAR (50) NOT NULL,
    
    course_id INT,
    
    INDEX (group_name), -- Индекс на поле group_name для быстрого поиска групп по имени
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) -- Связь с таблицей Courses
    
);


**-- Таблица для хранения информации о аудиториях**

CREATE TABLE Rooms (

    room_id INT AUTO_INCREMENT PRIMARY KEY,
    
    room_number VARCHAR (10) NOT NULL,
    
    capacity INT NOT NULL,
    
    INDEX (room_number) -- Индекс на поле room_number для быстрого поиска аудиторий по номеру
    
);


**-- Таблица для хранения информации о расписании занятий**

CREATE TABLE Schedule (

    schedule_id INT AUTO_INCREMENT PRIMARY KEY,
    
    course_id INT,
    
    professor_id INT,
    
    room_id INT,
    
    start_time TIME NOT NULL,
    
    end_time TIME NOT NULL,
    
    day_of_week ENUM ('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday') NOT NULL,
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска расписаний по курсу
    
    INDEX (professor_id), -- Индекс на поле professor_id для быстрого поиска расписаний по преподавателю
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id), -- Связь с таблицей Courses
    
    FOREIGN KEY (professor_id) REFERENCES Professors(professor_id), -- Связь с таблицей Professors
    
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id) -- Связь с таблицей Rooms
    
);


**-- Таблица для хранения информации об учебных планах**

CREATE TABLE Curricula (

    curriculum_id INT AUTO_INCREMENT PRIMARY KEY,
    
    course_id INT,
    
    student_group_id INT,
    
    semester ENUM ('Fall', 'Spring', 'Summer') NOT NULL,
    
    year YEAR NOT NULL,
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска учебных планов по курсу
    
    INDEX (student_group_id), -- Индекс на поле student_group_id для быстрого поиска учебных планов по группе студентов
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id), -- Связь с таблицей Courses
    
    FOREIGN KEY (student_group_id) REFERENCES StudentGroups(group_id) -- Связь с таблицей StudentGroups
    
);


**-- Таблица для хранения информации о записях студентов на курсы**

CREATE TABLE Enrollments (

    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
    
    student_id INT,
    
    course_id INT,
    
    grade ENUM ('A', 'B', 'C', 'D', 'F'),
    
    INDEX (student_id), -- Индекс на поле student_id для быстрого поиска записей по студенту
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска записей по курсу
    
    FOREIGN KEY (student_id) REFERENCES Students(student_id), -- Связь с таблицей Students
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) -- Связь с таблицей Courses
    
);


**-- Таблица для хранения информации об оценках преподавателей курсов**

CREATE TABLE CourseEvaluations (

    evaluation_id INT AUTO_INCREMENT PRIMARY KEY,
    
    professor_id INT,
    
    course_id INT,
    
    evaluation_date DATE NOT NULL,
    
    rating TINYINT NOT NULL CHECK (rating BETWEEN 1 AND 5),
    
    INDEX (professor_id), -- Индекс на поле professor_id для быстрого поиска оценок по преподавателю
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска оценок по курсу
    
    FOREIGN KEY (professor_id) REFERENCES Professors(professor_id), -- Связь с таблицей Professors
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) -- Связь с таблицей Courses
    
);


**-- Таблица для хранения истории посещений занятий**

CREATE TABLE Attendance (

    attendance_id INT AUTO_INCREMENT PRIMARY KEY,
    
    student_id INT,
    
    schedule_id INT,
    
    date DATE NOT NULL,
    
    status ENUM ('Present', 'Absent') NOT NULL,
    
    INDEX (student_id), -- Индекс на поле student_id для быстрого поиска посещений по студенту
    
    INDEX (schedule_id), -- Индекс на поле schedule_id для быстрого поиска посещений по расписанию
    
    FOREIGN KEY (student_id) REFERENCES Students(student_id), -- Связь с таблицей Students
    
    FOREIGN KEY (schedule_id) REFERENCES Schedule(schedule_id) -- Связь с таблицей Schedule
    
);


**-- Таблица для хранения информации о расписаниях для экзаменов**

CREATE TABLE ExamSchedules (

    exam_schedule_id INT AUTO_INCREMENT PRIMARY KEY,
    
    course_id INT,
    
    professor_id INT,
    
    room_id INT,
    
    exam_date DATE NOT NULL,
    
    start_time TIME NOT NULL,
    
    end_time TIME NOT NULL,
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска расписаний экзаменов по курсу
    
    INDEX (professor_id), -- Индекс на поле professor_id для быстрого поиска расписаний экзаменов по преподавателю
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id), -- Связь с таблицей Courses
    
    FOREIGN KEY (professor_id) REFERENCES Professors(professor_id), -- Связь с таблицей Professors
    
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id) -- Связь с таблицей Rooms
    
);


**-- Таблица для хранения информации о материалах курсов**

CREATE TABLE CourseMaterials (

    material_id INT AUTO_INCREMENT PRIMARY KEY,
    
    course_id INT,
    
    material_type ENUM ('Lecture Notes', 'Assignment', 'Exam', 'Reference') NOT NULL,
    
    material_link VARCHAR (255),
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска материалов по курсу
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) -- Связь с таблицей Courses
    
);


**-- Таблица для хранения информации о заявках на курсы**

CREATE TABLE CourseRequests (

    request_id INT AUTO_INCREMENT PRIMARY KEY,
    
    student_id INT,
    
    course_id INT,
    
    request_date DATE NOT NULL,
    
    status ENUM ('Pending', 'Approved', 'Rejected') NOT NULL,
    
    INDEX (student_id), -- Индекс на поле student_id для быстрого поиска заявок по студенту
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска заявок по курсу
    
    FOREIGN KEY (student_id) REFERENCES Students(student_id), -- Связь с таблицей Students
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) -- Связь с таблицей Courses
    
);


**-- Таблица для хранения информации о преподавателях, участвующих в курсе**

CREATE TABLE ProfessorAssignments (

    assignment_id INT AUTO_INCREMENT PRIMARY KEY,
    
    professor_id INT,
    
    course_id INT,
    
    semester ENUM ('Fall', 'Spring', 'Summer') NOT NULL,
    
    year YEAR NOT NULL,
    
    INDEX (professor_id), -- Индекс на поле professor_id для быстрого поиска назначений преподавателей
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска назначений по курсу
    
    FOREIGN KEY (professor_id) REFERENCES Professors(professor_id), -- Связь с таблицей Professors
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) -- Связь с таблицей Courses
    
);


**-- Таблица для хранения информации о студенческих проектах**

CREATE TABLE StudentProjects (

    project_id INT AUTO_INCREMENT PRIMARY KEY,
    
    project_name VARCHAR (100) NOT NULL,
    
    student_id INT,
    
    course_id INT,
    
    project_description TEXT,
    
    INDEX (student_id), -- Индекс на поле student_id для быстрого поиска проектов по студенту
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска проектов по курсу
    
    FOREIGN KEY (student_id) REFERENCES Students(student_id), -- Связь с таблицей Students
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) -- Связь с таблицей Courses
    
);


**-- Таблица для хранения информации о наставниках студентов**

CREATE TABLE Mentors (

    mentor_id INT AUTO_INCREMENT PRIMARY KEY,
    
    professor_id INT,
    
    student_id INT,
    
    mentorship_start DATE NOT NULL,
    
    mentorship_end DATE,
    
    INDEX (professor_id), -- Индекс на поле professor_id для быстрого поиска наставников по преподавателю
    
    INDEX (student_id), -- Индекс на поле student_id для быстрого поиска наставников по студенту
    
    FOREIGN KEY (professor_id) REFERENCES Professors(professor_id), -- Связь с таблицей Professors
    
    FOREIGN KEY (student_id) REFERENCES Students(student_id) -- Связь с таблицей Students
    
);


**-- Таблица для хранения информации о группах курсов**

CREATE TABLE CourseGroups (

    course_group_id INT AUTO_INCREMENT PRIMARY KEY,
    
    course_id INT,
    
    group_name VARCHAR(50) NOT NULL,
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска групп по курсу
    
    INDEX (group_name), -- Индекс на поле group_name для быстрого поиска групп по имени
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) -- Связь с таблицей Courses
    
);


**-- Таблица для хранения информации о временных слотах для расписаний**

CREATE TABLE TimeSlots (

    slot_id INT AUTO_INCREMENT PRIMARY KEY,
    
    start_time TIME NOT NULL,
    
    end_time TIME NOT NULL,
    
    day_of_week ENUM ('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday') NOT NULL,
    
    INDEX (start_time, end_time) -- Индекс на поля start_time и end_time для быстрого поиска временных слотов
    
);


**-- Таблица для хранения связей между курсами и ресурсами**

CREATE TABLE CourseResources (

    resource_id INT AUTO_INCREMENT PRIMARY KEY,
    
    course_id INT,
    
    resource_type ENUM ('Textbook', 'Software', 'Equipment') NOT NULL,
    
    resource_name VARCHAR (100) NOT NULL,
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска ресурсов по курсу
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) -- Связь с таблицей Courses
    
);


**-- Таблица для хранения информации о студенческих оценках**

CREATE TABLE StudentGrades (

    grade_id INT AUTO_INCREMENT PRIMARY KEY,
    
    student_id INT,
    
    course_id INT,
    
    grade ENUM ('A', 'B', 'C', 'D', 'F') NOT NULL,
    
    INDEX (student_id), -- Индекс на поле student_id для быстрого поиска оценок по студенту
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска оценок по курсу
    
    FOREIGN KEY (student_id) REFERENCES Students(student_id), -- Связь с таблицей Students
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) -- Связь с таблицей Courses
    
);


**-- Таблица для хранения информации о планах семестров**

CREATE TABLE SemesterPlans (

    plan_id INT AUTO_INCREMENT PRIMARY KEY, 
    
    course_id INT,
    
    semester ENUM ('Fall', 'Spring', 'Summer') NOT NULL,
    
    year YEAR NOT NULL,
    
    INDEX (course_id), -- Индекс на поле course_id для быстрого поиска планов по курсу
    
    FOREIGN KEY (course_id) REFERENCES Courses(course_id) -- Связь с таблицей Courses
    
);


**ER-Диаграмма**

<p>&nbsp;</p>
![image](https://github.com/user-attachments/assets/08578942-6725-4d3e-aeb1-4bd5d5c73c6f)

