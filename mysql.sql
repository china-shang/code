select (select distinct salary from Employee e order by salary desc limit 1,1 ) as  SecondHighestSalary
select IFNULL((select distinct salary from Employee e order by salary desc limit 1,1 ), NULL) as  SecondHighestSalary
# select 的临时表为空是返回NULL，distinct优先级高于order by， limit 从0开始
select Score, dense_rank() over(order by Score desc) as `Rank` from Scores; 
dense_rank() over排名，相同的合并为一个排名，占用一个名次 rank()相同的合并为一个排名，占用n个名次
