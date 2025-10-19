package calculator;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = readLine();

        String custom = "";
        String regex = ",|:";
        String[] nums;

        // 커스텀 구분자 유무 확인
        if (inputString.startsWith("//")) {
            int index = inputString.indexOf("\\n");
            // 커스텀 구분자 추출
            custom = inputString.substring(2, index);
            inputString = inputString.substring(index + 2);

            regex = regex + "|" + "\\\\" + custom;

            nums = inputString.split(regex);
            getSum(nums);
        } else {
            nums = inputString.split(regex);
            System.out.println(Arrays.toString(nums));
            getSum(nums);
        }
    }

    private static void getSum(String[] nums) {
        int sum = 0;
        try {
            for (String num : nums) {
                if (num.isBlank() || Integer.parseInt(num) < 0) {
                    throw new IllegalArgumentException();
                }
                sum += Integer.parseInt(num);
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자 이외의 값이 입력되었습니다.");
            return;
        }
        System.out.println("결과 : " + sum);
    }

}