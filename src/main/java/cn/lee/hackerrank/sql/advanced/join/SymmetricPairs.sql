/**
https://www.hackerrank.com/challenges/symmetric-pairs/problem
You are given a table, Functions, containing two columns: X and Y.



Two pairs (X1, Y1) and (X2, Y2) are said to be symmetric pairs if X1 = Y2 and X2 = Y1.

Write a query to output all such symmetric pairs in ascending order by the value of X.

Sample Input



Sample Output

20 20
20 21
22 23
 */

SELECT DISTINCT
  f1.x,
  f1.y
FROM (SELECT
        @rownum := @rownum + 1 rownum,
        f.*
      FROM functions f
        JOIN (SELECT @rownum := 0) t) f1
  JOIN (SELECT
          @rownum2 := @rownum2 + 1 rownum,
          f.*
        FROM functions f
          JOIN (SELECT @rownum2 := 0) t) f2 ON f1.rownum <> f2.rownum AND f1.x = f2.y AND f1.y = f2.x AND f1.x <= f1.y
ORDER BY f1.x;