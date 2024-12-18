import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 소들의 특성 저장
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            
            String name = st.nextToken(); // 소의 이름
            int k = Integer.parseInt(st.nextToken()); // 특성의 개수
            Set<String> traits = new HashSet<>();
            for (int j = 0; j < k; j++) {
                traits.add(st.nextToken());
            }
            map.put(name, traits); // 소와 그 소의 특성 저장
        }
        
        // 메모이제이션을 위한 캐시
        Map<String, Integer> memo = new HashMap<>();
        
        // 최대 Yes 횟수 계산
        int maxYes = getMaxYes(map, memo);
        System.out.println(maxYes);
    }

    // 재귀적으로 최대 Yes를 계산 (메모이제이션 포함)
    private static int getMaxYes(Map<String, Set<String>> map, Map<String, Integer> memo) {
        if (map.size() == 1) {
            return 0; // 하나의 소만 남으면 종료
        }

        // 캐시를 위한 Key 생성: 소들의 특성을 정렬된 문자열로 변환
        String currentState = getStateKey(map);
        if (memo.containsKey(currentState)) {
            return memo.get(currentState);
        }

        int maxYes = 0;
        Set<String> allTraits = getAllTraits(map);

        // 모든 특성에 대해 질문 시뮬레이션
        for (String trait : allTraits) {
            Map<String, Set<String>> yesGroup = new HashMap<>();
            Map<String, Set<String>> noGroup = new HashMap<>();
            
            for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                String name = entry.getKey();
                Set<String> traits = entry.getValue();
                
                if (traits.contains(trait)) {
                    yesGroup.put(name, traits);
                } else {
                    noGroup.put(name, traits);
                }
            }
            
            // 한쪽 그룹이 비어있는 경우, 이 질문은 유효하지 않음
            if (yesGroup.isEmpty() || noGroup.isEmpty()) {
                continue;
            }
            
            // 양쪽 그룹의 최대 Yes 계산
            int yesCount = getMaxYes(yesGroup, memo);
            int noCount = getMaxYes(noGroup, memo);
            
            // 현재 질문에 대한 Yes 횟수 계산
            maxYes = Math.max(maxYes, 1 + Math.max(yesCount, noCount));
        }
        
        // 결과 저장
        memo.put(currentState, maxYes);
        return maxYes;
    }

    // 모든 특성을 집합으로 가져오기
    private static Set<String> getAllTraits(Map<String, Set<String>> map) {
        Set<String> allTraits = new HashSet<>();
        for (Set<String> traits : map.values()) {
            allTraits.addAll(traits);
        }
        return allTraits;
    }

    // 현재 상태를 고유 문자열로 변환
    private static String getStateKey(Map<String, Set<String>> map) {
        List<String> traitSets = new ArrayList<>();
        for (Set<String> traits : map.values()) {
            List<String> sortedTraits = new ArrayList<>(traits);
            Collections.sort(sortedTraits); // 각 특성을 정렬
            traitSets.add(String.join(",", sortedTraits)); // 정렬된 특성을 문자열로 변환
        }
        Collections.sort(traitSets); // 전체 소들의 특성도 정렬
        return String.join(";", traitSets); // 고유 문자열 생성
    }
}
