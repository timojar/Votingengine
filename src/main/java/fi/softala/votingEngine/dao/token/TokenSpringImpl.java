package fi.softala.votingEngine.dao.token;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



import fi.softala.votingEngine.bean.Token;
import fi.softala.votingEngine.dao.EiLoydyPoikkeus;

@Repository
public class TokenSpringImpl implements TokenDao{
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	
public void lisaaToken(Token v){
	
	
	
	
	String sql = "insert into token(tokenId, email, ryhmaId) values(?,?,?)";
	
	Object[] parametrit = new Object[] { v.getTokenId(), v.getEmail(), v.getRyhmaId() };

	jdbcTemplate.update(sql, parametrit);


	
	
	
	
	
}




public void poistaToken(String tokenId){
	
	
String sql = "delete from token where tokenId = ?";
	
	Object[] parametrit = new Object[] { tokenId };

	jdbcTemplate.update(sql, parametrit);	
	
	
}

public Token haeToken(String tokenId){
	
	
	
	String sql = "select * from token where tokenId  = ?";
	Object[] parametrit = new Object[] { tokenId };
	RowMapper<Token> mapper = new TokenRowMapper();

	Token t;
	try {
		t = jdbcTemplate.queryForObject(sql, parametrit, mapper);
	} catch (IncorrectResultSizeDataAccessException e) {
		throw new EiLoydyPoikkeus(e);
	}
	
	
	
	return t;
	
	
}

}
