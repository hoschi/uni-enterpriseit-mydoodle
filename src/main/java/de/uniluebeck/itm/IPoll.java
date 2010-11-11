package de.uniluebeck.itm;

import java.util.*;

public interface IPoll {
	public List<IPoll> getPolls();
	public IPoll getPoll(int id);
}
