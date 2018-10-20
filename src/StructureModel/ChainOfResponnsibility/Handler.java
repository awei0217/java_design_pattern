package StructureModel.ChainOfResponnsibility;

/**
 * Created by sunpengwei on 2017/5/8.
 */
// 抽象处理角色
interface Handler extends Filter {

	void handler();
}
