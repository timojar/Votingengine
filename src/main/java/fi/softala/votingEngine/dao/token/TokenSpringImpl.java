package fi.softala.votingEngine.dao.token;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;





import fi.softala.votingEngine.bean.Token;
import fi.softala.votingEngine.dao.EiLoydyPoikkeus;

@Repository
public class TokenSpringImpl implements TokenDao{
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	
public void lisaaToken(Token v){
	

	
	final String sql = "insert into token(tokenId, email, ryhmaId) values(?,?,?)";

	// anonyymi sis‰luokka tarvitsee vakioina v‰litett‰v‰t arvot,
	// jotta roskien keruu onnistuu t‰m‰n metodin suorituksen p‰‰ttyess‰.
	final String tokenId = v.getTokenId();
	final String email = v.getEmail();
	final int ryhmaId=v.getRyhmaId();
	

	// jdbc pist‰‰ generoidun id:n t‰nne talteen
	KeyHolder idHolder = new GeneratedKeyHolder();

	// suoritetaan p‰ivitys itse m‰‰ritellyll‰ PreparedStatementCreatorilla
	// ja KeyHolderilla
	jdbcTemplate.update(new PreparedStatementCreator() {
		public PreparedStatement createPreparedStatement(
				Connection connection) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(sql,
					new String[] { "id" });
			ps.setString(1, tokenId);
			ps.setString(2, email);
			ps.setInt(3, ryhmaId);
			
			return ps;
		}
	}, idHolder);
	v.setId(idHolder.getKey().intValue());
		
	
	
	
	
	
	
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
