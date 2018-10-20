package StructureModel.ChainOfResponnsibility;

import java.util.List;

/**
 * Created by sunpengwei on 2017/5/8.
 */
public class FilterChain implements Filter {

	private List<Filter> filters;

	@Override
	public void doFilter(String str) {
		if(str ==null)
			return;
		for (Filter filter:filters){
			filter.doFilter(str);
		}

	}
}
