-- 코드를 입력하세요
SELECT mp.member_name, rr.review_text, date_format(rr.review_date,"%Y-%m-%d") AS REVIEW_DATE
FROM MEMBER_PROFILE mp
JOIN REST_REVIEW rr on rr.member_id = mp.member_id
WHERE mp.member_id = (
    SELECT member_id
    FROM REST_REVIEW 
    GROUP BY member_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
)
ORDER BY rr.review_date asc, rr.review_text asc