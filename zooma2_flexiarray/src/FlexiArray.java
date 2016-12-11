public class FlexiArray<T> {

    public interface ItemMatcher<T> {
        boolean isMatch(T item);
    }

    private T[] items;
    private T[] itemsColor;
    private int itemCount;
    private int size;

    @SuppressWarnings("unchecked")
    public FlexiArray(int size) {
        this.items = (T[]) new Object[size];
        this.itemsColor = (T[]) new Object[size];
        this.size = size;
        this.itemCount = 0;
    }

    public int findIndex(ItemMatcher<T> matcher) {
        for(int i=0; i<itemCount; i++) {
            if(matcher.isMatch(items[i])) {
                return i;
            }
        }
        return -1;
    }

    public void insert(int i, T item, T itemColor) {
        for(int j=itemCount - 1; j >= i; j--) {
            items[j + 1] = items[j];
            itemsColor[j+1] = itemsColor[j];
        }
        items[i] = item;
        itemsColor[i] = itemColor;
        itemCount++;
    }

    public void remove(int i) {
        for(int j = i + 1; j < itemCount; j++) {
            items[j - 1] = items[j];
            itemsColor[j - 1] = itemsColor[j];
        }
        itemCount--;
    }

    public T getOrder(int i) {
        return items[i];
    }
    public T getColor(int i) {
        return itemsColor[i];
    }
    public int getCount() {
        return itemCount;
    }
}