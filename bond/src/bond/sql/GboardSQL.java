package bond.sql;

public class GboardSQL {
	public final int SEL_ALL_LIST 	= 1001;
	public final int SEL_ID_CNT 	= 1002;
	
	public final int ADD_GBOARD 	= 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_ALL_LIST:
			buff.append("SELECT ");
			buff.append("	gno, mno, id, filename sname, wdate, body ");
			buff.append("FROM ");
			buff.append("	member, avatar, gboard ");
			buff.append("WHERE ");
			buff.append("	mno = writer ");
			buff.append("	AND	avatar = ano ");
			buff.append("ORDER BY ");
			buff.append("	wdate DESC ");
			break;
		case SEL_ID_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    member, gboard ");
			buff.append("WHERE ");
			buff.append("    mno = writer ");
			buff.append("    AND id = ? ");
			break;
		case ADD_GBOARD:
			buff.append("INSERT INTO ");
			buff.append("    gboard(gno, writer, body) ");
			buff.append("VALUES( ");
			buff.append("    gbrdSeq.NEXTVAL, ");
			buff.append("    ( ");
		    buff.append("		SELECT ");
			buff.append("    	    mno ");
			buff.append("    	FROM ");
			buff.append("    	    member ");
			buff.append("    	WHERE ");
			buff.append("    	    id = ? ");
			buff.append("    ), ? ");
			buff.append(") ");
			break;
		}
		
		return buff.toString();
	}
}
