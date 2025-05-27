-- Creating the tables

-- Users table

CREATE TABLE Users (
user_id int AUTO_INCREMENT PRIMARY KEY,
full_name varchar(100) NOT NULL,
email varchar(100) UNIQUE NOT NULL,
city varchar(100) NOT NULL,
registration_date date NOT NULL
);

INSERT INTO Users (full_name,email,city,registration_date)
VALUES ('Alice Johnson','alice@gmail.com','New York','2024-12-01'),
('Bob Smith','bob@gmail.com','Los Angeles','2024-12-05'),
('Charlie Lee','charlie@gmail.com','Chicago','2024-12-10'),
('Diana King','diana@gmail.com','New York','2025-01-15'),
('Ethen Hunt','ethen@gmail.com','Los Angeles','2025-02-01');

select * from Users;

-- Events table

CREATE TABLE Events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,                        
    title VARCHAR(200) NOT NULL,                                    
    description TEXT,                                               
    city VARCHAR(100) NOT NULL,                                     
    start_date DATETIME NOT NULL,                                   
    end_date DATETIME NOT NULL,                                     
    status ENUM('upcoming', 'completed', 'cancelled') DEFAULT 'upcoming',
    organizer_id INT,                                               
    FOREIGN KEY (organizer_id) REFERENCES Users(user_id)            
);


INSERT INTO Events (title, description, city, start_date, end_date, status, organizer_id) 
VALUES ('Tech Innovators Meetup', 'A meetup for tech enthusiasts.', 'New York', 
'2025-06-10 10:00:00', '2025-06-10 16:00:00', 'upcoming', 1), 
('AI & ML Conference', 'Conference on AI and ML advancements.', 'Chicago', 
'2025-05-15 09:00:00', '2025-05-15 17:00:00', 'completed', 3), 
('Frontend Development Bootcamp', 'Hands-on training on frontend tech.', 'Los Angeles', 
'2025-07-01 10:00:00', '2025-07-03 16:00:00', 'upcoming', 2);

select * from Events;

-- Sessions table

CREATE TABLE Sessions (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

INSERT INTO Sessions (event_id, title, speaker_name, start_time, end_time) 
VALUES (1, 'Opening Keynote', 'Dr. Tech', '2025-06-10 10:00:00', '2025-06-10 11:00:00'),
(1, 'Future of Web Dev', 'Alice Johnson', '2025-06-10 11:15:00', '2025-06-10 12:30:00'),
(2, 'AI in Healthcare', 'Charlie Lee', '2025-05-15 09:30:00', '2025-05-15 11:00:00'),
(3, 'Intro to HTML5', 'Bob Smith', '2025-07-01 10:00:00', '2025-07-01 12:00:00');

Select * from Sessions;
-- Registrations table

CREATE TABLE Registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    registration_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

INSERT INTO Registrations (user_id, event_id, registration_date) 
VALUES (1, 1, '2025-05-01'),
(2, 1, '2025-05-02'),
(3, 2, '2025-04-30'),
(4, 2, '2025-04-28'),
(5, 3, '2025-06-15');

Select * from Registrations;

-- Feedback table

CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comments TEXT,
    feedback_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

INSERT INTO Feedback (user_id, event_id, rating, comments, feedback_date) 
VALUES (3, 2, 4, 'Great insights!', '2025-05-16'),
(4, 2, 5, 'Very informative.', '2025-05-16'),
(2, 1, 3, 'Could be better.', '2025-06-11');

select * from Feedback;

-- Resources table

CREATE TABLE Resources (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    resource_type ENUM('pdf', 'image', 'link'),
    resource_url VARCHAR(255) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

INSERT INTO Resources (event_id, resource_type, resource_url, uploaded_at) 
VALUES (2, 'pdf', 'https://portal.com/resources/tech_meetup_agenda.pdf', '2025-05-01 10:00:00'),
(2, 'image', 'https://portal.com/resources/ai_poster.jpg', '2025-04-20 09:00:00'),
(3, 'link', 'https://portal.com/resources/html5_docs', '2025-06-25 15:00:00');

select * from resources;

-- Queries:

/*
1. User Upcoming Events 
Show a list of all upcoming events a user is registered for in their city, sorted by date. 

*/

select
u.full_name,
e.title as event_title,
e.city,
e.start_date,
e.end_date,e.status

from Users u

join Registrations r on u.user_id = r.user_id

join Events e on e.event_id = r.event_id

where e.status = 'upcoming' AND
e.city = u.city

order by e.start_date;


/*
2.Top Rated Events 
Identify events with the highest average rating, considering only those that have received at 
least 10 feedback submissions. 
*/

select
e.event_id,
e.title as Event_title,
count(f.feedback_id) as feedback_count,
avg(f.rating) as average_rating

from Events e

join Feedback f on f.event_id =e.event_id

group by e.event_id,e.title

having count(f.feedback_id) >=10

order by
average_rating desc;


/*
 3.Inactive Users 
Retrieve users who have not registered for any events in the last 90 days. 
*/

select 
u.user_id,
u.full_name,
max(r.registration_date) as Max_Registration

from Users u

left join Registrations r on u.user_id=r.user_id

group by 
u.user_id,u.full_name

having
Max_Registration is NULL

or Max_Registration < CURDATE() - interval 90 DAY;


/*
4.Peak Session Hours 
Count how many sessions are scheduled between 10 AM to 12 PM for each event. 
*/

select
s.event_id,
count(*) as session_start_from_10AM_to_12PM

from Sessions s

where
Time(s.start_time) BETWEEN '10:00:00' and '12:00:00'

group by s.event_id;


/*
7.Low Feedback Alerts 
List all users who gave feedback with a rating less than 3, along with their comments and 
associated event names.
*/

select
u.full_name,
e.title,
f.comments,
f.rating

from Feedback f

join Users u on f.user_id=u.user_id

join Events e on f.event_id=e.event_id

where 
f.rating < 3;



/*
10.Feedback Gap 
Identify events that had registrations but received no feedback at all. 
*/

SELECT DISTINCT
    e.event_id,
    e.title
FROM 
    Events e
JOIN 
    Registrations r ON e.event_id = r.event_id
LEFT JOIN 
    Feedback f ON e.event_id = f.event_id
WHERE 
    f.feedback_id IS NULL;




/*
12.Event with Maximum Sessions 
List the event(s) with the highest number of sessions.

*/

select
e.event_id,
e.title as Event_name,
count(s.session_id) as session_count
from Events e

join Sessions s on e.event_id = s.event_id

group by
e.event_id

order by
session_count desc;


/*
 13.Average Rating per City 
Calculate the average feedback rating of events conducted in each city. 

*/
select
e.city,
round(avg(f.rating),2) as average_rating

from Feedback f  

join Events e on f.event_id = e.event_id

group by 
e.city

order by 
average_rating desc;


/*
14.Most Registered Events 
List top 3 events based on the total number of user registrations.

*/
select
e.event_id,
e.title,
count(r.user_id) as total_registrations
from Events e

join Registrations r on r.event_id=e.event_id

group by
e.event_id,e.title

order by total_registrations desc

limit 3;


/*
21.Top Feedback Providers 
List top 5 users who have submitted the most feedback entries. 
*/

select
u.user_id,
u.full_name,
count(f.user_id) as feedback_count
from Users u

join Feedback f on f.user_id=u.user_id

group by 
u.user_id,u.full_name

order by 
feedback_count desc

limit 5;