/*BEGIN*/
/* AAAAAAAAAAAA */
/*END*/
SELECT
    *
FROM
    TEST    T
WHERE
    1       =   1
/*IF SF.isNotEmpty(id) */
    /*IF id < 100 */
AND T.ID    =   /*id*/0
    /*ELIF id >= 100 */
AND 1       =   1
    /*ELSE*/
AND T.ID    =   100
    /*END*/
/*END*/
/*IF SF.isNotEmpty(name) */
AND T.NAME  =   /*name*/''
/*END*/
/*IF true */
-- ELSEaaa
/*END*/
ORDER BY
    T.ID