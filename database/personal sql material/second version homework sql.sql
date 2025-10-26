#(A)
SELECT eid, ename, salary
FROM Emp
WHERE salary BETWEEN 30000 AND 50000;
#(B)
SELECT Dept.managerid, Emp.ename
FROM Dept
JOIN Emp ON Dept.managerid = Emp.eid
WHERE Emp.salary = (SELECT MIN(salary) FROM Emp);
#(C)
SELECT Dept.did
FROM Dept
JOIN Works ON Dept.did = Works.did
JOIN Emp ON Works.eid = Emp.eid
GROUP BY Dept.did
HAVING SUM(Emp.salary) > Dept.budget;