-- 방명록 게시판

CREATE TABLE gboard(
    gno NUMBER(4)
        CONSTRAINT GBD_NO_PK PRIMARY KEY,
    writer NUMBER(4)
        CONSTRAINT GBD_MNO_FK REFERENCES member(mno)
        CONSTRAINT GBD_MNO_UK UNIQUE
        CONSTRAINT GBD_MNO_NN NOT NULL,
    body VARCHAR2(100 CHAR)
        CONSTRAINT GBD_BODY_NN NOT NULL,
    wdate DATE DEFAULT sysdate
        CONSTRAINT GBD_DATE_NN NOT NULL
);

-- 방명록 시퀀스 생성
CREATE SEQUENCE gbrdSeq
    START WITH 1001
    MAXVALUE 9999
    NOCYCLE
    NOCACHE
;

-- 데이터 추가
INSERT INTO
    gboard(gno, writer, body)
VALUES(
    gbrdSeq.NEXTVAL, 1000, 
    '사이트 오픈합니다. 많은 이용 부탁드립니다.'
);

INSERT INTO
    gboard(gno, writer, body)
VALUES(
    gbrdSeq.NEXTVAL, 1001, 
    '사이트 오픈 축하합니다.'
);


INSERT INTO
    gboard(gno, writer, body)
VALUES(
    gbrdSeq.NEXTVAL, 1043, 
    '아냐 피곤해.'
);
commit;

SELECT
    gno, name, id, body, filename sname, wdate
FROM
    member, avatar, gboard
WHERE
    mno = writer
    AND avatar = ano
ORDER BY
    wdate DESC
;