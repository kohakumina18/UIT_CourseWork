//PL/SQL ORACLE SQL DEVELOPER
CREATE USER C##2 IDENTIFIED BY password;
GRANT DBA TO C##2;
SET SERVEROUTPUT ON;
//
CREATE TABLE LOI (
    MALOI VARCHAR2(20) PRIMARY KEY,
    NOIDUNG VARCHAR2(100),
    MUCTIENPHAT NUMBER
);
//
CREATE TABLE DOITUONG (
    MADT VARCHAR2(20) PRIMARY KEY,
    HOTEN VARCHAR2(50),
    CMND VARCHAR2(20),
    DIACHI VARCHAR2(200),
    BIENKS VARCHAR2(20),
    TONGTIENPHAT NUMBER
);
//
CREATE TABLE VIPHAM (
    MALOI VARCHAR2(20),
    MADT VARCHAR2(20),
    THOIDIEMVP TIMESTAMP,
    NGAYHEN DATE,
    FOREIGN KEY (MALOI) REFERENCES LOI(MALOI),
    FOREIGN KEY (MADT) REFERENCES DOITUONG(MADT)
);
//TRIGGERS: 
--CAU06: TRIGGER GIAM XE 10NGAY VOI VI PHAM >300.000 
CREATE OR REPLACE TRIGGER check_ngay_hen_constraint
BEFORE INSERT OR UPDATE ON VIPHAM
FOR EACH ROW
DECLARE
    v_ngay_vp TIMESTAMP := :NEW.THOIDIEMVP;
    v_ngay_hen DATE := :NEW.NGAYHEN;
    v_muc_tien NUMBER;
BEGIN
    SELECT MUCTIENPHAT INTO v_muc_tien
    FROM LOI
    WHERE MALOI = :NEW.MALOI;
    IF v_muc_tien > 300000 AND v_ngay_hen <= v_ngay_vp + INTERVAL '10' DAY THEN
        RAISE_APPLICATION_ERROR(-20001, 'Ngay hen phai sau it nhat 10 ngay ke tu ngay vi pham.');
    END IF;
END;

--
--CAU07:  TRIGGER: TONG TIEN PHAT = TONG MUC TIEN PHAT VI PHAM CAC LOI 
CREATE OR REPLACE TRIGGER tong_tien_phat
AFTER INSERT OR UPDATE ON VIPHAM
FOR EACH ROW
DECLARE
    TONGPHAT NUMBER;
BEGIN
    SELECT SUM(L.MUCTIENPHAT)
    INTO TONGPHAT
    FROM LOI L
    WHERE EXISTS (
        SELECT 1
        FROM VIPHAM V
        WHERE V.MALOI = L.MALOI
        AND V.MADT = :NEW.MADT
    );
    UPDATE DOITUONG
    SET TONGTIENPHAT = TONGPHAT
    WHERE MADT = :NEW.MADT;
END;
/



--
--
--INSERTING LOI
INSERT INTO LOI (MALOI, NOIDUNG, MUCTIENPHAT) VALUES ('L001', 'Vuot den do', 2000000);
INSERT INTO LOI (MALOI, NOIDUNG, MUCTIENPHAT) VALUES ('L002', 'Qua toc do', 1500000);
INSERT INTO LOI (MALOI, NOIDUNG, MUCTIENPHAT) VALUES ('L003', 'Khong doi mu bao hiem', 50000);
INSERT INTO LOI (MALOI, NOIDUNG, MUCTIENPHAT) VALUES ('L004', 'Su dung dien thoai khi lai xe', 1000000);
INSERT INTO LOI (MALOI, NOIDUNG, MUCTIENPHAT) VALUES ('L005', 'Khong giu khoang cach an toan', 80000);
INSERT INTO LOI (MALOI, NOIDUNG, MUCTIENPHAT) VALUES ('L006', 'Lang lach nguy hiem', 1200000);
INSERT INTO LOI (MALOI, NOIDUNG, MUCTIENPHAT) VALUES ('L007', 'Khong chap hanh toc do toi da', 100000);
INSERT INTO LOI (MALOI, NOIDUNG, MUCTIENPHAT) VALUES ('L008', 'Xe khong dang ky', 200000);
INSERT INTO LOI (MALOI, NOIDUNG, MUCTIENPHAT) VALUES ('L009', 'Vi pham cam dung do', 50000);
INSERT INTO LOI (MALOI, NOIDUNG, MUCTIENPHAT) VALUES ('L010', 'Vi pham han che toc do', 100000);
//
--
--
--
--INSERTING DOITUONG
 INSERT INTO DOITUONG (MADT, HOTEN, CMND, DIACHI, BIENKS, TONGTIENPHAT) VALUES ('DT001', 'Nguyen Van A', '123456789', '123 Duong ABC, TP.HCM', '51H-12345', 0);
