package com.example.vulnerable;

import java.sql.*;

/**
 * SQL Injection - Set 36-40
 */
public class SQLSet36 {
    
    private Connection c;
    
    public SQLSet36() throws SQLException {
        c = DriverManager.getConnection("jdbc:h2:mem:db");
    }
    
    public void vuln351(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM a WHERE x='" + v + "'"); }
    public void vuln352(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM b WHERE y='" + v + "'"); }
    public void vuln353(String v) throws SQLException { c.createStatement().executeUpdate("DELETE FROM c WHERE z=" + v); }
    public void vuln354(String v) throws SQLException { c.createStatement().execute("INSERT INTO d VALUES('" + v + "')"); }
    public void vuln355(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM e WHERE w LIKE '%" + v + "%'"); }
    public void vuln356(String v) throws SQLException { c.createStatement().executeUpdate("UPDATE f SET val='" + v + "'"); }
    public void vuln357(String v) throws SQLException { c.createStatement().executeQuery("SELECT COUNT(*) FROM g WHERE k=" + v); }
    public void vuln358(String v) throws SQLException { c.createStatement().execute("CREATE TABLE " + v + " (id INT)"); }
    public void vuln359(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM h ORDER BY " + v); }
    public void vuln360(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM i LIMIT " + v); }
    public void vuln361(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM j WHERE m='" + v + "'"); }
    public void vuln362(String v) throws SQLException { c.createStatement().executeUpdate("DELETE FROM k WHERE n=" + v); }
    public void vuln363(String v) throws SQLException { c.createStatement().execute("INSERT INTO l VALUES(" + v + ")"); }
    public void vuln364(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM m WHERE o='" + v + "'"); }
    public void vuln365(String v) throws SQLException { c.createStatement().executeUpdate("UPDATE n SET p='" + v + "' WHERE q=1"); }
    public void vuln366(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM o WHERE r=" + v); }
    public void vuln367(String v) throws SQLException { c.createStatement().execute("TRUNCATE TABLE " + v); }
    public void vuln368(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM p GROUP BY " + v); }
    public void vuln369(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM q HAVING COUNT(*)>" + v); }
    public void vuln370(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM r WHERE s='" + v + "'"); }
    public void vuln371(String v) throws SQLException { c.createStatement().executeUpdate("DELETE FROM s WHERE t=" + v); }
    public void vuln372(String v) throws SQLException { c.createStatement().execute("INSERT INTO t VALUES('" + v + "','" + v + "')"); }
    public void vuln373(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM u WHERE v IN ('" + v + "')"); }
    public void vuln374(String v) throws SQLException { c.createStatement().executeUpdate("UPDATE v SET w=" + v); }
    public void vuln375(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM w WHERE x BETWEEN 1 AND " + v); }
    public void vuln376(String v) throws SQLException { c.createStatement().execute("ALTER TABLE x ADD " + v); }
    public void vuln377(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM y WHERE z!='" + v + "'"); }
    public void vuln378(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM z WHERE a<'" + v + "'"); }
    public void vuln379(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM aa WHERE b>'" + v + "'"); }
    public void vuln380(String v) throws SQLException { c.createStatement().executeUpdate("UPDATE bb SET c='" + v + "' WHERE d='x'"); }
    public void vuln381(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM cc WHERE e<='" + v + "'"); }
    public void vuln382(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM dd WHERE f>='" + v + "'"); }
    public void vuln383(String v) throws SQLException { c.createStatement().executeQuery("SELECT DISTINCT g FROM ee WHERE h='" + v + "'"); }
    public void vuln384(String v) throws SQLException { c.createStatement().executeQuery("SELECT TOP " + v + " * FROM ff"); }
    public void vuln385(String v) throws SQLException { c.createStatement().execute("DROP DATABASE " + v); }
    public void vuln386(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM gg WHERE i='" + v + "' OR j='y'"); }
    public void vuln387(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM hh WHERE k='" + v + "' AND l='z'"); }
    public void vuln388(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM ii WHERE (m='" + v + "')"); }
    public void vuln389(String v) throws SQLException { c.createStatement().executeUpdate("UPDATE jj SET n='" + v + "', o='" + v + "'"); }
    public void vuln390(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM kk WHERE p LIKE '" + v + "%'"); }
    public void vuln391(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM ll WHERE q LIKE '%" + v + "'"); }
    public void vuln392(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM mm WHERE r NOT LIKE '%" + v + "%'"); }
    public void vuln393(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM nn WHERE s IN (" + v + ")"); }
    public void vuln394(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM oo WHERE t NOT IN ('" + v + "')"); }
    public void vuln395(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM pp WHERE u IS NULL AND v='" + v + "'"); }
    public void vuln396(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM qq WHERE w IS NOT NULL AND x='" + v + "'"); }
    public void vuln397(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM rr WHERE EXISTS (SELECT * FROM ss WHERE y='" + v + "')"); }
    public void vuln398(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM tt WHERE z = (SELECT a FROM uu WHERE b='" + v + "')"); }
    public void vuln399(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM vv UNION SELECT * FROM ww WHERE c='" + v + "'"); }
    public void vuln400(String v) throws SQLException { c.createStatement().executeQuery("SELECT * FROM xx INNER JOIN yy ON xx.d=yy.e WHERE f='" + v + "'"); }
}
