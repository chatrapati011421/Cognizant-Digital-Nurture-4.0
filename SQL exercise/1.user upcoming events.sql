
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




















