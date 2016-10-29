package fi.softala.votingEngine.dao.token;

import fi.softala.votingEngine.bean.Token;

public interface TokenDao {
	
	
public abstract void lisaaToken(Token v);

public abstract Token haeToken(String tokenId);

public abstract void poistaToken(String tokenId);
	

}
