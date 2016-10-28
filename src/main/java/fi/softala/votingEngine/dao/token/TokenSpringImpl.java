package fi.softala.votingEngine.dao.token;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fi.softala.votingEngine.bean.VerificationToken;
@Repository
public class TokenSpringImpl implements TokenDao{
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	
public void lisaaToken(VerificationToken v){
	
	
	
	
	String sql = "insert into token(tokenId, email, ryhmaId) values(?,?,?)";
	
	Object[] parametrit = new Object[] { v.getTokenId(), v.getEmail(), v.getRyhmaId() };

	jdbcTemplate.update(sql, parametrit);


	
	
	
	
	
}

}
