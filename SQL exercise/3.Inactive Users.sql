
/*
 Inactive Users 
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


























    
    