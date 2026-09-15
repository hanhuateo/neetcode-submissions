class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }
        List<Integer> sizes = new ArrayList<>();
        for (String str : strs) {
            sizes.add(str.length());
        }
        StringBuilder sb = new StringBuilder();
        for (Integer size : sizes) {
            sb.append(Integer.toString(size));
            sb.append(',');
        }
        sb.append('#');
        for (String str : strs) {
            sb.append(str);
        }
        System.out.println("sb : " + sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if (str.isEmpty()) {
            return result;
        }
        int index = str.indexOf('#');
        char[] array = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            if (Character.isDigit(array[i])) {
                sb.append(array[i]);
            } else {
                sizes.add(Integer.valueOf(sb.toString()));
                sb.setLength(0);
            }
        }
        System.out.println("sizes: " + sizes.toString());
        int pointer = index + 1;
        for (Integer size : sizes) {
            int count = size;
            while (count > 0) {
                sb.append(array[pointer]);
                count--;
                pointer++;
            }
            result.add(sb.toString());
            sb.setLength(0);
        }
        System.out.println("result : " + result.toString());
        return result;
    }
}
