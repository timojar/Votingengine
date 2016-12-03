package fi.softala.votingEngine.dao.opiskelija;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.votingEngine.bean.Opiskelija;

public class RegisterRowMapper implements RowMapper<Opiskelija> {
	
	
	
	
	
	public Opiskelija mapRow(ResultSet rs, int rownumber) throws SQLException {  
        Opiskelija o=new Opiskelija();  
        o.setId(rs.getInt("id"));  
        o.setEtunimi(rs.getString("etunimi")); 
        o.setSukunimi(rs.getString("sukunimi"));
        o.setEmail(rs.getString("email"));
        o.setOpiskelijanumero(rs.getString("opiskelijanumero"));
        o.setRyhmaId(rs.getInt("ryhmaId"));
        o.setValtuusId(rs.getInt("valtuusId"));
        
        return o;  
    } 	
		
	
	
	
	
	
	
	
	

}