INSERT INTO DOITUONG (MADT, HOTEN, CMND, DIACHI, BIENKS, TONGTIENPHAT) VALUES ('DT002', 'Tran Thi B', '987654321', '456 Duong XYZ, Ha Noi', '29C-98765', 0);
INSERT INTO DOITUONG (MADT, HOTEN, CMND, DIACHI, BIENKS, TONGTIENPHAT) VALUES ('DT003', 'Le Van C', '456789123', '789 Duong DEF, Da Nang', '72K-45678', 0);
INSERT INTO DOITUONG (MADT, HOTEN, CMND, DIACHI, BIENKS, TONGTIENPHAT) VALUES ('DT004', 'Pham Thi D', '321654987', '159 Duong GHI, Can Tho', '63F-32165', 0);
INSERT INTO DOITUONG (MADT, HOTEN, CMND, DIACHI, BIENKS, TONGTIENPHAT) VALUES ('DT005', 'Hoang Van E', '654321789', '357 Duong JKL, Hai Phong', '36M-65432', 0);
INSERT INTO DOITUONG (MADT, HOTEN, CMND, DIACHI, BIENKS, TONGTIENPHAT) VALUES ('DT006', 'Nguyen Thi F', '789123654', '852 Duong MNO, Dak Lak', '83T-78912', 0);
INSERT INTO DOITUONG (MADT, HOTEN, CMND, DIACHI, BIENKS, TONGTIENPHAT) VALUES ('DT007', 'Tran Van G', '147258369', '963 Duong PQR, Lam Dong', '68R-14725', 0);
INSERT INTO DOITUONG (MADT, HOTEN, CMND, DIACHI, BIENKS, TONGTIENPHAT) VALUES ('DT008', 'Le Thi H', '258369147', '741 Duong STU, Binh Duong', '59S-25836', 0);
INSERT INTO DOITUONG (MADT, HOTEN, CMND, DIACHI, BIENKS, TONGTIENPHAT) VALUES ('DT009', 'Hoang Van I', '369147258', '852 Duong VWX, Vung Tau', '47V-36914', 0);
INSERT INTO DOITUONG (MADT, HOTEN, CMND, DIACHI, BIENKS, TONGTIENPHAT) VALUES ('DT010', 'Pham Van K', '741852963', '963 Duong YZ, Thanh Hoa', '38Y-74185', 0);
//
-- INSERT OKE:
INSERT INTO VIPHAM (MALOI, MADT, THOIDIEMVP, NGAYHEN) 
VALUES ('L001', 'DT001', TIMESTAMP '2024-03-01 08:30:00', DATE '2024-03-13');

INSERT INTO VIPHAM (MALOI, MADT, THOIDIEMVP, NGAYHEN) 
VALUES ('L002', 'DT002', TIMESTAMP '2024-03-02 10:45:00', DATE '2024-03-19');

