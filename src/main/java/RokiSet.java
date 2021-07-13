import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class RokiSet<E> extends HashSet<E> {
    private int addCount = 0;

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        RokiSet<String> rokiSet = new RokiSet<>();
        rokiSet.addAll(Arrays.asList("포비", "제이슨", "CU", "브라운"));

        System.out.println(rokiSet.getAddCount());
    }
}
