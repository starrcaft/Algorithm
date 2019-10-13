import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CloestPair {
    static int inversion_count = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("data04_closest.txt"));
        Object[] a = br.lines().toArray();

        float[][] list = new float[a.length][2];
        int count = 0;
        for (Object s : a) {
            StringTokenizer st = new StringTokenizer(String.valueOf(s), ",");
            list[count][0] = Float.parseFloat(st.nextToken());
            list[count][1] = Float.parseFloat(st.nextToken());
            count++;
        }
        sortanddivide(list);
    }

    public static void sortanddivide(float[][] list) {
        Arrays.sort(list, new Comparator<float[]>() {
            @Override
            public int compare(float[] o1, float[] o2) {
                return Float.compare(o1[0], o2[0]);
            }
        });
        float result = closest(list, 0, list.length - 1); // 최단거리

        System.out.println(result);
    }

    public static float closest(float[][] list, int start, int end) {
        if ((end - start) <= 3) {
            float shortest = Float.MAX_VALUE;
            for (int i = start; i < end; i++) {
                for (int indexOfInner = i + 1; indexOfInner <= end; indexOfInner++) {
                    if (i != indexOfInner) {
                        shortest = Math.min(shortest, distance(list[i], list[indexOfInner]));
                    }
                }
            }
            return shortest;
        }

        int mid = (end - start) / 2;
        float midPoint = (list[mid][0] + list[mid + 1][0]) / 2;
        float dl = closest(list, start, mid);
        float dr = closest(list, mid + 1, end);
        float d = Math.min(dl, dr);
        float leftMid = midPoint - d;
        float rightMid = midPoint + d;
        float[][] closestlist = new float[end][2];
        int count = 0;
        for (int i = 0; i < end; i++) {
            if (list[i][0] < leftMid) {
                continue;
            } else if (list[i][0] > rightMid) {
                break;
            } else {
                closestlist[count] = list[i];
                count++;
            }
        }
        return closestList(closestlist, 0, count);
    }

    public static float closestList(float[][] closestList, int start, int end) {
        if ((end - start) <= 3) {
            float shortest = 0;
            float temp = 0;
            for (int i = start; i <= end; i++) {
                if (i + 1 > end) {
                    temp = distance(closestList[i], closestList[start]);
                } else {
                    temp = distance(closestList[i], closestList[i + 1]);
                }
                if (temp > shortest) shortest = temp;
            }
            return shortest;
        }
        int mid = (end - start) / 2;
        float dl = closestList(closestList, start, mid);
        float dr = closestList(closestList, mid + 1, end);
        float d = Math.min(dl, dr);
        return d;
    }

    public static float distance(float[] left, float[] right) {
        return (float) Math.sqrt(Math.pow((left[0] - right[0]), 2) + Math.pow((left[1] - right[1]), 2));
    }
}
