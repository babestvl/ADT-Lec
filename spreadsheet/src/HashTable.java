public class HashTable {
    static final int M = 1000;
    static final int P = 997;
    static final String EMPTY_KEY = null;

    int [] values;
    String [] keys;

    public HashTable() {
        values = new int[M];
        keys = new String[M];
        for(int i=0; i<M; i++) {
            keys[i] = EMPTY_KEY;
        }
    }

    int hash(String key) {
        int val = 0;
        for (int i =0 ; i < key.length();i++) {
            val += (int) (key.charAt(i)) * ((i+1)*(i*1));
            val %= M;
        }
        return val;

    }


    void put(String k, int v) {
        int idx = hash(k);
        //System.out.println("H = " + idx);
        while((keys[idx] != EMPTY_KEY) && (keys[idx] != k)) {
            idx++;
            if(idx == M) {
                idx = 0;
            }
            //System.out.println("Not empty move to " + idx);
        }
        keys[idx] = k;
        values[idx] = v;
    }

    int get(String k) {
        int idx = hash(k);
        //System.out.println("H = " + idx);
        while((keys[idx] != k) && (keys[idx] != EMPTY_KEY)) {
            idx++;
            if(idx == M) {
                idx = 0;
            }
            //System.out.println("Not the key, move to " + idx);
        }
        if(keys[idx] == k) {
            return values[idx];
        } else {
            throw new RuntimeException("Sorry");
        }
    }
}