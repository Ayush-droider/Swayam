package Trees;

public class SegmentTreeMax {
    int[] tree, arr;
    int n;

    public SegmentTreeMax(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        tree = new int[4 * n];
        build(0, 0, n - 1);
    }

    void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node + 1, start, mid);
        build(2 * node + 2, mid + 1, end);
        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return Integer.MIN_VALUE;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        int left = query(2 * node + 1, start, mid, l, r);
        int right = query(2 * node + 2, mid + 1, end, l, r);
        return Math.max(left, right);
    }

    void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            arr[idx] = val;
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) update(2 * node + 1, start, mid, idx, val);
        else update(2 * node + 2, mid + 1, end, idx, val);
        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTreeMax st = new SegmentTreeMax(arr);
        System.out.println(st.query(0, 0, arr.length - 1, 1, 4));
        st.update(0, 0, arr.length - 1, 3, 10);
        System.out.println(st.query(0, 0, arr.length - 1, 1, 4));
    }
}
