# Write your MySQL query statement below
SELECT s1.Score, COUNT(Id) Rank 
FROM Scores s1, (SELECT DISTINCT Score FROM Scores) s2
WHERE s1.Score <= s2.Score GROUP BY Id ORDER BY Rank