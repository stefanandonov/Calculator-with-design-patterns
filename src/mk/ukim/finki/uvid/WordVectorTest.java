//package mk.ukim.finki.uvid;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
///**
// * Word vectors test
// */
//
//class Vector {
//    List<Integer> vectorNumbers;
//
//    public static Vector DEFAULT_VECTOR = new Vector(Arrays.asList(5,5,5,5,5));
//
//    public Vector(List<Integer> vectorNumbers) {
//        this.vectorNumbers = vectorNumbers;
//    }
//
//    Vector sum (Vector other) {
//        List<Integer> result = new ArrayList<>();
//        IntStream.range(0,5).forEach(i -> result.add(this.vectorNumbers.get(i)+other.vectorNumbers.get(i)));
//        return new Vector(result);
//    }
//
//    Integer max () {
//        return this.vectorNumbers.stream().max(Comparator.naturalOrder()).orElse(0);
//    }
//
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Vector{");
//        sb.append("vectorNumbers=").append(vectorNumbers);
//        sb.append('}');
//        return sb.toString();
//    }
//}
//
//class WordVectors {
//    Map<String, Vector> wordVectorsMap;
//
//    List<String> text;
//
//    public WordVectors(String[] words, List<List<Integer>> vectors) {
//        wordVectorsMap = new HashMap<>();
//        text = new ArrayList<>();
//
//        for (int i=0;i<words.length;i++) {
//            wordVectorsMap.put(words[i], new Vector(vectors.get(i)));
//        }
//    }
//
//    public void readWords(List<String> words) {
//        this.text = words;
//    }
//
//    public List<Integer> slidingWindow(int n) {
//        List<Integer> finalResult = new ArrayList<>();
//        for (int i=0;i<text.size()-n;i++) {
//            Vector result = new Vector(Arrays.asList(0,0,0,0,0));
//            for (int j=0;j<n;j++) {
//                Vector curr = wordVectorsMap.getOrDefault(text.get(i+j), Vector.DEFAULT_VECTOR);
//                result = result.sum(curr);
//            }
//            finalResult.add(result.max());
//        }
//
//        return finalResult;
//    }
//}
//public class WordVectorsTest {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine();
//        String[] words = new String[n];
//        List<List<Integer>> vectors = new ArrayList<>(n);
//        for (int i = 0; i < n; ++i) {
//            String line = scanner.nextLine();
//            String[] parts = line.split("\\s+");
//            words[i] = parts[0];
//            List<Integer> vector = Arrays.stream(parts[1].split(":"))
//                    .map(Integer::parseInt)
//                    .collect(Collectors.toList());
//            vectors.add(vector);
//        }
//        n = scanner.nextInt();
//        scanner.nextLine();
//        List<String> wordsList = new ArrayList<>(n);
//        for (int i = 0; i < n; ++i) {
//            wordsList.add(scanner.nextLine());
//        }
//        WordVectors wordVectors = new WordVectors(words, vectors);
//        wordVectors.readWords(wordsList);
//        n = scanner.nextInt();
//        List<Integer> result = wordVectors.slidingWindow(n);
//        System.out.println(result.stream()
//                .map(Object::toString)
//                .collect(Collectors.joining(",")));
//        scanner.close();
//    }
//}
//
//
//
