/*
Top Rated Events 
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


    
    