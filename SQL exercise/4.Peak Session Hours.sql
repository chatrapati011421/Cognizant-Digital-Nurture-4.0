
/*
Peak Session Hours 
Count how many sessions are scheduled between 10 AM to 12 PM for each event. 
*/

select
s.event_id,
count(*) as session_start_from_10AM_to_12PM

from Sessions s

where
Time(s.start_time) BETWEEN '10:00:00' and '12:00:00'

group by s.event_id;


















    
    