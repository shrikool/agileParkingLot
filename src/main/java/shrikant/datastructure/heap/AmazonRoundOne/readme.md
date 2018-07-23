Awe want to know the top n selling items from the merchant perspective
1000 items -- hash map -- > keep track item -- count -- hashmap 
1000 items -- top 10 items ? --> Max Heap (10 elements) --> 1000O(log10) --> deleteMax() 10 times --> top ten items sold !!

item - Quantity
i1 - 5 --memotize this frequency 
i2 - 7
i3 - 10
i4 - 12
i1 - 3
heap size is 3
Heap size = 3

||
i1||
check the element is there in heap or not ?  Item was not there --i1|i2| --> i2|i1|
i2|i1|i3 --> i3|i1|i2
i3|i1|i2|i4 --> i3|i4|i2|i1 --> i4|i3|i2|i1 --> top 3 elements are still top n selling items --> 

   
   
When would you put this to secondary ry 
Ans :: When we find a item out of the max heap than we need to persist it along with it's frequency of sale.


class Item{
int itemNumber;
int frequencyOfSale;
}

class Heap{
Item[] items;
int capacity;

public boolean isHeapFull(){
    if (capacity == items.length)
        return true;
    return false;
}
}

public static void main(String[] args){
    public Item[] getTopThreeItem(Item[] items){
        if (items.length == 0)
            return new Item[];
            
        Item[] maxHeap = new Item[3];
        Item[] minHeap = new Item[3];
        
        for (item : items){
            if(isAlreadyInHeap(maxHeap, item)){
                updateItemSaleInMaxHeap(maxHeap, item);
                updateItemSaleInMinHeap(minHeap, item);
            }else{
                if (isHeapFull(maxHeap)){
                    Item itemWithMinFreq = peekTopInHeap(minHeap);
                    if(item.isFrequencyIsGreaterThan(itemWithMinFreq)){ // If two items are of same freq, than giving priority to one which is already in the heap or giving priority to insertion order.
                        deleteMin(minHeap);
                        deleteInHeap(maxHeap);
                        insertIntoMaxHeap(maxHeap, item);
                        insertIntoMinHeap(minHeap, item);
                    }
                }else{
                    insertIntoMaxHeap(maxHeap, item);
                    insertIntoMinHeap(minHeap, item);
                }
            }
        }
        
        return maxHeap;
    }
}

public boolean isHeapFull(Item[] items){
    if (items[item.length-1] == null)
        return false;
    return true;
}