import java.util.ArrayList;

public class ArrArray {
    public ArrayList<int[]> seznam = new ArrayList<int[]>();
    public ArrayList<Integer> elementi = new ArrayList<Integer>();
    public ArrayList<Integer> counter = new ArrayList<Integer>();
    public int cursor = 0;
    public ArrayList<Integer> zasedenost = new ArrayList<Integer>();
    public int leno;
    public boolean internal =false;
    public boolean empty=true;
    //public int fillment=0;

    public ArrArray(ArrayList<int[]> seznam, ArrayList<Integer> elementi, ArrayList<Integer> counter) {
        this.seznam = seznam;
        this.elementi = elementi;
        this.counter = counter;
    }

    public ArrArray() {

    }

    public boolean findArr(int e){
        for (int i =0; i<seznam.size(); i++){
            if(zasedenost.get(i)==0){
                return false;
            }
            for (int j = 0; j<seznam.get(i).length;j++){
                if (counter.get(elementi.indexOf(seznam.get(i)[j]))==0){
                    counter.set(elementi.indexOf(seznam.get(i)[j]),1);
                    elementi.set(elementi.indexOf(seznam.get(i)[j]),e);
                    seznam.get(i)[j]=e;
                    seznam.set(i,sort(seznam.get(i)));
                    return true;
                }
            }
        }
        return false;
    }
    public void insert(int e){
        //prazen();
        internal=true;
        int[] a= {e};
        int[] temp=a;
        if(seznam.isEmpty()){
            seznam.add(a);
            elementi.add(e);
            counter.add(1);
            zasedenost.add(1);
        }
        else{

            if(find(e)){
                counter.set(cursor,counter.get(cursor)+1);
            }
            else{
                elementi.add(e);
                counter.add(1);
                for(int i = 0; i<seznam.size();i++){
                    if(zasedenost.get(i)==0){
                        seznam.set(i,sort(temp));
                        zasedenost.set(i,1);
                        temp= new int[]{};
                        break;
                    }
                    else {
                        if (findArr(e)) {
                            break;
                        } else {
                            try {
                                seznam.get(i + 1);
                                temp = merge(seznam.get(i), temp);
                                zasedenost.set(i, 0);
                                seznam.set(i, new int[]{});
                            } catch (Exception r) {
                                temp = merge(seznam.get(i), temp);
                                zasedenost.set(i, 0);
                                seznam.set(i, new int[]{});
                                seznam.add(new int[(int) Math.pow(2, (i + 1))]);
                                zasedenost.add(0);
                            }
                        }
                    }

                }
            }
        }

        internal=false;
    }
    public boolean find(int e){

        for(int i = 0; i<elementi.size();i++){
            if(elementi.get(i)==e && counter.get(i)!=0){
                cursor=i;
                if(!internal){
                    System.out.println("true");
                }
                return true;
            }
        }
        if(!internal){
            System.out.println("false");
        }
        return false;
    }
    public int[] sort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        return arr;
    }
    public boolean delete(int e){
        internal=true;
        if(find(e)){
            counter.set(cursor,counter.get(cursor)-1);
            prazen();
            System.out.println("true");
            internal=false;

            return true;
        }
        internal=false;
        System.out.println("false");
        return false;

    }
    public void prazen(){
        for (int i =0; i<seznam.size(); i++){
            for (int j = 0; j<seznam.get(i).length;j++){
                internal=true;

                if (find(seznam.get(i)[j])&&counter.get(cursor)!=0){
                    empty=false;
                    //System.out.println("here1"+seznam.get(i)[j]);
                }
                internal=false;
            }
            //System.out.println("nasledna tabela:");
            if(empty){
                zasedenost.set(i,0);
                //System.out.println("here");
            }
            empty=true;
        }
    }
    public void printOut(){
        //prazen();
        if(isEmpty()) {
            System.out.println("empty");
        }
        else{
            internal = true;
            int[] temp;
            String izspis;
            for (int i = 0; i < seznam.size(); i++) {
                izspis = "";
                izspis = "A_" + String.valueOf(i) + ":";
                if (zasedenost.get(i) == 0) {
                    izspis = izspis + " ...";
                } else {
                    for (int j = 0; j < seznam.get(i).length; j++) {
                        temp = seznam.get(i);
                        //find(temp[j]);

                        if (!find(temp[j])) {
                            //System.out.println(cursor);
                            if (j == temp.length - 1) {
                                izspis = izspis + " x";
                            }
                            else{
                                izspis = izspis + " x,";
                            }
                        } else {
                            if (j == temp.length - 1) {
                                izspis = izspis + " " + String.valueOf(temp[j]) + "/" + String.valueOf(counter.get(cursor));
                            } else {
                                izspis = izspis + " " + String.valueOf(temp[j]) + "/" + String.valueOf(counter.get(cursor)) + ",";
                            }
                        }
                    }
                }
                System.out.println(izspis);

            }
            internal = false;
        }
    }
    public int[] merge(int[] arr1, int[] arr2){
        int fn = arr1.length;
        int sn = arr2.length;
        int[] arr= new int[fn+sn];
        System.arraycopy(arr1,0,arr,0,fn);
        System.arraycopy(arr2, 0, arr, fn, sn);
        return arr;
    }
    public boolean isEmpty(){
        for (int i=0; i< zasedenost.size();i++){
            if(zasedenost.get(i)!=0){
                return false;
            }
        }
        seznam=new ArrayList<int[]>();
        return true;
    }
}
