package fi.softala.votingEngine.dao.aani;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.votingEngine.bean.Aani;


public class AaniRowMapper implements RowMapper<Aani>
{

	
	
	public Aani mapRow(ResultSet rs, int rownumber) throws SQLException {  
        Aani a=new Aani();  
        
        
        
        a.setLkm(rs.getInt("lkm"));
        a.setInnoNimi(rs.getString("nimi")); 
        a.setAihe(rs.getString("aihe"));
        return a;  
    } 	
	
	
		
	
	
	
}
