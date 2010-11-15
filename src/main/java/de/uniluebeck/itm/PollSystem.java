package de.uniluebeck.itm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;


@WebService(endpointInterface = "de.uniluebeck.itm.IPollSystem")
public class PollSystem implements IPollSystem {
	
	private Map<Integer,Poll> pollMap = new HashMap<Integer,Poll>();
	
	public PollSystem() {
		
	}

	public Poll getPoll(int id) {
		return pollMap.get(Integer.valueOf(id));
	}

	public PollInfo[] getPolls() {
		ArrayList<PollInfo> result = new ArrayList<PollInfo>(pollMap.size());
		for (Poll poll : pollMap.values()) {
			result.add(poll.getInfo());
		}
		return (PollInfo[]) result.toArray();
	}

}
