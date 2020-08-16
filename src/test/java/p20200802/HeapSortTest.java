package p20200802;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @DisplayName("힙 정렬을 기능을 테스트한다 ")
    @Test
    void testHeapSortFunction() {
        //given
        int[] givenArr1 = {22, 5, 11, 32, 120, 68, 70};
        int[] givenArr2 = {22, 13, 15, 88, 120, 68, 70};
        int[] givenArr3 = {5, 3, 1, 9, 8, 7, 6, 10, 2, 4};
        int n1 = 7;
        int n3 = 10;

        HeapSort sol = new HeapSort();

        //when
//        sol.heapSort(givenArr1, n1);
//        sol.heapSort(givenArr2, n1);
        sol.heapSort(givenArr3, n3);

        //then
//        assertThat(givenArr1).isEqualTo(new int[]{5, 11, 22, 32, 68, 70, 120});
//        assertThat(givenArr2).isEqualTo(new int[]{13, 15, 22, 68, 70, 88, 120});
        assertThat(givenArr3).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }
}
