package de.uniluebeck.itm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

@WebService(endpointInterface = "de.uniluebeck.itm.IPollSystem")
public class PollSystem implements IPollSystem {
	
	private Map<Integer,IPoll> pollMap = new HashMap<Integer,IPoll>();
	
	public PollSystem() {
		
	}

	public IPoll getPoll(int id) {
		return pollMap.get(Integer.valueOf(id));
	}

	public List<IPollInfo> getPolls() {
		ArrayList<IPollInfo> result = new ArrayList<IPollInfo>(pollMap.size());
		for (IPoll poll : pollMap.values()) {
			result.add(poll.getInfo());
		}
		return result;
	}

}
