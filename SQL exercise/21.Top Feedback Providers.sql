
/*
 Top Feedback Providers 
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






















    
    