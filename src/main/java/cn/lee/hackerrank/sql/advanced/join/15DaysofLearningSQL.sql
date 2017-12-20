/**
https://www.hackerrank.com/challenges/15-days-of-learning-sql/problem
Julia conducted a  days of learning SQL contest. The start date of the contest was March 01, 2016 and the end date was March 15, 2016.

Write a query to print total number of unique hackers who made at least  submission each day (starting on the first day of the contest), and find the hacker_id and name of the hacker who made maximum number of submissions each day. If more than one such hacker has a maximum number of submissions, print the lowest hacker_id. The query should print this information for each day of the contest, sorted by the date.

Input Format

The following tables hold contest data:

Hackers: The hacker_id is the id of the hacker, and name is the name of the hacker.

Submissions: The submission_date is the date of the submission, submission_id is the id of the submission, hacker_id is the id of the hacker who made the submission, and score is the score of the submission.

Sample Input

For the following sample input, assume that the end date of the contest was March 06, 2016.

Hackers Table: Submissions Table:

Sample Output

2016-03-01 4 20703 Angela
2016-03-02 2 79722 Michael
2016-03-03 2 20703 Angela
2016-03-04 2 20703 Angela
2016-03-05 1 36396 Frank
2016-03-06 1 20703 Angela
Explanation

On March 01, 2016 hackers , , , and  made submissions. There are  unique hackers who made at least one submission each day. As each hacker made one submission,  is considered to be the hacker who made maximum number of submissions on this day. The name of the hacker is Angela.

On March 02, 2016 hackers , , and  made submissions. Now  and  were the only ones to submit every day, so there are  unique hackers who made at least one submission each day.  made  submissions, and name of the hacker is Michael.

On March 03, 2016 hackers , , and  made submissions. Now  and  were the only ones, so there are  unique hackers who made at least one submission each day. As each hacker made one submission so  is considered to be the hacker who made maximum number of submissions on this day. The name of the hacker is Angela.

On March 04, 2016 hackers , , , and  made submissions. Now  and  only submitted each day, so there are  unique hackers who made at least one submission each day. As each hacker made one submission so  is considered to be the hacker who made maximum number of submissions on this day. The name of the hacker is Angela.

On March 05, 2016 hackers , ,  and  made submissions. Now  only submitted each day, so there is only  unique hacker who made at least one submission each day.  made  submissions and name of the hacker is Frank.

On March 06, 2016 only  made submission, so there is only  unique hacker who made at least one submission each day.  made  submission and name of the hacker is Angela.
 */

SELECT
  t0.submission_date,
  t0.cnt,
  t.submission_id,
  h.name
FROM
  (SELECT
     s.submission_date,
     count(DISTINCT hacker_id) cnt
   FROM Submissions s
   GROUP BY s.submission_date) t0
  JOIN Submissions s
    ON (t0.submission_date = s.submission_date)
  JOIN (SELECT
          s.submission_date,
          max(submission_id) submission_id
        FROM Submissions s
        GROUP BY s.submission_date) t ON s.submission_date = t.submission_date AND s.submission_id = t.submission_id
  JOIN Hackers h ON s.hacker_id = h.hacker_id;

SELECT
  s.submission_date,
  count(DISTINCT hacker_id) cnt
FROM Submissions s
GROUP BY s.submission_date;

SELECT
  s.submission_date,
  max(submission_id) submission_id
FROM Submissions s
GROUP BY s.submission_date;

SELECT *
FROM Submissions s
  JOIN (SELECT
          s.submission_date,
          max(submission_id) submission_id
        FROM Submissions s
        GROUP BY s.submission_date) t ON s.submission_date = t.submission_date AND s.submission_id = t.submission_id;




SELECT
  submission_date,
  (
    SELECT
      COUNT(DISTINCT hacker_id)
    FROM
      Submissions s2
    WHERE
      s2.submission_date = s1.submission_date
      AND (
            SELECT
              COUNT(DISTINCT s3.submission_date)
            FROM
              Submissions s3
            WHERE
              s3.hacker_id = s2.hacker_id
              AND s3.submission_date < s1.submission_date
          ) = dateDIFF(
              s1.submission_date,
              '2016-03-01'
          )
  ),
  (
    SELECT
      hacker_id
    FROM
      submissions s2
    WHERE
      s2.submission_date = s1.submission_date
    GROUP BY
      hacker_id
    ORDER BY
      count(submission_id) DESC,
      hacker_id
    LIMIT 1
  ) AS shit,
  (
    SELECT
      NAME
    FROM
      hackers
    WHERE
      hacker_id = shit
  )
FROM
  (
    SELECT DISTINCT
      submission_date
    FROM
      submissions
  ) s1
GROUP BY
  submission_date