package fi.softala.votingEngine.dao.Aika;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapper;

import fi.softala.votingEngine.bean.Aani;
import fi.softala.votingEngine.bean.Aika;
import fi.softala.votingEngine.bean.Pvm;
public class AikaRowMapper implements RowMapper<Aika>{
	
	
public Aika mapRow (ResultSet rs, int rownumber) throws SQLException{
	
	Aika a= new Aika();
	
	
	a.setAlku(rs.getTimestamp("alku"));
	a.setLoppu(rs.getTimestamp("loppu"));
	a.setPvm(rs.getDate("loppu"));
	
	
	return a;
	
}
	
	

}
