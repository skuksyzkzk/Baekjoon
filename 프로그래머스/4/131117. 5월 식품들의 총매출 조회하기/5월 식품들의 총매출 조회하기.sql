-- 코드를 입력하세요
SELECT fr.product_id,fr.product_name,SUM(fr.price * fo.amount) AS total_sales
FROM FOOD_PRODUCT fr
JOIN FOOD_ORDER fo on fr.product_id = fo.product_id
WHERE fo.produce_date >= '2022-05-01' and fo.produce_date <= '2022-05-31'
GROUP BY fo.product_id
ORDER BY total_sales desc,fo.product_id