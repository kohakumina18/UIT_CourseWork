SET SERVEROUTPUT ON;

--cau01: warm up 
select NAME AS TenKhachHang, ID as MaKhachHang
from S_CUSTOMER
ORDER BY ID DESC;
//

--CAU07: NHAN VIEN PHONG 31, 42, 50  VOI LUONG >1350 
SELECT LAST_NAME ||' '||  FIRST_NAME AS EMPLOYEE_NAME, SALARY AS MONTHLY_SALARY
FROM S_EMP 
WHERE SALARY >1350 AND DEPT_ID IN (31,42,50);
//
--CAU08: INFO NHAN VIEN DUOC THUE NAM 91 
SELECT LAST_NAME ||' '||  FIRST_NAME AS EMPLOYEE_NAME, START_DATE AS NgayBatDauLamViec
FROM S_EMP 
WHERE EXTRACT (YEAR FROM START_DATE) = 1991;
//
--CAU09:NHAN VIEN DUOC TANG x0.15 LUONG
SELECT ID AS MaNhanVien, LAST_NAME ||' '||  FIRST_NAME AS EMPLOYEE_NAME, SALARY AS MONTHLY_SALARY
FROM S_EMP 
WHERE COMMISSION_PCT= 15;
//
--CAU10: INFO NHAN VIEN VA DOT TANG LUONG 
SELECT LAST_NAME ||' '||  FIRST_NAME AS EMPLOYEE_NAME, START_DATE AS NgayTuyenDung, 
TO_CHAR(
        NEXT_DAY(TRUNC(ADD_MONTHS(start_date, 6) - 1, 'MONTH') + 1, 'MONDAY'), 
        'FMMonth "of" FMDD YYYY'
    ) AS NgayXemXet_TangLuong
FROM 
s_emp;
//
--CAU22: HIEN THI INFO VA CHUC VU NHAN VIEN
SELECT 
    first_name || ' ' || last_name || ' (' || title || ')' AS NhanVien_ChucVu
FROM 
    s_emp;
//
--cau 23: INFO QUAN LY
SELECT  manager_id, COUNT(*) AS SoNhanVien_QUANLY
FROM   s_emp
GROUP BY manager_id;
//
--CAU24: QUAN LY QUAN LY >20 NHAN VIEN
SELECT manager_id,COUNT(*) AS num_employees_managed
FROM s_emp
GROUP BY manager_id
HAVING COUNT(*) >= 20;
//
--CAU25: CAC VUNG TRONG HE THONG
SELECT 
    r.id AS region_id,
    r.name AS region_name,
    COUNT(d.id) AS num_departments
FROM s_region r
LEFT JOIN s_dept d ON r.id = d.region_id
GROUP BY r.id, r.name;
//
--CAU26: INFO KHACH HANG
SELECT 
    c.name AS customer_name,
    COUNT(o.id) AS num_orders
FROM s_customer c
LEFT JOIN s_ord o ON c.id = o.customer_id
GROUP BY  c.name;
//
--CAU27: KHACH HANG DAT NHIEU DON NHAT
SELECT 
    c.name AS customer_name,
    COUNT(o.id) AS num_orders
FROM  s_customer c
LEFT JOIN s_ord o ON c.id = o.customer_id
GROUP BY  c.name
ORDER BY COUNT(o.id) DESC
FETCH FIRST 1 ROW ONLY;
//
--CAU28: KHACH HANG LA THANH KHOAN LON NHAT
SELECT 
    c.name AS customer_name,
    SUM(o.total) AS total_purchase_amount
FROM s_customer c
LEFT JOIN s_ord o ON c.id = o.customer_id
GROUP BY c.name
ORDER BY SUM(o.total) DESC
FETCH FIRST 1 ROW ONLY;
//
