/**


 */
SELECT
  c1.*,
  sum(total_submissions),
  sum(total_accepted_submissions),
  sum(total_views),
  sum(total_unique_views) f
FROM Contests c1
  JOIN Colleges c2 ON c1.contest_id = c2.contest_id
  JOIN Challenges c3 ON c2.College_id = c3.College_id
  left JOIN (SELECT
               challenge_id,
               sum(total_views)        total_views,
               sum(total_unique_views) total_unique_views
             FROM View_Stats
             GROUP BY challenge_id) vs ON c3.challenge_id = vs.challenge_id
  left JOIN (SELECT
               challenge_id,
               sum(total_submissions)          total_submissions,
               sum(total_accepted_submissions) total_accepted_submissions
             FROM Submission_Stats
             GROUP BY challenge_id) ss ON c3.challenge_id = ss.challenge_id

GROUP BY c1.contest_id,c1.hacker_id,c1.name

ORDER BY c1.contest_id