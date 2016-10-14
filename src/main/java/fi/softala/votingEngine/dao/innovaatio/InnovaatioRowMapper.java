package fi.softala.votingEngine.dao.innovaatio;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.votingEngine.bean.Innovaatio;

public class InnovaatioRowMapper implements RowMapper<Innovaatio> {
	
	

	public Innovaatio mapRow(ResultSet rs, int rownumber) throws SQLException {  
        Innovaatio i=new Innovaatio();  
        i.setId(rs.getInt("id"));  
        i.setNimi(rs.getString("nimi")); 
        i.setAihe(rs.getString("aihe"));
        return i;  
    } 	
	
	
	

}
