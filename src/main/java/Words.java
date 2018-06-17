import java.util.*;
import java.io.*;
/**
 * Задание №6
 *
 * @author Ежова Наталья
 */
public class Words {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\fanlo\\Aplana_work\\words.txt"));
        Set<String> words = new TreeSet<String>();
        while (sc.hasNext()) {
            String word = sc.useDelimiter("\\s+").next();
            words.add(word);
            System.out.print(word + " "); //вывести список слов из файла
        }
        System.out.println();
        System.out.print(words); // слова по алфавиту

        Scanner sc2 = new Scanner(new File("C:\\Users\\fanlo\\Aplana_work\\words.txt"));
        Map<String, Integer> statistics = new HashMap<String, Integer>();
        while (sc2.hasNext()) {
            String word2 = sc2.useDelimiter("\\s+").next();
            Integer count = statistics.get(word2);
            if (count == null) {
                count = 0;
            }
            statistics.put(word2, ++count);
        }
        System.out.println();
        System.out.print("Statistics: " + statistics); //статистика, сколько раз каждое слово встречается в файле
        System.out.println();

        Iterator<String> i = statistics.keySet().iterator();
        String word = i.next();
        Integer max = statistics.get(word);
        while(i.hasNext()) {
            String k = i.next();
            Integer val = statistics.get(k);
            if (val > max){
                max = val;
                word=k;
            }
        }
        System.out.println("Word "+word+" match "+max+" times."); //слово с максимальным количеством повторений.
    }
}




