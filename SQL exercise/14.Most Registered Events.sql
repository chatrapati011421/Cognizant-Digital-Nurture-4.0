/*
Most Registered Events 
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


    
    