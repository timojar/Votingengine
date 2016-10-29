package fi.softala.votingEngine.dao.token;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import fi.softala.votingEngine.bean.Token;;

public class TokenRowMapper implements RowMapper<Token> {
	
	
	public Token mapRow(ResultSet rs, int rownumber) throws SQLException {  
		Token t=new Token();  
       
		t.setTokenId(rs.getString("tokenId"));
		t.setEmail(rs.getString("email"));
		t.setRyhmaId(rs.getInt("ryhmaId"));
		
		
        
        return t;  
    } 	
	
		
	
	
	

}
