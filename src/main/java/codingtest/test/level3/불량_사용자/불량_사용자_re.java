package codingtest.test.level3.불량_사용자;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 불량_사용자_re {
    class Solution {
        public int solution(String[] users, String[] banned_id) {
            String[][] bans = Arrays.stream(banned_id)
                    .map(ban -> ban.replaceAll("\\*", "."))
                    .map(ban -> Arrays.stream(users)
                            .filter(user -> user.matches(ban))
                            .toArray(String[]::new))
                    .toArray(String[][]::new);

            Set<Set<String>> repo = new HashSet<>();
            count(0, bans, repo, new HashSet<>());

            return repo.size();
        }

        private void count(int idx, String[][] bans, Set<Set<String>> repo, Set<String> banSet) {
            if (idx == bans.length) {
                repo.add(new HashSet<>(banSet));
                return;
            }

            for (String ban : bans[idx]) {
                if (!banSet.contains(ban)) {
                    banSet.add(ban);
                    count(idx + 1, bans, repo, banSet);
                    banSet.remove(ban);
                }
            }
        }
    }
}
