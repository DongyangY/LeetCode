# Write your MySQL query statement below
SELECT w1.Id FROM Weather w1, Weather w2 
WHERE DATEDIFF(w1.Date, w2.Date) = 1 AND w2.Temperature < w1.Temperature