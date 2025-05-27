/*
 Average Rating per City 
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















    
    