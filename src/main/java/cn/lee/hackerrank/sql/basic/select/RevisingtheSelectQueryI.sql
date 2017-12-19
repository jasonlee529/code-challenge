/*
 https://www.hackerrank.com/challenges/revising-the-select-query/problem

QUERY ALL COLUMNS FOR ALL American cities IN CITY WITH populations larger THAN 100000. The CountryCode FOR America IS USA.

Input FORMAT

The CITY TABLE IS described AS FOLLOWS :CITY.jpg

Easy
Submitted 198842 times
Max Score 10
Need HELP ?

VIEW Discussions
VIEW Editorial Solution
VIEW Top Submissions
Rate This Challenge:
Download problem statement
Download sample test cases
Suggest Edits
CURRENT Buffer (saved locally, editable)
MySQL

*/

SELECT *
FROM CITY
WHERE population > 100000 AND CountryCode = 'USA'