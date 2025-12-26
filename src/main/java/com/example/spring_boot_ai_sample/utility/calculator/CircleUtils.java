package com.example.spring_boot_ai_sample.utility.calculator;

public class CircleUtils {
    /**
     * 指定した半径から円の面積を計算します。
     * 半径が負の場合は 0.0 を返します。
     * </p>
     *
     * <pre>
     * 使用例:
     * double area = CircleUtils.calculateCircleArea(3.0); // 結果: 28.274333882308138
     * </pre>
     *
     * @param radius 円の半径（非負である必要があります）
     * @return 円の面積（半径が負の場合は 0.0）
     */
    public static double calculateCircleArea(double radius) {
        if (radius < 0) {
            // エラー条件：半径が負の場合は早期リターン
            return 0.0;
        }
        double area = Math.PI * radius * radius;
        return area;
    }
}
