
/*
Event with Maximum Sessions 
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





















    
    