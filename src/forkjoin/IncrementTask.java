package forkjoin;


import java.util.concurrent.*;

/**
 * Created by sunpengwei on 2017/3/5.
 */
public class IncrementTask extends RecursiveTask<Long> {


	final long[] array;
	final int lo;
	final int hi;
	long sum =0;


	IncrementTask(long[] array, int lo, int hi) {
		this.array = array; this.lo = lo; this.hi = hi;
	}



	@Override
	protected Long compute() {

		if (hi - lo < 5) {
			for (int i = lo; i < hi; ++i){
				sum = sum + array[i];
			}
			return sum;
		} else {
			int mid = (lo + hi) >>> 1;
			IncrementTask f1 = new IncrementTask(array,lo,mid);
			f1.fork();
			IncrementTask f2 = new IncrementTask(array,mid,hi);
			return f2.invoke() + f1.join();
		}
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		long [] array = {12L,432L,523L,132L,112L,12L,13L,162L,2L,23L,32L};
		IncrementTask in = new IncrementTask(array,0,array.length);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Future<Long> sum = forkJoinPool.submit(in);

		System.out.println(sum.get());
	}
}
