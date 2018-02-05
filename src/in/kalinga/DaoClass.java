package in.kalinga;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService(endpointInterface="http://localhost:3434/service")
public interface DaoClass {
	@WebMethod
	public String getPlayers();
	public String insert(String fs,String pos,String pn,int tid);
	

}
