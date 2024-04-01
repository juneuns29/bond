package bond.sql;

public class GboardSQL {
	public final int SEL_ALL_LIST 	= 1001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_ALL_LIST:
			buff.append("SELECT ");
			buff.append("	mno, id, filename sname, wdate, body ");
			buff.append("FROM ");
			buff.append("	member, avatar, gboard ");
			buff.append("WHERE ");
			buff.append("	mno = writer ");
			buff.append("	AND	avatar = ano ");
			buff.append("ORDER BY ");
			buff.append("	wdate DESC ");
			break;
		}
		
		return buff.toString();
	}
}
