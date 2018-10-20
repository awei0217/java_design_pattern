package StructureModel.ChainOfResponnsibility;

/**
 * Created by sunpengwei on 2017/5/8.
 */
public abstract class AbstractHandler implements Handler {

	@Override
	public void doFilter(String str){
		handler();
	}
}
