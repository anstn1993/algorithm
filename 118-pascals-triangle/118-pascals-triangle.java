class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        // 행별로 수행
        for (int i = 0; i < numRows; i++) {
            result.add(new LinkedList<>());
            List<Integer> row = result.get(i);
            // 양 끝단에 1 추가
            row.add(0, 1);
            if (i > 0) row.add(row.size() - 1, 1);
            // 3행부터 가운데 열들에 값 생성
            if (i >= 2) {
                List<Integer> aboveRow = result.get(i - 1);
                for (int j = 1; j < i; j++) {
                    row.add(j, aboveRow.get(j - 1) + aboveRow.get(j));
                }    
            }
        }
        
        return result;
    }
}