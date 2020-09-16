package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2)    {
        Set<Integer> set=new HashSet<>(set1);
        set.addAll(set2);// добовляем все элемнты       - объединение множеств
        return set;
    }
        public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2)    {
            Set<Integer> set=new HashSet<>(set1);
            set.retainAll(set2);//пересечение множеств
            return set;
        }
            public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2)    {
                Set<Integer> set=new HashSet<>(set1);
                set.removeAll(set2);// удаляем только элементы  set2      - разница множеств
                return set;
            }
                public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2)    {
                    Set<Integer> set=new HashSet<>(set1);
                    set.addAll(difference(set2, set1));//        - симметрическая разница
                    return set;
                }
    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 3, 5, 7, 9);
        Set<Integer> set2 = Set.of(1, 4, 5, 8, 13);
        System.out.println(set1);
        System.out.println(set2);
        System.out.println("union - " + union(set1, set2));
        System.out.println("intersection - " + intersection(set1, set2));
        System.out.println("difference - " + difference(set1, set2));
        System.out.println("sym diff - " + symDifference(set1, set2));
    }
}
