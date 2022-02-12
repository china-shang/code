select (select distinct salary from Employee e order by salary desc limit 1,1 ) as  SecondHighestSalary
select IFNULL((select distinct salary from Employee e order by salary desc limit 1,1 ), NULL) as  SecondHighestSalary
# select 的临时表为空是返回NULL，distinct优先级高于order by， limit 从0开始

select Score, dense_rank() over(order by Score desc) as `Rank` from Scores; 
# dense_rank() over排名，相同的合并为一个排名，占用一个名次 rank()相同的合并为一个排名，占用n个名次

select distinct t1.Num as ConsecutiveNums from Logs t1, Logs t2, Logs t3 where t1.Num = t2.Num and t2.Num = t3.Num and t1.Id = t2.Id - 1 and t2.Id = t3.Id - 1;
select distinct t1.Num as ConsecutiveNums from Logs t1 join  Logs t2 on t1.Num = t2.Num join  Logs t3 on t2.Num = t3.Num where t1.Id = t2.Id - 1 and t2.Id = t3.Id -1;
# 连续的3个同样Num的Num 180 from t1, t2, t3执行笛卡尔积

select d.name as Department, e.name as Employee, e.salary as  Salary from Employee e join (select departmentId, Max(salary) as maxSalary from Employee group by departmentId) as t
on e.departmentId = t.departmentId and e.salary = t.maxSalary join Department d on e.departmentId=d.id
# 部门最高工资 184