--INSERTING VIPHAM LOI TRIGGER
INSERT INTO VIPHAM (MALOI, MADT, THOIDIEMVP, NGAYHEN) VALUES ('L002', 'DT002', TIMESTAMP '2024-03-02 10:45:00', DATE '2024-03-02');
INSERT INTO VIPHAM (MALOI, MADT, THOIDIEMVP, NGAYHEN) VALUES ('L003', 'DT003', TIMESTAMP '2024-03-05 12:15:00', DATE '2024-03-05');
INSERT INTO VIPHAM (MALOI, MADT, THOIDIEMVP, NGAYHEN) VALUES ('L004', 'DT004', TIMESTAMP '2024-03-10 14:20:00', DATE '2024-03-10');
INSERT INTO VIPHAM (MALOI, MADT, THOIDIEMVP, NGAYHEN) VALUES ('L005', 'DT005', TIMESTAMP '2024-03-12 16:30:00', DATE '2024-03-12');
INSERT INTO VIPHAM (MALOI, MADT, THOIDIEMVP, NGAYHEN) VALUES ('L006', 'DT006', TIMESTAMP '2024-03-15 18:45:00', DATE '2024-03-15');

--//
--CAU01: HIEN THI VIPHAM TRONG THANG
 CREATE OR REPLACE PROCEDURE hien_thi_danh_sach_vi_pham(thang_in IN NUMBER, nam_in IN NUMBER) AS
    v_count NUMBER;
BEGIN
    IF thang_in < 1 OR thang_in > 12 THEN
        DBMS_OUTPUT.PUT_LINE('Thang khong hop le. Thang phai tu 1 den 12.');
        RETURN;
    END IF;
    SELECT COUNT(*) INTO v_count
    FROM VIPHAM
    WHERE EXTRACT(MONTH FROM NGAYHEN) = thang_in
    AND EXTRACT(YEAR FROM NGAYHEN) = nam_in;
    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Khong tim thay doi tuong vi pham trong thang va nam duoc chi dinh.');
    ELSE
        FOR rec IN (SELECT * FROM VIPHAM WHERE EXTRACT(MONTH FROM NGAYHEN) = thang_in AND EXTRACT(YEAR FROM NGAYHEN) = nam_in) LOOP
            DBMS_OUTPUT.PUT_LINE('Doi tuong vi pham giao thong: ' || rec.MADT || ' - Ngay vi pham: ' || TO_CHAR(rec.NGAYHEN, 'DD-MON-YYYY'));
        END LOOP;
    END IF;
END;
--

--
//VD: 
--
--
--
BEGIN
    hien_thi_danh_sach_vi_pham(3, 2024);
END;
--
--
--
 --CAU02: HIEN THI VI PHAM TRONG THANG - SU DUNG CURSOR 
CREATE OR REPLACE PROCEDURE hien_thi_danh_sach_vi_pham_C(thang_in IN NUMBER, nam_in IN NUMBER) AS
    v_count NUMBER;
    CURSOR c_violations IS
        SELECT MADT, NGAYHEN
        FROM VIPHAM
        WHERE EXTRACT(MONTH FROM NGAYHEN) = thang_in
        AND EXTRACT(YEAR FROM NGAYHEN) = nam_in;
BEGIN
    IF thang_in < 1 OR thang_in > 12 THEN
        DBMS_OUTPUT.PUT_LINE('Thang khong hop le. Thang phai tu 1 den 12.');
        RETURN;
    END IF;
    SELECT COUNT(*) INTO v_count
    FROM VIPHAM
    WHERE EXTRACT(MONTH FROM NGAYHEN) = thang_in
    AND EXTRACT(YEAR FROM NGAYHEN) = nam_in;
    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Khong tim thay doi tuong vi pham trong thang va nam duoc chi dinh.');
    ELSE
        FOR rec IN c_violations LOOP
            DBMS_OUTPUT.PUT_LINE('Doi tuong vi pham giao thong: ' || rec.MADT || ' - Ngay vi pham: ' || TO_CHAR(rec.NGAYHEN, 'DD-MON-YYYY'));
        END LOOP;
    END IF;
END;
//-VD 
--
--
--
--
--
BEGIN
    hien_thi_danh_sach_vi_pham_C(3, 2024);
