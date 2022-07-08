# Write your MySQL query statement below
SELECT
    d.name AS Department,
    e.name AS Employee,
    salary
FROM Employee e
JOIN Department d on e.departmentId=d.id
WHERE (e.salary, e.departmentId) IN (
    SELECT 
        MAX(salary),
        departmentId
    FROM Employee
    GROUP BY departmentId
)