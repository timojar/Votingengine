package fi.softala.votingEngine.dao.token;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import fi.softala.votingEngine.bean.VerificationToken;;

public class TokenRowMapper implements RowMapper<VerificationToken> {
	
	
	public VerificationToken mapRow(ResultSet rs, int rownumber) throws SQLException {  
		VerificationToken t=new VerificationToken();  
       
		t.setTokenId(rs.getString("tokenId"));
		t.setEmail(rs.getString("email"));
		
		
        
        return t;  
    } 	
	
		
	
	
	

}