END;
--
--
--
--
//--------
--
--CAU03: TONG SO LOI VI PHAM GIAO THONG 
CREATE OR REPLACE PROCEDURE tong_so_loi_vipham(
    thang_in IN NUMBER,
    nam_in IN NUMBER,
    madt_in IN VARCHAR2,
    tong_so_loi OUT NUMBER
) AS
BEGIN
    tong_so_loi := 0;
    IF thang_in < 1 OR thang_in > 12 THEN
        DBMS_OUTPUT.PUT_LINE('Thang khong hop le. Thang phai tu 1 den 12.');
        RETURN;
    END IF;
    SELECT COUNT(*)
    INTO tong_so_loi
    FROM VIPHAM
    WHERE EXTRACT(MONTH FROM NGAYHEN) = thang_in
    AND EXTRACT(YEAR FROM NGAYHEN) = nam_in
    AND MADT = madt_in;
END;
//
--
--VD:  
--
--
DECLARE
    LOIVP NUMBER;
BEGIN
    LOIVP := 0; 
    tong_so_loi_vipham(3, 2024, 'DT002', LOIVP); 
    DBMS_OUTPUT.PUT_LINE('Tong so loi vi pham cua doi tuong trong thang 3 nam 2024 la: ' || LOIVP);
END;
--
--
--
--CAU04: CHO BIET TONG SO VIPHAM SU DUNG FUNCTION 
--
CREATE OR REPLACE FUNCTION tong_so_loi_vipham_F(
    thang_in IN NUMBER,
    nam_in IN NUMBER,
    madt_in IN VARCHAR2
) RETURN NUMBER
IS
    tong_so_loi NUMBER := 0;
BEGIN
    IF thang_in < 1 OR thang_in > 12 THEN
        DBMS_OUTPUT.PUT_LINE('Thang khong hop le. Thang phai tu 1 den 12.');
        RETURN 0; 
    END IF;
    SELECT COUNT(*)
    INTO tong_so_loi
    FROM VIPHAM
    WHERE EXTRACT(MONTH FROM NGAYHEN) = thang_in
    AND EXTRACT(YEAR FROM NGAYHEN) = nam_in
    AND MADT = madt_in;
    RETURN tong_so_loi;
EXCEPTION
    WHEN OTHERS THEN
        RETURN 0; 
END tong_so_loi_vipham_F;
--
--
--
--
--VD: 
DECLARE
    LOIVP NUMBER;
BEGIN
    LOIVP := tong_so_loi_vipham_F(3, 2024, 'DT001');
    DBMS_OUTPUT.PUT_LINE('Tong so loi vi pham cua doi tuong trong thang 3 nam 2024 la: ' || LOIVP);
END;
--
--
--
--CAU05: DOI TUONG NHIEU LOI NAHT TRONG NAM SU DUNG CURSOR 
CREATE OR REPLACE PROCEDURE loi_nhieu_nhat_trong_nam_C(
    nam_in IN NUMBER,
    ten_doi_tuong OUT VARCHAR2,
    tong_so_loi OUT NUMBER
) AS
    max_loi NUMBER := 0;
BEGIN
  
    ten_doi_tuong := NULL;
    tong_so_loi := 0;

    FOR rec IN (
        SELECT DOITUONG.HOTEN, COUNT(VIPHAM.MALOI) AS SO_LOI
        FROM VIPHAM
        JOIN DOITUONG ON VIPHAM.MADT = DOITUONG.MADT
        WHERE EXTRACT(YEAR FROM VIPHAM.NGAYHEN) = nam_in
        GROUP BY DOITUONG.HOTEN
    ) LOOP
        IF rec.SO_LOI > max_loi THEN
            max_loi := rec.SO_LOI;
            ten_doi_tuong := rec.HOTEN;
            tong_so_loi := rec.SO_LOI;
        END IF;
    END LOOP;
END;
--VD: 
DECLARE
    ten_doi_tuong VARCHAR2(100);
    tong_so_loi NUMBER;
BEGIN
    loi_nhieu_nhat_trong_nam_C(2024, ten_doi_tuong, tong_so_loi);
    DBMS_OUTPUT.PUT_LINE('Doi tuong co nhieu loi vi pham nhat nam 2024: ' || ten_doi_tuong || ' voi tong so loi: ' || tong_so_loi);
END;





 