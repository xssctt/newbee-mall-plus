package ltd.newbee.mall.task;


import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
//构造方法接受任务id和延迟时间,根据延迟时间计算出任务的起始时间start。
//实现getDelay()方法,用于返回从当前时间到起始时间的延迟间隔。
//实现compareTo()方法,用于定时任务队列的排序。
//实现equals()和hashCode()方法,判断任务id是否相同。
//主要用法是:
//继承Task类创建具体的定时任务。
//覆盖run()方法以实现需要定时执行的逻辑。
//创建任务对象时传入id和延迟时间。
//将任务添加到定时任务队列schedule,自动触发执行。
public abstract class Task implements Delayed, Runnable {
    private final String id;
    private final long start;

    /**
     *
     * @param id 定时任务ID
     * @param delayInMilliseconds 延迟执行时间，单位/毫秒
     */
    public Task(String id, long delayInMilliseconds) {
        this.id = id;
        this.start = System.currentTimeMillis() + delayInMilliseconds;
    }

    public String getId() {
        return id;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = this.start - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.start - ((Task) o).start);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
//        if (!(o instanceof Task t)) {
//            return false;
//        }
        Task t;
        if (o instanceof Task) {
            t = (Task) o;
        } else {
            return false;
        }
        return this.id.equals(t.getId());
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
