package p20200819;

import java.util.Comparator;

//이진 검색 트리 (= 이분 탐색 트리, 이진 탐색 트리)
public class BinTree<K, V> {
    public class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return data;
        }

        public void print() {
            System.out.println(data);
        }
    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    public BinTree() {
        this.root = null;
    }

    public BinTree(Comparator<? super K> comparator) {
        this();
        this.comparator = comparator;
    }

    public int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) // key1을 Comparable<K> 인터페이스형으로 형변환(cast)하고 compareTo 메서드를 호출하여 key2와 비교한다.
                : comparator.compare(key1, key2);
    }

    public V search(K key) {
        Node<K, V> p = root;

        while (true) {
            if (p == null) return null;

            int cond = comp(key, p.getKey());
            if (cond == 0) return p.getValue();

            if (cond < 0) { // key가 p보다 작다
                p = p.left;
                continue;
            }

            // key가 p보다 크다
            p = p.right;
        }
    }

    // 노드를 삽입할 때 주의해야 할 점은 노드를 삽입한 다음에 트리의 형태가 이진검색트리의 조건을 유지해야 한다는 점이다.
    // 따라서 노드를 삽입할 때는 알맞은 위치에 삽입해야 한다. 이때 삽입할 노드의 키와 같은 값을 가지는 노드가 이미 있다면 노드를 삽입해서는 안된다.

    // node를 루트로 하는 서브 트리에 노드<K,V>를 삽입
    public void addNode(Node<K, V> node, K key, V data) {
        int cond = comp(key, node.getKey());
        if (cond == 0) return;
        if (cond < 0) {
            if (node.left == null) {
                node.left = new Node<>(key, data, null, null);
                return;
            }
            addNode(node.left, key, data);
            return;
        }

        if (node.right == null) {
            node.right = new Node<>(key, data, null, null);
            return;
        }
        addNode(node.right, key, data);
    }

    //노드를 삽입
    public void add(K key, V data) {
        if (root == null) {
            root = new Node<>(key, data, null, null); // 트리가 비어있는 상태이므로 루트만으로 구성된 트리를 만들어야 한다.
            return;
        }
        addNode(root, key, data); // 트리가 비어있지 않은 상태이므로 메서드 addNode를 호출하여 노드를 삽입한다. 메서드 addNode는 node를 루트로 하는 서브 트리에 키 값이 key, 데이터가 data인 노드를 삽입한다.
    }

    // 노드를 삭제하는 remove 메서드 : 3가지의 경우가 있음 (그중에서 자식 노드가 2개인 노드를 삭제할 때가 복잡하다)
    public boolean remove(K key) {
        Node<K, V> p = root; // 스캔 중인 노드
        Node<K, V> parent = null; // 스캔 중인 노드의 부모 노드
        boolean isLeftChild = true; // p는 부모의 왼쪽 자식 노드인가?

        while (true) {
            if (p == null) // 더 이상 진행하지 않으면 그 키 값은 없다.
                return false;
            int cond = comp(key, p.getKey()); // key와 노드 p의 키 값을 비교해서
            if (cond == 0) // 같으면 검색 성공!
                break;

            parent = p; // 가지로 내려가기 전에 부모를 설정
            if (cond < 0) { // key 쪽이 작으면
                isLeftChild = true; // 왼쪽 자식으로 내려감
                p = p.left; // 왼쪽 서브 트리에서 검색
                continue;
            }

            isLeftChild = false; // 오른쪽 자식으로 내려감
            p = p.right; // 오른쪽 서브 트리에서 검색
        }

        if (p.left == null) { // p에는 왼쪽 자식이 없음
            if (p == root) root = p.right;
            else if (isLeftChild) parent.left = p.right; // 부모의 왼쪽 포인터가 오른쪽 자식을 가리킴
            else parent.right = p.right; // 부모의 오른쪽 포인터가 오른쪽 자식을 가리킴
        } else if (p.right == null) { // p에는 오른쪽 자식이 없음
            if (p == root) root = p.left;
            else if (isLeftChild) parent.left = p.left; // 부모의 왼쪽 포인터가 왼쪽 자식을 가리킴
            else parent.right = p.left; // 부모의 오른쪽 포인터가 왼쪽 자식을 가리킴
        } else {
            parent = p;
            Node<K, V> left = p.left; // 서브 트리 가운데 가장 큰 노드
            isLeftChild = true;
            while (left.right != null) { // 가장 큰 노드 left를 검색
                parent = left;
                left = left.right;
                isLeftChild = false;
            }

            p.key = left.key; // left 키 값을 p로 옮김
            p.data = left.data; // left의 데이터를 p로 옮김

            if (isLeftChild)
                parent.left = left.left; // left를 삭제
            else
                parent.right = left.left; // left를 삭제
        }
        return true;
    }

    // 모든 노드를 키 값의 오름차순으로 출력
    public void print() {
        printSubTree(root);
    }

    private void printSubTree(Node<K, V> node) {
        if (node != null) {
            printSubTree(node.left); // 왼쪽 서브 트리를 키 값의 오름차순으로 출력
            System.out.println(node.key + " " + node.data);
            printSubTree(node.right); // 오른쪽 서브 트리를 키 값의 오름차순으로 출력
        }
    }
}
