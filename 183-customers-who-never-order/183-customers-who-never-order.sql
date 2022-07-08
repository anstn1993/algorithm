# Write your MySQL query statement below
SELECT name as Customers FROM Customers 
WHERE id NOT IN(SELECT DISTINCT o.customerId FROM Orders o
JOIN Customers c on o.customerId = c.id)