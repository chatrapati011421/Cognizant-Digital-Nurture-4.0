/*
Low Feedback Alerts 
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










    
    