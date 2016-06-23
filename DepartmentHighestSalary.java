# Write your MySQL query statement below
SELECT d.Name Department, e.Name Employee, e.Salary
FROM Employee e, Department d
WHERE e.DepartmentId = d.Id AND (e.DepartmentId, e.Salary) 
IN (SELECT DepartmentId, MAX(Salary) FROM Employee GROUP BY DepartmentId) 