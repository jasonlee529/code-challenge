/*
https://www.hackerrank.com/challenges/binary-search-tree-1/problem
 */

SELECT
  DISTINCT t1.n,
  CASE
  WHEN t1.p IS NULL THEN
    'Root'
  when n in (select distinct p from bst) then 'Inner'
  else 'Leaf' end p

FROM
  bst t1

order by t1.n