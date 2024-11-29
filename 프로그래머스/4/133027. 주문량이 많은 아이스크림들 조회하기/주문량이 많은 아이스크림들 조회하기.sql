SELECT fh.flavor
FROM FIRST_HALF fh
JOIN(
    SELECT flavor , sum(total_order) as total 
    FROM july
    GROUP BY flavor
) j
on j.flavor = fh.flavor 
ORDER BY j.total + fh.total_order desc
LIMIT 3