/**
https://www.hackerrank.com/challenges/contest-leaderboard/problem

You did such a great job helping Julia with her last coding contest challenge that she wants you to work on this one, too!

The total score of a hacker is the sum of their maximum scores for all of the challenges. Write a query to print the hacker_id, name, and total score of the hackers ordered by the descending score. If more than one hacker achieved the same total score, then sort the result by ascending hacker_id. Exclude all hackers with a total score of  from your result.

Input Format

The following tables contain contest data:

Hackers: The hacker_id is the id of the hacker, and name is the name of the hacker.

Submissions: The submission_id is the id of the submission, hacker_id is the id of the hacker who made the submission, challenge_id is the id of the challenge for which the submission belongs to, and score is the score of the submission.

Sample Input

Hackers Table:

Submissions Table:

Sample Output

4071 Rose 191
74842 Lisa 174
84072 Bonnie 100
4806 Angela 89
26071 Frank 85
80305 Kimberly 67
49438 Patrick 43
Explanation

Hacker 4071 submitted solutions for challenges 19797 and 49593, so the total score .

Hacker 74842 submitted solutions for challenges 19797 and 63132, so the total score

Hacker 84072 submitted solutions for challenges 49593 and 63132, so the total score .

The total scores for hackers 4806, 26071, 80305, and 49438 can be similarly calculated.
 */


/*
Enter your query here.
*/
SELECT
  h.hacker_id,
  h.name,
  t2.score
FROM Hackers h
  JOIN (
         SELECT
           hacker_id,
           sum(score) score
         FROM (
                SELECT
                  s.hacker_id,
                  s.challenge_id,
                  max(score) score
                FROM Submissions s
                GROUP BY s.hacker_id, s.challenge_id) t
         GROUP BY t.hacker_id
         HAVING score > 0) t2 ON h.hacker_id = t2.hacker_id
ORDER BY t2.score DESC, h.hacker_id