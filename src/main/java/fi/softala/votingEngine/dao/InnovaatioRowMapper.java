package fi.softala.votingEngine.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.votingEngine.bean.Innovaatio;

public class InnovaatioRowMapper implements RowMapper<Innovaatio> {
	
	

	public Innovaatio mapRow(ResultSet rs, int rownumber) throws SQLException {  
        Innovaatio i=new Innovaatio();  
        i.setId(rs.getInt(1));  
        i.setNimi(rs.getString(2)); 
        i.setAihe(rs.getString(3));
        return i;  
    } 	
	
	
	

}
