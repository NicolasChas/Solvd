public class Sorting {
    
    void menorMayor(int array[],int length){
        for(int i=0;i<length-1;i++){
            int min=i;
            for(int j=i+1;j<length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            int swap=array[min];
            array[min]=array[i];
            array[i]=swap;
        }
        for (int i=0; i<length; ++i){
            System.out.print(array[i]+" ");
        }
    }

    void mayorMenor(int array[],int length){
        for(int i=0;i<length-1;i++){
            int max=i;
            for(int j=i+1;j<length;j++){
                if(array[j]>array[max]){
                    max=j;
                }
            }
            int swap=array[max];
            array[max]=array[i];
            array[i]=swap;
        }
        for (int i=0; i<length; ++i){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args){
        Sorting object= new Sorting();
        int[] array={155,43,21,73,11,9,55,101};
        int length=array.length;
        System.out.println("\nArray sorted from lowest to highest:");
        object.menorMayor(array,length);
        System.out.println("\nArray sorted from highest to lowest:");
        object.mayorMenor(array, length);
    }
}
