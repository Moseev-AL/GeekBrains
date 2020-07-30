
public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];


    public static void generateSolidArray() {

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long s = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long f = System.currentTimeMillis();
        System.out.println("Solid array processing time: "+ (f - s));
    }

    public static void generateSplittedArrays() {

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long s = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread threadA1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread threadA2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + (i+h) / 5) * Math.cos(0.2f + (i+h) / 5) * Math.cos(0.4f + (i+h) / 2));
            }
        });

        threadA1.start();
        threadA2.start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long f = System.currentTimeMillis();
        System.out.println("Splitted array processing time: "+ (f - s));
    }


    public static void main(String[] args) {
        generateSolidArray();
        generateSplittedArrays();
    }

}

