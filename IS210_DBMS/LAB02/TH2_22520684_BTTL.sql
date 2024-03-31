SET SERVEROUTPUT ON;
--TH03_BAI01_CAU02: BLOCKS LENH IN SO NGUYEN TO
DECLARE
    n NUMBER;
    i NUMBER;
    j NUMBER;
    is_prime BOOLEAN;
BEGIN   
    DBMS_OUTPUT.PUT_LINE('Enter the value of n( the number of first prime number you want  to print:');
    n := &n; -- Input N
    DBMS_OUTPUT.PUT_LINE('The first ' || n || ' prime numbers are:');

    i := 2;
    WHILE n > 0 LOOP
        is_prime := TRUE;
        FOR j IN 2..SQRT(i) LOOP
            IF MOD(i, j) = 0 THEN
                is_prime := FALSE;
                EXIT;
            END IF;
        END LOOP;  
        IF is_prime THEN
            DBMS_OUTPUT.PUT_LINE(i);
            n := n - 1;
        END IF;   
        i := i + 1;
    END LOOP;
END;
//
--
--
--TH03_BAI01_CAU04:BLOCKS LENH KIEM TRA TAM GIAC
DECLARE KiemTraTamGiac
    a NUMBER;
    b NUMBER;
    c NUMBER;
    valid_triangle BOOLEAN;
    triangle_type VARCHAR2(50);
BEGIN
    DBMS_OUTPUT.PUT_LINE('Nhap do dai cua ba canh cua tam giac:');
    a := &a; -- Canh thu nhat
    b := &b; -- Canh thu hai
    c := &c; -- Canh thu ba   
    -- Kiem tra tinh hop le cua tam giac
    valid_triangle := TRUE;
    IF (a + b <= c) OR (a + c <= b) OR (b + c <= a) THEN
        valid_triangle := FALSE;
    END IF;   
    -- Bao loi tam giac khong hop le
    IF NOT valid_triangle THEN
        DBMS_OUTPUT.PUT_LINE('Ba canh nhap vao khong tao thanh tam giac hop le.');
    ELSE
        -- Neu tam giac hop le, xac dinh loai tam giac
        IF a = b AND b = c THEN
            triangle_type := 'Tam giac deu';
        ELSIF a = b OR a = c OR b = c THEN
            IF a*a + b*b = c*c OR a*a + c*c = b*b OR b*b + c*c = a*a THEN
                triangle_type := 'Tam giac vuong can';
            ELSE
                triangle_type := 'Tam giac can';
            END IF;
        ELSE
            IF a*a + b*b = c*c OR a*a + c*c = b*b OR b*b + c*c = a*a THEN
                triangle_type := 'Tam giac vuong';
            ELSE
                triangle_type := 'Tam giac thuong';
            END IF;
        END IF;        
        -- In ra loai tam giac
        DBMS_OUTPUT.PUT_LINE('Tam giac duoc tao thanh boi ba canh da nhap la: ' || triangle_type);
    END IF;
END;
//
--
--
--TH03_BAI02_CAU02: PROCEDURE KIEM TRA VA THEM HS
CREATE OR REPLACE PROCEDURE Check_Insert_HS AS
    v_student_id STUDENT.StudentID%TYPE;
    v_student_name VARCHAR2(100);
    v_class_count NUMBER;
BEGIN
    -- INPUT MASV
    v_student_id := '&student_id';
    -- KIEM TRA MASV TRONG DATABASE
    SELECT FirstName || ' ' || LastName INTO v_student_name
    FROM STUDENT
    WHERE StudentID = v_student_id;
    -- OUTPUT THONG TIN LOP HOC
    SELECT COUNT(*) INTO v_class_count
    FROM ENROLLMENT
    WHERE StudentID = v_student_id;
    DBMS_OUTPUT.PUT_LINE('Sinh vien co ma ' || v_student_id || ' ten la ' || v_student_name);
    IF v_class_count > 0 THEN
        DBMS_OUTPUT.PUT_LINE('Sinh vien dang tham gia ' || v_class_count || ' lop hoc.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Sinh vien khong tham gia vao bat ky lop hoc nao.');
    END IF;
EXCEPTION
    -- Neu khong tim thay sinh vien, yeu cau nguoi dung nhap thong tin moi
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Khong tim thay sinh vien co ma ' || v_student_id || '.');
        DBMS_OUTPUT.PUT_LINE('Vui long nhap thong tin cua sinh vien moi:');
        -- Nhap thong tin sinh vien moi tu nguoi dung
        INSERT INTO STUDENT(StudentID, FirstName, LastName, Address)
        VALUES (v_student_id, '&first_name', '&last_name', '&address');
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Them sinh vien moi thanh cong.');
END;
//
--

--TH03_BAI03_CAU01- PROCEDURE DIEU KHIEN SO LUONG LOP CUA GV
CREATE OR REPLACE PROCEDURE KiemSoatWorkloadGV AS
    v_instructor_id INSTRUCTOR.InstructorID%TYPE;
    v_class_count NUMBER;
BEGIN
    -- input MAGV 
    v_instructor_id := '&instructor_id';
    -- Dem so lop GV dang dung lop giang day
    SELECT COUNT(*) INTO v_class_count
    FROM CLASS
    WHERE InstructorID = v_instructor_id;
    -- Kiem tra va dieu khien luong cong viec cua giao vien
    IF v_class_count >= 5 THEN
        DBMS_OUTPUT.PUT_LINE('Giao vien nay nen nghi ngoi!');
    ELSE
        DBMS_OUTPUT.PUT_LINE('So luong lop ma giao vien nay dang day la: ' || v_class_count);
    END IF;
END;
//
--
--
--TH02_BAI02_07->10_22->28
----cau01: warm up 
--select C.NAME AS TenKhachHang, C.ID as MaKhachHang
--from S_CUSTOMER C
--ORDER BY ID DESC;
--//

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
--CAU25: CAC REGION TRONG HE THONG
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
--
--
--
