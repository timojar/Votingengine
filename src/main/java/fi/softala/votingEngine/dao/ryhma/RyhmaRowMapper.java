package fi.softala.votingEngine.dao.ryhma;

import java.sql.ResultSet;
import java.sql.SQLException;



import org.springframework.jdbc.core.RowMapper;

import fi.softala.votingEngine.bean.Ryhma;

public class RyhmaRowMapper implements RowMapper<Ryhma> {

	
	
	public Ryhma mapRow(ResultSet rs, int rownumber) throws SQLException {  
        Ryhma r=new Ryhma();  
        
        r.setId(rs.getInt("id"));
        r.setNimi(rs.getString("nimi"));
        r.setTyyppi(rs.getString("tyyppi"));
        return r;  
    } 	
	
		
		
	
	
	
	
}
