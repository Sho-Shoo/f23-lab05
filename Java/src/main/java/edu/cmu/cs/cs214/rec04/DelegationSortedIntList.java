package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{

    private final SortedIntList sortedList;
    private int totalAdded;

    public DelegationSortedIntList() {
        sortedList = new SortedIntList();
        totalAdded = 0;
    }

    @Override
    public boolean add(int num) {
        this.totalAdded++;
        return this.sortedList.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        this.totalAdded += list.size();
        return this.sortedList.addAll(list);
    }

    @Override
    public int get(int index) {
        return this.sortedList.get(index);
    }

    @Override
    public boolean remove(int num) {
        return this.sortedList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return this.sortedList.removeAll(list);
    }

    @Override
    public int size() {
        return sortedList.size();
    }

    public int getTotalAdded() {
        return this.totalAdded;
    }


}