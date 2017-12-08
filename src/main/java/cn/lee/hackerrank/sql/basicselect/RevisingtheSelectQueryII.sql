/*
 https://www.hackerrank.com/challenges/revising-the-select-query-2/problem

Query the names of all American cities in CITY with populations larger than 120000. The CountryCode for America is USA.

Input Format

The CITY table is described as follows: CITY.jpg

*/

SELECT name
FROM CITY
WHERE population > 100000 AND CountryCode = 'USA'